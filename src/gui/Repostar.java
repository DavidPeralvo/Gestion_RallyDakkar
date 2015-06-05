/**
 * Paquete que contiene la GUI del programa
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.Camiones;
import proyecto.Coche;
import proyecto.Moto;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Clase repostar 
 * @author David Peralvo
 * @version 1.0
 */
public class Repostar extends VentanaPadre {
		private int index=0;
		private ArrayListDakkar listaRepostaje;
		private int MAX_COMBUSTIBLE_COCHE=100;
		private int MAX_COMBUSTIBLE_MOTO=40;
		private int MAX_COMBUSTIBLE_CAMION=500;
	public Repostar(final ArrayListDakkar inscripcion) {
		setModal(true);
		this.listaRepostaje=inscripcion;
		repostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepostarVehiculo(inscripcion, listaRepostaje.get(index));
				mostrarVehiculosDakkar(listaRepostaje.get(index));
				
				
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
		textField_FechaInscripcion.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_CantCombustible.setEnabled(false);
		textField_CantCombustible.setEditable(false);
		comboBox_TipoMoto.setEnabled(false);
		comboBox_ClaseCamiones.setEnabled(false);
		comboBox_CategoriaMotos.setEnabled(false);
		comboBox_CategoriaCoches.setEnabled(false);
		comboBox_Combustible.setEnabled(false);
		comboBox_Pais.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setEditable(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEditable(false);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		textField_Dorsal.setEditable(false);
		setTitle("Repostar");
		setBounds(100, 100, 606, 410);
		btnActualizar.setVisible(false);
		btnBorrar.setVisible(false);
		btnAadir.setVisible(false);
		btnBuscar.setVisible(false);
		btnReparar.setVisible(false);
		modificar.setVisible(false);
		abandonar.setVisible(false);
		lblVelocidad.setVisible(false);
		anterior.setEnabled(false);
		textField_KM.setVisible(false);
		if(listaRepostaje.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		mostrarVehiculosDakkar(listaRepostaje.get(index));
		
		
	}
	/**
	 * M&eacute;todo que comprueba los botones para listar
	 */
	private void bottonTest(){
	if(index+1==listaRepostaje.size())
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
	mostrarVehiculosDakkar(listaRepostaje.get(++index));
	bottonTest();
}
/**
 * M&eacute;todo para mostrar al anterior participante
 */
private void mostrarAnterior(){
	mostrarVehiculosDakkar(listaRepostaje.get(--index));
	bottonTest();
	
}
	/**
	 * M&eacute;todo que muestra los veh&iacute;culos
	 * @param vehiculo vehiculo de la inscripci&oacute;n
	*/
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
		if(vehiculo instanceof Coche){
			Coche coche=(Coche) vehiculo;
			comboBox_CategoriaCoches.setVisible(true);
			lblCategoria.setVisible(true);
			comboBox_Combustible.setVisible(true);
			lblCombustible.setVisible(true);
			lblCantidadDeCombustible.setVisible(false);
			lblFechaDeInscripcion.setVisible(false);
			comboBox_CategoriaMotos.setVisible(false);
			comboBox_ClaseCamiones.setVisible(false);
			comboBox_TipoMoto.setVisible(false);
			lblClase.setVisible(false);
			lblTipoDeMoto.setVisible(false);
			textField_Mecanico.setVisible(false);
			lblMecanico.setVisible(false);
			cancelButton.setVisible(true);
			textField_Dorsal.setText(coche.getDorsal());
			textField_Piloto.setText(coche.getNombre());
			textField_Copiloto.setText(coche.getCopiloto());
			textField_Escuderia.setText(coche.getEscuderia());
			rdbtnCoche.setSelected(true);
			comboBox_Pais.setSelectedItem(coche.getPais());
			comboBox_Combustible.setSelectedItem(coche.getCombustible());
			comboBox_CategoriaCoches.setSelectedItem(coche.getCategoria());
			textField_FechaInscripcion.setText(coche.getFechaCreacion().toString());
			textField_CantCombustible.setText(Float.toString(coche.getCantidadCombustible()));
			if(coche.getCantidadCombustible()==MAX_COMBUSTIBLE_COCHE){
				repostar.setEnabled(false);
			}
			else{
				repostar.setEnabled(true);
			}
		}
		else{if(vehiculo instanceof Moto){
			Moto moto=(Moto) vehiculo;
			
			lblCantidadDeCombustible.setVisible(true);
			lblFechaDeInscripcion.setVisible(false);
			textField_FechaInscripcion.setVisible(false);
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
			lblMecanico.setVisible(false);
			lblCombustible.setVisible(false);
			cancelButton.setVisible(true);
			textField_Dorsal.setText(moto.getDorsal());
			textField_Piloto.setText(moto.getNombre());
			textField_Escuderia.setText(moto.getEscuderia());
			rdbtnMoto.setSelected(true);
			comboBox_Pais.setSelectedItem(moto.getPais());
			comboBox_CategoriaMotos.setSelectedItem(moto.getCategoria());
			comboBox_TipoMoto.setSelectedItem(moto.getTipo() );
			textField_FechaInscripcion.setText(moto.getFechaCreacion().toString());
			textField_CantCombustible.setText(Float.toString(moto.getCantidadCombustible()));
			if(moto.getCantidadCombustible()==MAX_COMBUSTIBLE_MOTO){
				repostar.setEnabled(false);
			}
			else{
				repostar.setEnabled(true);
			}
			
		}
		else{
			Camiones camion= (Camiones) vehiculo;
			
			lblCantidadDeCombustible.setVisible(true);
			lblFechaDeInscripcion.setVisible(false);
			textField_FechaInscripcion.setVisible(false);
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
			lblMecanico.setVisible(true);
			lblCombustible.setVisible(false);
			cancelButton.setVisible(true);
			textField_Dorsal.setText(camion.getDorsal());
			textField_Piloto.setText(camion.getNombre());
			textField_Copiloto.setText(camion.getCopiloto());
			textField_Mecanico.setText(camion.getMecanico());
			textField_Escuderia.setText(camion.getEscuderia());
			rdbtnCamion.setSelected(true);
			comboBox_Pais.setSelectedItem(camion.getPais());
			comboBox_ClaseCamiones.setSelectedItem(camion.getClase());
			textField_FechaInscripcion.setText(camion.getFechaCreacion().toString());
			textField_CantCombustible.setText(Float.toString(camion.getCantidadCombustible()));
			if(camion.getCantidadCombustible()==MAX_COMBUSTIBLE_CAMION){
				repostar.setEnabled(false);
			}
			else{
				repostar.setEnabled(true);
			}
		}
			
		}
	}
	/**
	 * M&eacute;todo que reposta a los veh&iacute;culos .
	 * @param inscripcion arraylist que almacena la informaci&oacute;n
	 * @param vehiculo veh&iacute;culo que reposta.
	 */
	private void RepostarVehiculo(ArrayListDakkar inscripcion,VehiculoDakkar vehiculo){
		if(vehiculo instanceof Coche){
			Coche coche=(Coche)vehiculo;
			if(coche.getCantidadCombustible()==MAX_COMBUSTIBLE_COCHE){
				JOptionPane.showMessageDialog(contentPanel,"Deposito lleno", "Error",JOptionPane.ERROR_MESSAGE);
				repostar.setEnabled(false);
			}
			else{
				coche.setCantidadCombustible(100);
				JOptionPane.showMessageDialog(contentPanel,"El veh&iacute;culo repostado con &eacute;xito");
			}
			
			
		}
		else{if(vehiculo instanceof Moto){
			Moto moto=(Moto)vehiculo;
			if(moto.getCantidadCombustible()==MAX_COMBUSTIBLE_MOTO){
				JOptionPane.showMessageDialog(contentPanel,"Deposito lleno", "Error",JOptionPane.ERROR_MESSAGE);
				repostar.setEnabled(false);
			}else{
				
			moto.setCantidadCombustible(40);
			JOptionPane.showMessageDialog(contentPanel,"El veh&iacute;culo repostado con &eacute;xito");}
		}
		else{
			Camiones camion=(Camiones)vehiculo;
			if(camion.getCantidadCombustible()==MAX_COMBUSTIBLE_MOTO){
				repostar.setEnabled(false);
				JOptionPane.showMessageDialog(contentPanel,"Deposito lleno", "Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
			camion.setCantidadCombustible(500);
			JOptionPane.showMessageDialog(contentPanel,"El vehículo repostado con éxito");
			}
		}
			
		}
	}

}
