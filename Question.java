//This object creates a question using information from the newFile.java class.
public class Question {

	public int firstNum = 0;
	public int secondNum = 0;
	public int answer = 0;
	public char operand = '0';
	
	/*
	* This object constructor takes 3 integers:
	* 
	* a: the first number in any given equation
	* b: the second number in any given equation
	* i: the number that decides the operator
	*/
	Question(int a, int b, int i) {
		
		firstNum = a;
		secondNum = b;

		switch(i) {
		
			case 1:
				operand = '+';
				answer = firstNum + secondNum;
				break;
				
			case 2:
				operand = '-';
				answer = firstNum - secondNum;
				break;
				
			case 3:
				operand = '*';
				answer = firstNum * secondNum;
				break;
				
			case 4:
				operand = '/';
				answer = firstNum;
				firstNum *= secondNum;
				break;
			}
		
	}
	
	//Returns first number in the question
	public int returnFirstNum() {
		return firstNum;
	}
	
	//Returns second number in the question
	public int returnSecondNum() {
		return secondNum;
	}
	
	//Returns operater in the question
	public char returnOperand() {
		return operand;
	}
	
	//Returns the answer of the question
	public int returnAnswer() {

		return answer;
	}

	//Returns the full question
	public String printQuestion() {
		String question = firstNum + " " + operand + " " + secondNum + " = __?";
		return question;
	}
	
	//Returns boolean that represents if the user's input is the same as the correct answer.
	//It takes integer userInput as a parameter.
	public boolean checkAnswer(int userInput) {

		boolean answerCorrect = userInput == answer;
		
		return answerCorrect;
	}
	
}
