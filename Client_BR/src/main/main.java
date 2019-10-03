package main;

import view.ButtonHolder;
import view.FirstConnection;
import view.Window;

public class main {

	public static void main(String[] args) {

		ButtonHolder bt = new ButtonHolder();
		
		Window window = new Window(350, 100);
		FirstConnection firstConnection = new FirstConnection();
		window.setContentPane(firstConnection);

	}
}
