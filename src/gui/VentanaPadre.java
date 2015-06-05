/**
 * Paquete que contiene la GUI del programa
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import proyecto.Paises;
import proyecto.Combustible;
import proyecto.CategoriaVehiculos;
import proyecto.CategoriaMotos;
import proyecto.Mototipo;
import proyecto.ClaseCamiones;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Ventana Padre de todas las ventanas de GUI
 * @author David Peralvo
 *@version 1.0
 */
public class VentanaPadre extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField_Dorsal;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JTextField textField_Piloto;
	protected JTextField textField_Copiloto;
	protected JTextField textField_Mecanico;
	protected JTextField textField_Escuderia;
	protected JTextField textField_KM;
	protected JTextField textField_CantCombustible;
	protected JTextField textField_FechaInscripcion;
	protected JLabel lblDorsal;
	protected JPanel panel;
	protected JRadioButton rdbtnCoche;
	protected JRadioButton rdbtnMoto;
	protected JRadioButton rdbtnCamion;
	protected JLabel lblNombre;
	protected JLabel lblCopiloto;
	protected JLabel lblMecanico;
	protected JComboBox<Paises> comboBox_Pais;
	protected JLabel lblNewLabel;
	protected JLabel lblEscuderia;
	protected JLabel lblCombustible;
	protected JComboBox <Combustible>comboBox_Combustible;
	protected JComboBox<CategoriaVehiculos> comboBox_CategoriaCoches;
	protected JLabel lblCategoria;
	protected JComboBox comboBox_TipoMoto;
	protected JLabel lblTipoDeMoto;
	protected JLabel lblClase;
	protected JComboBox <CategoriaMotos>comboBox_CategoriaMotos;
	protected JComboBox <ClaseCamiones>comboBox_ClaseCamiones;
	protected JLabel lblVelocidad;
	protected JLabel lblCantidadDeCombustible;
	protected JLabel lblFechaDeInscripcion;
	protected JPanel buttonPane;
	protected JButton btnAadir;
	protected JButton cancelButton;
	protected JButton btnBorrar;
	protected JButton anterior;
	protected JButton posterior;
	protected JButton modificar;
	protected JButton abandonar;
	protected JButton repostar;
	protected JButton btnBuscar;
	protected JButton btnReparar;
	protected JButton btnActualizar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPadre dialog = new VentanaPadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setTitle("Ventana padre");
		setBounds(100, 100, 606, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setBounds(25, 21, 46, 14);
		contentPanel.add(lblDorsal);
		
		textField_Dorsal = new JTextField();
		textField_Dorsal.setBounds(66, 18, 86, 20);
		contentPanel.add(textField_Dorsal);
		textField_Dorsal.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Vehiculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(227, 11, 268, 46);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnCoche = new JRadioButton("Coche");
		buttonGroup.add(rdbtnCoche);
		rdbtnCoche.setBounds(6, 16, 68, 23);
		panel.add(rdbtnCoche);
		
		rdbtnMoto = new JRadioButton("Moto");
		buttonGroup.add(rdbtnMoto);
		rdbtnMoto.setBounds(76, 16, 55, 23);
		panel.add(rdbtnMoto);
		
		rdbtnCamion = new JRadioButton("Camion");
		buttonGroup.add(rdbtnCamion);
		rdbtnCamion.setBounds(133, 16, 109, 23);
		panel.add(rdbtnCamion);
		
		lblNombre = new JLabel("Piloto");
		lblNombre.setBounds(25, 88, 46, 14);
		contentPanel.add(lblNombre);
		
		textField_Piloto = new JTextField();
		textField_Piloto.setBounds(66, 85, 86, 20);
		contentPanel.add(textField_Piloto);
		textField_Piloto.setColumns(10);
		
		lblCopiloto = new JLabel("Copiloto");
		lblCopiloto.setBounds(162, 88, 46, 14);
		contentPanel.add(lblCopiloto);
		
		textField_Copiloto = new JTextField();
		textField_Copiloto.setBounds(218, 85, 86, 20);
		contentPanel.add(textField_Copiloto);
		textField_Copiloto.setColumns(10);
		
		lblMecanico = new JLabel("Mecanico");
		lblMecanico.setBounds(314, 88, 56, 14);
		contentPanel.add(lblMecanico);
		
		textField_Mecanico = new JTextField();
		textField_Mecanico.setBounds(380, 85, 86, 20);
		contentPanel.add(textField_Mecanico);
		textField_Mecanico.setColumns(10);
		
		comboBox_Pais = new JComboBox();
		comboBox_Pais.setModel(new DefaultComboBoxModel(Paises.values()));
		comboBox_Pais.setBounds(66, 130, 142, 20);
		contentPanel.add(comboBox_Pais);
		
		lblNewLabel = new JLabel("Pais");
		lblNewLabel.setBounds(25, 133, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblEscuderia = new JLabel("Escuderia");
		lblEscuderia.setBounds(227, 133, 64, 14);
		contentPanel.add(lblEscuderia);
		
		textField_Escuderia = new JTextField();
		textField_Escuderia.setBounds(301, 130, 111, 20);
		contentPanel.add(textField_Escuderia);
		textField_Escuderia.setColumns(10);
		
		lblCombustible = new JLabel("Combustible");
		lblCombustible.setBounds(25, 183, 75, 14);
		contentPanel.add(lblCombustible);
		
		comboBox_Combustible = new JComboBox();
		comboBox_Combustible.setModel(new DefaultComboBoxModel(Combustible.values()));
		comboBox_Combustible.setBounds(110, 180, 86, 20);
		contentPanel.add(comboBox_Combustible);
		
		comboBox_CategoriaCoches = new JComboBox();
		comboBox_CategoriaCoches.setModel(new DefaultComboBoxModel(CategoriaVehiculos.values()));
		comboBox_CategoriaCoches.setBounds(324, 180, 46, 20);
		contentPanel.add(comboBox_CategoriaCoches);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(245, 183, 69, 14);
		contentPanel.add(lblCategoria);
		
		comboBox_TipoMoto = new JComboBox();
		comboBox_TipoMoto.setModel(new DefaultComboBoxModel(Mototipo.values()));
		comboBox_TipoMoto.setBounds(110, 180, 86, 20);
		contentPanel.add(comboBox_TipoMoto);
		
		lblTipoDeMoto = new JLabel("Tipo de Moto");
		lblTipoDeMoto.setBounds(25, 183, 75, 14);
		contentPanel.add(lblTipoDeMoto);
		
		lblClase = new JLabel("Clase\r\n");
		lblClase.setBounds(25, 176, 108, 29);
		contentPanel.add(lblClase);
		
		comboBox_CategoriaMotos = new JComboBox();
		comboBox_CategoriaMotos.setModel(new DefaultComboBoxModel(CategoriaMotos.values()));
		comboBox_CategoriaMotos.setBounds(314, 180, 164, 20);
		contentPanel.add(comboBox_CategoriaMotos);
		
		comboBox_ClaseCamiones = new JComboBox();
		comboBox_ClaseCamiones.setModel(new DefaultComboBoxModel(ClaseCamiones.values()));
		comboBox_ClaseCamiones.setBounds(110, 180, 124, 20);
		contentPanel.add(comboBox_ClaseCamiones);
		
		lblVelocidad = new JLabel("Kilometros etapa");
		lblVelocidad.setBounds(25, 230, 108, 14);
		contentPanel.add(lblVelocidad);
		
		textField_KM = new JTextField();
		textField_KM.setBounds(136, 227, 86, 20);
		contentPanel.add(textField_KM);
		textField_KM.setColumns(10);
		
		lblCantidadDeCombustible = new JLabel("Cantidad de Combustible");
		lblCantidadDeCombustible.setBounds(287, 230, 142, 14);
		contentPanel.add(lblCantidadDeCombustible);
		
		textField_CantCombustible = new JTextField();
		textField_CantCombustible.setBounds(439, 227, 86, 20);
		contentPanel.add(textField_CantCombustible);
		textField_CantCombustible.setColumns(10);
		
		lblFechaDeInscripcion = new JLabel("Fecha de inscripcion");
		lblFechaDeInscripcion.setBounds(228, 282, 125, 14);
		contentPanel.add(lblFechaDeInscripcion);
		
		textField_FechaInscripcion = new JTextField();
		textField_FechaInscripcion.setBounds(380, 279, 161, 20);
		contentPanel.add(textField_FechaInscripcion);
		textField_FechaInscripcion.setColumns(10);
		{
			 buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnActualizar = new JButton("Actualizar");
			buttonPane.add(btnActualizar);
			
			btnReparar = new JButton("Reparar");
			buttonPane.add(btnReparar);
			
			btnBuscar = new JButton("Buscar");
			buttonPane.add(btnBuscar);
			
			modificar = new JButton("Modificar");
			buttonPane.add(modificar);
			
			repostar = new JButton("Repostar");
			buttonPane.add(repostar);
			
			abandonar = new JButton("Abandonar");
			buttonPane.add(abandonar);
			
			anterior = new JButton("<<");
			buttonPane.add(anterior);
			
			posterior = new JButton(">>");
			buttonPane.add(posterior);
			
			btnBorrar = new JButton("Borrar");
			buttonPane.add(btnBorrar);
			
			btnAadir = new JButton("A\u00F1adir");
			buttonPane.add(btnAadir);
			
			cancelButton = new JButton("cancelar");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}
}
