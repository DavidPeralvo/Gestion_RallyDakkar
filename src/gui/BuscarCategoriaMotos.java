/**
 * Paquete que contiene la GUI del programa
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.CategoriaMotos;
import proyecto.Moto;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
/**
 * Clase Buscar por categoria de motos
 * @author David Peralvo
 *@version 1.0
 */
public class BuscarCategoriaMotos extends VentanaPadre {
	/**
	 * Campo index
	 */
	private int index=0;
	/**
	 * Campo CategoriaMotos
	 */
	private ArrayList<VehiculoDakkar>categoriaMotos;

	public BuscarCategoriaMotos(final ArrayListDakkar inscripcion) {
		categoriaMotos=inscripcion.categoriaMotos(getMoto(comboBox_CategoriaMotos));
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;
				categoriaMotos=inscripcion.categoriaMotos(getMoto(comboBox_CategoriaMotos));
				if(categoriaMotos.size()==1){
					posterior.setEnabled(false);
					anterior.setEnabled(false);
				}
				if(categoriaMotos.size()==0){
					JOptionPane.showMessageDialog(contentPanel,"No hay motos de esta clase en la inscripci&oacute;n");
					posterior.setEnabled(false);
				}
				else{
				mostrarVehiculosDakkar(categoriaMotos.get(index));
				}
				bottonTest();
			}
			
		});
		comboBox_Pais.setEnabled(false);
		setModal(true);
		setTitle("Buscar por categoria de moto");
		comboBox_TipoMoto.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_FechaInscripcion.setEnabled(false);
		textField_Escuderia.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Piloto.setEnabled(false);
		textField_Piloto.setEditable(false);
		textField_Dorsal.setEditable(false);
		textField_Dorsal.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnMoto.setSelected(true);
		setBounds(100, 100, 606, 410);
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		lblFechaDeInscripcion.setVisible(false);
		textField_FechaInscripcion.setVisible(false);
		lblVelocidad.setVisible(false);
		comboBox_CategoriaCoches.setVisible(false);
		comboBox_CategoriaMotos.setVisible(true);
		comboBox_ClaseCamiones.setVisible(false);
		comboBox_Combustible.setVisible(false);
		textField_FechaInscripcion.setVisible(true);
		lblFechaDeInscripcion.setVisible(true);
		comboBox_TipoMoto.setVisible(true);
		lblClase.setVisible(false);
		lblCategoria.setVisible(true);
		lblCopiloto.setVisible(false);
		lblTipoDeMoto.setVisible(true);
		textField_Copiloto.setVisible(false);
		textField_Mecanico.setVisible(false);
		textField_KM.setVisible(false);
		lblMecanico.setVisible(false);
		lblCombustible.setVisible(false);
		cancelButton.setVisible(true);
		modificar.setVisible(false);
		repostar.setVisible(false);
		abandonar.setVisible(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		btnBorrar.setVisible(false);
		btnAadir.setVisible(false);
		if(categoriaMotos.size()==0){
			JOptionPane.showMessageDialog(contentPanel,"No hay motos en la inscripci&oacute;n");
			posterior.setEnabled(false);
			btnBuscar.setEnabled(false);
			anterior.setEnabled(false);
		}
	}
	/**
	 * M&eacute;todo que comprueba los botones para listar
	 */
	private void bottonTest() {
	
		if(index+1==categoriaMotos.size())
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
		mostrarVehiculosDakkar(categoriaMotos.get(++index));
		bottonTest();
	}
	/**
	 * M&eacute;todo para mostrar al anterior participante
	 */
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(categoriaMotos.get(--index));
		bottonTest();
	}
	/**
	 * M&eacute;todo que obtiene la categor&iacute;a de motos
	 * @param MotoComboBox combobox de categor&iacute;a de motos
	 * @return La categor&iacute;a de moto elegida
	 */
	CategoriaMotos getMoto(JComboBox<CategoriaMotos> MotoComboBox) {
		CategoriaMotos moto = (CategoriaMotos) MotoComboBox.getSelectedItem();
		return moto;}
	/**
	 * M&eacute;todo que muestra los veh&iacute;culos
	 * @param vehiculo vehiculo de la inscripci&oacute;n
	 */
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
		Moto moto=(Moto) vehiculo;
		textField_Dorsal.setText(moto.getDorsal());
		textField_Piloto.setText(moto.getNombre());
		textField_Escuderia.setText(moto.getEscuderia());
		rdbtnMoto.setSelected(true);
		comboBox_Pais.setSelectedItem(moto.getPais());
		comboBox_CategoriaMotos.setSelectedItem(moto.getCategoria());
		comboBox_TipoMoto.setSelectedItem(moto.getTipo() );
		textField_FechaInscripcion.setText(moto.getFechaCreacion().toString());
}

}
