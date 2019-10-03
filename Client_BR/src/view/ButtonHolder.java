package view;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonHolder {
	
	public static JButton tryConnection;
	public static JTextField connectionString;
	
	public ButtonHolder() {
		tryConnection = new JButton("Try !");
		
		connectionString = new JTextField();
		connectionString.setColumns(16);
		
	}
}
