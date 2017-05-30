package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.Ctrl;
import model.Composant;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.Scrollbar;
import javax.swing.ScrollPaneConstants;

/**
 * Classe définissant la vue d'ajout d'un médicament
 * @author xavier
 *
 */
public class MedicineAdd extends JDialog implements MyView{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnValider;
	private JButton btnAnnuler;
	private static JTextField txtNom;
	private static JComboBox<String> cbxFormes;
	private static JTextField txtBrevet;
	private static JComboBox<String> cbxPrincipeActif;
	private static JList list;

	/**
	 * Méthode statique permettant de réinitialiser les champs
	 */
	public static void init(){
		txtBrevet.setText("");
		txtNom.setText("");
	}
	
	/**
	 * Méthode statique permettant d'obtenir le contenu du champ texte nom
	 * @return le contenu du champ texte nom
	 */
	public static String getTxtName(){
		return txtNom.getText();
	}
	
	/**
	 * Méthode statique permettant d'obtenir la sélection de la liste déroulante formes
	 * @return la selection de la liste déroulante formes
	 */
	public static String getTxtForm(){
		return (String) cbxFormes.getSelectedItem();
	}
	
	
	public static String getTxtComposant(){
		return (String) cbxPrincipeActif.getSelectedItem();
	}
	
	public static int[] getIndexExipients(){
		return (int[]) list.getSelectedIndices();
	}
	
	/**
	 * Méthode statique permettant d'obtenir le contenu du champ texte date brevet
	 * @return le contenu du champ texte date brevet
	 */
	public static String getTxtPatentDate(){
		if(txtBrevet.getText().equals(""))
			return null;
		return txtBrevet.getText();
	}
	/**
	 * Méthode statique permettant de placer le curseur dans le champ texte nom
	 */
	public static void focusTxtName(){
		MedicineAdd.txtNom.requestFocus();
	}
	
	/**
	 * Create the dialog.
	 * @param forms les formes à intégrer dans la liste déroulante
	 * @param composants 
	 */
	public MedicineAdd(String[] forms, String[] Composants) {
		setTitle("M\u00E9dicament - Modifier");
		setModal(true);
		setBounds(100, 100, 450, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(83, 45, 50, 14);
		contentPanel.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(140, 42, 192, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblForme = new JLabel("Forme :");
		lblForme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForme.setBounds(63, 128, 70, 14);
		contentPanel.add(lblForme);
		
		cbxFormes = new JComboBox<String>(forms)/*forms*/;
		cbxFormes.setBounds(140, 125, 192, 20);
		contentPanel.add(cbxFormes);
		
		JLabel lblDateBrevet = new JLabel("Date brevet :");
		lblDateBrevet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateBrevet.setBounds(53, 87, 80, 14);
		contentPanel.add(lblDateBrevet);
		
		txtBrevet = new JTextField();
		txtBrevet.setBounds(140, 84, 192, 20);
		contentPanel.add(txtBrevet);
		txtBrevet.setColumns(10);
		
		JLabel lbComposition = new JLabel("Composition :");
		lbComposition.setBounds(65, 194, 80, 14);
		contentPanel.add(lbComposition);
		
		JLabel lblPrincipeActif = new JLabel("Principe actif  : ");
		lblPrincipeActif.setBounds(155, 219, 80, 14);
		contentPanel.add(lblPrincipeActif);
		
		cbxPrincipeActif = new JComboBox<String>(Composants)/*Composants*/;
		cbxPrincipeActif.setBounds(245, 216, 161, 20);
		contentPanel.add(cbxPrincipeActif);
		
		JLabel lbExicipient = new JLabel("Exicipient(s) :");
		lbExicipient.setBounds(155, 264, 80, 14);
		contentPanel.add(lbExicipient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(250, 264, 156, 98);
		contentPanel.add(scrollPane_1);
		
		list = new JList(Composants);
		scrollPane_1.setViewportView(list);
		JScrollPane scrollPane = new JScrollPane();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnValider = new JButton("Valider");
				buttonPane.add(btnValider);
				getRootPane().setDefaultButton(btnValider);
			}
			{
				btnAnnuler = new JButton("Annuler");
				buttonPane.add(btnAnnuler);
			}
			{
				JButton btnFermer = new JButton("Fermer");
				btnFermer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnFermer);
			}
		}
	}


	private Dimension preferredSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignListener(Ctrl ctrl) {
		this.btnValider.setActionCommand("MedicineAdd_valider");
		this.btnValider.addActionListener(ctrl);
		this.btnAnnuler.setActionCommand("MedicineAdd_annuler");
		this.btnAnnuler.addActionListener(ctrl);
	}
}
