import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class GUI implements ActionListener{
	
	//game variables
	public static int qMax, qMin, numMax, numMin, operandDecider, firstNum, secondNum, score, lives;

	//GUI variables
	private JFrame FRAME;
	private JPanel TITLEPANEL;
	private JPanel BUTTONSPANEL;
	private JPanel TEXTFIELDPANEL;
	private JPanel QUESTIONPANEL;
	private static JLabel title;
	private static JLabel question;
	private static JLabel stats;
	
	Container con; 
	private static JTextField answer;

	Font TITLEFONT = new Font("Arial", Font.PLAIN, 80);
	Font LABELFONT = new Font("Arial", Font.PLAIN, 28);
	Font STATSFONT = new Font("Arial", Font.PLAIN, 14);

	String NAME = "Math Game";

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	
	int userAnswer;

	static Question currentQuestion;
	
	public GUI() {
		
		//opening screen		

		title = new JLabel("Welcome :)", SwingConstants.CENTER);
		title.setFont(TITLEFONT);
		
		question = new JLabel("", SwingConstants.CENTER);
		JButton begin = new JButton("BEGIN");
		begin.setBackground(Color.green);
		begin.setForeground(Color.white);
		begin.setFont(LABELFONT);
		begin.addActionListener(tsHandler);
		
		JButton rules = new JButton("RULES");
		rules.setBackground(Color.blue);
		rules.setForeground(Color.white);
		rules.setFont(LABELFONT);
		
		FRAME = new JFrame();
		FRAME.setSize(800, 600);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.getContentPane().setBackground(Color.white);
		FRAME.setTitle(NAME);
		FRAME.setLayout(null);
		FRAME.setVisible(true);
		con = FRAME.getContentPane();
		
		TITLEPANEL = new JPanel();
		TITLEPANEL.setBounds(100,80,600,150);
		TITLEPANEL.setLayout(new GridLayout(0, 1));
		TITLEPANEL.add(title);
		TITLEPANEL.setBackground(Color.white);
		FRAME.add(TITLEPANEL); 
		
		
		BUTTONSPANEL = new JPanel();
		BUTTONSPANEL.setBounds(175,250,450,100);
		BUTTONSPANEL.add(rules);
		BUTTONSPANEL.add(begin);
		BUTTONSPANEL.setBackground(Color.white);
		FRAME.add(BUTTONSPANEL);
		
		
		
		con.add(TITLEPANEL);
		con.add(BUTTONSPANEL);
	}
	
	//main method
	public static void main(String[] args) {		
	
		new GUI();		
		
	}
	
	//the game starts
	public void Start() {
	
		BUTTONSPANEL.setVisible(false);
		
		answer = new JTextField(" ", 13);
		answer.setFont(LABELFONT);

		stats = new JLabel("Score:      " + "Lives:   ", SwingConstants.CENTER);
		stats.setFont(STATSFONT);
		stats.setAlignmentY(Component.TOP_ALIGNMENT);
		
		question = new JLabel(" ", SwingConstants.CENTER);
		question.setFont(TITLEFONT);
		
		QUESTIONPANEL = new JPanel();
		QUESTIONPANEL.setBounds(150,250,450,100);
		QUESTIONPANEL.setBackground(Color.white);
		QUESTIONPANEL.add(question);
		FRAME.add(QUESTIONPANEL);
		con.add(QUESTIONPANEL);
		
		TEXTFIELDPANEL = new JPanel();
		TEXTFIELDPANEL.setBounds(175, 350, 450, 100);	
		TEXTFIELDPANEL.setBackground(Color.white);
		TEXTFIELDPANEL.add(answer);
		FRAME.add(TEXTFIELDPANEL);	
		con.add(TEXTFIELDPANEL);
		
		JButton submit = new JButton("Done");
		submit.setFont(LABELFONT);
		submit.setBackground(Color.green);
		submit.setForeground(Color.white);
		submit.addActionListener(new GUI());
		TEXTFIELDPANEL.add(submit);
		
		runLevels();
		
		
	}


 	public static void runLevels() {
	
 		level1();
 		runSelectedLevels();
		level2();
 		runSelectedLevels();
		level3();
 		runSelectedLevels();
		level4();
 		runSelectedLevels();

	}

 	public static void runSelectedLevels() {
				
		while (score < 10 && lives > 0 ) {
			submit();
			stats.setText("Score: " + score + "   Lives: " + lives);
				
		}


		question.setText(endLevel());

	}
		
	private static void submit() {
		int userAnswer = 0;
		
		currentQuestion = generateQuestion();

		question.setText(currentQuestion.printQuestion());
		userAnswer = Integer.parseInt(answer.getText());


		while (!currentQuestion.checkAnswer(userAnswer)) {
			lives--;
			question.setText("Try again!");
			userAnswer = Integer.parseInt(answer.getText());

		}
		score++;				
		question.setText("You got it!");		
	}

	//This method runs the first level of the game, where there are two integers in the range of 1-10.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question has addition and subtraction,
	public static void level1() {
		
		title.setText("level 1!");
		score = 0;
		lives = 3;
		qMax = 2;
		qMin = 1;
		numMin = 1;
		numMax = 10;

	}

	//This method runs the third level of the game, where there are two integers in the range of 1-20.
	//To pass this level, you must achieve a score of 10 without getting more than 3 label.setTextestions wrong.
	//This question has addition and subtraction.
	public static void level2() {
		title.setText("level 2!");
	
		score = 0;
		lives = 3;
		qMax = 2;
		qMin = 1;
		numMin = 1;
		numMax = 20;


	}

	//This method runs the third level of the game, where there are two integers in the range of 1-10.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question has addition, subtraction, and multiplication.
	public static void level3() {
		title.setText("level 3! ");

		score = 0;
		lives = 3;
		qMax = 3;
		qMin = 1;
		numMin = 1;
		numMax = 10;


	}

	//This method runs the fourth level of the game, where there are two integers in the range of 1-10.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question only has division and multiplication problems.
	public static void level4() {
		title.setText("level 4!");

		score = 0;
		lives = 3;
		qMax = 4;
		qMin = 3;
		numMin = 1;
		numMax = 10;


	}

	//This method generates a question using various variables.
	public static Question generateQuestion() {

		operandDecider = (int)Math.floor(Math.random()*(qMax - qMin + 1) + qMin);

		firstNum = (int)Math.floor(Math.random()*(numMax - numMin + 1) + numMin);
		secondNum = (int)Math.floor(Math.random()*(firstNum - numMin + 1) + numMin);

		Question newQuestion = new Question(firstNum, secondNum, operandDecider);

		return newQuestion;
		
	}

	public static String endLevel() {

		String message = "";

		if (score == 10) {
			message = "You passed the level!";
		} else {
			message = "You didn't pass the level!";
			endGame(false);
		}

		return message;
	}

	public static void endGame(boolean success) {

		if (success) {

			title.setText("Congratulations! You beat the game!");
			

		} else {

			title.setText("You have no more lives left!");

		}

		question.setText("\nYour score was: " + score 
				+"\nYou had " + lives + " lives remaining.");

				title.setText("\nThank you for playing our game!");
				System.exit(0);		

	}
	
public class TitleScreenHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("begun");
		Start();
	} 
	
	@Override
	public void actionPerformed(actionEvent e) {
		//rules
		
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		submit();
}


	

}
