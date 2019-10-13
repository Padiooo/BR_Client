package player;

public class Clock extends Thread {

	private int clock_time = 0;
	private IPlayer player;
	
	private boolean stop = false;

	public Clock(int clock_time, IPlayer player) {
		this.clock_time = clock_time;
		this.player = player;
	}

	@Override
	public void run() {
		while (!getStop()) {
			try {
				Thread.sleep(clock_time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			player.move();
		}
	}
	
	private synchronized boolean getStop() {
		return stop;
	}
	
	public void stopClock() {
		stop = true;
	}
	
	

}
