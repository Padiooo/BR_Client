package Player;

public class BallShoot extends Thread {
	
	private IPlayer player;
	private int id_ball;
	
	// millis
	private int reload_cooldown = 5000;

	public BallShoot(IPlayer player, int id_ball) {
		this.player = player;
		this.id_ball = id_ball;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(reload_cooldown);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		player.reload(id_ball);
		
	}

}
