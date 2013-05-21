package packInterfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import packBaseDatos.ManejoDB;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnadirArtista extends JDialog {

	private static ManejoDB mdb;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			mdb = mdb.getInstance();
			AnadirArtista dialog = new AnadirArtista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AnadirArtista() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTextField());
		contentPanel.add(getTextField_1());
		contentPanel.add(getTextField_2());
		contentPanel.add(getTextField_3());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getLblNewLabel_4());
		contentPanel.add(getBtnNewButton());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(159, 64, 114, 19);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(159, 95, 114, 19);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(159, 126, 114, 19);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(159, 157, 114, 19);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(38, 66, 70, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Alias");
			lblNewLabel_1.setBounds(38, 97, 70, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Edad");
			lblNewLabel_2.setBounds(38, 128, 70, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Disponibilidad");
			lblNewLabel_3.setBounds(38, 159, 116, 15);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Anadir Artista");
			lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel_4.setBounds(67, 12, 141, 15);
		}
		return lblNewLabel_4;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Anadir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nombre = getTextField().getText();
					String alias = getTextField_1().getText();
					int edad = Integer.parseInt(getTextField_2().getText());
					mdb.introducirArtista(nombre, alias, edad, 's');
					//Aqui hay que hacer uno para la disponibilidad. Panel desplegable con si o no. Si si, si. Si no, no.
					
				}
			});
			btnNewButton.setBounds(159, 201, 117, 25);
		}
		return btnNewButton;
	}
}
