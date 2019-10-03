package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.C_Holder;

public class FirstConnection extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	public FirstConnection() {
		ButtonHolder.tryConnection.addActionListener(this);
		
		add(ButtonHolder.connectionString);
		add(ButtonHolder.tryConnection);
	}

	public void paintComponent(Graphics g) {

		g.clearRect(0, 0, 500, 500);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 500, 500);

	}

	private void tryConnection() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
