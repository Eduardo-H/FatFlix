package xunito.fatflix;

import xunito.fatflix.db.ConnDB;

public class Main {

	public static void main(String[] args) {
		ConnDB.initDB();
		App.launch(App.class);
		ConnDB.closeConn();
	}

}
