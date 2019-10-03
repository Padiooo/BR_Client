package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import player.IPlayer;
import view.Window;

public class C_Holder extends Thread {
	
	
	private Socket socket;
	private BufferedReader reader;
	private static BufferedWriter writer;
	
	private static IPlayer player;
	
	private int id_player;
	
	public C_Holder(Socket socket) {
		this.socket = socket;
		
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		displayReady();
		
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				writer.write("Je suis le player 1");
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void sendMessage(String command) {
		if(player.isAlive()) {
			try {
				writer.write(command);
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void displayReady() {
		Window win_ready = new Window(100, 60);
		
	}
	

}
