package controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;

import connection.C_Holder;
import view.ButtonHolder;
import view.CleanPanel;
import view.Window;

public class Controller implements Observer {

	private ButtonHolder bh;
	private CleanPanel pan;
	private Window win;

	private C_Holder c_holder;

	public Controller() {
		bh = new ButtonHolder();
		bh.addObserver(this);
		begin();
	}

	private void begin() {
		int size_x = 350;
		int size_y = 100;
		win = new Window(size_x, size_y, "Connection");
		pan = new CleanPanel(size_x, size_y);
		pan.add(bh.getTxt_Connection_string());
		pan.add(bh.getB_Try_connection());
		win.setContentPane(pan);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.getClass() == String.class) {
			tryConnection((String) arg);
		} else if (arg.getClass() == boolean.class) {
			ready();
		}
	}
	
	private void ready() {
		c_holder.start();
	}

	private void tryConnection(String adress) {
		Socket socket = null;

		try {
			socket = new Socket(adress, 9999);
		} catch (UnknownHostException e) {
			pan.printMessage("Unknow host adress");
			// e.printStackTrace();
		} catch (IOException e) {
			pan.printMessage("Issues while connecting to server");
			// e.printStackTrace();
		}
		if (socket != null) {
			int size_x = 200;
			int size_y = 80;
			c_holder = new C_Holder(socket);
			win.close();
			pan = new CleanPanel(pan.size_x, pan.size_y);
			pan.add(bh.getB_Ready());
			win = new Window(size_x, size_y, "Ready ?");
			win.setContentPane(pan);
		}
	}

}
