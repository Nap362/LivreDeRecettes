package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dialog.DialogCreerRecette;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class PresentationJFrameCreerRecette extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNouvelleRecette;
	private JLabel lblNom;
	private JTextField txtfNom;
	private JLabel lblType;
	private JLabel lblTemps;
	private JComboBox<String> cbxType;
	private JLabel lblTypeViande;
	private JLabel lblTypePoisson;
	private JCheckBox chckbxVegan;
	private JComboBox<String> cbxTypeViande;
	private JComboBox<String> cbxTypePoisson;
	private JLabel lblNbrPersonnes;
	private JSpinner spnPersonnes;
	private JButton btnAjouterIngredient;
	private JButton btnAjouterInstruction;
	private JButton btnCreer;
	private JButton btnAnnuler;
	private DialogCreerRecette dialogCreerRecette;
	private JSpinner spnTemps;

	/**
	 * Create the frame.
	 */
	public PresentationJFrameCreerRecette() {
		setResizable(false);
		setTitle("Assistant de cuisine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 525);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);

		lblNouvelleRecette = new JLabel("Nouvelle recette");
		lblNouvelleRecette.setFont(new Font("Tahoma", Font.BOLD, 20));

		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtfNom = new JTextField();
		txtfNom.setColumns(10);
		txtfNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_txtfNom_actionPerformed(e);
			}
		});

		lblType = new JLabel("Type de recette");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTemps = new JLabel("Temps de préparation");
		lblTemps.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbxType = new JComboBox<>();
		cbxType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbxType.setModel(new DefaultComboBoxModel<>(new String[] { "Viande", "Poisson", "Végétarien", "Dessert" }));
		cbxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_cbxType_actionPerformed(e);
			}
		});

		lblTypeViande = new JLabel("Type de viande");
		lblTypeViande.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTypePoisson = new JLabel("Type de poisson");
		lblTypePoisson.setFont(new Font("Tahoma", Font.PLAIN, 14));

		chckbxVegan = new JCheckBox("Végan");
		chckbxVegan.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbxTypeViande = new JComboBox<>();
		cbxTypeViande.setModel(new DefaultComboBoxModel<>(new String[] {"Agneau", "Boeuf", "Canard", "Dinde", "Gibier", "Lapin", "Mouton", "Pintade", "Porc", "Poulet", "Veau"}));
		cbxTypeViande.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbxTypePoisson = new JComboBox<>();
		cbxTypePoisson.setModel(new DefaultComboBoxModel<>(new String[] { "Bar", "Cabillaud", "Dorade", "Eglefin", "Hareng", "Limande", "Maquereau", "Merlan", "Merlu", "Sar", "Saumon", "Sole", "Truite", "Turbot",
				"Crabe", "Crevette", "Ecrevisse", "Gambas", "Homard", "Langouste", "Langoustine", "Tourteau", "Bigorneau", "Bulot", "Clam", "Coque",
				"StJacques", "Couteau", "Huitre", "Moule", "Palourde", "Petoncle", "Telline" }));
		cbxTypePoisson.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNbrPersonnes = new JLabel("Nombre de personnes");
		lblNbrPersonnes.setFont(new Font("Tahoma", Font.PLAIN, 14));

		spnPersonnes = new JSpinner();
		spnPersonnes.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spnPersonnes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnPersonnes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spnPersonnes_stateChanged(e);

			}
		});

		btnAjouterIngredient = new JButton("Ajouter un ingrédient");
		btnAjouterIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAjouterIngredient_actionPerformed(e);
			}
		});
		btnAjouterIngredient.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnAjouterInstruction = new JButton("Ajouter une instruction");
		btnAjouterInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouterInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAjouterInstruction_actionPerformed(e);
			}
		});

		btnCreer = new JButton("Créer");
		btnCreer.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAnnuler_actionPerformed(e);
			}
		});

		spnTemps = new JSpinner();
		spnTemps.setModel(new SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(5), null, Integer.valueOf(5)));
		spnTemps.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnTemps.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				do_spnTemps_stateChanged(e);

			}
		});
		GroupLayout glContentPane = new GroupLayout(contentPane);
		glContentPane.setHorizontalGroup(
			glContentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(glContentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAjouterInstruction)
								.addComponent(btnAjouterIngredient)))
						.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(glContentPane.createSequentialGroup()
								.addGap(49)
								.addComponent(lblNouvelleRecette, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addGap(56))
							.addGroup(glContentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(glContentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(glContentPane.createSequentialGroup()
										.addGap(17)
										.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(chckbxVegan)
											.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(glContentPane.createSequentialGroup()
													.addComponent(lblTypeViande)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(cbxTypeViande, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
												.addGroup(glContentPane.createSequentialGroup()
													.addComponent(lblTypePoisson)
													.addGap(18)
													.addComponent(cbxTypePoisson, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))))
									.addGroup(glContentPane.createSequentialGroup()
										.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbxType, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
							.addGroup(glContentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNom)
								.addGap(10)
								.addComponent(txtfNom, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
							.addGroup(glContentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTemps)
									.addComponent(lblNbrPersonnes))
								.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
								.addGroup(glContentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(spnPersonnes)
									.addComponent(spnTemps, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))))
					.addGap(384))
				.addGroup(Alignment.LEADING, glContentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnCreer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAnnuler))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		glContentPane.setVerticalGroup(
			glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNouvelleRecette)
					.addGap(18)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblType))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxTypeViande, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTypeViande))
					.addGap(6)
					.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(glContentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTypePoisson))
						.addGroup(glContentPane.createSequentialGroup()
							.addComponent(cbxTypePoisson, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(chckbxVegan)))
					.addGap(18)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNom))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTemps)
						.addComponent(spnTemps, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNbrPersonnes)
						.addComponent(spnPersonnes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnAjouterIngredient)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAjouterInstruction, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCreer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
		);
		contentPane.setLayout(glContentPane);
	}

	public void initPresentation(DialogCreerRecette d) {
//		cbxType.setSelectedIndex(-1);
//		cbxTypeViande.setSelectedIndex(-1);
		cbxTypeViande.setEnabled(false);
		lblTypeViande.setEnabled(false);
//		cbxTypePoisson.setSelectedIndex(-1);
		cbxTypePoisson.setEnabled(false);
		lblTypePoisson.setEnabled(false);
		chckbxVegan.setSelected(false);
		chckbxVegan.setEnabled(false);
		lblNom.setEnabled(false);
//		txtfNom.setText("");
		txtfNom.setEnabled(false);
		lblTemps.setEnabled(false);
//		spnTemps.setValue(5);
		spnTemps.setEnabled(false);
		lblNbrPersonnes.setEnabled(false);
//		spnTemps.setValue(1);
		spnPersonnes.setEnabled(false);
		btnAjouterIngredient.setEnabled(false);
		btnAjouterInstruction.setEnabled(false);
		btnCreer.setEnabled(false);
		btnAnnuler.setEnabled(true);
		
		this.dialogCreerRecette = d;
	}

	public void enableTypeViande() {
		cbxTypeViande.setEnabled(true);
		lblTypeViande.setEnabled(true);
		cbxTypePoisson.setEnabled(false);
		lblTypePoisson.setEnabled(false);
		chckbxVegan.setEnabled(false);
	}

	public void enableTypePoisson() {
		cbxTypeViande.setEnabled(false);
		lblTypeViande.setEnabled(false);
		cbxTypePoisson.setEnabled(true);
		lblTypePoisson.setEnabled(true);
		chckbxVegan.setEnabled(false);
	}

	public void enableVegan() {
		cbxTypeViande.setEnabled(false);
		lblTypeViande.setEnabled(false);
		cbxTypePoisson.setEnabled(false);
		lblTypePoisson.setEnabled(false);
		chckbxVegan.setEnabled(true);
	}
	
	public void enableDessert() {
		cbxTypeViande.setEnabled(false);
		lblTypeViande.setEnabled(false);
		cbxTypePoisson.setEnabled(false);
		lblTypePoisson.setEnabled(false);
		chckbxVegan.setEnabled(false);
	}

	public void enableChampsSuplementaires() {
		lblNom.setEnabled(true);
		txtfNom.setEnabled(true);
	}

	public void enableAjoutIngredients() {
		btnAjouterIngredient.setEnabled(true);
	}
	
	public void enableAjoutInstructions() {
		btnAjouterInstruction.setEnabled(true);
	}

	protected void do_cbxType_actionPerformed(ActionEvent e) {
		dialogCreerRecette.handlerTypeChoisi((String) cbxType.getSelectedItem());
	}

	protected void do_txtfNom_actionPerformed(ActionEvent e) {
		lblTemps.setEnabled(true);
		spnTemps.setEnabled(true);
	}

	protected void do_spnTemps_stateChanged(ChangeEvent e) {
		lblNbrPersonnes.setEnabled(true);
		spnPersonnes.setEnabled(true);
	}

	protected void do_spnPersonnes_stateChanged(ChangeEvent e) {
		lblTemps.setEnabled(true);
		spnTemps.setEnabled(true);
	}

	protected void do_btnAjouterIngredient_actionPerformed(ActionEvent e) {
		
	}

	protected void do_btnAjouterInstruction_actionPerformed(ActionEvent e) {
	}
	
	protected void do_btnAnnuler_actionPerformed(ActionEvent e) {
		
		cbxTypeViande.setEnabled(false);
		lblTypeViande.setEnabled(false);
		cbxTypePoisson.setEnabled(false);
		lblTypePoisson.setEnabled(false);
		chckbxVegan.setSelected(false);
		chckbxVegan.setEnabled(false);
		lblNom.setEnabled(false);
		txtfNom.setText("");
		txtfNom.setEnabled(false);
		lblTemps.setEnabled(false);
		spnTemps.setValue(5);
		spnTemps.setEnabled(false);
		lblNbrPersonnes.setEnabled(false);
		spnPersonnes.setValue(1);
		spnPersonnes.setEnabled(false);
		btnAjouterIngredient.setEnabled(false);
		btnAjouterInstruction.setEnabled(false);
		btnCreer.setEnabled(false);
		btnAnnuler.setEnabled(true);
	}
	
	protected void do_btnCreer_actionPerformed(ActionEvent e) {
		String nom = txtfNom.getText();
		String typeViande = (String) cbxTypeViande.getSelectedItem();
		String typePoisson = (String) cbxTypePoisson.getSelectedItem();
		boolean vegan = chckbxVegan.isSelected();
		int temps = (int) spnTemps.getValue();
		dialogCreerRecette.handlerRecetteInitialisee(nom, typeViande, typePoisson, vegan, temps);
		lblTemps.setEnabled(true);
		spnTemps.setEnabled(true);
	}
}
