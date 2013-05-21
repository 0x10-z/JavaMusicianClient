package packInterfaz;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import packBaseDatos.ManejoDB;
import packInterfaz.ManejoFicheros;
import packInterfaz.VentanaArtistas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;

public class VentanaPrincipal extends JDialog {
	VentanaArtistas va;
	private static ManejoDB db;
	ManejoFicheros mn = new ManejoFicheros();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPrincipal dialog = new VentanaPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPrincipal() {
		db = db.getInstance();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		/*
		 * Boton inciar
		 */
		JButton btnIniciar = new JButton("iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int n = JOptionPane
						.showConfirmDialog(
								null,
								"Desea iniciar una fuente de datos nueva?\nSi selecciona 'SI' sobreescribira la informacion guardada",
								"Fuente de Datos", JOptionPane.YES_NO_OPTION);
				/*
				 * Control de respuesta del showConfirmDialog
				 */
				if (n == JOptionPane.YES_OPTION) {
					String host = null;
					String user = null;
					String psw = "";
					String[] datos = new String[3];
					while (!db.probarConexion(host, user, psw)) {
						datos = db.introducirDatosDB();
						host = datos[0];
						user = datos[1];
						psw = datos[2];
						
					}
					
					va = new VentanaArtistas();
					va.setVisible(true);
					dispose();
				} else if (n == JOptionPane.NO_OPTION) {
					// Mirar si existe fichero con ruta. Si existe, bien, sino
					// darle la opcion a escoger ruta
					System.out
							.println("Has seleccionado que no desea iniciar una fuente de datos nueva");

					/**
					 * Cargar del de configuracion
					 */
					String[] datos = mn.cargarFConfiguracion();
					String host = datos[0];
					String user = datos[1];
					String psw = datos[2];
					/**
					 * Esto prueba si los datos de configuracion son validos
					 * para la bd
					 */
					while (!db.probarConexion(host, user, psw)) {
						datos = db.introducirDatosDB();
						host = datos[0];
						user = datos[1];
						psw = datos[2];
						
					}

					System.out.println("Conexion correcta con la db");
					// Aqui habria que cargar la fuente de datos
					
					
					
					va = new VentanaArtistas();
					va.setVisible(true);
					dispose();
					// Cargar (llamar a VentanaArtistas)

					// --------------------
				}
				dispose();
			}
		});
		btnIniciar.setBounds(148, 137, 117, 25);
		getContentPane().add(btnIniciar);
	}

}
