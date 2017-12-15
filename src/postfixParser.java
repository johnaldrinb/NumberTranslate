import java.util.*;

public class postfixParser{
	
	public String[] parsePostfix(String equation){
		String[] tokens = equation.split(" ");
		Stack <String> outputStack = new Stack<>();
		Stack <String> pStack = new Stack<>();
		
		for(String element : tokens){
			if(element.matches("\\d*")){
				outputStack.push(element);
				pStack.push(element);
				
			} else if(element.equals("+")){
				int operand1 = Integer.valueOf(outputStack.pop());
				int operand2 = Integer.valueOf(outputStack.pop());
				String arg1 = pStack.pop();
				String arg2 = pStack.pop();
				outputStack.push(String.valueOf(operand2 + operand1));
				pStack.push("( " + arg2 + " + " + arg1 + " )");
				
			} else if(element.equals("-")){
				int operand1 = Integer.valueOf(outputStack.pop());
				int operand2 = Integer.valueOf(outputStack.pop());
				String arg1 = pStack.pop();
				String arg2 = pStack.pop();
				outputStack.push(String.valueOf(operand2 - operand1));
				pStack.push("( " + arg2 + " - " + arg1 + " )");
				
			} else if(element.equals("*")){
				int operand1 = Integer.valueOf(outputStack.pop());
				int operand2 = Integer.valueOf(outputStack.pop());
				String arg1 = pStack.pop();
				String arg2 = pStack.pop();
				outputStack.push(String.valueOf(operand2 * operand1));
				pStack.push("( " + arg2 + " * " + arg1 + " )");
				
			} else if(element.equals("/")){
				int operand1 = Integer.valueOf(outputStack.pop());
				int operand2 = Integer.valueOf(outputStack.pop());
				String arg1 = pStack.pop();
				String arg2 = pStack.pop();
				
				try{
					outputStack.push(String.valueOf(operand2 / operand1));
					pStack.push("( " + arg2 + " / " + arg1 + " )");
					
				} catch (ArithmeticException e){
					String[] results = new String[2];
					results[0] = "Cannot divide by zero...";
					results[1] = "No Solution...";
					return results;
				}
			}
		}
		
		String[] results = new String[2];
		results[0] = outputStack.pop();
		results[1] = pStack.pop();
		return results;
	}
}