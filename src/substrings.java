import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class substrings {

    String postfixEQT;
 
    public String[] parseEquation(String equation) {
        
        Scanner input = new Scanner(System.in);
        //String equation;
        String[] results = new String[2];
        int choice;
        boolean number = false;
        boolean valid;
        boolean loop = true;
            valid = validate(equation);

        if(valid) {
            computePrecedence(equation);
            String translation = translate(equation);
            results[0] = translation;
            results[1] = postfixEQT;
            return results;
        } else {
			results[0] = "syntax error";
			results[1] = "syntax error";
			return results;
        }
    }

    public String translate(String equation){
        String[] substrings = equation.split(" ");
        String equation1 = "";
		
        for(int ctr = 0; ctr <= substrings.length-1; ctr++) {
            if(substrings[ctr].matches(".*\\d.*")) {
                Long num = Long.parseLong(substrings[ctr]);
                equation1 = equation1 + EnglishNumberToWords.convert(num)+" ";
                   
            } else if(substrings[ctr].matches(".*\\*.*") || substrings[ctr].matches(".*\\/.*") || substrings[ctr].matches(".*\\+.*") || substrings[ctr].matches(".*\\-.*")) {
                equation1 = equation1 + convertOP(substrings[ctr])+" ";
            }
        }
        return equation1;
    }

    public String convertOP(String operator) {
        
        if(operator.equals("+")) {
            return "Plus";
        } else if(operator.equals("-")) {
            return "Minus";
        } else if(operator.equals("*")) {
            return "Times";
        } else if(operator.equals("/")) {
            return "Divided by";
        } else return "";
    }

    public void computePrecedence(String equation){
        String[] subs = equation.split(" ");
        String output = "";
        String topStack = "";
        Stack opStack = new Stack();
        
        for(int ctr = 0; ctr < subs.length ; ctr++){
            
            int stackPrecedence;
            int currentPrecedence;
            String letter = subs[ctr];
            
            if(letter.matches("\\d*")){
                output = output + letter;
                output = output + " ";
				
            } else if(letter.equals("+")){
                if(opStack.isEmpty()){
                    opStack.push(letter);
                    
                } else if(opStack.peek().equals("*")||opStack.peek().equals("/")){
                    output = output + opStack.peek();
					opStack.pop();
                    opStack.push(letter);
					output = output + " ";
                    
                } else if(opStack.peek().equals("+")||opStack.peek().equals("-")){
                    output = output + opStack.peek();
                    opStack.pop();
                    opStack.push(letter);
					output = output + " ";
                    
                }
				
            } else if(letter.equals("-")){
                if(opStack.isEmpty()){
                    opStack.push(letter);
                    
                } else if(opStack.peek().equals("*")||opStack.peek().equals("/")){
                    output = output + opStack.peek();
                    opStack.pop();
                    opStack.push(letter);
					output = output + " ";
                    
                } else if(opStack.peek().equals("+")||opStack.peek().equals("-")){
                    output = output + opStack.peek();
                    opStack.pop();
                    opStack.push(letter);
					output = output + " ";
                    
                }
				
            } else if(letter.equals("*")){
                if(opStack.isEmpty()){
                    opStack.push(letter);
                    
                } else if(opStack.peek().equals("*")||opStack.peek().equals("/")){
                    output = output + opStack.peek();
                    opStack.pop();
                    opStack.push(letter);
					output = output + " ";
                    
                } else if(opStack.peek().equals("+")||opStack.peek().equals("-")){
                    opStack.push(letter);
                    
                }
				
            } else if(letter.equals("/")){
                if(opStack.isEmpty()){
                    opStack.push(letter);
                    
                } else if(opStack.peek().equals("*")||opStack.peek().equals("/")){
                    output = output + opStack.peek();
                    opStack.pop();
                    opStack.push(letter);
					output = output + " ";
                    
                } else if(opStack.peek().equals("+")||opStack.peek().equals("-")){
                    opStack.push(letter);
                    
                }
			}
		}
		
        if(!opStack.isEmpty()){
			try{
				for(int ctr = 0; ctr < opStack.size()+2; ctr++){
					output = output + opStack.pop() + " ";
				} 
			} catch (Exception e){
			}
        }
		
        postfixEQT = output;
    }    
    

    
    public boolean validate(String equation) {
        
        boolean valid = false;
        
        String rule1 = "\\d*[+]{1}\\d*";
        String rule2 = "\\d*[-]{1}\\d*";
        String rule3 = "\\d*[*]{1}\\d*";
        String rule4 = "\\d*[/]{1}\\d*";
        
        String[] subs = equation.split(" ");
        String[] operation = new String[subs.length];
		int tok_index = 0;
		
        for(String token : subs){
			switch(tok_index % 2){
				case 0: 
					if( token.matches("\\d*")){
						valid = true;
						break;
					} else 
						return false;
					
				case 1:
					if( token.matches("[+]") 
						||token.matches("[-]") 
						||token.matches("[*]") 
						||token.matches("[/]")){
                
						valid = true;
						break;
					}else {
						return false;
					}
			}
			tok_index++;
        }
        
		for(int ctr = 2; ctr <= subs.length-1; ctr++) {
            operation[ctr] = subs[ctr-2] + subs[ctr-1] + subs[ctr];
            if(ctr % 2 == 0) {
                operation[ctr] = subs[ctr-2] + subs[ctr-1] + subs[ctr];
                if(operation[ctr].matches(rule1)) {
                    valid = true;
                } else if(operation[ctr].matches(rule2)) {
                    valid = true;
                } else if(operation[ctr].matches(rule3)) {
                    valid = true;
                } else if(operation[ctr].matches(rule4)) {
                    valid = true;
                } else return false;
            }
        }
		
        return valid;
    }
}


