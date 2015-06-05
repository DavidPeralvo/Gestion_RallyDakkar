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
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarCamiones extends VentanaPadre {
		private int index=0;
		private ArrayList<VehiculoDakkar>mostrarCamiones;
		private int opcion=3;

	public MostrarCamiones(ArrayListDakkar inscripcion) {
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
		setTitle("Mostrar Camiones");
		this.mostrarCamiones=inscripcion.getVehiculo(opcion);
		comboBox_ClaseCamiones.setEnabled(false);
		textField_FechaInscripcion.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_CantCombustible.setEditable(false);
		textField_CantCombustible.setEnabled(false);
		textField_KM.setEnabled(false);
		textField_KM.setEditable(false);
		textField_Escuderia.setEditable(false);
		textField_Escuderia.setEnabled(false);
		comboBox_Pais.setEnabled(false);
		textField_Mecanico.setEnabled(false);
		textField_Mecanico.setEditable(false);
		textField_Copiloto.setEnabled(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEditable(false);
		textField_Piloto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCamion.setEnabled(false);
		rdbtnCamion.setSelected(true);
		textField_Dorsal.setEnabled(false);
		textField_Dorsal.setEditable(false);
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
		btnBuscar.setVisible(false);
		cancelButton.setVisible(true);
		modificar.setVisible(false);
		repostar.setVisible(false);
		abandonar.setVisible(false);
		btnAadir.setVisible(false);
		btnBorrar.setVisible(false);
		anterior.setEnabled(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		if(mostrarCamiones.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		if(mostrarCamiones.size()==0){
			JOptionPane.showMessageDialog(contentPanel,"No hay camiones en la inscripción");
			posterior.setEnabled(false);
		}
		else{
		mostrarVehiculosDakkar(mostrarCamiones.get(index));}
		
		

		
	}
	private void bottonTest() {
		
		if(index+1==mostrarCamiones.size())
			posterior.setEnabled(false);
		else
			posterior.setEnabled(true);

		if (index==0)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	private void mostrarSiguiente(){
		mostrarVehiculosDakkar(mostrarCamiones.get(++index));
		bottonTest();
	}
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(mostrarCamiones.get(--index));
		bottonTest();
	}
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
		Camiones camion= (Camiones) vehiculo;
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
