package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPanel;

public class FirstConnection extends JPanel {

	private static final long serialVersionUID = 1L;

	private String errors = "";

	private int x;
	private int y;

	public FirstConnection(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paintComponent(Graphics g) {

		g.clearRect(0, 0, x, y);

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, x, y);

		g.setColor(Color.BLACK);
		g.drawString(errors, x / 3, y / 2);

	}


	public void printError(String errors) {
		this.errors = errors;
		repaint();
	}



}
