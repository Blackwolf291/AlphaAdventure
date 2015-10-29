package TextGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameScreen extends JFrame implements Runnable{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public static JTextArea textArea;
	public static JTextArea statsScreen;
	public void run(){
		textField.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_ENTER){
					String userInput = textField.getText();
					textField.setText("");
					textArea.append(userInput + "\n");
					Input.holder.addNewInput(userInput);
				}
			}
			public void keyReleased(KeyEvent arg0) {
			}
			public void keyTyped(KeyEvent k) {
			}
			
		});
	}
	
	public GameScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Alpha Adventure");
			
		textField = new JTextField();
		textField.setBounds(207, 530, 564, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(207, 5, 564, 519);
		contentPane.add(textArea);
		PrintStream printStream = new PrintStream(new SwingOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		textArea.setEnabled(false);
		
		statsScreen = new JTextArea();
		statsScreen.setBounds(10, 5, 192, 546);
		contentPane.add(statsScreen);
		statsScreen.setEnabled(false);
		this.setVisible(true);
	}
}
