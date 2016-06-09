package TextGame;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class SwingOutputStream extends OutputStream{
	 private JTextArea textArea;
	    public SwingOutputStream(JTextArea textArea) {
	        this.textArea = textArea;
	    }

	@Override
	public void write(int characterNumber) throws IOException {
		textArea.append(String.valueOf((char)characterNumber));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

}
