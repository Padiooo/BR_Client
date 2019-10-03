package Player;

public interface IPlayer {
	
	public String move();
	
	public boolean shoot(int mouse_x, int mouse_y);
	
	public boolean reload(int id_ball);
	
	public boolean isAlive();
	
	public boolean die();
	
	public void setDirectionX() {};
	
	public void sendChanges(String command);

}
