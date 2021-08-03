import java.util.*;


public class newFile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String currentQuestionText = "";
		
		int a, b, operandDecider;
		
		int qMax = 4;
		int qMin = 1;
		
		int numMin = 1;
		int numMax = 10;
		
		operandDecider = (int)Math.floor(Math.random()*(qMax - qMin + 1) + qMin);
		
		a = (int)Math.floor(Math.random()*(numMax - numMin + 1) + numMin);
		b = (int)Math.floor(Math.random()*(a - numMin + 1) + numMin);
		
		System.out.println(a + " " + b + " " + operandDecider);
		
		
		Question current = new Question(a, b);
		
		current.operand(operandDecider);
		currentQuestionText = current.returnFirstNum() + " " + current.returnOperand() + " " + current.returnSecondNum() + " = __?";
		
		
		System.out.println(currentQuestionText);
		
		int userInput = sc.nextInt();
		
		System.out.println(current.checkAnswer(userInput));

	}

}
 