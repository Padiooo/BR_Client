package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import player.Clock;
import player.IPlayer;
import player.KeyboardListener;
import player.MousePlayerListener;
import player.Player;
import view.GamePanel;
import view.Window;

public class C_Holder extends Thread {

	@SuppressWarnings("unused")
	private Socket socket;
	private BufferedReader reader;
	private static BufferedWriter writer;

	private String delims = "[ ]+";
	private StringBuilder str = new StringBuilder();

	private static IPlayer player;
	private MousePlayerListener listener_mouse;
	private KeyboardListener listener_key;
	private Clock clock;

	private Window win;
	private GamePanel pan;

	public C_Holder(Socket socket) {
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				doAction(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doAction(String data) {
		String[] datas = data.split(delims);
		switch (datas[0]) {
		case "SETUP":
			setup(datas);
			System.out.println(data);
			break;
		case "START":
			startGame();
			System.out.println(data);
			break;
		case "DIE":
			die();
			System.out.println(data);
			break;
		case "DEATH_RECAP":
			deathRecap(data);
			System.out.println(data);
		default:
			updatePanel(datas);
			break;
		}
	}

	private void setup(String[] datas) {
		int client_id = Integer.valueOf(datas[1]);
		int size_x = Integer.valueOf(datas[2]);
		int size_y = Integer.valueOf(datas[3]);
		int clock_time = Integer.valueOf(datas[4]);

		win = new Window(client_id, size_x, size_y);
		pan = new GamePanel(client_id, size_x, size_y);
		win.setContentPane(pan);

		player = new Player(this);
		clock = new Clock(clock_time, player);
		listener_mouse = new MousePlayerListener(player);
		listener_key = new KeyboardListener(player);
	}

	private void startGame() {
		win.addMouseListener(listener_mouse);
		win.addKeyListener(listener_key);
		clock.start();
	}

	private void die() {
		win.removeMouseListener(listener_mouse);
		win.removeKeyListener(listener_key);
		clock.stopClock();
		player.die();
	}

	private void deathRecap(String data) {
		str.append(data);
		str.append(System.lineSeparator());
	}

	private void updatePanel(String[] datas) {
		int rows = datas.length / 9;
		int[] players_id = new int[rows];
		int[][][] coord_data = new int[rows][4][2];

		int shift = 0;
		int k = 0;

		for (int i = 0; i < rows; i++) {
			players_id[i] = Integer.valueOf(datas[shift]);
			for (int j = 1; j < 9; j += 2) {
				coord_data[i][k][0] = Integer.valueOf(datas[j + shift]);
				coord_data[i][k][1] = Integer.valueOf(datas[j + 1 + shift]);
				k++;
			}
			k = 0;
			shift += 9;
		}

		pan.setId(players_id);
		pan.setData(coord_data);
		pan.repaint();
	}

	public void sendReady() {
		try {
			writer.write("READY");
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String command) {

		if (player.isAlive()) {
			try {
				writer.write(command);
				writer.newLine();
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
