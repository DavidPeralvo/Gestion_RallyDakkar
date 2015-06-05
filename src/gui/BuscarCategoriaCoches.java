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
import proyecto.CategoriaVehiculos;
import proyecto.Coche;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase Buscar por categoria de coches
 * @author David Peralvo
 *@version 1.0
 */
public class BuscarCategoriaCoches extends VentanaPadre {
	/**
	 * Campo CategoriaCoches
	 */
	private ArrayList<VehiculoDakkar>categoriaCoches;
	/**
	 * Campo index
	 */
	private int index=0;
	

	public BuscarCategoriaCoches(final ArrayListDakkar inscripcion) {
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;
				categoriaCoches=inscripcion.categoriaCoches(getVehiculo(comboBox_CategoriaCoches));
				if(categoriaCoches.size()==1){
					posterior.setEnabled(false);
					anterior.setEnabled(false);
				}
				if(categoriaCoches.size()==0){
					JOptionPane.showMessageDialog(contentPanel,"No hay coches de esta categoria en la inscripci&oacute;n");
					posterior.setEnabled(false);
				}
				else{
				mostrarVehiculosDakkar(categoriaCoches.get(index));
				}
				bottonTest();
			}
		});
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
				bottonTest();
			}
		});
		posterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
				bottonTest();
			}
		});
		this.categoriaCoches=inscripcion.categoriaCoches(getVehiculo(comboBox_CategoriaCoches));
		textField_FechaInscripcion.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		comboBox_Combustible.setEnabled(false);
		comboBox_Pais.setEnabled(false);
		textField_Escuderia.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setEnabled(false);
		textField_Mecanico.setEditable(false);
		textField_Copiloto.setEnabled(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEnabled(false);
		textField_Piloto.setEditable(false);
		rdbtnCoche.setSelected(true);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		textField_Dorsal.setEnabled(false);
		textField_Dorsal.setEditable(false);
		repostar.setVisible(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
	
		btnBuscar.setBounds(44, 293, 89, 23);
		
		setModal(true);
		setTitle("Buscar coches por categoria");
		setBounds(100, 100, 606, 410);
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
		textField_FechaInscripcion.setVisible(true);
		lblFechaDeInscripcion.setVisible(true);
		textField_KM.setVisible(false);
		lblMecanico.setVisible(false);
		lblCombustible.setVisible(true);
		cancelButton.setVisible(true);
		modificar.setVisible(false);
		btnBorrar.setVisible(false);
		abandonar.setVisible(false);
		btnAadir.setVisible(false);
		anterior.setEnabled(false);
		posterior.setEnabled(false);
		if(categoriaCoches.size()==0){
			JOptionPane.showMessageDialog(contentPanel,"No hay coches en la inscripción");
			posterior.setEnabled(false);
			btnBuscar.setEnabled(false);
			anterior.setEnabled(false);
		}
	
		
	
	}
	/**
	 * M&eacute;todo que comprueba los botones para listar
	 */
private void bottonTest() {
		
		if(index+1==categoriaCoches.size())
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
		mostrarVehiculosDakkar(categoriaCoches.get(++index));
		bottonTest();
	}
	/**
	 * M&eacute;todo para mostrar al anterior participante
	 */
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(categoriaCoches.get(--index));
		bottonTest();
	}
		/**
		 * M&eacute;todo que obtiene la categor&iacute;a de coches
		 * @param combo_boxCategoriaCoches combox de categor&iacute;a de coches
		 * @return La categor&iacute;a de coche elegida
		 */
	CategoriaVehiculos getVehiculo(JComboBox<CategoriaVehiculos> combo_boxCategoriaCoches) {
		CategoriaVehiculos coche = (CategoriaVehiculos) combo_boxCategoriaCoches.getSelectedItem();
		return coche;}
	/**
	 * M&eacute;todo que muestra los veh&iacute;culos
	 * @param vehiculo vehiculo de la inscripci&oacute;n
	 */
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
		Coche coche=(Coche) vehiculo;
		textField_Dorsal.setText(coche.getDorsal());
		textField_Piloto.setText(coche.getNombre());
		textField_Copiloto.setText(coche.getCopiloto());
		textField_Escuderia.setText(coche.getEscuderia());
		rdbtnCoche.setSelected(true);
		comboBox_Pais.setSelectedItem(coche.getPais());
		comboBox_Combustible.setSelectedItem(coche.getCombustible());
		textField_FechaInscripcion.setText(coche.getFechaCreacion().toString());
		
		}
}
	

