package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;

public class FirstConnection extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private String errors = "zafazfzf";

	public FirstConnection() {
		ButtonHolder.tryConnection.addActionListener(this);

		add(ButtonHolder.connectionString);
		add(ButtonHolder.tryConnection);
	}

	public void paintComponent(Graphics g) {

		g.clearRect(0, 0, 350, 100);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 350, 100);

		if (errors.compareTo("") != 0) {
			g.setColor(Color.BLACK);
			g.drawString(errors, 100, 50);
		}

	}

	private void tryConnection(String ip) {
		Socket socket;
		try {
			socket = new Socket(ip, 9999);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			printError(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			printError(e.toString());
		}
		System.out.println("Connected");

	}

	private void printError(String errors) {
		this.errors = errors;
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tryConnection(ButtonHolder.connectionString.getText());
	}

}
