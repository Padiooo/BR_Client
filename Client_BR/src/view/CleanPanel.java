package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;

public class CleanPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String message = "";

	private int size_x;
	private int size_y;

	public CleanPanel(int size_x, int size_y) {
		this.size_x = size_x;
		this.size_y = size_y;
	}

	public void paintComponent(Graphics g) {

		int index = g.getFont().getSize() * message.length() / 3;

		g.clearRect(0, 0, size_x, size_y);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, size_x, size_y);

		g.setColor(Color.BLACK);
		g.drawString(message, size_x / 2 - index, size_y / 2);

		g.getFont().getSize();

	}

	public void printMessage(String message) {
		this.message = message;
		repaint();
	}

}
