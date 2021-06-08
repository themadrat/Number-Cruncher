package numberCruncher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;

public class UserInterface2 extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	
	private JTextField txtEnterInitials;
	
	Scanner initialsScanner;
	Scanner txtFileScanner;

	private boolean initialsSubmitted = false;
	
	private JLabel lblErrorLabel = new JLabel("");
	private JLabel lblEnterInitialsPrompt = new JLabel("Enter Your Initials Here");
	private JLabel lblDifficultyPrompt = new JLabel("");
	
	private String playerInitials;

	private JButton btnEasyModeButton = new JButton("Easy Mode");
	private JButton btnModerateModeButton = new JButton("Moderate Mode");
	private JButton btnDifficultModeButton = new JButton("Difficult Mode");
	private JButton btnSubmissionButton = new JButton("Submit Initials");
	
	private DefaultListModel<String> numberList1 = new DefaultListModel<>(); //used to display the history of the users guesses for each track
	private DefaultListModel<String> numberList2 = new DefaultListModel<>();
	private DefaultListModel<String> numberList3 = new DefaultListModel<>();
	private DefaultListModel<String> numberList4 = new DefaultListModel<>();
	private DefaultListModel<String> numberList5 = new DefaultListModel<>();
	private DefaultListModel<String> numberList6 = new DefaultListModel<>();
	private DefaultListModel<String> numberList7 = new DefaultListModel<>();
	
	private JList JlistHistory1 = new JList(numberList1);
	private JList JlistHistory2 = new JList(numberList2);
	private JList JlistHistory3 = new JList(numberList3);
	private JList JlistHistory4 = new JList(numberList4);
	private JList JlistHistory5 = new JList(numberList5);
	private JList JlistHistory6 = new JList(numberList6);
	private JList JlistHistory7 = new JList(numberList7);
	
	private JLabel lblInitials = new JLabel("");
	private JLabel lblRangeAchieved = new JLabel("");
	private JLabel lblScoreAchieved = new JLabel("");
	private JLabel lblLevelAchieved = new JLabel("");
	
	NumberCruncherManager2 NCM2 = new NumberCruncherManager2();
	
	private int[] theRandomArray;
	private int[] theGuessArray;
	
	private ImageIcon checkMark = new ImageIcon("Images/CheckMark.png");
	private ImageIcon xMark = new ImageIcon("Images/XMark.png");
	private ImageIcon arrowUp = new ImageIcon("Images/LedArrowUp.png");
	private ImageIcon arrowDown = new ImageIcon("Images/LedArrowDown.png");
	private ImageIcon logo = new ImageIcon("Images/Logo.png");
	
	private JLabel lblLogo = new JLabel(logo);
	
	private final Integer textTimer = 5000;
	private Boolean timeToEmptyText = true;
	private Timer emptyText = new Timer(textTimer, this);
	
	private int attemptsCounter1;
	private int attemptsCounter2;
	private int attemptsCounter3;
	private int attemptsCounter4;
	private int attemptsCounter5;
	private int attemptsCounter6;
	private int attemptsCounter7;
	
	private boolean gameOver = false;
	private JLabel lblCorrectnessDisplay = new JLabel("");
	private JLabel lblArrowDisplay = new JLabel("");
	private JLabel lblCorrectnessDisplay_1 = new JLabel("");
	private JLabel lblCorrectnessDisplay_2 = new JLabel("");
	private JLabel lblCorrectnessDisplay_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay_4 = new JLabel("");
	private JLabel lblCorrectnessDisplay_5 = new JLabel("");
	private JLabel lblCorrectnessDisplay_6 = new JLabel("");
	private JLabel lblArrowDisplay_1 = new JLabel("");
	private JLabel lblArrowDisplay_2 = new JLabel("");
	private JLabel lblArrowDisplay_3 = new JLabel("");
	private JLabel lblArrowDisplay_4 = new JLabel("");
	private JLabel lblArrowDisplay_5 = new JLabel("");
	private JLabel lblArrowDisplay_6 = new JLabel("");
	private JTextField txtGuessField;
	private JTextField txtGuessField_1;
	private JTextField txtGuessField_2;
	private JTextField txtGuessField_3;
	private JTextField txtGuessField_4;
	private JTextField txtGuessField_5;
	private JTextField txtGuessField_6;
	
	private JButton btnGuessSubmission = new JButton("Submit Guesses");
	
	private JLabel lblAttemptsCounter = new JLabel("");
	private JLabel lblAttemptsCounter_1 = new JLabel("");
	private JLabel lblAttemptsCounter_2 = new JLabel("");
	private JLabel lblAttemptsCounter_3 = new JLabel("");
	private JLabel lblAttemptsCounter_4 = new JLabel("");
	private JLabel lblAttemptsCounter_5 = new JLabel("");
	private JLabel lblAttemptsCounter_6 = new JLabel("");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface2 frame = new UserInterface2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public UserInterface2() {
		emptyText.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 825, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAttemptsCounter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttemptsCounter.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
		lblAttemptsCounter.setBounds(110, 94, 50, 50);
		contentPane.add(lblAttemptsCounter);
		
		lblDifficultyPrompt.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblDifficultyPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficultyPrompt.setBounds(325, 278, 150, 25);
		getContentPane().add(lblDifficultyPrompt);
		
		
		lblEnterInitialsPrompt.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblEnterInitialsPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterInitialsPrompt.setBounds(325, 352, 150, 25);
		getContentPane().add(lblEnterInitialsPrompt);
		lblErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		

		lblErrorLabel.setEnabled(false);
		lblErrorLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblErrorLabel.setBounds(230, 444, 335, 50);
		getContentPane().add(lblErrorLabel);

		txtEnterInitials = new JTextField();
		txtEnterInitials.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		txtEnterInitials.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterInitials.setBounds(325, 383, 150, 50);
		getContentPane().add(txtEnterInitials);
		txtEnterInitials.setColumns(10);
		

		btnEasyModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Method					:	actionPerformed
				 * 
				 * Method Parameters		:	ActionEvent e
				 * 
				 * Method Return			:	void
				 * 
				 * Synopsis					:	This method is responsible for setting the screen
				 * 								for the level selected by the user.
				 * 
				 * Modifications			:	Date:		Developer:		Notes:
				 * 								06/02/21	Jared Shaddick	Initial Setup
				 * 								06/07/21	Jared Shaddick	Comments Added
				 */
				
				difficultySelection(1);
			}
		});
		btnEasyModeButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		btnEasyModeButton.setBounds(25, 514, 225, 75);
		getContentPane().add(btnEasyModeButton);
		
		btnModerateModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Method					:	actionPerformed
				 * 
				 * Method Parameters		:	ActionEvent e
				 * 
				 * Method Return			:	void
				 * 
				 * Synopsis					:	This method is responsible for setting the screen
				 * 								for the level selected by the user.
				 * 
				 * Modifications			:	Date:		Developer:		Notes:
				 * 								06/02/21	Jared Shaddick	Initial Setup
				 * 								06/07/21	Jared Shaddick	Comments Added
				 */
				
				difficultySelection(2);
			}
		});
		btnModerateModeButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		btnModerateModeButton.setBounds(263, 514, 275, 75);
		getContentPane().add(btnModerateModeButton);
		
		btnDifficultModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Method					:	actionPerformed
				 * 
				 * Method Parameters		:	ActionEvent e
				 * 
				 * Method Return			:	void
				 * 
				 * Synopsis					:	This method is responsible for setting the screen
				 * 								for the level selected by the user.
				 * 
				 * Modifications			:	Date:		Developer:		Notes:
				 * 								06/02/21	Jared Shaddick	Initial Setup
				 * 								06/07/21	Jared Shaddick	Comments Added
				 */

				difficultySelection(3);
			}
		});
		btnDifficultModeButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		btnDifficultModeButton.setBounds(550, 514, 225, 75);
		getContentPane().add(btnDifficultModeButton);
		
		btnSubmissionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialsSubmitted();
			}
		});
	btnSubmissionButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	btnSubmissionButton.setBounds(485, 383, 150, 50);
	getContentPane().add(btnSubmissionButton);
	JlistHistory1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory1.setBounds(110, 155, 50, 200);
	
	contentPane.add(JlistHistory1);
	JlistHistory2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory2.setBounds(210, 155, 50, 200);
	
	contentPane.add(JlistHistory2);
	JlistHistory3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory3.setBounds(310, 150, 50, 200);
	
	contentPane.add(JlistHistory3);
	JlistHistory4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory4.setBounds(410, 155, 50, 200);
	
	contentPane.add(JlistHistory4);
	JlistHistory5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory5.setBounds(510, 155, 50, 200);
	
	contentPane.add(JlistHistory5);
	JlistHistory6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory6.setBounds(610, 155, 50, 200);
	
	contentPane.add(JlistHistory6);
	JlistHistory7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory7.setBounds(710, 155, 50, 200);
	
	contentPane.add(JlistHistory7);
	lblRangeAchieved.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblRangeAchieved.setBounds(10, 397, 150, 25);
	
	contentPane.add(lblRangeAchieved);
	lblScoreAchieved.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblScoreAchieved.setBounds(10, 430, 150, 25);
	
	contentPane.add(lblScoreAchieved);
	lblLevelAchieved.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblLevelAchieved.setBounds(10, 452, 150, 25);
	
	contentPane.add(lblLevelAchieved);
	lblInitials.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblInitials.setBounds(10, 352, 150, 25);
	
	contentPane.add(lblInitials);
	
	lblLogo.setBounds(0, 0, 809, 267);
	contentPane.add(lblLogo);
	lblCorrectnessDisplay.setBounds(110, 358, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay);
	lblCorrectnessDisplay_1.setBounds(210, 358, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay_1);
	lblCorrectnessDisplay_2.setBounds(310, 352, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay_2);
	lblCorrectnessDisplay_3.setBounds(410, 352, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay_3);
	lblCorrectnessDisplay_4.setBounds(510, 352, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay_4);
	lblCorrectnessDisplay_5.setBounds(610, 352, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay_5);
	lblCorrectnessDisplay_6.setBounds(710, 352, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay_6);
	lblArrowDisplay.setBounds(135, 358, 25, 25);
	
	contentPane.add(lblArrowDisplay);
	lblArrowDisplay_1.setBounds(225, 358, 25, 25);
	
	contentPane.add(lblArrowDisplay_1);
	lblArrowDisplay_2.setBounds(335, 352, 25, 25);
	
	contentPane.add(lblArrowDisplay_2);
	lblArrowDisplay_3.setBounds(435, 352, 25, 25);
	
	contentPane.add(lblArrowDisplay_3);
	lblArrowDisplay_4.setBounds(535, 358, 25, 25);
	
	contentPane.add(lblArrowDisplay_4);
	lblArrowDisplay_5.setBounds(634, 358, 25, 25);
	
	contentPane.add(lblArrowDisplay_5);
	lblArrowDisplay_6.setBounds(735, 358, 25, 25);
	
	contentPane.add(lblArrowDisplay_6);
	
	txtGuessField = new JTextField();
	txtGuessField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField.setBounds(106, 403, 50, 25);
	contentPane.add(txtGuessField);
	txtGuessField.setColumns(10);
	
	txtGuessField_1 = new JTextField();
	txtGuessField_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField_1.setColumns(10);
	txtGuessField_1.setBounds(210, 403, 50, 25);
	contentPane.add(txtGuessField_1);
	
	txtGuessField_2 = new JTextField();
	txtGuessField_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField_2.setColumns(10);
	txtGuessField_2.setBounds(310, 403, 50, 25);
	contentPane.add(txtGuessField_2);
	
	txtGuessField_3 = new JTextField();
	txtGuessField_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField_3.setColumns(10);
	txtGuessField_3.setBounds(410, 403, 50, 25);
	contentPane.add(txtGuessField_3);
	
	txtGuessField_4 = new JTextField();
	txtGuessField_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField_4.setColumns(10);
	txtGuessField_4.setBounds(510, 403, 50, 25);
	contentPane.add(txtGuessField_4);
	
	txtGuessField_5 = new JTextField();
	txtGuessField_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField_5.setColumns(10);
	txtGuessField_5.setBounds(610, 403, 50, 25);
	contentPane.add(txtGuessField_5);
	
	txtGuessField_6 = new JTextField();
	txtGuessField_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	txtGuessField_6.setColumns(10);
	txtGuessField_6.setBounds(710, 403, 50, 25);
	contentPane.add(txtGuessField_6);
	
	btnGuessSubmission.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (NCM2.getSelectedMode() == 1) {
				
				checkNumbers();
			}
		}
	});
	btnGuessSubmission.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
	btnGuessSubmission.setBounds(575, 452, 150, 25);
	contentPane.add(btnGuessSubmission);
	lblAttemptsCounter_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsCounter_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
	lblAttemptsCounter_1.setBounds(210, 94, 50, 50);
	
	contentPane.add(lblAttemptsCounter_1);
	lblAttemptsCounter_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsCounter_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
	lblAttemptsCounter_2.setBounds(310, 94, 50, 50);
	
	contentPane.add(lblAttemptsCounter_2);
	lblAttemptsCounter_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsCounter_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
	lblAttemptsCounter_3.setBounds(410, 94, 50, 50);
	
	contentPane.add(lblAttemptsCounter_3);
	lblAttemptsCounter_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsCounter_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
	lblAttemptsCounter_4.setBounds(510, 94, 50, 50);
	
	contentPane.add(lblAttemptsCounter_4);
	lblAttemptsCounter_5.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsCounter_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
	lblAttemptsCounter_5.setBounds(610, 94, 50, 50);
	
	contentPane.add(lblAttemptsCounter_5);
	lblAttemptsCounter_6.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsCounter_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
	lblAttemptsCounter_6.setBounds(710, 94, 50, 50);
	
	contentPane.add(lblAttemptsCounter_6);
	JlistHistory1.setVisible(false);
	JlistHistory2.setVisible(false);
	JlistHistory3.setVisible(false);
	JlistHistory4.setVisible(false);
	JlistHistory5.setVisible(false);
	JlistHistory6.setVisible(false);
	JlistHistory7.setVisible(false);
	txtGuessField.setVisible(false);
	txtGuessField_1.setVisible(false);
	txtGuessField_2.setVisible(false);
	txtGuessField_3.setVisible(false);
	txtGuessField_4.setVisible(false);
	txtGuessField_5.setVisible(false);
	txtGuessField_6.setVisible(false);
	btnGuessSubmission.setVisible(false);
	//setVisible statements end
	}
	
	private void difficultySelection(int buttonPressed) {
		if (buttonPressed == 1) {
			lblDifficultyPrompt.setVisible(false);
			lblErrorLabel.setVisible(false);
			lblEnterInitialsPrompt.setVisible(false);
			btnEasyModeButton.setVisible(false);
			btnModerateModeButton.setVisible(false);
			btnDifficultModeButton.setVisible(false);
			btnSubmissionButton.setVisible(false);
			txtEnterInitials.setVisible(false);
			lblRangeAchieved.setVisible(false);
			lblScoreAchieved.setVisible(false);
			lblLevelAchieved.setVisible(false);
			lblLogo.setVisible(false);
			
			NCM2.getMode(1);
			NCM2.theNumberArray();
			theGuessArray = new int[NCM2.getTracks()];
			
			attemptsCounter1 = NCM2.getAttempts();
			attemptsCounter2 = NCM2.getAttempts();
			attemptsCounter3 = NCM2.getAttempts();
			
			JlistHistory1.setVisible(true);
			JlistHistory2.setVisible(true);
			JlistHistory3.setVisible(true);
			
			lblCorrectnessDisplay.setVisible(true);
			lblCorrectnessDisplay_1.setVisible(true);
			lblCorrectnessDisplay_2.setVisible(true);
			lblArrowDisplay.setVisible(true);
			lblArrowDisplay_1.setVisible(true);
			lblArrowDisplay_2.setVisible(true);
			
			txtGuessField.setVisible(true);
			txtGuessField_1.setVisible(true);
			txtGuessField_2.setVisible(true);
			
			lblAttemptsCounter.setText("" + attemptsCounter1);
			lblAttemptsCounter_1.setText("" + attemptsCounter2);
			lblAttemptsCounter_2.setText("" + attemptsCounter3);
			
			btnGuessSubmission.setVisible(true);

			
			
			setTheTracks();
		}
		
		if (buttonPressed == 2) {
			lblDifficultyPrompt.setVisible(false);
			lblErrorLabel.setVisible(false);
			lblEnterInitialsPrompt.setVisible(false);
			btnEasyModeButton.setVisible(false);
			btnModerateModeButton.setVisible(false);
			btnDifficultModeButton.setVisible(false);
			btnSubmissionButton.setVisible(false);
			txtEnterInitials.setVisible(false);
			lblRangeAchieved.setVisible(false);
			lblScoreAchieved.setVisible(false);
			lblLevelAchieved.setVisible(false);
			lblLogo.setVisible(false);
			
			NCM2.getMode(2);
			NCM2.theNumberArray();
			theGuessArray = new int[NCM2.getTracks()];
			
			attemptsCounter1 = NCM2.getAttempts();
			attemptsCounter2 = NCM2.getAttempts();
			attemptsCounter3 = NCM2.getAttempts();
			attemptsCounter4 = NCM2.getAttempts();
			attemptsCounter5 = NCM2.getAttempts();
			
			JlistHistory1.setVisible(true);
			JlistHistory2.setVisible(true);
			JlistHistory3.setVisible(true);
			JlistHistory4.setVisible(true);
			JlistHistory5.setVisible(true);
			
			txtGuessField.setVisible(true);
			txtGuessField_1.setVisible(true);
			txtGuessField_2.setVisible(true);
			txtGuessField_3.setVisible(true);
			txtGuessField_4.setVisible(true);
			
			btnGuessSubmission.setVisible(true);
			
			lblAttemptsCounter.setText("" + attemptsCounter1);
			lblAttemptsCounter_1.setText("" + attemptsCounter2);
			lblAttemptsCounter_2.setText("" + attemptsCounter3);
			lblAttemptsCounter_3.setText("" + attemptsCounter4);
			lblAttemptsCounter_4.setText("" + attemptsCounter5);
			
			setTheTracks();
		}

		if (buttonPressed == 3) {
			lblDifficultyPrompt.setVisible(false);
			lblErrorLabel.setVisible(false);
			lblEnterInitialsPrompt.setVisible(false);
			btnEasyModeButton.setVisible(false);
			btnModerateModeButton.setVisible(false);
			btnDifficultModeButton.setVisible(false);
			btnSubmissionButton.setVisible(false);
			txtEnterInitials.setVisible(false);
			lblRangeAchieved.setVisible(false);
			lblScoreAchieved.setVisible(false);
			lblLevelAchieved.setVisible(false);
			lblLogo.setVisible(false);
			
			NCM2.getMode(3);
			NCM2.theNumberArray();
			theGuessArray = new int[NCM2.getTracks()];
			
			attemptsCounter1 = NCM2.getAttempts();
			attemptsCounter2 = NCM2.getAttempts();
			attemptsCounter3 = NCM2.getAttempts();
			attemptsCounter4 = NCM2.getAttempts();
			attemptsCounter5 = NCM2.getAttempts();
			attemptsCounter6 = NCM2.getAttempts();
			attemptsCounter7 = NCM2.getAttempts();
			
			JlistHistory1.setVisible(true);
			JlistHistory2.setVisible(true);
			JlistHistory3.setVisible(true);
			JlistHistory4.setVisible(true);
			JlistHistory5.setVisible(true);
			JlistHistory6.setVisible(true);
			JlistHistory7.setVisible(true);
			
			txtGuessField.setVisible(true);
			txtGuessField_1.setVisible(true);
			txtGuessField_2.setVisible(true);
			txtGuessField_3.setVisible(true);
			txtGuessField_4.setVisible(true);
			txtGuessField_5.setVisible(true);
			txtGuessField_6.setVisible(true);
			
			lblAttemptsCounter.setText("" + attemptsCounter1);
			lblAttemptsCounter_1.setText("" + attemptsCounter2);
			lblAttemptsCounter_2.setText("" + attemptsCounter3);
			lblAttemptsCounter_3.setText("" + attemptsCounter4);
			lblAttemptsCounter_4.setText("" + attemptsCounter5);
			lblAttemptsCounter_5.setText("" + attemptsCounter6);
			lblAttemptsCounter_6.setText("" + attemptsCounter7);
			
			btnGuessSubmission.setVisible(true);
			
			setTheTracks();
		}
	}
	
	private void initialsSubmitted() {
		/*
		 * Method				:	actionPerformed
		 * 
		 * Method Return		:	void
		 * 
		 * Method Parameters	:	ActionEvent e
		 * 
		 * Synopsis				:	This method is responsible for setting the player's initials
		 * 							and allowing them to pick a difficulty.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/27/21	Jared Shaddick	Initial Setup
		 * 							05/05/21	Jared Shaddick 	Comments Added
		 */		
		Pattern alphabet = Pattern.compile("[a-zA-Z]");
		
		String[] maxInitials = new String[3];
		
		playerInitials = txtEnterInitials.getText();	
		Matcher checkInitials = alphabet.matcher(playerInitials);
		
		if(checkInitials.find()) {
			
			if(txtEnterInitials.getText().toCharArray().length <= maxInitials.length) {	
				
			}
			else {
				
				lblErrorLabel.setEnabled(true);
				lblErrorLabel.setText("Error! More than three letters detected!");
			}

		}
		else {
			lblErrorLabel.setEnabled(true);
			lblErrorLabel.setText("Error! Non-letter input detected!");
		}
	}
	
	private void setTheTracks() {
		/*
		 * Method				:	setTheTracks()
		 * 
		 * Method Return		:	void
		 * 
		 * Method Parameters	: 	none
		 * 
		 * Synopsis				:	This method sets the int[] created in
		 * 							Number Cruncher Manager.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							06/04/21	Jared Shaddick	Initial Setup
		 * 							06/07/21	Jared Shaddick 	Comments Added
		 */
		theRandomArray = NCM2.getRandomizedNumbers();
	}
	
	private void checkNumbers() {
		/* Method				:	actionPerformed
		 * 
		 * Method Parameters	:	ActionEvent e
		 * 
		 * Method Return		:	null
		 * 
		 * Synopsis				:	This method is responsible for providing feedback to the 
		 * 							user based on the selections in the textFields.	The method
		 * 							will also pass a value to a parameter in Number Cruncher Manager
		 * 							so that the player may get their result calculated. This method
		 * 							will also add the previous failed guesses to a JList.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							06/05/2021	Jared Shaddick	Initial Setup Started
		 * 							06/06/2021	Jared Shaddick	Setup Finished
		 * 							06/07/2021	Jared Shaddick	Comments Added
		 */
		JTextField[] guesses = new JTextField[7];
		guesses[0] = txtGuessField;
		guesses[1] = txtGuessField_1;
		guesses[2] = txtGuessField_2;
		guesses[3] = txtGuessField_3;
		guesses[4] = txtGuessField_4;
		guesses[5] = txtGuessField_5;
		guesses[6] = txtGuessField_6;
		
		for (int indexCounter = 0; indexCounter < theGuessArray.length; indexCounter++) {
			theGuessArray[indexCounter] = Integer.parseInt(guesses[indexCounter].getText());
		}
		System.out.println(Arrays.toString(theGuessArray));
		NCM2.checkTracks(theGuessArray);
		
		JLabel[] correctnessArray = new JLabel[7];
		correctnessArray[0] = lblCorrectnessDisplay;
		correctnessArray[1] = lblCorrectnessDisplay_1;
		correctnessArray[2] = lblCorrectnessDisplay_2;
		correctnessArray[3] = lblCorrectnessDisplay_3;
		correctnessArray[4] = lblCorrectnessDisplay_4;
		correctnessArray[5] = lblCorrectnessDisplay_5;
		correctnessArray[6] = lblCorrectnessDisplay_6;
		
		JLabel[] arrowArray = new JLabel[7];
		arrowArray[0] = lblArrowDisplay;
		arrowArray[1] = lblArrowDisplay_1;
		arrowArray[2] = lblArrowDisplay_2;
		arrowArray[3] = lblArrowDisplay_3;
		arrowArray[4] = lblArrowDisplay_4;
		arrowArray[5] = lblArrowDisplay_5;
		arrowArray[6] = lblArrowDisplay_6;
		
		JList[] history = new JList[7];
		history[0] = JlistHistory1;
		history[1] = JlistHistory2;
		history[2] = JlistHistory3;
		history[3] = JlistHistory4;
		history[4] = JlistHistory5;
		history[5] = JlistHistory6;
		history[6] = JlistHistory7;
		
		String[] historicNumber = new String[7];
		historicNumber[0] = guesses[0].getText();
		historicNumber[1] = guesses[1].getText();
		historicNumber[2] = guesses[2].getText();
		historicNumber[3] = guesses[3].getText();
		historicNumber[4] = guesses[4].getText();
		historicNumber[5] = guesses[5].getText();
		historicNumber[6] = guesses[6].getText();
		
		DefaultListModel[] numberList = new DefaultListModel[7];
		numberList[0] = numberList1;
		numberList[1] = numberList2;
		numberList[2] = numberList3;
		numberList[3] = numberList4;
		numberList[4] = numberList5;
		numberList[5] = numberList6;
		numberList[6] = numberList7;
		
		if (NCM2.getSelectedMode() == 1) {
			for (int indexCounter = 0; indexCounter < NCM2.getResult().length; indexCounter++) {
				if (NCM2.getResult()[indexCounter] == 1) {
					correctnessArray[indexCounter].setIcon(checkMark);
				}
				else {
					correctnessArray[indexCounter].setIcon(xMark);
					
					numberList[indexCounter].addElement(historicNumber[indexCounter]);
				}
				if (theGuessArray[indexCounter] < theRandomArray[indexCounter]) {
					arrowArray[indexCounter].setIcon(arrowUp);	
				}
				else if (theGuessArray[indexCounter] > theRandomArray[indexCounter]){
					arrowArray[indexCounter].setIcon(arrowDown);	
				}
			}
			
		}
		
		if (NCM2.getSelectedMode() == 2) {
			for (int indexCounter = 0; indexCounter < NCM2.getResult().length; indexCounter++) {
				for (indexCounter = 0; indexCounter < NCM2.getResult().length; indexCounter++) {
					if (NCM2.getResult()[indexCounter] == 1) {
						correctnessArray[indexCounter].setIcon(checkMark);
					}
					else {
						correctnessArray[indexCounter].setIcon(xMark);
						
						numberList[indexCounter].addElement(historicNumber[indexCounter]);
					}
					if (theGuessArray[indexCounter] < theRandomArray[indexCounter]) {
						arrowArray[indexCounter].setIcon(arrowUp);	
					}
					else if (theGuessArray[indexCounter] > theRandomArray[indexCounter]){
						arrowArray[indexCounter].setIcon(arrowDown);	
					}
				}
			}
		}
		if (NCM2.getSelectedMode() == 3) {
			for (int indexCounter = 0; indexCounter < NCM2.getResult().length; indexCounter++) {
				if (NCM2.getResult()[indexCounter] == 1) {
					for (indexCounter = 0; indexCounter < NCM2.getResult().length; indexCounter++) {
						if (NCM2.getResult()[indexCounter] == 1) {
							correctnessArray[indexCounter].setIcon(checkMark);
						}
						else {
							correctnessArray[indexCounter].setIcon(xMark);
							
							numberList[indexCounter].addElement(historicNumber[indexCounter]);
						}
						if (theGuessArray[indexCounter] < theRandomArray[indexCounter]) {
							arrowArray[indexCounter].setIcon(arrowUp);	
						}
						else if (theGuessArray[indexCounter] > theRandomArray[indexCounter]){
							arrowArray[indexCounter].setIcon(arrowDown);	
						}
					}
				}
			}
		}
	}
	
	private void gameOver() {
		/*
		 * Method				:	gameOver
		 * 
		 * Method Parameters	:	none
		 * 
		 * Method Return		: 	void
		 * 
		 * Synopsis				:	This method is responsible for modifying a file so that 
		 * 							player stats from a game can be saved. It is also in charge of
		 * 							displaying game over text to the player.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							06/07/21	Jared Shaddick	Initial Setup & Comments Added
		 */					
		
		JlistHistory1.setVisible(false);
		JlistHistory2.setVisible(false);
		JlistHistory3.setVisible(false);
		JlistHistory4.setVisible(false);
		JlistHistory5.setVisible(false);
		JlistHistory6.setVisible(false);
		JlistHistory7.setVisible(false);
		lblCorrectnessDisplay.setVisible(false);
		lblCorrectnessDisplay_1.setVisible(false);
		lblCorrectnessDisplay_2.setVisible(false);
		lblCorrectnessDisplay_3.setVisible(false);
		lblCorrectnessDisplay_4.setVisible(false);
		lblCorrectnessDisplay_5.setVisible(false);
		lblCorrectnessDisplay_6.setVisible(false);
		lblArrowDisplay.setVisible(false);
		lblArrowDisplay_1.setVisible(false);
		lblArrowDisplay_2.setVisible(false);
		lblArrowDisplay_3.setVisible(false);
		lblArrowDisplay_4.setVisible(false);
		lblArrowDisplay_5.setVisible(false);
		lblArrowDisplay_6.setVisible(false);
		txtGuessField.setVisible(false);
		txtGuessField_1.setVisible(false);
		txtGuessField_2.setVisible(false);
		txtGuessField_3.setVisible(false);
		txtGuessField_4.setVisible(false);
		txtGuessField_5.setVisible(false);
		txtGuessField_6.setVisible(false);
		btnGuessSubmission.setVisible(false);
		
		
	}
		@Override
	public void actionPerformed(ActionEvent e) {
		if (timeToEmptyText) {
			
			if (!gameOver) {
				lblErrorLabel.setText("");
			}
		}
		timeToEmptyText = !timeToEmptyText;
	}
};

