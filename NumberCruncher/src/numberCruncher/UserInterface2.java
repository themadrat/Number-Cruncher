package numberCruncher;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

public class UserInterface2 extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtEnterInitials;
	
	Scanner initialsScanner;

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
	private JTextPane textPaneHistory1_1 = new JTextPane();
	private JTextPane textPaneHistory2_1 = new JTextPane();
	private JTextPane textPaneHistory3_1 = new JTextPane();
	private JLabel lblArrowDisplay1_1 = new JLabel("");
	private JLabel lblArrowDisplay2_1 = new JLabel("");
	private JLabel lblArrowDisplay3_1 = new JLabel("");
	private JLabel lblAttempts_1 = new JLabel("Attempts:");
	private JButton btnGuessSubmission_1 = new JButton("Submit Guesses");
	
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
	private JTextPane textPaneHistory1_2 = new JTextPane();
	private JTextPane textPaneHistory2_2 = new JTextPane();
	private JTextPane textPaneHistory3_2 = new JTextPane();
	private JTextPane textPaneHistory4_2 = new JTextPane();
	private JTextPane textPaneHistory5_2 = new JTextPane();
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
	private JTextPane textPaneHistory1_3 = new JTextPane();
	private JTextPane textPaneHistory2_3 = new JTextPane();
	private JTextPane textPaneHistory3_3 = new JTextPane();
	private JTextPane textPaneHistory4_3 = new JTextPane();
	private JTextPane textPaneHistory5_3 = new JTextPane();
	private JTextPane textPaneHistory6_3 = new JTextPane();
	private JTextPane textPaneHistory7_3 = new JTextPane();
	private JLabel lblArrowDisplay1_3 = new JLabel("");
	private JLabel lblArrowDisplay2_3 = new JLabel("");
	private JLabel lblArrowDisplay3_3 = new JLabel("");
	private JLabel lblArrowDisplay4_3 = new JLabel("");
	private JLabel lblArrowDisplay5_3 = new JLabel("");
	private JLabel lblArrowDisplay6_3 = new JLabel("");
	private JLabel lblArrowDisplay7_3 = new JLabel("");
	private JButton btnSubmitGuesses_3 = new JButton("Submit Guesses");
	
	private JLabel lblScore = new JLabel("Score: ");
	private JLabel lblLevel = new JLabel("Level:");
	
	NumberCruncherManager2 NCM2 = new NumberCruncherManager2();
	
	private int[] theRandomArray;
	private int[] tracksToUse;
	
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
				if (initialsSubmitted) {
					lblDifficultyPrompt.setVisible(false);
					lblErrorLabel.setVisible(false);
					lblEnterInitialsPrompt.setVisible(false);
					btnEasyModeButton.setVisible(false);
					btnModerateModeButton.setVisible(false);
					btnDifficultModeButton.setVisible(false);
					btnSubmissionButton.setVisible(false);
					txtEnterInitials.setVisible(false);
					NCM2.getMode(1);
					NCM2.trackGenerator();
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
					textPaneHistory1_1.setVisible(true);
					textPaneHistory2_1.setVisible(true);
					textPaneHistory3_1.setVisible(true);
					lblAttempts_1.setVisible(true);
					btnGuessSubmission_1.setVisible(true);
					lblAttemptsDisplay1_1.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay2_1.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay3_1.setText("" + NCM2.getAttempts());
					lblRange_1.setText("Range: 1-10");
					
					lblScore.setVisible(true);
					lblLevel.setVisible(true);
					
				}
			}
		});
		btnEasyModeButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		btnEasyModeButton.setBounds(25, 514, 225, 75);
		getContentPane().add(btnEasyModeButton);
		
		btnModerateModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (initialsSubmitted) {
					lblDifficultyPrompt.setVisible(false);
					lblErrorLabel.setVisible(false);
					lblEnterInitialsPrompt.setVisible(false);
					btnEasyModeButton.setVisible(false);
					btnModerateModeButton.setVisible(false);
					btnDifficultModeButton.setVisible(false);
					btnSubmissionButton.setVisible(false);
					txtEnterInitials.setVisible(false);
					
					NCM2.getMode(2);
					NCM2.trackGenerator();
					
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
					textPaneHistory1_2.setVisible(true);
					textPaneHistory2_2.setVisible(true);
					textPaneHistory3_2.setVisible(true);
					textPaneHistory4_2.setVisible(true);
					textPaneHistory5_2.setVisible(true);
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
					lblRange_2.setText("Range: 1-100");
					lblAttemptsDisplay1_2.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay2_2.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay3_2.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay4_2.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay5_2.setText("" + NCM2.getAttempts());
					btnGuessSubmission_2.setVisible(true);
					
					lblScore.setVisible(true);
					lblLevel.setVisible(true);
				}
			}
		});
		btnModerateModeButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 32));
		btnModerateModeButton.setBounds(263, 514, 275, 75);
		getContentPane().add(btnModerateModeButton);
		
		btnDifficultModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (initialsSubmitted) {
					
					lblDifficultyPrompt.setVisible(false);
					lblErrorLabel.setVisible(false);
					lblEnterInitialsPrompt.setVisible(false);
					btnEasyModeButton.setVisible(false);
					btnModerateModeButton.setVisible(false);
					btnDifficultModeButton.setVisible(false);
					btnSubmissionButton.setVisible(false);
					txtEnterInitials.setVisible(false);
					
					NCM2.getMode(3);
					NCM2.trackGenerator();
					
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
					textPaneHistory1_3.setVisible(true);
					textPaneHistory2_3.setVisible(true);
					textPaneHistory3_3.setVisible(true);
					textPaneHistory4_3.setVisible(true);
					textPaneHistory5_3.setVisible(true);
					textPaneHistory6_3.setVisible(true);
					textPaneHistory7_3.setVisible(true);
					lblAttemptsDisplay1_3.setVisible(true);
					lblAttemptsDisplay2_3.setVisible(true);
					lblAttemptsDisplay3_3.setVisible(true);
					lblAttemptsDisplay4_3.setVisible(true);
					lblAttemptsDisplay5_3.setVisible(true);
					lblAttemptsDisplay6_3.setVisible(true);
					lblAttemptsDisplay7_3.setVisible(true);
					lblArrowDisplay1_3.setVisible(true);
					lblArrowDisplay2_3.setVisible(true);
					lblArrowDisplay3_3.setVisible(true);
					lblArrowDisplay4_3.setVisible(true);
					lblArrowDisplay5_3.setVisible(true);
					lblArrowDisplay6_3.setVisible(true);
					lblArrowDisplay7_3.setVisible(true);
					lblAttempts_3.setVisible(true);
					btnSubmitGuesses_3.setVisible(true);
					
					lblRange_3.setText("Range: 1-1000");
					
					lblAttemptsDisplay1_3.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay2_3.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay3_3.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay4_3.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay5_3.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay6_3.setText("" + NCM2.getAttempts());
					lblAttemptsDisplay7_3.setText("" + NCM2.getAttempts());
					
					lblScore.setVisible(true);
					lblLevel.setVisible(true);
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
	textPaneHistory1_1.setEditable(false);
	
	textPaneHistory1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
	textPaneHistory1_1.setBounds(270, 105, 60, 200);
	getContentPane().add(textPaneHistory1_1);
	textPaneHistory2_1.setEditable(false);
	
	textPaneHistory2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
	textPaneHistory2_1.setBounds(340, 105, 60, 200);
	getContentPane().add(textPaneHistory2_1);
	textPaneHistory3_1.setEditable(false);
	
	textPaneHistory3_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
	textPaneHistory3_1.setBounds(410, 105, 60, 200);
	getContentPane().add(textPaneHistory3_1);

	lblArrowDisplay1_1.setBounds(270, 316, 60, 60);
	getContentPane().add(lblArrowDisplay1_1);
	
	lblArrowDisplay2_1.setBounds(340, 316, 60, 60);
	getContentPane().add(lblArrowDisplay2_1);
	
	lblArrowDisplay3_1.setBounds(410, 316, 60, 60);
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
	textPaneHistory1_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	textPaneHistory1_2.setEditable(false);
	
	textPaneHistory1_2.setBounds(150, 115, 60, 200);
	getContentPane().add(textPaneHistory1_2);
	textPaneHistory2_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	textPaneHistory2_2.setEditable(false);
	
	textPaneHistory2_2.setBounds(250, 115, 60, 200);
	getContentPane().add(textPaneHistory2_2);
	textPaneHistory3_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	textPaneHistory3_2.setEditable(false);
	
	textPaneHistory3_2.setBounds(350, 115, 60, 200);
	getContentPane().add(textPaneHistory3_2);
	textPaneHistory4_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	textPaneHistory4_2.setEditable(false);
	
	textPaneHistory4_2.setBounds(450, 115, 60, 200);
	getContentPane().add(textPaneHistory4_2);
	textPaneHistory5_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	textPaneHistory5_2.setEditable(false);
	
	textPaneHistory5_2.setBounds(550, 115, 60, 200);
	getContentPane().add(textPaneHistory5_2);
	
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
	
	lblArrowDisplay1_2.setBounds(150, 325, 60, 60);
	getContentPane().add(lblArrowDisplay1_2);
	
	lblArrowDisplay2_2.setBounds(250, 325, 60, 60);
	getContentPane().add(lblArrowDisplay2_2);
	
	lblArrowDisplay3_2.setBounds(350, 326, 60, 60);
	getContentPane().add(lblArrowDisplay3_2);
	
	lblArrowDisplay4_2.setBounds(450, 325, 60, 60);
	getContentPane().add(lblArrowDisplay4_2);
	
	lblArrowDisplay5_2.setBounds(550, 326, 60, 60);
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
	btnGuessSubmission_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
	btnGuessSubmission_2.setBounds(270, 427, 210, 50);
	
	contentPane.add(btnGuessSubmission_2);
	
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
	

	textPaneHistory1_3.setEditable(false);
	textPaneHistory1_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory1_3.setBounds(110, 155, 50, 200);
	getContentPane().add(textPaneHistory1_3);
	

	textPaneHistory2_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory2_3.setEditable(false);
	textPaneHistory2_3.setBounds(210, 155, 50, 200);
	getContentPane().add(textPaneHistory2_3);
	

	textPaneHistory3_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory3_3.setEditable(false);
	textPaneHistory3_3.setBounds(310, 155, 50, 200);
	getContentPane().add(textPaneHistory3_3);
	

	textPaneHistory4_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory4_3.setEditable(false);
	textPaneHistory4_3.setBounds(410, 155, 50, 200);
	getContentPane().add(textPaneHistory4_3);
	

	textPaneHistory5_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory5_3.setEditable(false);
	textPaneHistory5_3.setBounds(510, 155, 50, 200);
	getContentPane().add(textPaneHistory5_3);
	

	textPaneHistory6_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory6_3.setEditable(false);
	textPaneHistory6_3.setBounds(610, 155, 50, 200);
	getContentPane().add(textPaneHistory6_3);
	

	textPaneHistory7_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
	textPaneHistory7_3.setEditable(false);
	textPaneHistory7_3.setBounds(710, 155, 50, 200);
	getContentPane().add(textPaneHistory7_3);
	

	lblArrowDisplay1_3.setBounds(110, 370, 50, 50);
	getContentPane().add(lblArrowDisplay1_3);
	

	lblArrowDisplay2_3.setBounds(210, 370, 50, 50);
	getContentPane().add(lblArrowDisplay2_3);
	

	lblArrowDisplay3_3.setBounds(310, 370, 50, 50);
	getContentPane().add(lblArrowDisplay3_3);
	

	lblArrowDisplay4_3.setBounds(410, 370, 50, 50);
	getContentPane().add(lblArrowDisplay4_3);
	

	lblArrowDisplay5_3.setBounds(510, 370, 50, 50);
	getContentPane().add(lblArrowDisplay5_3);
	

	lblArrowDisplay6_3.setBounds(600, 370, 50, 50);
	getContentPane().add(lblArrowDisplay6_3);
	

	lblArrowDisplay7_3.setBounds(710, 370, 50, 50);
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
	textFieldGuess3_3.setBounds(300, 431, 75, 25);
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
	

	btnSubmitGuesses_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
	btnSubmitGuesses_3.setBounds(100, 466, 200, 50);
	getContentPane().add(btnSubmitGuesses_3);
	
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
	textPaneHistory1_1.setVisible(false);
	textPaneHistory2_1.setVisible(false);
	textPaneHistory3_1.setVisible(false);
	lblAttempts_1.setVisible(false);
	btnGuessSubmission_1.setVisible(false);
	
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
	textPaneHistory1_2.setVisible(false);
	textPaneHistory2_2.setVisible(false);
	textPaneHistory3_2.setVisible(false);
	textPaneHistory4_2.setVisible(false);
	textPaneHistory5_2.setVisible(false);
	lblAttemptsDisplay1_2.setVisible(false);
	lblAttemptsDisplay2_2.setVisible(false);
	lblAttemptsDisplay3_2.setVisible(false);
	lblAttemptsDisplay4_2.setVisible(false);
	lblAttemptsDisplay5_2.setVisible(false);
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
	textPaneHistory1_3.setVisible(false);
	textPaneHistory2_3.setVisible(false);
	textPaneHistory3_3.setVisible(false);
	textPaneHistory4_3.setVisible(false);
	textPaneHistory5_3.setVisible(false);
	textPaneHistory6_3.setVisible(false);
	textPaneHistory7_3.setVisible(false);
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
	lblAttempts_3.setVisible(false);
	btnSubmitGuesses_3.setVisible(false);
	
	lblScore.setVisible(false);
	lblLevel.setVisible(false);
	}

	private String getPlayerInitials() {
		return playerInitials;
	}
	
	private void getTheTracks() {
		
	}
	
	private void tracksToGuess() {
		theRandomArray = new int[NCM2.getRange()];
		
		for (int indexCounter = 0; indexCounter < theRandomArray.length; indexCounter++) {
			theRandomArray[indexCounter] = NCM2.getRandomizedNumbers()[indexCounter];
		}
	}
}
