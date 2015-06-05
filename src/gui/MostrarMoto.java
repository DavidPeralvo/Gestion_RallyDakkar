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
import proyecto.Moto;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarMoto extends VentanaPadre {
	private ArrayList<VehiculoDakkar>mostrarMotos;
	private int index;
	private int opcion=2;

	public MostrarMoto(ArrayListDakkar inscripcion) {
		this.mostrarMotos=inscripcion.getVehiculo(opcion);
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
		setTitle("Mostrar Motos");
		comboBox_TipoMoto.setEnabled(false);
		comboBox_CategoriaMotos.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_FechaInscripcion.setEnabled(false);
		comboBox_Pais.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Escuderia.setEnabled(false);
		textField_Mecanico.setEnabled(false);
		textField_Mecanico.setEditable(false);
		textField_Copiloto.setEnabled(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEditable(false);
		textField_Piloto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnMoto.setSelected(true);
		textField_Dorsal.setEnabled(false);
		textField_Dorsal.setEditable(false);
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
		btnAadir.setVisible(false);
		btnBuscar.setVisible(false);
		btnBorrar.setVisible(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		abandonar.setVisible(false);
		anterior.setEnabled(false);
		if(mostrarMotos.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		if(mostrarMotos.size()==0){
			JOptionPane.showMessageDialog(contentPanel,"No hay motos en la inscripción");
			posterior.setEnabled(false);
		}
		else{
		mostrarVehiculosDakkar(mostrarMotos.get(index));}
		

	}
	
	private void bottonTest() {
		
		if(index+1==mostrarMotos.size())
			posterior.setEnabled(false);
		else
			posterior.setEnabled(true);

		if (index==0)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	
	private void mostrarSiguiente(){
		mostrarVehiculosDakkar(mostrarMotos.get(++index));
		bottonTest();
	}
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(mostrarMotos.get(--index));
		bottonTest();
	}
	
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
