package main;

import View.ButtonHolder;
import View.FirstConnection;
import View.Window;

public class main {

	public static void main(String[] args) {

		ButtonHolder bt = new ButtonHolder();
		
		Window window = new Window(350, 80);
		FirstConnection firstConnection = new FirstConnection();
		window.setContentPane(firstConnection);

	}
}
