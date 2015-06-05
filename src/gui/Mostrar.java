package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.Camiones;
import proyecto.Coche;
import proyecto.Moto;
import proyecto.VehiculoDakkar;

import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mostrar extends VentanaPadre {
		private int index=0;
		private int error=-1;
		private ArrayListDakkar inscripcionMostrar;

	public Mostrar(ArrayListDakkar inscripcion) {
		this.inscripcionMostrar=inscripcion;rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		textField_Dorsal.setEnabled(false);
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
		this.inscripcionMostrar=inscripcion;
		comboBox_Pais.setEnabled(false);
		comboBox_ClaseCamiones.setEnabled(false);
		comboBox_Combustible.setEnabled(false);
		comboBox_CategoriaMotos.setEnabled(false);
		comboBox_CategoriaCoches.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_CantCombustible.setEditable(false);
		textField_KM.setEditable(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setEditable(false);
		textField_Dorsal.setEditable(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEditable(false);
		textField_FechaInscripcion.setVisible(true);
		comboBox_ClaseCamiones.setEnabled(false);
		comboBox_ClaseCamiones.setEditable(false);
		setTitle("Mostrar Vehiculos");
		setBounds(100, 100, 606, 410);
		btnAadir.setVisible(false);
		btnBorrar.setVisible(false);
		repostar.setVisible(false);
		modificar.setVisible(false);
		abandonar.setVisible(false);
		textField_KM.setVisible(false);
		btnBuscar.setVisible(false);
		lblVelocidad.setVisible(false);
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		comboBox_TipoMoto.setEnabled(false);
		anterior.setEnabled(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		
		if(inscripcionMostrar.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		mostrarVehiculosDakkar(inscripcionMostrar.get(index));
		
	
		
	}
	private void bottonTest() {
		
		if(index+1==inscripcionMostrar.size())
			posterior.setEnabled(false);
		else
			posterior.setEnabled(true);

		if (index==0)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	
	private void mostrarSiguiente(){
		mostrarVehiculosDakkar(inscripcionMostrar.get(++index));
		bottonTest();
	}
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(inscripcionMostrar.get(--index));
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

}
