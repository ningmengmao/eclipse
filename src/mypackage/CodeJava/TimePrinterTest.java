package mypackage.CodeJava;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;


class TimePrinter implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("At the tone, the time is" + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}
public class TimePrinterTest {
	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(10000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit progarm?");
		System.exit(0);
	}
}