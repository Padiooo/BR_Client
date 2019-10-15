package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public Window(int id, int x, int y) {

		setTitle("Client " + id);

		setSize(x + 8, y + 38);

		setLocationRelativeTo(null);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(Color.GRAY);

		setVisible(true);
	}

	public Window(int x, int y, String title) {

		setTitle(title);
		setSize(x + 8, y + 38);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(Color.GRAY);
		setVisible(true);
	}

	public void close() {
		setVisible(false);
		dispose();
	}
}
