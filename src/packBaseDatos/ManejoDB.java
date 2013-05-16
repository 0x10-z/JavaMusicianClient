package packBaseDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class ManejoDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CargarDriver4();
		Connection con;
		try {
			con = establecerConexion();

			Ejercicio4(con);
			System.out.println("------------------------");
			Ejercicio5(con);
			System.out.println("------------------------");
			Ejercicio6(con);
			System.out.println("------------------------");
			Ejercicio7(con);
			System.out.println("------------------------");
			Ejercicio8(con);
			System.out.println("------------------------");
			Ejercicio9(con);
			cerrarConexion(con);
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
	 * 3. Haz un programa que abra y cierre la conexión a la base de datos
	 * osakidetza usando un driver de tipo4
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection establecerConexion() throws SQLException {
		Connection con;
		


		String url = "jdbc:mysql://db4free.net:3306/javamusica";
		String user = "elequipob";
		String psw = "elequipo3";
		con = DriverManager.getConnection(url, user, psw);
		
		System.out.println("Conexion establecida");
	
		
		
		con = DriverManager.getConnection(url);

		System.out.println("Conexion establecida");
		return con;

	}

	public static void cerrarConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 4. Muestra los nombres de los médicos por pantalla
	 * 
	 * @param con
	 */
	public static void Ejercicio4(Connection con) {
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT nombre FROM medico");
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha logrado la conexion");
			e.printStackTrace();

		}
	}

	/**
	 * 5. Haz un programa que muestre la estructura (pares de nombreatributo
	 * tipodatoatributo) de la tabla asegurado por pantalla(se supone que no
	 * conocemos ni el número ni el tipo de los atributos)
	 * 
	 * @param con
	 */
	private static void Ejercicio5(Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM asegurado");
			ResultSetMetaData metadata = rs.getMetaData();
			int columns = metadata.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				System.out.println("Nombre " + metadata.getColumnName(i)
						+ " Tipo: " + metadata.getColumnTypeName(i));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha logrado la conexion");
			e.printStackTrace();

		}
	}

	/**
	 * 6. Muestra toda la información de los médicos, suponiendo que no
	 * conocemos ni la cantidad ni los tipos de los atributos de dicha tabla
	 * 
	 * @param con
	 */
	public static void Ejercicio6(Connection con) {

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM medico");
			ResultSetMetaData metadata = rs.getMetaData();
			int column = metadata.getColumnCount();
			while (rs.next()) {
				System.out.println("------");
				for (int i = 1; i < column; i++) {
					System.out.println(rs.getObject(i));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha logrado la conexion");
			e.printStackTrace();

		}
	}

	/**
	 * 7. Escribe un programa que borre los médicos con código menor que 5 y que
	 * nos indique el número de tuplas borradas.
	 * 
	 * @param con
	 */
	public static void Ejercicio7(Connection con) {
		try {
			Statement st = con.createStatement();
			int i;

			i = st.executeUpdate("DELETE FROM medico WHERE codigo<5");

			System.out.println("Se han borrado " + i + " tuplas");

		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			System.out
					.println("No se puede borrar ninguna tupla. Violacion de Integridad");
			System.out.println("Se han borrado 0 tuplas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 8. Haz un programa que muestre la información de los asegurados asignados
	 * al código de médico que nos indique el usuario
	 * 
	 * @param con
	 */
	public static void Ejercicio8(Connection con) {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(
				System.in));

		System.out
				.println("Introduce el codigo de medico del que quieres saber la informacion");
		try {
			int codigo = Integer.parseInt(entrada.readLine());
			Statement st = con.createStatement();
			String sql = "SELECT asegurado.nombre, asegurado.ape1, asegurado.ape2, asegurado.barrio, asegurado.loccentro FROM medico inner join asegurado ON codigo=medico WHERE codigo=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData metadata = rs.getMetaData();
			int column = metadata.getColumnCount();
			System.out
					.println("Los asegurados del medico: " + codigo + " son:");
			while (rs.next()) {
				System.out.println();
				for (int i = 1; i <= column; i++) {
					System.out.print(rs.getObject(i) + "\t");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha logrado la conexion");
			e.printStackTrace();

		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Formato de numero no valido");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("Error de E/S");
		}
	}

	public static void Ejercicio9(Connection con) {

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT nombre, codigo FROM medico");

			while (rs.next()) {
				System.out.println(rs.getString("nombre") + " "
						+ rs.getInt("codigo"));

				Statement st2 = con.createStatement();
				String sql = "SELECT nombre FROM asegurado WHERE medico=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, rs.getInt("codigo"));
				ResultSet rs2 = ps.executeQuery();
				while (rs2.next()) {
					System.out.print("\t");
					System.out.println(rs2.getString("nombre"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha logrado la conexion");
			e.printStackTrace();

		}

	}

}






