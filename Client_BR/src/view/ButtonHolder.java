package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonHolder extends Observable implements ActionListener {

	private JButton b_try_connection;
	private JButton b_ready;
	
	private JTextField txt_connection_string;

	public ButtonHolder() {
		b_try_connection = new JButton("Try !");

		txt_connection_string = new JTextField();
		txt_connection_string.setColumns(16);

		b_ready = new JButton("ready");

		b_try_connection.addActionListener(this);
		b_ready.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();

		if (o == b_try_connection) {
			setChanged();
			notifyObservers(txt_connection_string.getText());
		} else if (o == b_ready) {
			setChanged();
			notifyObservers(true);
		}
	}

	
	//----------------------------------------
	
	public JButton getB_Try_connection() {
		return b_try_connection;
	}

	public JTextField getTxt_Connection_string() {
		return txt_connection_string;
	}

	public JButton getB_Ready() {
		return b_ready;
	}
	
}
