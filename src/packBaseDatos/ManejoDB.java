package packBaseDatos;

import java.sql.*;



public class ManejoDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CargarDriver4();
		Connection con;
		String path = null;
		try {
			//con = establecerConexion(path);
			/////////////
			//String url = "jdbc:mysql://localhost:3306/"+ "javamusica" + "?user=root";

			String url= "jdbc:mysql://localhost:3306/javamusica";
			String user = "root";
			String psw = "";
			
			con = DriverManager.getConnection(url, user, psw);
			System.out.println("Conexion establecida");
			//////////////////
			// Prueba
			prueba(con);
			
			
			/////////////
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			///////////

			//cerrarConexion(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido establecer la conexion");
			e.printStackTrace();
		}
	}

	public static void CargarDriver4() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver cargado exitosamente");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Driver no encontrado");
		}
	}

	/**
	 * Colocar la ruta donde se encuentra la db
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection establecerConexion() throws SQLException {
		Connection con;
		//String url = "jdbc:mysql://localhost:3306/"+ "javamusica" + "?user=root";

		String url= "jdbc:mysql://localhost:3306/javamusica";
		String user = "root";
		String psw = "";
		
		con = DriverManager.getConnection(url, user, psw);
		System.out.println("Conexion establecida");
		return con;

	}

	public void cerrarConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void prueba(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM artista");
			
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
