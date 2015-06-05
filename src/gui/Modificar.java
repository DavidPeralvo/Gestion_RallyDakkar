package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.Camiones;
import proyecto.CampoNoValidoException;
import proyecto.CategoriaMotos;
import proyecto.CategoriaVehiculos;
import proyecto.ClaseCamiones;
import proyecto.Coche;
import proyecto.Combustible;

import proyecto.Moto;
import proyecto.Mototipo;

import proyecto.Paises;
import proyecto.VehiculoDakkar;

public class Modificar extends VentanaPadre {
		private int  index=0;
		private ArrayListDakkar inscripcionModificar;
	public Modificar(final ArrayListDakkar inscripcion) {
		
		
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
		
		
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarVehiculo(inscripcion, inscripcionModificar.get(index));
				} catch (CampoNoValidoException e1) {
					
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		textField_FechaInscripcion.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		this.inscripcionModificar=inscripcion;
		textField_Dorsal.setEditable(false);
		setModal(true);
	
		
		setTitle("Modificar Vehiculo");
		
		setBounds(100, 100, 606, 410);
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		btnBuscar.setVisible(false);
		lblFechaDeInscripcion.setVisible(false);
		textField_FechaInscripcion.setVisible(false);
		lblVelocidad.setVisible(false);
		comboBox_CategoriaCoches.setVisible(false);
		comboBox_CategoriaMotos.setVisible(false);
		comboBox_ClaseCamiones.setVisible(false);
		comboBox_Combustible.setVisible(false);
		comboBox_TipoMoto.setVisible(false);
		lblClase.setVisible(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		lblCategoria.setVisible(false);
		lblCopiloto.setVisible(false);
		lblTipoDeMoto.setVisible(false);
		textField_Copiloto.setVisible(false);
		textField_Mecanico.setVisible(false);
		textField_KM.setVisible(false);
		lblMecanico.setVisible(false);
		lblCombustible.setVisible(false);
		btnAadir.setVisible(false);
		cancelButton.setVisible(true);
		lblDorsal.setVisible(true);
		btnBorrar.setVisible(false);
		anterior.setVisible(true);
		posterior.setVisible(true);
		repostar.setVisible(false);
		modificar.setVisible(true);
		abandonar.setVisible(false);
		anterior.setEnabled(false);
		if(inscripcionModificar.size()==1){
			posterior.setEnabled(false);
		}
		mostrarVehiculosDakkar(inscripcionModificar.get(index));

		
		
				
	}
	
	private void bottonTest(){
	if(index+1==inscripcionModificar.size())
		posterior.setEnabled(false);
	else
		posterior.setEnabled(true);

	if (index==0)
		anterior.setEnabled(false);
	else
		anterior.setEnabled(true);
}

private void mostrarSiguiente(){
	mostrarVehiculosDakkar(inscripcionModificar.get(++index));
	bottonTest();
}
private void mostrarAnterior(){
	mostrarVehiculosDakkar(inscripcionModificar.get(--index));
	bottonTest();
}

private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
	if(vehiculo instanceof Coche){
		Coche coche=(Coche) vehiculo;
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
		textField_Dorsal.setText(coche.getDorsal());
		textField_Piloto.setText(coche.getNombre());
		textField_Copiloto.setText(coche.getCopiloto());
		textField_Escuderia.setText(coche.getEscuderia());
		rdbtnCoche.setSelected(true);
		comboBox_Pais.setSelectedItem(coche.getPais());
		comboBox_Combustible.setSelectedItem(coche.getCombustible());
		comboBox_CategoriaCoches.setSelectedItem(coche.getCategoria());
		textField_FechaInscripcion.setText(coche.getFechaCreacion().toString());
			
	}
	else{if(vehiculo instanceof Moto){
		Moto moto=(Moto) vehiculo;
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
		textField_Dorsal.setText(moto.getDorsal());
		textField_Piloto.setText(moto.getNombre());
		textField_Escuderia.setText(moto.getEscuderia());
		rdbtnMoto.setSelected(true);
		comboBox_Pais.setSelectedItem(moto.getPais());
		comboBox_CategoriaMotos.setSelectedItem(moto.getCategoria());
		comboBox_TipoMoto.setSelectedItem(moto.getTipo() );
		textField_FechaInscripcion.setText(moto.getFechaCreacion().toString());
		
	}
	else{
		Camiones camion= (Camiones) vehiculo;
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
		textField_Dorsal.setText(camion.getDorsal());
		textField_Piloto.setText(camion.getNombre());
		textField_Copiloto.setText(camion.getCopiloto());
		textField_Mecanico.setText(camion.getMecanico());
		textField_Escuderia.setText(camion.getEscuderia());
		rdbtnCamion.setSelected(true);
		comboBox_Pais.setSelectedItem(camion.getPais());
		comboBox_ClaseCamiones.setSelectedItem(camion.getClase());
		textField_FechaInscripcion.setText(camion.getFechaCreacion().toString());
		
		
	}
		
	}
}
	private void modificarVehiculo(ArrayListDakkar inscripcion,VehiculoDakkar vehiculo) throws CampoNoValidoException {
		if(vehiculo instanceof Coche){
			Coche coche = (Coche)vehiculo;
			coche.setNombre(textField_Piloto.getText());
			coche.setCopiloto(textField_Copiloto.getText());
			coche.setEscuderia(textField_Escuderia.getText());
			coche.setCategoria(getVehiculo(comboBox_CategoriaCoches));
			coche.setPais(getPais(comboBox_Pais));
			coche.setCombustible(getTipoCombustible(comboBox_Combustible));
		}
		
		else{if(vehiculo instanceof Moto){
			Moto moto= (Moto) vehiculo;
			moto.setNombre(textField_Piloto.getText());
			moto.setEscuderia(textField_Escuderia.getText());
			moto.setPais(getPais(comboBox_Pais));
			moto.setTipo(getTipoMoto(comboBox_TipoMoto));
			moto.setCategoria(getMoto(comboBox_CategoriaMotos));
		}
		else{
			Camiones camion=(Camiones) vehiculo;
			camion.setNombre(textField_Piloto.getText());
			camion.setCopiloto(textField_Copiloto.getText());
			camion.setMecanico(textField_Mecanico.getText());
			camion.setPais(getPais(comboBox_Pais));
			camion.setClase(getClaseCamion(comboBox_ClaseCamiones));
			camion.setEscuderia(textField_Escuderia.getText());
			
		}
			
			
			
			
		}
		
		
		
	}
	 Paises getPais(JComboBox<Paises> paisComboBox) {
			Paises pais = (Paises) paisComboBox.getSelectedItem();
			return pais;}
	 CategoriaVehiculos getVehiculo(JComboBox<CategoriaVehiculos> combo_boxCategoriaCoches) {
			CategoriaVehiculos coche = (CategoriaVehiculos) combo_boxCategoriaCoches.getSelectedItem();
			return coche;}
	 CategoriaMotos getMoto(JComboBox<CategoriaMotos> MotoComboBox) {
			CategoriaMotos moto = (CategoriaMotos) MotoComboBox.getSelectedItem();
			return moto;}
	 Mototipo getTipoMoto(JComboBox<Mototipo> MotoTipoComboBox) {
			Mototipo motoTipo = (Mototipo) MotoTipoComboBox.getSelectedItem();
			return motoTipo;}
	 Combustible getTipoCombustible(JComboBox<Combustible> CombustibleTipoComboBox) {
			Combustible CombustibleTipo = (Combustible)CombustibleTipoComboBox.getSelectedItem();
			return CombustibleTipo;}
	 ClaseCamiones getClaseCamion(JComboBox<ClaseCamiones>claseCamionesComboBox){
		 ClaseCamiones claseCamion = (ClaseCamiones)claseCamionesComboBox.getSelectedItem();
		 return claseCamion;
	 }
	

}
