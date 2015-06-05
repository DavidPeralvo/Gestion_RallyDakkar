package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
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

import proyecto.DorsalNoValidoException;

import proyecto.Moto;
import proyecto.Mototipo;

import proyecto.Paises;
import proyecto.VehiculoDakkar;
import proyecto.VehiculoYaExisteException;
import proyecto.vehiculoNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class Annadir extends VentanaPadre {

	public Annadir(final ArrayListDakkar inscripcion) {
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inscripcion.annadirVehiculo(tipoVehiculo());
					JOptionPane.showMessageDialog(contentPanel,"Vehículo a\u00f1adido con \u00e9xito.");
					clear();
				} catch (CampoNoValidoException| DorsalNoValidoException | VehiculoYaExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		setModal(true);
	
		
		setTitle("Inscripcion Vehiculo");
		
		setBounds(100, 100, 559, 337);
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		lblFechaDeInscripcion.setVisible(false);
		textField_FechaInscripcion.setVisible(false);
		lblVelocidad.setVisible(false);
		comboBox_CategoriaCoches.setVisible(false);
		comboBox_CategoriaMotos.setVisible(false);
		comboBox_ClaseCamiones.setVisible(false);
		comboBox_Combustible.setVisible(false);
		comboBox_TipoMoto.setVisible(false);
		lblClase.setVisible(false);
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
		anterior.setVisible(false);
		posterior.setVisible(false);
		repostar.setVisible(false);
		modificar.setVisible(false);
		abandonar.setVisible(false);
		btnBuscar.setVisible(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		
		
		rdbtnMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Inscripcion Moto");
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
				textField_KM.setVisible(false);
				lblMecanico.setVisible(false);
				lblCombustible.setVisible(false);
				btnAadir.setVisible(true);
				cancelButton.setVisible(true);

				
				
				
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
				textField_KM.setVisible(false);
				lblMecanico.setVisible(false);
				lblCombustible.setVisible(true);
				setTitle("Inscripcion Coche");
				btnAadir.setVisible(true);
				cancelButton.setVisible(true);
				
			}
		});
		
		rdbtnCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				textField_KM.setVisible(false);
				lblMecanico.setVisible(true);
				lblCombustible.setVisible(false);
				setTitle("Inscripcion Camion");
				btnAadir.setVisible(true);
				cancelButton.setVisible(true);
			}
		});
	}
	private void clear() {
		textField_Dorsal.setText("");
		textField_Copiloto.setText("");
		textField_Piloto.setText("");
		textField_Escuderia.setText("");
		textField_Mecanico.setText("");
		
	}
	private VehiculoDakkar tipoVehiculo() throws CampoNoValidoException , DorsalNoValidoException{
		if(rdbtnCoche.isSelected()){
			return new Coche( textField_Dorsal.getText(), textField_Piloto.getText(), textField_Escuderia.getText(), getPais(comboBox_Pais), 100, true, textField_Copiloto.getText(), getTipoCombustible(comboBox_Combustible), getVehiculo(comboBox_CategoriaCoches), new Date());
		}
		else{if(rdbtnMoto.isSelected()){
			return new Moto( textField_Dorsal.getText(), textField_Piloto.getText(), textField_Escuderia.getText(), getPais(comboBox_Pais), 40, true, getTipoMoto(comboBox_TipoMoto), getMoto(comboBox_CategoriaMotos),new Date());
		} else{
			return new Camiones( textField_Dorsal.getText(), textField_Piloto.getText(), textField_Escuderia.getText(), getPais(comboBox_Pais), 500, true,textField_Copiloto.getText(), textField_Mecanico.getText(), getClaseCamion(comboBox_ClaseCamiones),new Date());
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
