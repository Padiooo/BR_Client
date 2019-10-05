package player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

public class MousePlayerListener extends Observable implements MouseListener {

	private IPlayer player;

	public MousePlayerListener(IPlayer player) {
		this.player = player;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX() - 9;
		int y = e.getY() - 38;
		player.shoot(x, y);
	}

	//@formatter:off
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	//@formatter:on

}
