package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.DorsalNoValidoException;
import proyecto.vehiculoNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Borrar extends VentanaPadre {

	public Borrar(final ArrayListDakkar inscripcion) {
		textField_Copiloto.setEditable(false);
		comboBox_CategoriaMotos.setEnabled(false);
		comboBox_CategoriaCoches.setEnabled(false);
		comboBox_ClaseCamiones.setEnabled(false);
		comboBox_Combustible.setEnabled(false);
		comboBox_Pais.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_CantCombustible.setEnabled(false);
		textField_Velocidad.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setEditable(false);
		textField_Copiloto.setEnabled(false);
		textField_Piloto.setEditable(false);
		setModal(true);
		setTitle("Borrar");
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		lblFechaDeInscripcion.setVisible(true);
		textField_FechaInscripcion.setVisible(true);
		lblVelocidad.setVisible(false);
		comboBox_TipoMoto.setVisible(false);
		lblClase.setVisible(false);
		lblCategoria.setVisible(false);
		lblCopiloto.setVisible(false);
		lblTipoDeMoto.setVisible(false);
		textField_Copiloto.setVisible(false);
		textField_Mecanico.setVisible(false);
		textField_Velocidad.setVisible(false);
		lblMecanico.setVisible(false);
		lblCombustible.setVisible(false);
		btnAadir.setVisible(false);
		cancelButton.setVisible(true);
		btnBorrar.setVisible(false);
		lblDorsal.setVisible(false);
		textField_Dorsal.setVisible(false);
		comboBox_TipoMoto.setEnabled(false);
		anterior.setVisible(false);
		posterior.setVisible(false);
		repostar.setVisible(false);
		modificar.setVisible(false);
		abandonar.setVisible(false);
	
		setBounds(100, 100, 587, 410);
		
		rdbtnMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CantCombustible.setVisible(false);
				lblCantidadDeCombustible.setVisible(false);
				lblFechaDeInscripcion.setVisible(false);
				textField_FechaInscripcion.setVisible(false);
				lblVelocidad.setVisible(false);
				comboBox_CategoriaCoches.setVisible(false);
				comboBox_CategoriaMotos.setVisible(true);
				comboBox_ClaseCamiones.setVisible(false);
				comboBox_Combustible.setVisible(false);
				comboBox_TipoMoto.setVisible(true);
				lblClase.setVisible(false);
				lblCategoria.setVisible(true);
				lblCopiloto.setVisible(false);
				lblTipoDeMoto.setVisible(true);
				textField_Copiloto.setVisible(false);
				textField_Mecanico.setVisible(false);
				textField_Velocidad.setVisible(false);
				lblMecanico.setVisible(false);
				lblCombustible.setVisible(false);
				setTitle("Borrar Moto");
				btnBorrar.setVisible(false);
				cancelButton.setVisible(true);
				lblDorsal.setVisible(true);
				textField_Dorsal.setVisible(true);
				lblFechaDeInscripcion.setVisible(true);
				textField_FechaInscripcion.setVisible(true);
				btnBorrar.setVisible(true);
				
			}
		});
		rdbtnCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CantCombustible.setVisible(false);
				lblCantidadDeCombustible.setVisible(false);
				lblFechaDeInscripcion.setVisible(false);
				textField_FechaInscripcion.setVisible(false);
				lblVelocidad.setVisible(false);
				comboBox_CategoriaCoches.setVisible(true);
				comboBox_CategoriaMotos.setVisible(false);
				comboBox_ClaseCamiones.setVisible(false);
				comboBox_Combustible.setVisible(true);
				comboBox_TipoMoto.setVisible(false);
				lblClase.setVisible(false);
				lblCategoria.setVisible(true);
				lblCopiloto.setVisible(true);
				lblTipoDeMoto.setVisible(false);
				textField_Copiloto.setVisible(true);
				textField_Mecanico.setVisible(false);
				textField_Velocidad.setVisible(false);
				lblMecanico.setVisible(false);
				lblCombustible.setVisible(true);
				setTitle("Borrar Coche");
				btnBorrar.setVisible(true);
				lblFechaDeInscripcion.setVisible(true);
				textField_FechaInscripcion.setVisible(true);
				cancelButton.setVisible(true);
				lblDorsal.setVisible(true);
				textField_Dorsal.setVisible(true);
				btnBorrar.setVisible(true);
				
				
				
			}
		});
		
		rdbtnCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Inscripcion Camion ");
				textField_CantCombustible.setVisible(false);
				lblCantidadDeCombustible.setVisible(false);
				lblFechaDeInscripcion.setVisible(false);
				textField_FechaInscripcion.setVisible(false);
				lblVelocidad.setVisible(false);
				comboBox_CategoriaCoches.setVisible(false);
				comboBox_CategoriaMotos.setVisible(false);
				comboBox_ClaseCamiones.setVisible(true);
				comboBox_Combustible.setVisible(false);
				comboBox_TipoMoto.setVisible(false);
				lblClase.setVisible(true);
				lblCategoria.setVisible(false);
				lblCopiloto.setVisible(true);
				lblTipoDeMoto.setVisible(false);
				textField_Copiloto.setVisible(true);
				textField_Mecanico.setVisible(true);
				textField_Velocidad.setVisible(false);
				lblMecanico.setVisible(true);
				lblCombustible.setVisible(false);
				setTitle("Borrar Camion");
				btnBorrar.setVisible(true);
				lblFechaDeInscripcion.setVisible(true);
				textField_FechaInscripcion.setVisible(true);
				cancelButton.setVisible(true);
				lblDorsal.setVisible(true);
				textField_Dorsal.setVisible(true);
				btnBorrar.setVisible(true);
				
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inscripcion.borrarVehiculo(textField_Dorsal.getText());
					JOptionPane.showMessageDialog(contentPanel,"Vehículo borrado con \u00e9xito.");
				} catch (DorsalNoValidoException | vehiculoNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
		

}
