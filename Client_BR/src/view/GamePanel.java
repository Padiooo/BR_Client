package view;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int client_id;
	private int size_x;
	private int size_y;

	public GamePanel(int client_id, int size_x, int size_y) {
		this.client_id = client_id;
		this.size_x = size_x;
		this.size_y = size_y;
	}

}
