package player;

import connection.C_Holder;

public class Player implements IPlayer {

	private int direction_x;
	private int direction_y;
	private int[] ball_id = { 1, 1, 1 };

	private boolean alive = true;
	
	public int size_player;
	
	private C_Holder c_holder;

	public Player(C_Holder c_holder, int size_player) {
		this.c_holder = c_holder;
		this.size_player = size_player;
	}

	@Override
	public String move() {
		String command = String.format("move %d %d", direction_x, direction_y);

		if (direction_x != 0 || direction_y != 0) {
			sendChanges(command);
		}
		return command;
	}

	@Override
	public boolean shoot(int mouse_x, int mouse_y) {

		int id_ball = getIdBall();

		if (id_ball != -1) {

			new BallShoot(this, id_ball).start();

			String command = String.format("shoot %d %d %d", id_ball, mouse_x, mouse_y);

			sendChanges(command);

			return true;
		}

		return false;
	}

	@Override
	public boolean reload(int id_ball) {

		if (id_ball >= 0 && id_ball <= 2) {
			ball_id[id_ball] = 1;
			String command = String.format("reload %d", id_ball);

			sendChanges(command);
		}

		return false;
	}

	@Override
	public boolean isAlive() {
		return this.alive;
	}

	@Override
	public boolean die() {
		this.alive = false;
		return alive;
	}

	@Override
	public void sendChanges(String command) {
		c_holder.sendMessage(command);
	}

	private int getIdBall() {
		int id_ball = 0;
		for (id_ball = 0; id_ball < ball_id.length; id_ball++) {
			if (ball_id[id_ball] > 0) {
				ball_id[id_ball] = -1;
				break;
			}
		}
		if (id_ball == 3) {
			return -1;
		}
		return id_ball;
	}

	@Override
	public void setDirection_x(int direction_x) {
		this.direction_x = direction_x;
	}

	@Override
	public void setDirection_y(int direction_y) {
		this.direction_y = direction_y;
	}
	
	@Override
	public int getSizePlayer() {
		return size_player;
	}

	// --------------------------------------------------------

	public int getDirection_x() {
		return direction_x;
	}

	public int getDirection_y() {
		return direction_y;
	}

}
