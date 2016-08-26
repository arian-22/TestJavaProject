package database;


import java.sql.*;

import javax.swing.JOptionPane;


public class MySQL {
	
	private static Connection Conexion;
	
	
	
	public void mySQLConnection(String user, String pass, String db_name) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + db_name, user, pass);
        JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa");
    }
	
	public void closeConnection() throws SQLException {
		Conexion.close();
        JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
   }
	
	public void doQuery(String query) throws SQLException{
				
		Statement stm = Conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while (rs.next())
		{
		   System.out.println("Razon Social: "+rs.getObject("razon_social")+
		      ", CUIT: "+rs.getObject("cuit")+
		      ", Teléfono: "+rs.getObject("telefono"));
		}
	}


	
}
