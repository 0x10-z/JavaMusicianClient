package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Interfaz.ManejoFicheros;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VentanaArtistas extends JDialog {
	private JScrollPane scrollPane;
	private JList list;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	ManejoFicheros va = new ManejoFicheros();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaArtistas dialog = new VentanaArtistas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaArtistas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(52, 40, 227, 156);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}

	private JList getList() {
		if (list == null) {
			DefaultListModel modelo = new DefaultListModel();
			list = new JList(modelo);
			BufferedReader br = leerFichero(va.cargarFConfiguracion());
			String linea;
			try {
				while ((linea = br.readLine()) != null)
					modelo.addElement(linea);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(52, 207, 117, 25);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(315, 37, 117, 25);
		}
		return btnNewButton_1;
	}

	/**
	 * Este metodo va en artistas
	 * 
	 */
	private BufferedReader leerFichero(String path) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br;
	}
}
