package ui;

import java.sql.SQLException;

import database.MySQL;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		MySQL db = new MySQL();
		
		db.mySQLConnection("root", "root", "agencia_personal");
		
		String query = "SELECT * FROM empresas";
		db.doQuery(query);
		
		db.closeConnection();

	}

}
