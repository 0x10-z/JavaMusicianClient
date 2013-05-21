package packInterfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

import packBaseDatos.ManejoDB;
import packGroups.Artista;
import packInterfaz.ManejoFicheros;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaArtistas extends JDialog {
	private JList list;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	ManejoFicheros mf = new ManejoFicheros();
	private JScrollPane scrollPane;
	private JList list_1;
	private JList list_2;
	private JButton btnNewButton_2;
	BuscarArtista ba;
	private JButton btnNewButton_3;
	AnadirArtista aa;
	private static ManejoDB mdb;
	BiografiaArtista bioArtista;
	private Artista[] listaAr;

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
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getBtnNewButton_3());
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Buscar Artista");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ba = new BuscarArtista();
					ba.setVisible(true);
					ba.setModal(true);
					setModal(false);
					//dispose();
					
				}
			});
			btnNewButton.setBounds(34, 217, 156, 25);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Aceptar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					bioArtista = new BiografiaArtista(listaAr[list_2.getSelectedIndex()]);
					bioArtista.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(315, 37, 117, 25);
		}
		return btnNewButton_1;
	}

	/**
	 * Este metodo va en artistas
	 * 
	 */
	// Esto metodo ya no se usa
	private BufferedReader leerFuenteDatos(String path) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).

			archivo = new File(path);
			while (!archivo.isFile()) {
				JOptionPane.showInputDialog(null, "Path invalido");
			}
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

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 38, 269, 167);
			scrollPane.setViewportView(getList_2());
		}
		return scrollPane;
	}

	private JList getList_2() {
		if (list_2 == null) {
			//Artista[] listaAr;
			mdb = mdb.getInstance();
			System.out.println("Se va a proceder al volcado de la bd");
			listaAr = mdb.volcarBDaLista();
			String[] listaNombres = new String[listaAr.length];
			for (int i = 0; i < listaNombres.length; i++) {
				listaNombres[i] = listaAr[i].getNombre();
			}
			list_2 = new JList(listaNombres);

		}
		return list_2;
	}
	

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Cargar nueva fuente");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					/**
					 * Aqui debe ir el codigo para cargar una nueva fuente de
					 * datos
					 */

				}
			});
			btnNewButton_2.setBounds(243, 207, 193, 45);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("Anadir  ");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aa = new AnadirArtista();
					aa.setVisible(true);
					dispose();
					
				}
			});
			btnNewButton_3.setBounds(315, 88, 117, 25);
		}
		return btnNewButton_3;
	}
	
	public Artista[] getList() {
		return this.listaAr;
	}
}
