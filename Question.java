
public class Question {

	public int firstNum = 0;
	public int secondNum = 0;
	public int answer = 0;
	public char operand = '0';
	
	Question(int a, int b) {
		
		firstNum = a;
		secondNum = b;
		
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
	
	public int operand(int i) {
		
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
			answer = firstNum / secondNum;
			break;
		}
		
		return answer;
	}
	
	public String checkAnswer(int userInput) {
		String correct = "You got it!";
		String incorrect = "Try again!";
		String message = "";
		
		if (userInput == answer) {
			message = correct;
		} else {
			message = incorrect;
		}
		
		return message;
	}
	
}
