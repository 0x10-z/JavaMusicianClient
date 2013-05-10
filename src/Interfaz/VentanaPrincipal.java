package Interfaz;

import Interfaz.ManejoFicheros;
import Interfaz.VentanaArtistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class VentanaPrincipal extends JDialog {
	VentanaArtistas va = new VentanaArtistas();

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		/*
		 * Boton inciar
		 */
		JButton btnIniciar = new JButton("iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = JOptionPane.showConfirmDialog(null,
						"Desea iniciar una fuente de datos nueva?\nSi selecciona 'SI' sobreescribira la informacion guardada",
						"Fuente de Datos", JOptionPane.YES_NO_OPTION);
				/*
				 * Control de respuesta del showConfirmDialog
				 */
				if (n == JOptionPane.YES_OPTION) {
					// Escoger ruta
					System.out.println("SI");
					File archivoElegido = mn.menuCargaFuenteDatos();
					
					

					// Cargar fuente de datos

					// Abrir ventana artistas
					va.setVisible(true);
					dispose();
				} else if (n == JOptionPane.NO_OPTION) {
					// Mirar si existe fichero con ruta. Si existe, bien, sino
					// darle la opcion a escoger ruta
					System.out.println("Has seleccionado que no desea iniciar una fuente de datos nueva");

					/**
					 * Cargar del de configuracion
					 */
					String path = mn.cargarFConfiguracion();
					// Metodo de la clase Artista que le pasemos el path y se
					// cargue alli todo

					if (path.equals("No existe")) {
						JOptionPane
								.showMessageDialog(null,
										"No existe fuente de datos.\nSe procedera a cargar nueva fuente de datos");
						File archivoElegido = mn.menuCargaFuenteDatos();
						
						
						
						// Aqui habria que cargar la fuente de datos
						va.setVisible(true);
						dispose();
					} else {
						// Aqui habria que cargar la fuente dfe datos
						va.setVisible(true);
						dispose();
						// Cargar (llamar a VentanaArtistas)
					}
					// --------------------
				}
				dispose();
			}
		});
		btnIniciar.setBounds(148, 137, 117, 25);
		getContentPane().add(btnIniciar);
	}

}
