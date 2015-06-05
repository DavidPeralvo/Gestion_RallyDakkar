/**
 * Paquete que contiene la GUI del programa
 */
package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.Camiones;
import proyecto.ClaseCamiones;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase Buscar por clase de Camiones
 * @author David Peralvo
 *@version 1.0
 */

public class BuscarClaseCamiones extends VentanaPadre {
		/**
		 * Campo index
		 */
		private int index=0;
		/**
		 * Campo CategoriaCoches
		 */
		private ArrayList<VehiculoDakkar> claseCamiones;

	
	public BuscarClaseCamiones(final ArrayListDakkar inscripcion) {
		claseCamiones=inscripcion.claseCamiones(getClaseCamion(comboBox_ClaseCamiones));
		posterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
				bottonTest();
			}
		});
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
				bottonTest();
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;
				claseCamiones=inscripcion.claseCamiones(getClaseCamion(comboBox_ClaseCamiones));
				if(claseCamiones.size()==1){
					posterior.setEnabled(false);
					anterior.setEnabled(false);
				}
				if(claseCamiones.size()==0){
					JOptionPane.showMessageDialog(contentPanel,"No hay motos de esta clase en la inscripción");
					posterior.setEnabled(false);}
				
				else{
				mostrarVehiculosDakkar(claseCamiones.get(index));
				}
				bottonTest();
			}
			
		});
		rdbtnCoche.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCamion.setEnabled(false);
		rdbtnCamion.setSelected(true);
		textField_FechaInscripcion.setEditable(false);
		textField_FechaInscripcion.setEnabled(false);
		textField_Escuderia.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setEnabled(false);
		textField_Mecanico.setEditable(false);
		textField_Copiloto.setEnabled(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEnabled(false);
		textField_Piloto.setEditable(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		comboBox_Pais.setEnabled(false);
		textField_Dorsal.setEnabled(false);
		textField_Dorsal.setEditable(false);
		setModal(true);
		setTitle("Buscar por clase de camiones");
		setBounds(100, 100, 606, 410);
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
		textField_FechaInscripcion.setVisible(true);
		lblFechaDeInscripcion.setVisible(true);
		textField_Copiloto.setVisible(true);
		textField_Mecanico.setVisible(true);
		textField_KM.setVisible(false);
		lblMecanico.setVisible(true);
		lblCombustible.setVisible(false);
		cancelButton.setVisible(true);
		modificar.setVisible(false);
		btnAadir.setVisible(false);
		btnBorrar.setVisible(false);
		repostar.setVisible(false);
		abandonar.setVisible(false);
		if(claseCamiones.size()==0){
			JOptionPane.showMessageDialog(contentPanel,"No hay Camiones en la inscripción");
			posterior.setEnabled(false);
			btnBuscar.setEnabled(false);
			anterior.setEnabled(false);
			
		}
	}
	/**
	 * M&eacute;todo que comprueba los botones para listar
	 */
	private void bottonTest() {
		
		if(index+1==claseCamiones.size())
			posterior.setEnabled(false);
		else
			posterior.setEnabled(true);

		if (index==0)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	/**
	 * M&eacute;todo para mostrar el siguiente participante
	 */
	private void mostrarSiguiente(){
		mostrarVehiculosDakkar(claseCamiones.get(++index));
		bottonTest();
	}
	/**
	 * M&eacute;todo para mostrar al anterior participante
	 */
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(claseCamiones.get(--index));
		bottonTest();
	}
	/**
	 * M&eacute;todo que obtiene la clase de Camiones
	 * @param claseCamionesComboBox combobox de clase de camiones
	 * @return La clase de camiones elegida
	 */
	ClaseCamiones getClaseCamion(JComboBox<ClaseCamiones>claseCamionesComboBox){
		ClaseCamiones claseCamion = (ClaseCamiones)claseCamionesComboBox.getSelectedItem();
		return claseCamion;
}	
	/**
	 * M&eacute;todo que muestra los veh&iacute;culos
	 * @param vehiculo vehiculo de la inscripci&oacute;n
	 */
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
		Camiones camion=(Camiones)vehiculo;
		textField_Dorsal.setText(camion.getDorsal());
		textField_Piloto.setText(camion.getNombre());
		textField_Copiloto.setText(camion.getCopiloto());
		textField_Mecanico.setText(camion.getMecanico());
		textField_Escuderia.setText(camion.getEscuderia());
		rdbtnCamion.setSelected(true);
		comboBox_Pais.setSelectedItem(camion.getPais());
		textField_FechaInscripcion.setText(camion.getFechaCreacion().toString());
		
	}

}
