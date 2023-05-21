package presentation;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

public class PresentationJFrameFenetreAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JLabel lblListeRecettes;

	/**
	 * Create the frame.
	 */
	public PresentationJFrameFenetreAdmin() {
		setResizable(false);
		setTitle("Administrateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblListeRecettes = new JLabel("Liste des recettes :");
		lblListeRecettes.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textArea = new JTextArea();
		textArea.setEditable(true);
		GroupLayout glContentPane = new GroupLayout(contentPane);
		glContentPane.setHorizontalGroup(glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
						.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
								.addGroup(glContentPane.createSequentialGroup().addContainerGap().addComponent(
										lblListeRecettes, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		glContentPane.setVerticalGroup(glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup().addGap(9).addComponent(lblListeRecettes).addGap(17)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)));
		contentPane.setLayout(glContentPane);
	}

	public void presentationRecetteAjoutee(String nom) {
		textArea.append(" > " + nom +"\n");
	}
}

