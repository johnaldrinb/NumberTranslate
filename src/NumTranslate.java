import java.util.Stack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumTranslate implements ActionListener {
	JFrame window;
	JButton button_clear;
	JButton button_answer;
	JLabel label_postFix;
	JLabel label_input;
	JLabel label_output;
	JLabel label_solution;
	JLabel label_answer;
	JLabel label_answerWord;
	JTextField textField_input;
	JTextArea textArea_postFix;
	JTextArea textArea_output;
	JTextArea textArea_solution;
	JTextArea textArea_answer;
	JTextArea textArea_answerWord;

	public NumTranslate(){
		init();
	}	

	public void init() {
		window = new JFrame("WORDIFY");
		button_clear = new JButton("CLEAR");
		button_answer = new JButton("SHOW ANSWER");
		label_postFix = new JLabel("Postfix Notation:");
		label_input = new JLabel("Enter equation to translate (values must be separated by a space):");
		label_output = new JLabel("Translation:");
		label_answer = new JLabel("Answer:");
		label_solution = new JLabel("Solution:");
		label_answerWord = new JLabel("Answer Translation:");
		textArea_output = new JTextArea();
		textField_input = new JTextField();
		textArea_postFix = new JTextArea();
		textArea_answer = new JTextArea();
		textArea_solution = new JTextArea();
		textArea_answerWord = new JTextArea();
		JScrollPane scroller_Translation = new JScrollPane(textArea_output);
		JScrollPane scroller_Postfix = new JScrollPane(textArea_postFix);
		JScrollPane scroller_Solution = new JScrollPane(textArea_solution);
		JScrollPane scroller_Answer = new JScrollPane(textArea_answer);
		JScrollPane scroller_AnswerWord = new JScrollPane(textArea_answerWord);
		JPanel panel = new JPanel();
		
		window.setLayout(null);
		window.setSize(700,690);
		window.setForeground(Color.blue);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.add(panel);
		panel.setLayout(null);
		panel.setBounds(0,0,700,700);
		panel.setBackground(new Color(255,190,190));
		panel.add(button_clear);
		panel.add(button_answer);
		panel.add(label_output);
		panel.add(label_input);
		panel.add(label_postFix);
		panel.add(label_answer);
		panel.add(label_answerWord);
		panel.add(label_solution);
		panel.add(textArea_answer);
		panel.add(textArea_answerWord);
		panel.add(textArea_postFix);
		panel.add(textField_input);
		panel.add(textArea_output);
		panel.add(textArea_solution);
		panel.add(scroller_Translation);
		panel.add(scroller_Answer);
		panel.add(scroller_AnswerWord);
		panel.add(scroller_Postfix);
		panel.add(scroller_Solution);
		
		label_answer.setBounds(15,450,88,40);
		label_answer.setFont(new Font("Arial",1,20));
		//label_answer.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		label_answer.setBackground(new Color(204,204,255));
		
		label_answerWord.setBounds(15,550,200,40);
		label_answerWord.setFont(new Font("Arial",1,20));
		//label_answerWord.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		label_answerWord.setBackground(new Color(204,204,255));
		
		label_input.setBounds(15,15,640,40);
		label_input.setFont(new Font("Arial",1,20));
		//label_input.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		label_input.setBackground(new Color(204,204,255));

		label_output.setBounds(15,150,120,40);
		label_output.setFont(new Font("Arial",1,20));
		//label_output.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		label_output.setBackground(new Color(204,204,255));

		label_postFix.setBounds(15,250,170,40);
		label_postFix.setFont(new Font("Arial",1,20));
		//label_postFix.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		label_postFix.setBackground(new Color(204,204,255));
		
		label_solution.setBounds(15,350,95,40);
		label_solution.setFont(new Font("Arial",1,20));
		//label_solution.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		label_solution.setBackground(new Color(204,204,255));

		button_clear.setBounds(15,105,160,40);
		button_clear.setToolTipText("Click to clear input & output fields");
		button_clear.addActionListener(this);
		button_clear.setBackground(new Color(204,204,255));
		
		button_answer.setBounds(180,105,160,40);
		button_answer.setToolTipText("Click to show the answer for the equation");
		button_answer.addActionListener(this);
		button_answer.setBackground(new Color(204,204,255));

		textArea_output.setBounds(15,200,665,50);
		textArea_output.setEditable(false);
		textArea_output.setWrapStyleWord(true);
		textArea_output.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textArea_output.setFont(new Font("Consolas",1,20));
		textArea_output.setBackground(new Color(255,255,255));
		textArea_output.setToolTipText("Displays the translation of the equation");
		scroller_Translation.setViewportView(textArea_output);
		scroller_Translation.setBounds(15,195,665,50);
		scroller_Translation.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		textArea_postFix.setEditable(false);
		textArea_postFix.setWrapStyleWord(true);
		textArea_postFix.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textArea_postFix.setFont(new Font("Consolas",1,20));
		textArea_postFix.setBackground(new Color(255,255,255));
		textArea_postFix.setToolTipText("Displays the Postfix Notation of the equation");
		scroller_Postfix.setViewportView(textArea_postFix);
		scroller_Postfix.setBounds(15,295,665,50);
		scroller_Postfix.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		textArea_answer.setEditable(false);
		textArea_answer.setWrapStyleWord(true);
		textArea_answer.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textArea_answer.setFont(new Font("Consolas",1,20));
		textArea_answer.setBackground(new Color(255,255,255));
		textArea_answer.setToolTipText("Displays the answer for the equation");
		scroller_Answer.setViewportView(textArea_answer);
		scroller_Answer.setBounds(15,495,665,50);
		scroller_Answer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		textArea_solution.setEditable(false);
		textArea_solution.setWrapStyleWord(true);
		textArea_solution.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textArea_solution.setFont(new Font("Consolas",1,20));
		textArea_solution.setBackground(new Color(255,255,255));
		textArea_solution.setToolTipText("Displays the solution for the equation");
		scroller_Solution.setViewportView(textArea_solution);
		scroller_Solution.setBounds(15,395,665,50);
		scroller_Solution.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		textArea_answerWord.setEditable(false);
		textArea_answerWord.setWrapStyleWord(true);
		textArea_answerWord.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		textArea_answerWord.setFont(new Font("Consolas",1,20));
		textArea_answerWord.setBackground(new Color(255,255,255));
		scroller_AnswerWord.setViewportView(textArea_answerWord);
		scroller_AnswerWord.setBounds(15,595,665,50);
		scroller_AnswerWord.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		textField_input.setBounds(15,60,665,40);
		textField_input.setFont(new Font("Consolas",1,20));
		textField_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				try{
					if (!textField_input.getText().equals("")) {
						substrings sub = new substrings();

						String translation = "";
						String equation = textField_input.getText();
						String[] results = sub.parseEquation(equation);
						
						translation = translation + results[0];
						textArea_postFix.setText(results[1]);
						textArea_output.setText(translation);
						textArea_answer.setText("");
						textArea_answerWord.setText("");
						textArea_solution.setText("");
						
					} else {
						textArea_output.setText("");
						textArea_postFix.setText("");
					}
				} catch (NumberFormatException e) {
				}
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == button_clear) {
			textField_input.setText("");
			textArea_output.setText("");
			textArea_postFix.setText("");
			textArea_answer.setText("");
			textArea_answerWord.setText("");
			textArea_solution.setText("");
			
		} else if (ae.getSource() == button_answer) {
			try{
				
				EnglishNumberToWords translator = new EnglishNumberToWords();
				postfixParser pfx = new postfixParser();
				String[] results = pfx.parsePostfix(textArea_postFix.getText());
				String answer = results[0];
				String solution = results[1];
				
				if(answer.equals("Cannot divide by zero...")){
					JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Math Error", JOptionPane.WARNING_MESSAGE);
					textArea_output.setText("");
					textArea_postFix.setText("");
					textField_input.setText("");
					
				} else if(textArea_output.equals("syntax error")){
					textArea_solution.setText("syntax error");
					textArea_answer.setText("syntax error");
					
				} else{
					textArea_solution.setText(solution);
					textArea_answer.setText(answer);
				}
				
				if(answer.charAt(0) == '-'){
					answer = answer.replace('-',' ');
					answer = answer.trim();
					Long number = Long.parseLong(answer);
					textArea_answerWord.setText( "Negative " + translator.convert(number));
					
				} else if(answer.matches("\\d*")){
					Long number = Long.parseLong(answer);
					textArea_answerWord.setText(translator.convert(number));
					
				}
			} catch (Exception e){
			}
		}
	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new NumTranslate();
            }  // public void run()
       });
	}
}