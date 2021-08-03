import java.util.*;

public class newFile {

	public static int qMax, qMin, numMax, numMin, operandDecider, firstNum, secondNum, score, lives;

	public static void main(String[] args) {

		openingDialogue();

	}

	public static void runLevels() {

		level1();
		runSelectedLevel();
		level2();
		runSelectedLevel();
		level3();
		runSelectedLevel();
		level4();

	}

	public static void runSelectedLevel() {

		int userAnswer = 0;

		Scanner sc = new Scanner(System.in);

		Question currentQuestion;

		while (score < 10 && lives > 0) {

			currentQuestion = generateQuestion();

			System.out.println(currentQuestion.printQuestion());
			userAnswer = sc.nextInt();

			System.out.println("");

			if (currentQuestion.checkAnswer(userAnswer)) {
				score++;
				System.out.println("You got it!");
			} else {
				lives--;
				System.out.println("Try again!");
			}

			System.out.println("");
		
		}

		System.out.println("\n\n");

		System.out.println(endLevel());

	}

	//This method runs the first level of the game, where there are two integers in the range of 1-10.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question has addition and subtraction,
	public static void level1() {

		score = 0;
		lives = 3;
		qMax = 2;
		qMin = 1;
		numMin = 1;
		numMax = 10;

		System.out.println("Starting level 1...\n");

	}

	//This method runs the third level of the game, where there are two integers in the range of 1-20.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question has addition and subtraction.
	public static void level2() {

		score = 0;
		lives = 3;
		qMax = 2;
		qMin = 1;
		numMin = 1;
		numMax = 20;

		System.out.println("Starting level 2...\n");

	}

	//This method runs the third level of the game, where there are two integers in the range of 1-10.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question has addition, subtraction, and multiplication.
	public static void level3() {

		score = 0;
		lives = 3;
		qMax = 3;
		qMin = 1;
		numMin = 1;
		numMax = 10;

		System.out.println("Starting level 3...\n");

	}

	//This method runs the fourth level of the game, where there are two integers in the range of 1-10.
	//To pass this level, you must achieve a score of 10 without getting more than 3 questions wrong.
	//This question only has division and multiplication problems.
	public static void level4() {

		score = 0;
		lives = 3;
		qMax = 4;
		qMin = 3;
		numMin = 1;
		numMax = 10;

		System.out.println("Starting level 4...\n");

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

		Scanner sc = new Scanner(System.in);

		if (success) {

			System.out.println("Congratulations! You beat the game!");
			

		} else {

			System.out.println("Unfortunately, you did not beat the game.");

		}

		System.out.println("\nYour score was: " + score);
		System.out.println("You had " + lives + " lives remaining.");

		System.out.println("\nWould you like to play again?");
		System.out.println("1. yes\n2. no");

		int userInput = sc.nextInt();

		switch(userInput) {

			case 1:
				System.out.println("\n\n\n");
				runLevels();
				break;
			case 2:
				System.out.println("\nThank you for playing our game!");
				System.exit(0);
				break;
		}

	}

	public static void openingDialogue() {

		Scanner sc = new Scanner(System.in);
			
		System.out.println("Welcome to the game:");

		System.out.println("The objective is to go through 4 levels of math problems.");

		System.out.println("Each level is more challenging than the previous.");

		System.out.println("To pass a level, you must solve 10 questions correctly.");

		System.out.println("However, you only have 3 lives in each level. For every incorrct answer, you lose a life.");

		System.out.println("Once you have 0 lives, the game is over.");

		System.out.println("Would you like to start the game?\n1. Yes\n2. No");

		int userInput = sc.nextInt();

		System.out.println("");

		switch(userInput) {
			case 1:
				runLevels();
				break;
			case 2:
				System.exit(0);
				break;
		}

	}

}
 