package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import connection.C_Holder;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private FirstConnection firstConnection;
	

	public Window(int id, int x, int y) {

		setTitle("Client " + id);

		setSize(x, y);

		setLocationRelativeTo(null);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBackground(Color.GRAY);

		setVisible(true);
	}

	public Window(int x, int y) {

		setTitle("Try connection");
		setSize(x, y);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(Color.GRAY);

		firstConnection = new FirstConnection(x, y);

		ButtonHolder.tryConnection.addActionListener(this);

		firstConnection.add(ButtonHolder.connectionString);
		firstConnection.add(ButtonHolder.tryConnection);

		setContentPane(firstConnection);

		setVisible(true);

	}

	public void close() {
		setVisible(false);
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tryConnection(ButtonHolder.connectionString.getText());
	}

	private void tryConnection(String ip) {
		Socket socket = null;
		try {
			socket = new Socket(ip, 9999);

		} catch (UnknownHostException e) {
			e.printStackTrace();
			firstConnection.printError("Unknow host");
		} catch (IOException e) {
			e.printStackTrace();
			firstConnection.printError("Server fail");
		}
		
		if(socket != null) {
			Thread t = new C_Holder(socket);
			t.start();
			close();
		}

	}
}
