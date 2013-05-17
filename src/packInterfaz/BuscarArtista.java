package packInterfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

import packBaseDatos.ManejoDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarArtista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private static ManejoDB mdb;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarArtista dialog = new BuscarArtista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarArtista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(141, 88, 146, 26);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Buscar Artista");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
			lblNewLabel.setBounds(149, 38, 138, 26);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(64, 116, 310, 45);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnNewButton = new JButton("BUSCAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mdb = mdb.getInstance();
					boolean existe;
					existe = mdb.buscarArtista(textField.getText());
					if(existe){
						lblNewLabel_1.setText("Existe el artista "+textField.getText());
					}else{
						lblNewLabel_1.setText("Lo siento, no existe. Haz otro intento");
					}
					
				}
			});
			btnNewButton.setBounds(116, 173, 211, 39);
			contentPanel.add(btnNewButton);
		}
	}
}
