package numberCruncher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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
	
	private JTextField textFieldTrack1_1;
	private JTextField textFieldTrack2_1;
	private JTextField textFieldTrack3_1;
	private JLabel lblRange_1 = new JLabel("Range: ");
	private JLabel lblEasyTrack1_1 = new JLabel("Track 1");
	private JLabel lblEasyTrack2_1 = new JLabel("Track 2");
	private JLabel lblEasyTrack3_1 = new JLabel("Track 3");
	private JLabel lblAttemptsDisplay1_1 = new JLabel("");
	private JLabel lblAttemptsDisplay2_1 = new JLabel("");
	private JLabel lblAttemptsDisplay3_1 = new JLabel("");
	private JLabel lblArrowDisplay1_1 = new JLabel("");
	private JLabel lblArrowDisplay2_1 = new JLabel("");
	private JLabel lblArrowDisplay3_1 = new JLabel("");
	private JLabel lblAttempts_1 = new JLabel("Attempts:");
	private JButton btnGuessSubmission_1 = new JButton("Submit Guesses");
	private JLabel lblCorrectnessDisplay1_1 = new JLabel("");
	private JLabel lblCorrectnessDisplay2_1 = new JLabel("");
	private JLabel lblCorrectnessDisplay3_1 = new JLabel("");
	
	private JTextField textFieldGuess1_2;
	private JTextField textFieldGuess2_2;
	private JTextField textFieldGuess3_2;
	private JTextField textFieldGuess4_2;
	private JTextField textFieldGuess5_2;
	private JLabel lblRange_2 = new JLabel("Range: ");
	private JLabel lblTrack1_2 = new JLabel("Track 1");
	private JLabel lblTrack2_2 = new JLabel("Track 2");
	private JLabel lblTrack3_2 = new JLabel("Track 3");
	private JLabel lblTrack4_2 = new JLabel("Track 4");
	private JLabel lblTrack5_2 = new JLabel("Track 5");
	private JLabel lblAttemptsDisplay1_2 = new JLabel("");
	private JLabel lblAttemptsDisplay2_2 = new JLabel("");
	private JLabel lblAttemptsDisplay3_2 = new JLabel("");
	private JLabel lblAttemptsDisplay4_2 = new JLabel("");
	private JLabel lblAttemptsDisplay5_2 = new JLabel("");
	private JLabel lblArrowDisplay1_2 = new JLabel("");
	private JLabel lblArrowDisplay2_2 = new JLabel("");
	private JLabel lblArrowDisplay3_2 = new JLabel("");
	private JLabel lblArrowDisplay4_2 = new JLabel("");
	private JLabel lblArrowDisplay5_2 = new JLabel("");
	private JLabel lblAttempts_2 = new JLabel("Attempts:");
	private JButton btnGuessSubmission_2 = new JButton("Submit Guesses");
	
	private JTextField textFieldGuess1_3;
	private JTextField textFieldGuess2_3;
	private JTextField textFieldGuess3_3;
	private JTextField textFieldGuess4_3;
	private JTextField textFieldGuess5_3;
	private JTextField textFieldGuess6_3;
	private JTextField textFieldGuess7_3;
	private JLabel lblTrack1_3 = new JLabel("Track 1");
	private JLabel lblTrack2_3 = new JLabel("Track 2");
	private JLabel lblTrack3_3 = new JLabel("Track 3");
	private JLabel lblTrack4_3 = new JLabel("Track 4");
	private JLabel lblTrack5_3 = new JLabel("Track 5");
	private JLabel lblTrack6_3 = new JLabel("Track 6");
	private JLabel lblTrack7_3 = new JLabel("Track 7");
	private JLabel lblRange_3 = new JLabel("Range:");
	private JLabel lblAttempts_3 = new JLabel("Attempts:");
	private JLabel lblAttemptsDisplay1_3 = new JLabel("");
	private JLabel lblAttemptsDisplay2_3 = new JLabel("");
	private JLabel lblAttemptsDisplay3_3 = new JLabel("");
	private JLabel lblAttemptsDisplay4_3 = new JLabel("");
	private JLabel lblAttemptsDisplay5_3 = new JLabel("");
	private JLabel lblAttemptsDisplay6_3 = new JLabel("");
	private JLabel lblAttemptsDisplay7_3 = new JLabel("");
	private JLabel lblArrowDisplay1_3 = new JLabel("");
	private JLabel lblArrowDisplay2_3 = new JLabel("");
	private JLabel lblArrowDisplay3_3 = new JLabel("");
	private JLabel lblArrowDisplay4_3 = new JLabel("");
	private JLabel lblArrowDisplay5_3 = new JLabel("");
	private JLabel lblArrowDisplay6_3 = new JLabel("");
	private JLabel lblArrowDisplay7_3 = new JLabel("");
	private JButton btnSubmitGuesses_3 = new JButton("Submit Guesses");
	private JLabel lblGameError = new JLabel("");
	
	DefaultListModel<String> numberList1 = new DefaultListModel<>(); //used to display the history of the users guesses for each track
	DefaultListModel<String> numberList2 = new DefaultListModel<>();
	DefaultListModel<String> numberList3 = new DefaultListModel<>();
	DefaultListModel<String> numberList4 = new DefaultListModel<>();
	DefaultListModel<String> numberList5 = new DefaultListModel<>();
	DefaultListModel<String> numberList6 = new DefaultListModel<>();
	DefaultListModel<String> numberList7 = new DefaultListModel<>();
	
	private JList JlistHistory1_1 = new JList(numberList1);
	private JList JlistHistory2_1 = new JList(numberList2);
	private JList JlistHistory3_1 = new JList(numberList3);
	
	private JList JlistHistory1_2 = new JList(numberList1);
	private JList JlistHistory2_2 = new JList(numberList2);
	private JList JlistHistory3_2 = new JList(numberList3);
	private JList JlistHistory4_2 = new JList(numberList4);
	private JList JlistHistory5_2 = new JList(numberList5);
	
	private JList JlistHistory1_3 = new JList(numberList1);
	private JList JlistHistory2_3 = new JList(numberList2);
	private JList JlistHistory3_3 = new JList(numberList3);
	private JList JlistHistory4_3 = new JList(numberList4);
	private JList JlistHistory5_3 = new JList(numberList5);
	private JList JlistHistory6_3 = new JList(numberList6);
	private JList JlistHistory7_3 = new JList(numberList7);
	
	private JLabel lblCorrectnessDisplay1_2 = new JLabel("");
	private JLabel lblCorrectnessDisplay2_2 = new JLabel("");
	private JLabel lblCorrectnessDisplay3_2 = new JLabel("");
	private JLabel lblCorrectnessDisplay4_2 = new JLabel("");
	private JLabel lblCorrectnessDisplay5_2 = new JLabel("");
	
	private JLabel lblCorrectnessDisplay1_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay2_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay3_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay4_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay5_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay6_3 = new JLabel("");
	private JLabel lblCorrectnessDisplay7_3 = new JLabel("");
	
	private JLabel lblScore = new JLabel("Score: ");
	private JLabel lblLevel = new JLabel("Level:");
	
	private JLabel lblInitials = new JLabel("");
	private JLabel lblRangeAchieved = new JLabel("");
	private JLabel lblScoreAchieved = new JLabel("");
	private JLabel lblLevelAchieved = new JLabel("");
	
	NumberCruncherManager2 NCM2 = new NumberCruncherManager2();
	
	private int[] theRandomArray;
	private int[] theGuessArray;
	
	private boolean allNumbersCorrect = false;
	
	private int tracksGuessed = 0;
	
	private ImageIcon checkMark = new ImageIcon("Images/CheckMark.png");
	private ImageIcon xMark = new ImageIcon("Images/XMark.png");
	private ImageIcon arrowUp = new ImageIcon("Images/LedArrowUp.png");
	private ImageIcon arrowDown = new ImageIcon("Images/LedArrowDown.png");
	
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
				
				if (initialsSubmitted) {
					
					lblGameError.setVisible(true);
					theGuessArray = new int[3];
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
					
					NCM2.getMode(1);
					NCM2.theNumberArray();
					
					attemptsCounter1 = NCM2.getAttempts();
					attemptsCounter2 = NCM2.getAttempts();
					attemptsCounter3 = NCM2.getAttempts();
					
					textFieldTrack1_1.setVisible(true);
					textFieldTrack2_1.setVisible(true);
					textFieldTrack3_1.setVisible(true);
					lblRange_1.setVisible(true);
					lblEasyTrack1_1.setVisible(true);
					lblEasyTrack2_1.setVisible(true);
					lblEasyTrack3_1.setVisible(true);
					lblAttemptsDisplay1_1.setVisible(true);
					lblAttemptsDisplay2_1.setVisible(true);
					lblAttemptsDisplay3_1.setVisible(true);
					JlistHistory1_1.setVisible(true);
					JlistHistory2_1.setVisible(true);
					JlistHistory3_1.setVisible(true);
					lblAttempts_1.setVisible(true);
					btnGuessSubmission_1.setVisible(true);
					lblAttemptsDisplay1_1.setText("" + attemptsCounter1);
					lblAttemptsDisplay2_1.setText("" + attemptsCounter2);
					lblAttemptsDisplay3_1.setText("" + attemptsCounter3);
					lblRange_1.setText("Range: 0-" + NCM2.getRange());
					
					lblScore.setVisible(true);
					lblLevel.setVisible(true);
					
					setTheTracks();
				}
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
				
				if (initialsSubmitted) {
					lblGameError.setVisible(true);
					theGuessArray = new int[5];
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
					
					NCM2.getMode(2);
					NCM2.theNumberArray();
					
					attemptsCounter1 = NCM2.getAttempts();
					attemptsCounter2 = NCM2.getAttempts();
					attemptsCounter3 = NCM2.getAttempts();
					attemptsCounter4 = NCM2.getAttempts();
					attemptsCounter5 = NCM2.getAttempts();
					
					textFieldGuess1_2.setVisible(true);
					textFieldGuess2_2.setVisible(true);
					textFieldGuess3_2.setVisible(true);
					textFieldGuess4_2.setVisible(true);
					textFieldGuess5_2.setVisible(true);
					lblRange_2.setVisible(true);
					lblTrack1_2.setVisible(true);
					lblTrack2_2.setVisible(true);
					lblTrack3_2.setVisible(true);
					lblTrack4_2.setVisible(true);
					lblTrack5_2.setVisible(true);
					JlistHistory1_2.setVisible(true);
					JlistHistory2_2.setVisible(true);
					JlistHistory3_2.setVisible(true);
					JlistHistory4_2.setVisible(true);
					JlistHistory5_2.setVisible(true);
					lblCorrectnessDisplay1_2.setVisible(true);
					lblCorrectnessDisplay2_2.setVisible(true);
					lblCorrectnessDisplay3_2.setVisible(true);
					lblCorrectnessDisplay4_2.setVisible(true);
					lblCorrectnessDisplay5_2.setVisible(true);
					lblAttemptsDisplay1_2.setVisible(true);
					lblAttemptsDisplay2_2.setVisible(true);
					lblAttemptsDisplay3_2.setVisible(true);
					lblAttemptsDisplay4_2.setVisible(true);
					lblAttemptsDisplay5_2.setVisible(true);
					lblArrowDisplay1_2.setVisible(true);
					lblArrowDisplay2_2.setVisible(true);
					lblArrowDisplay3_2.setVisible(true);
					lblArrowDisplay4_2.setVisible(true);
					lblArrowDisplay5_2.setVisible(true);
					lblAttempts_2.setVisible(true);
					lblRange_2.setText("Range: 0-" + NCM2.getRange());
					lblAttemptsDisplay1_2.setText("" + attemptsCounter1);
					lblAttemptsDisplay2_2.setText("" + attemptsCounter2);
					lblAttemptsDisplay3_2.setText("" + attemptsCounter3);
					lblAttemptsDisplay4_2.setText("" + attemptsCounter4);
					lblAttemptsDisplay5_2.setText("" + attemptsCounter5);
					btnGuessSubmission_2.setVisible(true);
					
					lblScore.setVisible(true);
					lblLevel.setVisible(true);
					
					setTheTracks();
				}
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

				if (initialsSubmitted) {
					lblGameError.setVisible(true);
					theGuessArray = new int[7];
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
					
					NCM2.getMode(3);
					NCM2.theNumberArray();
					
					attemptsCounter1 = NCM2.getAttempts();
					attemptsCounter2 = NCM2.getAttempts();
					attemptsCounter3 = NCM2.getAttempts();
					attemptsCounter4 = NCM2.getAttempts();
					attemptsCounter5 = NCM2.getAttempts();
					attemptsCounter6 = NCM2.getAttempts();
					attemptsCounter7 = NCM2.getAttempts();
					
					textFieldGuess1_3.setVisible(true);
					textFieldGuess2_3.setVisible(true);
					textFieldGuess3_3.setVisible(true);
					textFieldGuess4_3.setVisible(true);
					textFieldGuess5_3.setVisible(true);
					textFieldGuess6_3.setVisible(true);
					textFieldGuess7_3.setVisible(true);
					lblRange_3.setVisible(true);
					lblTrack1_3.setVisible(true);
					lblTrack2_3.setVisible(true);
					lblTrack3_3.setVisible(true);
					lblTrack4_3.setVisible(true);
					lblTrack5_3.setVisible(true);
					lblTrack6_3.setVisible(true);
					lblTrack7_3.setVisible(true);
					JlistHistory1_3.setVisible(true);
					JlistHistory2_3.setVisible(true);
					JlistHistory3_3.setVisible(true);
					JlistHistory4_3.setVisible(true);
					JlistHistory5_3.setVisible(true);
					JlistHistory6_3.setVisible(true);
					JlistHistory7_3.setVisible(true);
					lblAttemptsDisplay1_3.setVisible(true);
					lblAttemptsDisplay2_3.setVisible(true);
					lblAttemptsDisplay3_3.setVisible(true);
					lblAttemptsDisplay4_3.setVisible(true);
					lblAttemptsDisplay5_3.setVisible(true);
					lblAttemptsDisplay6_3.setVisible(true);
					lblAttemptsDisplay7_3.setVisible(true);
					lblCorrectnessDisplay1_3.setVisible(true);
					lblCorrectnessDisplay2_3.setVisible(true);
					lblCorrectnessDisplay3_3.setVisible(true);
					lblCorrectnessDisplay4_3.setVisible(true);
					lblCorrectnessDisplay5_3.setVisible(true);
					lblCorrectnessDisplay6_3.setVisible(true);
					lblCorrectnessDisplay7_3.setVisible(true);
					lblArrowDisplay1_3.setVisible(true);
					lblArrowDisplay2_3.setVisible(true);
					lblArrowDisplay3_3.setVisible(true);
					lblArrowDisplay4_3.setVisible(true);
					lblArrowDisplay5_3.setVisible(true);
					lblArrowDisplay6_3.setVisible(true);
					lblArrowDisplay7_3.setVisible(true);
					lblAttempts_3.setVisible(true);
					btnSubmitGuesses_3.setVisible(true);
					
					lblRange_3.setText("Range: 0-" + NCM2.getRange());
					
					lblAttemptsDisplay1_3.setText("" + attemptsCounter1);
					lblAttemptsDisplay2_3.setText("" + attemptsCounter2);
					lblAttemptsDisplay3_3.setText("" + attemptsCounter3);
					lblAttemptsDisplay4_3.setText("" + attemptsCounter4);
					lblAttemptsDisplay5_3.setText("" + attemptsCounter5);
					lblAttemptsDisplay6_3.setText("" + attemptsCounter6);
					lblAttemptsDisplay7_3.setText("" + attemptsCounter7);
					
					lblScore.setVisible(true);
					lblLevel.setVisible(true);
					
					setTheTracks();
				}
			}
		});
		btnDifficultModeButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		btnDifficultModeButton.setBounds(550, 514, 225, 75);
		getContentPane().add(btnDifficultModeButton);
		
		btnSubmissionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					
					if(playerInitials.toCharArray().length <= maxInitials.length) {
						initialsSubmitted = true;
						lblEnterInitialsPrompt.setText("Initials Entered");
						lblDifficultyPrompt.setText("Select A Difficulty");
						readFile();
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
		});
	btnSubmissionButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	btnSubmissionButton.setBounds(485, 383, 150, 50);
	getContentPane().add(btnSubmissionButton);
	
	lblRange_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblRange_1.setBounds(504, 105, 200, 30);
	getContentPane().add(lblRange_1);
	
	lblEasyTrack1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblEasyTrack1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	lblEasyTrack1_1.setBounds(270, 30, 60, 25);
	getContentPane().add(lblEasyTrack1_1);
	
	lblEasyTrack2_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblEasyTrack2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	lblEasyTrack2_1.setBounds(340, 30, 60, 25);
	getContentPane().add(lblEasyTrack2_1);
	
	lblEasyTrack3_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblEasyTrack3_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	lblEasyTrack3_1.setBounds(410, 30, 60, 25);
	getContentPane().add(lblEasyTrack3_1);
	
	lblAttemptsDisplay1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay1_1.setBounds(270, 55, 60, 50);
	getContentPane().add(lblAttemptsDisplay1_1);
	
	lblAttemptsDisplay2_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay2_1.setBounds(340, 55, 60, 50);
	getContentPane().add(lblAttemptsDisplay2_1);
	

	lblAttemptsDisplay3_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay3_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay3_1.setBounds(410, 55, 60, 50);
	getContentPane().add(lblAttemptsDisplay3_1);

	lblArrowDisplay1_1.setBounds(270, 316, 24, 24);
	getContentPane().add(lblArrowDisplay1_1);
	
	lblArrowDisplay2_1.setBounds(340, 316, 24, 24);
	getContentPane().add(lblArrowDisplay2_1);
	
	lblArrowDisplay3_1.setBounds(410, 316, 24, 24);
	getContentPane().add(lblArrowDisplay3_1);
	
	textFieldTrack1_1 = new JTextField();
	textFieldTrack1_1.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldTrack1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldTrack1_1.setBounds(270, 387, 60, 35);
	getContentPane().add(textFieldTrack1_1);
	textFieldTrack1_1.setColumns(10);
	
	textFieldTrack2_1 = new JTextField();
	textFieldTrack2_1.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldTrack2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldTrack2_1.setColumns(10);
	textFieldTrack2_1.setBounds(340, 387, 60, 35);
	getContentPane().add(textFieldTrack2_1);
	
	textFieldTrack3_1 = new JTextField();
	textFieldTrack3_1.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldTrack3_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldTrack3_1.setColumns(10);
	textFieldTrack3_1.setBounds(410, 387, 60, 35);
	getContentPane().add(textFieldTrack3_1);
	
	lblAttempts_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttempts_1.setBounds(130, 52, 130, 50);
	getContentPane().add(lblAttempts_1);
	
	lblTrack1_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblTrack1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	lblTrack1_2.setBounds(150, 35, 60, 20);
	getContentPane().add(lblTrack1_2);
	
	lblTrack2_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblTrack2_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	lblTrack2_2.setBounds(250, 35, 60, 20);
	getContentPane().add(lblTrack2_2);
	
	lblTrack3_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblTrack3_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	lblTrack3_2.setBounds(350, 35, 60, 20);
	getContentPane().add(lblTrack3_2);
	
	lblTrack4_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblTrack4_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	lblTrack4_2.setBounds(450, 35, 60, 20);
	getContentPane().add(lblTrack4_2);
	
	lblTrack5_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblTrack5_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	lblTrack5_2.setBounds(550, 35, 60, 20);
	getContentPane().add(lblTrack5_2);
	
	lblAttemptsDisplay1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay1_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay1_2.setBounds(155, 60, 50, 50);
	getContentPane().add(lblAttemptsDisplay1_2);
	
	lblAttemptsDisplay2_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay2_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay2_2.setBounds(255, 60, 50, 50);
	getContentPane().add(lblAttemptsDisplay2_2);
	
	lblAttemptsDisplay3_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay3_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay3_2.setBounds(355, 60, 50, 50);
	getContentPane().add(lblAttemptsDisplay3_2);
	
	lblAttemptsDisplay4_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay4_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay4_2.setBounds(455, 60, 50, 50);
	getContentPane().add(lblAttemptsDisplay4_2);
	
	lblAttemptsDisplay5_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay5_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 28));
	lblAttemptsDisplay5_2.setBounds(555, 60, 50, 50);
	getContentPane().add(lblAttemptsDisplay5_2);
	
	lblArrowDisplay1_2.setBounds(150, 325, 25, 25);
	getContentPane().add(lblArrowDisplay1_2);
	
	lblArrowDisplay2_2.setBounds(250, 325, 25, 25);
	getContentPane().add(lblArrowDisplay2_2);
	
	lblArrowDisplay3_2.setBounds(350, 326, 25, 25);
	getContentPane().add(lblArrowDisplay3_2);
	
	lblArrowDisplay4_2.setBounds(450, 325, 25, 25);
	getContentPane().add(lblArrowDisplay4_2);
	
	lblArrowDisplay5_2.setBounds(550, 326, 25, 25);
	getContentPane().add(lblArrowDisplay5_2);
	
	textFieldGuess1_2 = new JTextField();
	textFieldGuess1_2.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	textFieldGuess1_2.setBounds(150, 395, 60, 25);
	getContentPane().add(textFieldGuess1_2);
	textFieldGuess1_2.setColumns(10);
	
	textFieldGuess2_2 = new JTextField();
	textFieldGuess2_2.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess2_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	textFieldGuess2_2.setColumns(10);
	textFieldGuess2_2.setBounds(250, 395, 60, 25);
	getContentPane().add(textFieldGuess2_2);
	
	textFieldGuess3_2 = new JTextField();
	textFieldGuess3_2.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess3_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	textFieldGuess3_2.setColumns(10);
	textFieldGuess3_2.setBounds(350, 395, 60, 25);
	getContentPane().add(textFieldGuess3_2);
	
	textFieldGuess4_2 = new JTextField();
	textFieldGuess4_2.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess4_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	textFieldGuess4_2.setColumns(10);
	textFieldGuess4_2.setBounds(450, 395, 60, 25);
	getContentPane().add(textFieldGuess4_2);
	
	textFieldGuess5_2 = new JTextField();
	textFieldGuess5_2.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess5_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
	textFieldGuess5_2.setColumns(10);
	textFieldGuess5_2.setBounds(550, 395, 60, 25);
	getContentPane().add(textFieldGuess5_2);
	
	lblAttempts_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttempts_2.setBounds(31, 60, 100, 50);
	getContentPane().add(lblAttempts_2);
	lblRange_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	
	lblRange_2.setBounds(615, 60, 150, 50);
	getContentPane().add(lblRange_2);
	
	btnGuessSubmission_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
			Pattern numbers = Pattern.compile("[0-9]");
			
			String historicalNumber1;
			String historicalNumber2;
			String historicalNumber3;
			String historicalNumber4;
			String historicalNumber5;
			
			int numberGuessed1;
			int numberGuessed2;
			int numberGuessed3;
			int numberGuessed4;
			int numberGuessed5;
			
			numberGuessed1 = Integer.parseInt(textFieldGuess1_2.getText());
			numberGuessed2 = Integer.parseInt(textFieldGuess2_2.getText());
			numberGuessed3 = Integer.parseInt(textFieldGuess3_2.getText());
			numberGuessed4 = Integer.parseInt(textFieldGuess4_2.getText());
			numberGuessed5 = Integer.parseInt(textFieldGuess5_2.getText());
			
			
			
			Matcher checkNumber1 = numbers.matcher(String.valueOf(numberGuessed1));
			Matcher checkNumber2 = numbers.matcher(String.valueOf(numberGuessed2));
			Matcher checkNumber3 = numbers.matcher(String.valueOf(numberGuessed3));
			Matcher checkNumber4 = numbers.matcher(String.valueOf(numberGuessed4));
			Matcher checkNumber5 = numbers.matcher(String.valueOf(numberGuessed5));
			
			if (checkNumber1.find()) {
				if (numberGuessed1 == theRandomArray[0]) {
					theGuessArray[0] = numberGuessed1;
					
					lblCorrectnessDisplay1_2.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed1 < theGuessArray[0]) {
					attemptsCounter1--;
					lblArrowDisplay1_2.setIcon(arrowUp);
					lblCorrectnessDisplay1_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber1 = String.valueOf(numberGuessed1);
					
					numberList1.addElement(historicalNumber1);
				}
				else if(numberGuessed1 > theGuessArray[0]) {
					attemptsCounter1--;
					lblArrowDisplay1_2.setIcon(arrowDown);
					lblCorrectnessDisplay1_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber1 = String.valueOf(numberGuessed1);
					
					numberList1.addElement(historicalNumber1);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if(checkNumber2.find()) {
				if (numberGuessed2 == theRandomArray[1]) {
					theGuessArray[1] = numberGuessed2;
					
					lblCorrectnessDisplay2_2.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed1 < theGuessArray[1]) {
					attemptsCounter2--;
					lblArrowDisplay2_2.setIcon(arrowUp);
					lblCorrectnessDisplay2_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber1 = String.valueOf(numberGuessed1);
					
					numberList1.addElement(historicalNumber1);
				}
				else if(numberGuessed2 > theGuessArray[1]) {
					attemptsCounter2--;
					lblArrowDisplay2_2.setIcon(arrowDown);
					lblCorrectnessDisplay2_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber2 = String.valueOf(numberGuessed2);
					
					numberList2.addElement(historicalNumber2);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if(checkNumber3.find()) {
				if (numberGuessed3 == theRandomArray[2]) {
					theGuessArray[2] = numberGuessed3;
					
					lblCorrectnessDisplay3_2.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed3 < theGuessArray[2]) {
					attemptsCounter3--;
					lblArrowDisplay3_2.setIcon(arrowUp);
					lblCorrectnessDisplay3_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber3 = String.valueOf(numberGuessed3);
					
					numberList3.addElement(historicalNumber3);
				}
				else if(numberGuessed3 > theGuessArray[0]) {
					attemptsCounter3--;
					lblArrowDisplay3_2.setIcon(arrowDown);
					lblCorrectnessDisplay3_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber3 = String.valueOf(numberGuessed3);
					
					numberList3.addElement(historicalNumber3);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if (checkNumber4.find()) {
				if (numberGuessed4 == theRandomArray[3]) {
					theGuessArray[3] = numberGuessed4;
					
					lblCorrectnessDisplay4_2.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed4 < theGuessArray[3]) {
					attemptsCounter4--;
					lblArrowDisplay4_2.setIcon(arrowUp);
					lblCorrectnessDisplay4_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber4 = String.valueOf(numberGuessed4);
					
					numberList4.addElement(historicalNumber4);
				}
				else if(numberGuessed4 > theGuessArray[3]) {
					attemptsCounter4--;
					lblArrowDisplay4_2.setIcon(arrowDown);
					lblCorrectnessDisplay4_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber4 = String.valueOf(numberGuessed4);
					
					numberList4.addElement(historicalNumber4);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if (checkNumber5.find()) {
				if (numberGuessed5 == theRandomArray[4]) {
					theGuessArray[4] = numberGuessed5;
					
					lblCorrectnessDisplay5_2.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed5 < theGuessArray[4]) {
					attemptsCounter5--;
					lblArrowDisplay5_2.setIcon(arrowUp);
					lblCorrectnessDisplay5_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber5 = String.valueOf(numberGuessed5);
					
					numberList5.addElement(historicalNumber5);
				}
				else if(numberGuessed5 > theGuessArray[4]) {
					attemptsCounter5--;
					lblArrowDisplay5_2.setIcon(arrowDown);
					lblCorrectnessDisplay5_2.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber5 = String.valueOf(numberGuessed5);
					
					numberList5.addElement(historicalNumber5);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			if (tracksGuessed == 5) {
				allNumbersCorrect = true;
				NCM2.checkTracks(allNumbersCorrect);
				tracksGuessed = 0;
				if (allNumbersCorrect) {
					allNumbersCorrect = false;
				}
			}
			lblAttemptsDisplay1_2.setText("" + attemptsCounter1);
			lblAttemptsDisplay2_2.setText("" + attemptsCounter2);
			lblAttemptsDisplay3_2.setText("" + attemptsCounter3);
			lblAttemptsDisplay4_2.setText("" + attemptsCounter4);
			lblAttemptsDisplay5_2.setText("" + attemptsCounter5);
			lblRange_2.setText("Range: 0-" + NCM2.getRange());
			lblScore.setText("Score: " + NCM2.getScore());
			lblLevel.setText("Level: " + NCM2.getLevel());
			theRandomArray = new int[NCM2.getRange()];
			theRandomArray = NCM2.getRandomizedNumbers();
			if (attemptsCounter1 == 0 || attemptsCounter2 == 0 || attemptsCounter3 == 0) {
				gameOver();
			}
		}
	});
	btnGuessSubmission_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	btnGuessSubmission_2.setBounds(270, 427, 210, 50);
	
	contentPane.add(btnGuessSubmission_2);
	
	btnGuessSubmission_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
				Pattern numbers = Pattern.compile("[0-9]");
				
				String historicalNumber1;
				String historicalNumber2;
				String historicalNumber3;
				
				int numberGuessed1;
				int numberGuessed2;
				int numberGuessed3;
				
				numberGuessed1 = Integer.parseInt(textFieldTrack1_1.getText());
				numberGuessed2 = Integer.parseInt(textFieldTrack2_1.getText());
				numberGuessed3 = Integer.parseInt(textFieldTrack3_1.getText());
				
				Matcher checkNumber1 = numbers.matcher(String.valueOf(numberGuessed1));
				Matcher checkNumber2 = numbers.matcher(String.valueOf(numberGuessed2));
				Matcher checkNumber3 = numbers.matcher(String.valueOf(numberGuessed3));
				
				if(checkNumber1.find()) {
					if (numberGuessed1 == theRandomArray[0]) {
						theGuessArray[0] = numberGuessed1;
						
						lblCorrectnessDisplay1_1.setIcon(checkMark);
						tracksGuessed++;
					}
					else if(numberGuessed1 < theGuessArray[0]) {
						tracksGuessed = 0;
						attemptsCounter1--;
						lblArrowDisplay1_1.setIcon(arrowUp);
						lblCorrectnessDisplay1_1.setIcon(xMark);
						
						historicalNumber1 = String.valueOf(numberGuessed1);
						
						numberList1.addElement(historicalNumber1);
					}
					else if(numberGuessed1 > theGuessArray[0]) {
						tracksGuessed = 0;
						attemptsCounter1--;
						lblArrowDisplay1_1.setIcon(arrowDown);
						lblCorrectnessDisplay1_1.setIcon(xMark);
						
						historicalNumber1 = String.valueOf(numberGuessed1);
						
						numberList1.addElement(historicalNumber1);
					}
					
				}
				
				else {
					lblGameError.setText("Non-Digit Detected!!");
				}
				
				if (checkNumber2.find()) {
					if (numberGuessed2 == theRandomArray[1]) {
						theGuessArray[1] = numberGuessed2;
						
						lblCorrectnessDisplay2_1.setIcon(checkMark);
						tracksGuessed++;
					}
					else if(numberGuessed2 < theGuessArray[1]) {
						tracksGuessed = 0;
						attemptsCounter2--;
						lblArrowDisplay2_1.setIcon(arrowUp);
						lblCorrectnessDisplay2_1.setIcon(xMark);
						
						historicalNumber2 = String.valueOf(numberGuessed2);
						
						numberList2.addElement(historicalNumber2);
					}
					else if(numberGuessed2 > theGuessArray[1]) {
						tracksGuessed = 0;
						attemptsCounter2--;
						lblArrowDisplay2_1.setIcon(arrowDown);
						lblCorrectnessDisplay2_1.setIcon(xMark);
						
						historicalNumber2 = String.valueOf(numberGuessed2);
						
						numberList2.addElement(historicalNumber2);
					}
				}
				else {
					lblGameError.setText("Non-Digit Detected!!");
				}
				
				if (checkNumber3.find()) {
					if (numberGuessed3 == theRandomArray[2]) {
						theGuessArray[2] = numberGuessed3;
						
						lblCorrectnessDisplay3_1.setIcon(checkMark);
						tracksGuessed++;
					}
					else if(numberGuessed3 < theGuessArray[2]) {
						tracksGuessed = 0;
						attemptsCounter3--;
						lblArrowDisplay3_1.setIcon(arrowUp);
						lblCorrectnessDisplay3_1.setIcon(xMark);
						
						historicalNumber3 = String.valueOf(numberGuessed3);
						
						numberList3.addElement(historicalNumber3);
					}
					else if(numberGuessed3 > theGuessArray[2]) {
						attemptsCounter3--;
						tracksGuessed = 0;
						lblArrowDisplay3_1.setIcon(arrowDown);
						lblCorrectnessDisplay3_1.setIcon(xMark);
						
						historicalNumber3 = String.valueOf(numberGuessed1);
						
						numberList3.addElement(historicalNumber3);
					}
				}
				else {
					lblGameError.setText("Non-Digit Detected!!");
				}
				
				if (tracksGuessed == 3) {
					allNumbersCorrect = true;
					NCM2.checkTracks(allNumbersCorrect);
					tracksGuessed = 0;
					if (allNumbersCorrect) {
						allNumbersCorrect = false;
					}
				}
				lblAttemptsDisplay1_1.setText("" + attemptsCounter1);
				lblAttemptsDisplay2_1.setText("" + attemptsCounter2);
				lblAttemptsDisplay3_1.setText("" + attemptsCounter3);
				lblRange_1.setText("Range: 0-" + NCM2.getRange());
				lblScore.setText("Score: " + NCM2.getScore());
				lblLevel.setText("Level: " + NCM2.getLevel());
				theRandomArray = new int[NCM2.getRange()];
				theRandomArray = NCM2.getRandomizedNumbers();
				
				if (attemptsCounter1 == 0 || attemptsCounter2 == 0 || attemptsCounter3 == 0 || attemptsCounter4 == 0|| attemptsCounter5 == 0) {
					gameOver();
				}
			}
	});
	btnGuessSubmission_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	btnGuessSubmission_1.setBounds(270, 427, 210, 50);
	contentPane.add(btnGuessSubmission_1);
	
	lblScore.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 26));
	lblScore.setBounds(25, 525, 200, 50);
	
	contentPane.add(lblScore);
	
	lblLevel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 26));
	lblLevel.setBounds(230, 525, 150, 50);
	
	contentPane.add(lblLevel);
	
	lblTrack1_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack1_3.setBounds(100, 60, 75, 25);
	getContentPane().add(lblTrack1_3);
	

	lblTrack2_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack2_3.setBounds(200, 60, 75, 25);
	getContentPane().add(lblTrack2_3);
	

	lblTrack3_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack3_3.setBounds(300, 60, 75, 25);
	getContentPane().add(lblTrack3_3);
	

	lblTrack4_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack4_3.setBounds(400, 60, 75, 25);
	getContentPane().add(lblTrack4_3);
	

	lblTrack5_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack5_3.setBounds(500, 60, 75, 25);
	getContentPane().add(lblTrack5_3);
	

	lblTrack6_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack6_3.setBounds(600, 60, 75, 25);
	getContentPane().add(lblTrack6_3);
	

	lblTrack7_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblTrack7_3.setBounds(700, 60, 75, 25);
	getContentPane().add(lblTrack7_3);
	

	lblRange_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblRange_3.setBounds(500, 10, 150, 35);
	getContentPane().add(lblRange_3);
	

	lblAttempts_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	lblAttempts_3.setBounds(10, 100, 75, 25);
	getContentPane().add(lblAttempts_3);
	

	lblAttemptsDisplay1_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay1_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay1_3.setBounds(110, 95, 50, 50);
	getContentPane().add(lblAttemptsDisplay1_3);
	

	lblAttemptsDisplay2_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay2_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay2_3.setBounds(210, 96, 50, 50);
	getContentPane().add(lblAttemptsDisplay2_3);
	
	lblAttemptsDisplay3_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay3_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay3_3.setBounds(310, 95, 50, 50);
	getContentPane().add(lblAttemptsDisplay3_3);
	
	lblAttemptsDisplay4_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay4_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay4_3.setBounds(410, 95, 50, 50);
	getContentPane().add(lblAttemptsDisplay4_3);
	

	lblAttemptsDisplay5_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay5_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay5_3.setBounds(510, 96, 50, 50);
	getContentPane().add(lblAttemptsDisplay5_3);
	

	lblAttemptsDisplay6_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay6_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay6_3.setBounds(610, 95, 50, 50);
	getContentPane().add(lblAttemptsDisplay6_3);
	

	lblAttemptsDisplay7_3.setHorizontalAlignment(SwingConstants.CENTER);
	lblAttemptsDisplay7_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	lblAttemptsDisplay7_3.setBounds(710, 95, 50, 50);
	getContentPane().add(lblAttemptsDisplay7_3);
	

	lblArrowDisplay1_3.setBounds(110, 370, 25, 25);
	getContentPane().add(lblArrowDisplay1_3);
	

	lblArrowDisplay2_3.setBounds(210, 370, 25, 25);
	getContentPane().add(lblArrowDisplay2_3);
	

	lblArrowDisplay3_3.setBounds(310, 370, 25, 25);
	getContentPane().add(lblArrowDisplay3_3);
	

	lblArrowDisplay4_3.setBounds(410, 370, 25, 25);
	getContentPane().add(lblArrowDisplay4_3);
	

	lblArrowDisplay5_3.setBounds(510, 370, 25, 25);
	getContentPane().add(lblArrowDisplay5_3);
	

	lblArrowDisplay6_3.setBounds(600, 370, 25, 25);
	getContentPane().add(lblArrowDisplay6_3);
	

	lblArrowDisplay7_3.setBounds(710, 370, 25, 25);
	getContentPane().add(lblArrowDisplay7_3);
	
	textFieldGuess1_3 = new JTextField();
	textFieldGuess1_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess1_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess1_3.setBounds(100, 430, 75, 25);
	getContentPane().add(textFieldGuess1_3);
	textFieldGuess1_3.setColumns(10);
	
	textFieldGuess2_3 = new JTextField();
	textFieldGuess2_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess2_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess2_3.setColumns(10);
	textFieldGuess2_3.setBounds(200, 431, 75, 25);
	getContentPane().add(textFieldGuess2_3);
	
	textFieldGuess3_3 = new JTextField();
	textFieldGuess3_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess3_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess3_3.setColumns(10);
	textFieldGuess3_3.setBounds(300, 430, 75, 25);
	getContentPane().add(textFieldGuess3_3);
	
	textFieldGuess4_3 = new JTextField();
	textFieldGuess4_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess4_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess4_3.setColumns(10);
	textFieldGuess4_3.setBounds(400, 431, 75, 25);
	getContentPane().add(textFieldGuess4_3);
	
	textFieldGuess5_3 = new JTextField();
	textFieldGuess5_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess5_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess5_3.setColumns(10);
	textFieldGuess5_3.setBounds(500, 431, 75, 25);
	getContentPane().add(textFieldGuess5_3);
	
	textFieldGuess6_3 = new JTextField();
	textFieldGuess6_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess6_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess6_3.setColumns(10);
	textFieldGuess6_3.setBounds(600, 431, 75, 25);
	getContentPane().add(textFieldGuess6_3);
	
	textFieldGuess7_3 = new JTextField();
	textFieldGuess7_3.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldGuess7_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textFieldGuess7_3.setColumns(10);
	textFieldGuess7_3.setBounds(700, 431, 75, 25);
	getContentPane().add(textFieldGuess7_3);
	btnSubmitGuesses_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
			Pattern numbers = Pattern.compile("[0-9]");
			
			String historicalNumber1;
			String historicalNumber2;
			String historicalNumber3;
			String historicalNumber4;
			String historicalNumber5;
			String historicalNumber6;
			String historicalNumber7;
			
			int numberGuessed1;
			int numberGuessed2;
			int numberGuessed3;
			int numberGuessed4;
			int numberGuessed5;
			int numberGuessed6;
			int numberGuessed7;
			
			numberGuessed1 = Integer.parseInt(textFieldGuess1_3.getText());
			numberGuessed2 = Integer.parseInt(textFieldGuess2_3.getText());
			numberGuessed3 = Integer.parseInt(textFieldGuess3_3.getText());
			numberGuessed4 = Integer.parseInt(textFieldGuess4_3.getText());
			numberGuessed5 = Integer.parseInt(textFieldGuess5_3.getText());
			numberGuessed6 = Integer.parseInt(textFieldGuess6_3.getText());
			numberGuessed7 = Integer.parseInt(textFieldGuess7_3.getText());
			
			
			
			Matcher checkNumber1 = numbers.matcher(String.valueOf(numberGuessed1));
			Matcher checkNumber2 = numbers.matcher(String.valueOf(numberGuessed2));
			Matcher checkNumber3 = numbers.matcher(String.valueOf(numberGuessed3));
			Matcher checkNumber4 = numbers.matcher(String.valueOf(numberGuessed4));
			Matcher checkNumber5 = numbers.matcher(String.valueOf(numberGuessed5));
			Matcher checkNumber6 = numbers.matcher(String.valueOf(numberGuessed6));
			Matcher checkNumber7 = numbers.matcher(String.valueOf(numberGuessed7));
			
			if (checkNumber1.find()) {
				if (numberGuessed1 == theRandomArray[0]) {
					theGuessArray[0] = numberGuessed1;
					
					lblCorrectnessDisplay1_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed1 < theGuessArray[0]) {
					attemptsCounter1--;
					lblArrowDisplay1_3.setIcon(arrowUp);
					lblCorrectnessDisplay1_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber1 = String.valueOf(numberGuessed1);
					
					numberList1.addElement(historicalNumber1);
				}
				else if(numberGuessed1 > theGuessArray[0]) {
					attemptsCounter1--;
					lblArrowDisplay1_3.setIcon(arrowDown);
					lblCorrectnessDisplay1_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber1 = String.valueOf(numberGuessed1);
					
					numberList1.addElement(historicalNumber1);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if(checkNumber2.find()) {
				if (numberGuessed2 == theRandomArray[1]) {
					theGuessArray[1] = numberGuessed2;
					
					lblCorrectnessDisplay2_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed1 < theGuessArray[1]) {
					attemptsCounter2--;
					lblArrowDisplay2_3.setIcon(arrowUp);
					lblCorrectnessDisplay2_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber1 = String.valueOf(numberGuessed1);
					
					numberList1.addElement(historicalNumber1);
				}
				else if(numberGuessed2 > theGuessArray[1]) {
					attemptsCounter2--;
					lblArrowDisplay2_3.setIcon(arrowDown);
					lblCorrectnessDisplay2_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber2 = String.valueOf(numberGuessed2);
					
					numberList2.addElement(historicalNumber2);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if(checkNumber3.find()) {
				if (numberGuessed3 == theRandomArray[2]) {
					theGuessArray[2] = numberGuessed3;
					
					lblCorrectnessDisplay3_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed3 < theGuessArray[2]) {
					attemptsCounter3--;
					lblArrowDisplay3_3.setIcon(arrowUp);
					lblCorrectnessDisplay3_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber3 = String.valueOf(numberGuessed3);
					
					
					numberList3.addElement(historicalNumber3);
				}
				else if(numberGuessed3 > theGuessArray[0]) {
					attemptsCounter3--;
					lblArrowDisplay3_3.setIcon(arrowDown);
					lblCorrectnessDisplay3_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber3 = String.valueOf(numberGuessed3);
					
					numberList3.addElement(historicalNumber3);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if (checkNumber4.find()) {
				if (numberGuessed4 == theRandomArray[3]) {
					theGuessArray[3] = numberGuessed4;
					
					lblCorrectnessDisplay4_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed4 < theGuessArray[3]) {
					attemptsCounter4--;
					lblArrowDisplay4_3.setIcon(arrowUp);
					lblCorrectnessDisplay4_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber4 = String.valueOf(numberGuessed4);
					
					numberList4.addElement(historicalNumber4);
				}
				else if(numberGuessed4 > theGuessArray[3]) {
					attemptsCounter4--;
					lblArrowDisplay4_3.setIcon(arrowDown);
					lblCorrectnessDisplay4_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber4 = String.valueOf(numberGuessed4);
					
					numberList4.addElement(historicalNumber4);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if (checkNumber5.find()) {
				if (numberGuessed5 == theRandomArray[4]) {
					theGuessArray[4] = numberGuessed5;
					
					lblCorrectnessDisplay5_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed5 < theGuessArray[4]) {
					attemptsCounter5--;
					lblArrowDisplay5_3.setIcon(arrowUp);
					lblCorrectnessDisplay5_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber5 = String.valueOf(numberGuessed5);
					
					numberList5.addElement(historicalNumber5);
				}
				else if(numberGuessed5 > theGuessArray[4]) {
					attemptsCounter5--;
					lblArrowDisplay5_3.setIcon(arrowDown);
					lblCorrectnessDisplay5_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber5 = String.valueOf(numberGuessed5);
					
					numberList5.addElement(historicalNumber5);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if(checkNumber6.find()) {
				if (numberGuessed6 == theRandomArray[5]) {
					theGuessArray[5] = numberGuessed6;
					
					lblCorrectnessDisplay6_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed6 < theGuessArray[5]) {
					attemptsCounter6--;
					lblArrowDisplay6_3.setIcon(arrowUp);
					lblCorrectnessDisplay6_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber6 = String.valueOf(numberGuessed6);
					
					numberList6.addElement(historicalNumber6);
				}
				else if(numberGuessed6 > theGuessArray[5]) {
					attemptsCounter6--;
					lblArrowDisplay6_3.setIcon(arrowDown);
					lblCorrectnessDisplay6_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber6 = String.valueOf(numberGuessed6);
					
					numberList6.addElement(historicalNumber6);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if(checkNumber7.find()) {
				if (numberGuessed7 == theRandomArray[6]) {
					theGuessArray[6] = numberGuessed7;
					
					lblCorrectnessDisplay7_3.setIcon(checkMark);
					tracksGuessed++;
				}
				else if(numberGuessed7 < theGuessArray[6]) {
					attemptsCounter7--;
					lblArrowDisplay7_3.setIcon(arrowUp);
					lblCorrectnessDisplay7_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber7 = String.valueOf(numberGuessed7);
					
					numberList7.addElement(historicalNumber7);
				}
				else if(numberGuessed7 > theGuessArray[6]) {
					attemptsCounter7--;
					lblArrowDisplay7_3.setIcon(arrowDown);
					lblCorrectnessDisplay7_3.setIcon(xMark);
					tracksGuessed = 0;
					historicalNumber7 = String.valueOf(numberGuessed5);
					
					numberList7.addElement(historicalNumber7);
				}
			}
			
			else {
				lblGameError.setText("Non-Digit Detected!!");
			}
			
			if (tracksGuessed == 7) {
				allNumbersCorrect = true;
				NCM2.checkTracks(allNumbersCorrect);
				tracksGuessed = 0;
				if (allNumbersCorrect) {
					allNumbersCorrect = false;
				}
				if (attemptsCounter1 == 0 || attemptsCounter2 == 0 || attemptsCounter3 == 0 || attemptsCounter4 == 0|| attemptsCounter5 == 0 || attemptsCounter6 == 0 || attemptsCounter7 == 0) {
					gameOver();
				}
			}
			lblAttemptsDisplay1_3.setText("" + attemptsCounter1);
			lblAttemptsDisplay2_3.setText("" + attemptsCounter2);
			lblAttemptsDisplay3_3.setText("" + attemptsCounter3);
			lblAttemptsDisplay4_3.setText("" + attemptsCounter4);
			lblAttemptsDisplay5_3.setText("" + attemptsCounter5);
			lblAttemptsDisplay6_3.setText("" + attemptsCounter6);
			lblAttemptsDisplay7_3.setText("" + attemptsCounter7);
			lblRange_3.setText("Range: 0-" + NCM2.getRange());
			lblScore.setText("Score: " + NCM2.getScore());
			lblLevel.setText("Level: " + NCM2.getLevel());
			theRandomArray = new int[NCM2.getRange()];
			theRandomArray = NCM2.getRandomizedNumbers();
		}
	});
	

	btnSubmitGuesses_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
	btnSubmitGuesses_3.setBounds(100, 466, 200, 50);
	getContentPane().add(btnSubmitGuesses_3);
	
	lblGameError.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	lblGameError.setBounds(504, 463, 250, 25);
	contentPane.add(lblGameError);
	
	lblCorrectnessDisplay1_1.setBounds(304, 314, 24, 24);
	contentPane.add(lblCorrectnessDisplay1_1);
	lblCorrectnessDisplay2_1.setBounds(374, 314, 24, 24);
	
	contentPane.add(lblCorrectnessDisplay2_1);
	lblCorrectnessDisplay3_1.setBounds(444, 314, 24, 24);
	
	contentPane.add(lblCorrectnessDisplay3_1);
	JlistHistory1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory1_1.setBounds(270, 105, 60, 200);
	
	contentPane.add(JlistHistory1_1);
	JlistHistory2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory2_1.setBounds(340, 103, 60, 200);
	
	contentPane.add(JlistHistory2_1);
	JlistHistory3_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory3_1.setBounds(410, 103, 60, 200);
	
	contentPane.add(JlistHistory3_1);
	
	JlistHistory1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory1_2.setBounds(150, 117, 60, 200);
	contentPane.add(JlistHistory1_2);
	
	JlistHistory2_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory2_2.setBounds(250, 115, 60, 200);
	contentPane.add(JlistHistory2_2);
	
	JlistHistory3_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory3_2.setBounds(350, 115, 60, 200);
	contentPane.add(JlistHistory3_2);
	
	JlistHistory4_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory4_2.setBounds(450, 115, 60, 200);
	contentPane.add(JlistHistory4_2);
	
	JlistHistory5_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
	JlistHistory5_2.setBounds(550, 115, 60, 200);
	contentPane.add(JlistHistory5_2);
	JlistHistory1_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory1_3.setBounds(110, 155, 50, 200);
	
	contentPane.add(JlistHistory1_3);
	JlistHistory2_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory2_3.setBounds(210, 155, 50, 200);
	
	contentPane.add(JlistHistory2_3);
	JlistHistory3_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory3_3.setBounds(310, 150, 50, 200);
	
	contentPane.add(JlistHistory3_3);
	JlistHistory4_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory4_3.setBounds(410, 155, 50, 200);
	
	contentPane.add(JlistHistory4_3);
	JlistHistory5_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory5_3.setBounds(510, 155, 50, 200);
	
	contentPane.add(JlistHistory5_3);
	JlistHistory6_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory6_3.setBounds(610, 155, 50, 200);
	
	contentPane.add(JlistHistory6_3);
	JlistHistory7_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
	JlistHistory7_3.setBounds(710, 155, 50, 200);
	
	contentPane.add(JlistHistory7_3);
	
	lblCorrectnessDisplay1_3.setBounds(130, 358, 25, 25);
	contentPane.add(lblCorrectnessDisplay1_3);

	lblCorrectnessDisplay2_3.setBounds(236, 366, 25, 25);
	contentPane.add(lblCorrectnessDisplay2_3);
	
	lblCorrectnessDisplay3_3.setBounds(335, 366, 25, 25);
	contentPane.add(lblCorrectnessDisplay3_3);
	
	lblCorrectnessDisplay4_3.setBounds(436, 371, 25, 25);
	contentPane.add(lblCorrectnessDisplay4_3);
	
	lblCorrectnessDisplay5_3.setBounds(536, 371, 25, 25);
	contentPane.add(lblCorrectnessDisplay5_3);
	
	lblCorrectnessDisplay6_3.setBounds(626, 366, 25, 25);
	contentPane.add(lblCorrectnessDisplay6_3);
	
	lblCorrectnessDisplay7_3.setBounds(741, 366, 25, 25);
	contentPane.add(lblCorrectnessDisplay7_3);
	lblCorrectnessDisplay1_2.setBounds(186, 325, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay1_2);
	lblCorrectnessDisplay2_2.setBounds(280, 326, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay2_2);
	lblCorrectnessDisplay3_2.setBounds(376, 325, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay3_2);
	lblCorrectnessDisplay4_2.setBounds(470, 325, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay4_2);
	lblCorrectnessDisplay5_2.setBounds(585, 325, 25, 25);
	
	contentPane.add(lblCorrectnessDisplay5_2);
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
	
	//setVisible statements start
	textFieldTrack1_1.setVisible(false);
	textFieldTrack2_1.setVisible(false);
	textFieldTrack3_1.setVisible(false);
	lblRange_1.setVisible(false);
	lblEasyTrack1_1.setVisible(false);
	lblEasyTrack2_1.setVisible(false);
	lblEasyTrack3_1.setVisible(false);
	lblAttemptsDisplay1_1.setVisible(false);
	lblAttemptsDisplay2_1.setVisible(false);
	lblAttemptsDisplay3_1.setVisible(false);
	lblAttempts_1.setVisible(false);
	btnGuessSubmission_1.setVisible(false);
	JlistHistory1_1.setVisible(false);
	JlistHistory2_1.setVisible(false);
	JlistHistory3_1.setVisible(false);
	
	textFieldGuess1_2.setVisible(false);
	textFieldGuess2_2.setVisible(false);
	textFieldGuess3_2.setVisible(false);
	textFieldGuess4_2.setVisible(false);
	textFieldGuess5_2.setVisible(false);
	lblRange_2.setVisible(false);
	lblTrack1_2.setVisible(false);
	lblTrack2_2.setVisible(false);
	lblTrack3_2.setVisible(false);
	lblTrack4_2.setVisible(false);
	lblTrack5_2.setVisible(false);
	lblAttemptsDisplay1_2.setVisible(false);
	lblAttemptsDisplay2_2.setVisible(false);
	lblAttemptsDisplay3_2.setVisible(false);
	lblAttemptsDisplay4_2.setVisible(false);
	lblAttemptsDisplay5_2.setVisible(false);
	JlistHistory1_2.setVisible(false);
	JlistHistory2_2.setVisible(false);
	JlistHistory3_2.setVisible(false);
	JlistHistory4_2.setVisible(false);
	JlistHistory5_2.setVisible(false);
	lblArrowDisplay1_2.setVisible(false);
	lblArrowDisplay2_2.setVisible(false);
	lblArrowDisplay3_2.setVisible(false);
	lblArrowDisplay4_2.setVisible(false);
	lblArrowDisplay5_2.setVisible(false);
	lblAttempts_2.setVisible(false);
	btnGuessSubmission_2.setVisible(false);
	
	textFieldGuess1_3.setVisible(false);
	textFieldGuess2_3.setVisible(false);
	textFieldGuess3_3.setVisible(false);
	textFieldGuess4_3.setVisible(false);
	textFieldGuess5_3.setVisible(false);
	textFieldGuess6_3.setVisible(false);
	textFieldGuess7_3.setVisible(false);
	lblRange_3.setVisible(false);
	lblTrack1_3.setVisible(false);
	lblTrack2_3.setVisible(false);
	lblTrack3_3.setVisible(false);
	lblTrack4_3.setVisible(false);
	lblTrack5_3.setVisible(false);
	lblTrack6_3.setVisible(false);
	lblTrack7_3.setVisible(false);
	lblAttemptsDisplay1_3.setVisible(false);
	lblAttemptsDisplay2_3.setVisible(false);
	lblAttemptsDisplay3_3.setVisible(false);
	lblAttemptsDisplay4_3.setVisible(false);
	lblAttemptsDisplay5_3.setVisible(false);
	lblAttemptsDisplay6_3.setVisible(false);
	lblAttemptsDisplay7_3.setVisible(false);
	lblArrowDisplay1_3.setVisible(false);
	lblArrowDisplay2_3.setVisible(false);
	lblArrowDisplay3_3.setVisible(false);
	lblArrowDisplay4_3.setVisible(false);
	lblArrowDisplay5_3.setVisible(false);
	lblArrowDisplay6_3.setVisible(false);
	lblArrowDisplay7_3.setVisible(false);
	JlistHistory1_3.setVisible(false);
	JlistHistory2_3.setVisible(false);
	JlistHistory3_3.setVisible(false);
	JlistHistory4_3.setVisible(false);
	JlistHistory5_3.setVisible(false);
	JlistHistory6_3.setVisible(false);
	JlistHistory7_3.setVisible(false);
	lblAttempts_3.setVisible(false);
	btnSubmitGuesses_3.setVisible(false);
	
	lblScore.setVisible(false);
	lblLevel.setVisible(false);
	lblGameError.setVisible(false);
	//setVisible statements end
	}
	
	private void readFile() {
		/*
		 * Method					:	readFile()
		 * 
		 * Method Parameters	`	:	none
		 * 
		 * Method Return			:	void
		 * 
		 * Synopsis					:	This method reads a file and assigns a variable to each
		 * 								line
		 * 
		 * Modifications			:	Date:		Developer:		Notes:
		 * 								06/07/21	Jared Shaddick	Initial Setup & Comments Added
		 */
		String txtString = "";
		try {
			File txtFile = new File("TXT/Score.txt");								//sets the file to be used

			txtFileScanner = new Scanner(txtFile);									//passes the text within the file to the scanner
			
			txtString = txtFileScanner.nextLine();
			lblInitials.setText("Achiever: " + txtString);
			txtString = txtFileScanner.nextLine();
			lblScoreAchieved.setText("Max Score: " + txtString);
			txtString = txtFileScanner.nextLine();
			lblLevelAchieved.setText("Max Level: " + txtString);
			txtString = txtFileScanner.nextLine();
			lblRangeAchieved.setText("Max Range: 0-" + txtString);
		}
		catch (Exception e){
			System.out.println("Error, could not read file");						//notifies the developer that something is not working
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
		lblGameError.setText("Game Over!!");
		
		textFieldTrack1_1.setVisible(false);
		textFieldTrack2_1.setVisible(false);
		textFieldTrack3_1.setVisible(false);
		lblRange_1.setVisible(false);
		lblEasyTrack1_1.setVisible(false);
		lblEasyTrack2_1.setVisible(false);
		lblEasyTrack3_1.setVisible(false);
		lblAttemptsDisplay1_1.setVisible(false);
		lblAttemptsDisplay2_1.setVisible(false);
		lblAttemptsDisplay3_1.setVisible(false);
		lblAttempts_1.setVisible(false);
		btnGuessSubmission_1.setVisible(false);
		JlistHistory1_1.setVisible(false);
		JlistHistory2_1.setVisible(false);
		JlistHistory3_1.setVisible(false);
		
		textFieldGuess1_2.setVisible(false);
		textFieldGuess2_2.setVisible(false);
		textFieldGuess3_2.setVisible(false);
		textFieldGuess4_2.setVisible(false);
		textFieldGuess5_2.setVisible(false);
		lblRange_2.setVisible(false);
		lblTrack1_2.setVisible(false);
		lblTrack2_2.setVisible(false);
		lblTrack3_2.setVisible(false);
		lblTrack4_2.setVisible(false);
		lblTrack5_2.setVisible(false);
		lblAttemptsDisplay1_2.setVisible(false);
		lblAttemptsDisplay2_2.setVisible(false);
		lblAttemptsDisplay3_2.setVisible(false);
		lblAttemptsDisplay4_2.setVisible(false);
		lblAttemptsDisplay5_2.setVisible(false);
		JlistHistory1_2.setVisible(false);
		JlistHistory2_2.setVisible(false);
		JlistHistory3_2.setVisible(false);
		JlistHistory4_2.setVisible(false);
		JlistHistory5_2.setVisible(false);
		lblArrowDisplay1_2.setVisible(false);
		lblArrowDisplay2_2.setVisible(false);
		lblArrowDisplay3_2.setVisible(false);
		lblArrowDisplay4_2.setVisible(false);
		lblArrowDisplay5_2.setVisible(false);
		lblAttempts_2.setVisible(false);
		btnGuessSubmission_2.setVisible(false);
		
		textFieldGuess1_3.setVisible(false);
		textFieldGuess2_3.setVisible(false);
		textFieldGuess3_3.setVisible(false);
		textFieldGuess4_3.setVisible(false);
		textFieldGuess5_3.setVisible(false);
		textFieldGuess6_3.setVisible(false);
		textFieldGuess7_3.setVisible(false);
		lblRange_3.setVisible(false);
		lblTrack1_3.setVisible(false);
		lblTrack2_3.setVisible(false);
		lblTrack3_3.setVisible(false);
		lblTrack4_3.setVisible(false);
		lblTrack5_3.setVisible(false);
		lblTrack6_3.setVisible(false);
		lblTrack7_3.setVisible(false);
		lblAttemptsDisplay1_3.setVisible(false);
		lblAttemptsDisplay2_3.setVisible(false);
		lblAttemptsDisplay3_3.setVisible(false);
		lblAttemptsDisplay4_3.setVisible(false);
		lblAttemptsDisplay5_3.setVisible(false);
		lblAttemptsDisplay6_3.setVisible(false);
		lblAttemptsDisplay7_3.setVisible(false);
		lblArrowDisplay1_3.setVisible(false);
		lblArrowDisplay2_3.setVisible(false);
		lblArrowDisplay3_3.setVisible(false);
		lblArrowDisplay4_3.setVisible(false);
		lblArrowDisplay5_3.setVisible(false);
		lblArrowDisplay6_3.setVisible(false);
		lblArrowDisplay7_3.setVisible(false);
		JlistHistory1_3.setVisible(false);
		JlistHistory2_3.setVisible(false);
		JlistHistory3_3.setVisible(false);
		JlistHistory4_3.setVisible(false);
		JlistHistory5_3.setVisible(false);
		JlistHistory6_3.setVisible(false);
		JlistHistory7_3.setVisible(false);
		lblAttempts_3.setVisible(false);
		btnSubmitGuesses_3.setVisible(false);
		
		lblCorrectnessDisplay1_1.setVisible(false);
		lblCorrectnessDisplay2_1.setVisible(false);
		lblCorrectnessDisplay3_1.setVisible(false);
		
		lblCorrectnessDisplay1_2.setVisible(false);
		lblCorrectnessDisplay2_2.setVisible(false);
		lblCorrectnessDisplay3_2.setVisible(false);
		lblCorrectnessDisplay4_2.setVisible(false);
		lblCorrectnessDisplay5_2.setVisible(false);
		
		lblCorrectnessDisplay1_3.setVisible(false);
		lblCorrectnessDisplay2_3.setVisible(false);
		lblCorrectnessDisplay3_3.setVisible(false);
		lblCorrectnessDisplay4_3.setVisible(false);
		lblCorrectnessDisplay5_3.setVisible(false);
		lblCorrectnessDisplay6_3.setVisible(false);
		lblCorrectnessDisplay7_3.setVisible(false);
		
		File txtFile = new File("TXT/Scores.txt");	
		
		  try {
	            FileWriter fileWriter = new FileWriter(txtFile);
	            
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            bufferedWriter.write(playerInitials);
	            bufferedWriter.write(" " + NCM2.getScore());
	            bufferedWriter.write(" " + NCM2.getLevel());
	            bufferedWriter.write(" 0-" + NCM2.getRange() + " ");

	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '"+ txtFile + "'");
	        }
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (timeToEmptyText) {
				lblArrowDisplay1_1.setIcon(null);
				lblArrowDisplay2_1.setIcon(null);
				lblArrowDisplay3_1.setIcon(null);
				
				lblArrowDisplay1_2.setIcon(null);
				lblArrowDisplay2_2.setIcon(null);
				lblArrowDisplay3_2.setIcon(null);
				lblArrowDisplay4_2.setIcon(null);
				lblArrowDisplay5_2.setIcon(null);
				
				lblArrowDisplay1_3.setIcon(null);
				lblArrowDisplay2_3.setIcon(null);
				lblArrowDisplay3_3.setIcon(null);
				lblArrowDisplay4_3.setIcon(null);
				lblArrowDisplay5_3.setIcon(null);
				lblArrowDisplay6_3.setIcon(null);
				lblArrowDisplay7_3.setIcon(null);
				
				lblCorrectnessDisplay1_1.setIcon(null);
				lblCorrectnessDisplay2_1.setIcon(null);
				lblCorrectnessDisplay3_1.setIcon(null);
				
				lblCorrectnessDisplay1_2.setIcon(null);
				lblCorrectnessDisplay2_2.setIcon(null);
				lblCorrectnessDisplay3_2.setIcon(null);
				lblCorrectnessDisplay4_2.setIcon(null);
				lblCorrectnessDisplay5_2.setIcon(null);
				
				lblCorrectnessDisplay1_3.setIcon(null);
				lblCorrectnessDisplay2_3.setIcon(null);
				lblCorrectnessDisplay3_3.setIcon(null);
				lblCorrectnessDisplay4_3.setIcon(null);
				lblCorrectnessDisplay5_3.setIcon(null);
				lblCorrectnessDisplay6_3.setIcon(null);
				lblCorrectnessDisplay7_3.setIcon(null);
				
				lblGameError.setText("");
				if (!gameOver) {
					lblErrorLabel.setText("");
				}
			}
			timeToEmptyText = !timeToEmptyText;
		}};

