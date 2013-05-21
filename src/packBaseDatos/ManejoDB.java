package packBaseDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import packGlobalEnums.Instrumentos;
import packGroups.Artista;
import packInterfaz.ManejoFicheros;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class ManejoDB {

	private static ManejoDB instance;
	static Connection con;
	private String host;
	private String user;
	private String psw;
	ManejoFicheros mn = new ManejoFicheros();

	private ManejoDB() {
		System.out.println("Cargando driver");
		CargarDriver();
		establecerHUP();

	}

	public Artista[] volcarBDaLista() {
		ArrayList<Artista> lista = new ArrayList<Artista>();
		Artista artista;
		try {
			con = establecerConexion(host, user, psw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM artista");
			ResultSetMetaData metadata = rs.getMetaData();
			int column = metadata.getColumnCount();
			while (rs.next()) {
				System.out.println("Volcando base de datos a una lista...");
				//for (int i = 1; i < column; i++) {
					artista = new Artista(rs.getString("nombre"),
							rs.getString("alias"), rs.getInt("edad"),
							Instrumentos.ARPA);
					lista.add(artista);
				//}
			}

			cerrarConexion(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido establecer la conexion");
			e.printStackTrace();
		}

		Artista[] datosArtistas = new Artista[lista.size()];
		int i = 0;
		for (Artista artista2 : lista) {
			datosArtistas[i++] = artista2;
		}
		return datosArtistas;
	}

	public boolean probarConexion(String pHost, String pUser, String pPsw) {
		String url = pHost;
		String user = pUser;
		String psw = pPsw;

		try {
			con = DriverManager.getConnection(url, user, psw);
			System.out.println("Conexion establecida");
			// Llamar al metodo para guardar los datos en configuracion
			
			mn.guardarFConfiguracion(url, user, psw);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out
					.println("No se ha podido establecer conexion con la base de datos");
			return false;
		//} finally {
			//cerrarConexion(con);
		}

	}

	private void establecerHUP() {
		String[] datos;
		// TODO Auto-generated method stub
		datos = mn.cargarFConfiguracion();
		host = datos[0];
		user = datos[1];
		psw = datos[2];
	}

	public boolean buscarArtista(String pNombre) {
		con = establecerConexion(host, user, psw);
		boolean existe = false;
		String sql = "SELECT * FROM artista WHERE nombre=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// damos valores a los parámetros
			ps.setString(1, pNombre);
			// ps.setBoolean(4, disponible);
			// ejecutamos la sentencia SQL
			ResultSet rs = ps.executeQuery();
			System.out.println("Existe Artista " + pNombre + "? " + rs);

			if (rs.next()) {
				existe = true;
				return existe;
			} else {
				existe = false;
				return existe;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		cerrarConexion(con);
		return existe;
	}

	public void mostrarTodo() {
		try {
			con = establecerConexion(host, psw, user);
			// /////////////////////////////////////////

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM artista");
			ResultSetMetaData metadata = rs.getMetaData();
			int column = metadata.getColumnCount();
			while (rs.next()) {
				System.out.println("------");
				for (int i = 1; i < column; i++) {
					System.out.print(rs.getObject(i) + " | ");
				}
				System.out.println("\n------");

			}

			// introducirArtista(con, "ola", "asda", 1, 's');
			// ///////////////////////////////////////////
			cerrarConexion(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido establecer la conexion");
			e.printStackTrace();
		}
	}

	private void cerrarConexion(Connection con2) {
		// TODO Auto-generated method stub
		try {
			con.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Connection establecerConexion(String pUrl, String pUser, String pPsw) {
		// TODO Auto-generated method stub
		String url = pUrl;
		String user = pUser;
		String psw = pPsw;
		System.out.println(pUrl + "\n" + pUser + "\n" + pPsw);

		// CONEXION CON SERVIDOR || ESTO ES LO QUE HAY QUE PONER EN
		// CONFIGURACION
		// String url = "jdbc:mysql://db4free.net:3306/javamusica";
		// String user = "elequipob";
		// String psw = "elequipo3";
		// CONEXION LOCAL
		// String url = "jdbc:mysql://localhost:3306/javamusica";
		// String user = "root";
		// String psw = "0306iocio00506";
		try {
			con = DriverManager.getConnection(url, user, psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("No se ha podido establecer conexion con la base de datos");
		}

		System.out.println("Conexion establecida");

		return con;
	}

	private void CargarDriver() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver cargado exitosamente");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Driver no encontrado");
		}
	}

	public static ManejoDB getInstance() {
		if (null == instance) {
			instance = new ManejoDB();
		}
		return instance;
	}

	public void introducirArtista(String pNombre, String pAlias, int edad,
			char c) {
		// TODO Auto-generated method stub
		// generación del preparedStatement
		con = establecerConexion(host, user, psw);
		String sql = "insert into artista (nombre, alias, edad, disponible) values ( ?, ?, ?, 'si');";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// damos valores a los parámetros
			ps.setString(1, pNombre);
			ps.setString(2, pAlias);
			ps.setInt(3, edad);
			// ps.setBoolean(4, disponible);
			// ejecutamos la sentencia SQL
			int rs = ps.executeUpdate();
			System.out.println("Artista anadido: " + rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		cerrarConexion(con);
		// insert into artista (nombre, alias, edad, disponible) values ("iker",
		// "ik", 21, 'n');
	}
	
	public String[] introducirDatosDB() {
		String[] datos;
		JOptionPane.showMessageDialog(null,
										"No se ha establecido conexion con la db.\nIntroduce datos para una nueva conexion");
		host = JOptionPane
				.showInputDialog("Introduce el host de la bd. Por Ejemplo: 'jdbc:mysql://localhost:3306/javamusica'");
		user = JOptionPane
				.showInputDialog("Introduce el usuario de la bd");
		psw = JOptionPane
				.showInputDialog("Introduce la contrasena");
		
		return  datos = new String[]{host, user, psw};
	}

}