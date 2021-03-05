package xunito.fatflix;

import xunito.fatflix.db.ConnDB;

public class Main {

	public static void main(String[] args) {
		Thread connection = new Thread(new FileThread());
		App.setConnection(connection);
		
		ConnDB.initDB();
		App.launch(App.class);
		ConnDB.closeConn();
		
		connection.interrupt();
	}

}
