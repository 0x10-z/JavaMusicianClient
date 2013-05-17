package packInterfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Label;
import javax.swing.JScrollPane;

import packGroups.Artista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.util.ArrayList;

public class BiografiaArtista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private TextArea textArea;
	private Artista artista2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BiografiaArtista dialog = new BiografiaArtista(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BiografiaArtista(Artista artista) {
		artista2 = artista;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
			lblNewLabel.setBounds(27, 12, 85, 25);
			contentPanel.add(lblNewLabel);
		}
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnNewButton_1());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getTextArea());
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel(new ImageIcon("/home/iocio/Escritorio/image.jpg"));
			lblNewLabel_2.setBounds(12, 49, 214, 126);
			
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Bio. Artista");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					/*
					 * Sacar la biografia del artista
					 */
					ArrayList<String>hitos = artista2.getBiografia().getHitos();
					String texto = null;
					for (String hito : hitos) {
						texto += texto+"\n";
					}
					getTextArea().setText(texto);						
				}
			});
			btnNewButton.setBounds(292, 42, 117, 25);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Bio. Grupo");
			btnNewButton_1.setBounds(292, 79, 117, 25);
		}
		return btnNewButton_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setBounds(112, 17, 70, 15);
		}
		return lblNewLabel_1;
	}
	private TextArea getTextArea() {
		if (textArea == null) {
			textArea = new TextArea();
			textArea.setBounds(246, 110, 192, 134);
		}
		return textArea;
	}
}