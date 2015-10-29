package TextGame;

import java.io.*;

import javax.swing.JTextArea;

public class SwingOutputStream extends OutputStream{
	 private JTextArea textArea;
	    public SwingOutputStream(JTextArea textArea) {
	        this.textArea = textArea;
	    }

	public void write(int characterNumber) throws IOException {
		textArea.append(String.valueOf((char)characterNumber));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

}
