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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
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
	}

<<<<<<< HEAD
=======
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

>>>>>>> 1554ae9f6840d0e4eaa5af41eb9a91804a94eb77
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Buscar Artista");
			btnNewButton.setBounds(34, 217, 156, 25);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Aceptar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
<<<<<<< HEAD
	private BufferedReader leerFuenteDatos(String path){
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	 
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	    	 
	         archivo = new File (path);
	         while(!archivo.isFile()){
	        	 JOptionPane.showInputDialog(null, "Path invalido");
	         }
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	 
	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	            System.out.println(linea);
	         
	         
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	      return br;
=======
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
>>>>>>> 1554ae9f6840d0e4eaa5af41eb9a91804a94eb77
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
			
			//Esto nos devuelve un array de string con todos los artistas
			String[] elementos = mf.leerFichero(mf.cargarFConfiguracion());
			
			list_2 = new JList(elementos);
		}
		return list_2;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Cargar nueva fuente");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					/**
					 * Aqui debe ir el codigo para cargar una nueva fuente de datos
					 */
					
				}
			});
			btnNewButton_2.setBounds(243, 207, 193, 45);
		}
		return btnNewButton_2;
	}
}
