
public class Question {

	public int firstNum = 0;
	public int secondNum = 0;
	public int answer = 0;
	public char operand = '0';
	
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
	
	public int returnFirstNum() {
		return firstNum;
	}
	
	public int returnSecondNum() {
		return secondNum;
	}
	
	public char returnOperand() {
		return operand;
	}
	
	public int returnAnswer() {

		return answer;
	}

	public String printQuestion() {
		String question = firstNum + " " + operand + " " + secondNum + " = __?";
		return question;
	}
	
	public boolean checkAnswer(int userInput) {

		boolean answerCorrect = userInput == answer;
		
		return answerCorrect;
	}
	
}
