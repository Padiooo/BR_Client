package player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

	private IPlayer player;

	public KeyboardListener(IPlayer player) {
		this.player = player;
	}

	//@formatter:off
	@Override
	public void keyTyped(KeyEvent e) {}
	//@formatter:on

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'z':
			player.setDirection_y(-1);
			break;
		case 'q':
			player.setDirection_x(-1);
			break;
		case 's':
			player.setDirection_y(1);
			break;
		case 'd':
			player.setDirection_x(1);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		char c = e.getKeyChar();

		if (c == 'z' || c == 's') {
			player.setDirection_y(0);
		}
		if (c == 'q' || c == 'd') {
			player.setDirection_x(0);
		}

	}

}
