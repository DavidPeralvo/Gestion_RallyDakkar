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
import proyecto.Coche;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarCoches extends VentanaPadre {
		private ArrayList<VehiculoDakkar> mostrar;
		private int index=0;
		private int opcion=1;

	public MostrarCoches(ArrayListDakkar inscripcion) {
		comboBox_Combustible.setEnabled(false);
		comboBox_ClaseCamiones.setEnabled(false);
		posterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
				bottonTest();
			}
		});
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mostrarAnterior();
			bottonTest();}
		});
		this.mostrar=inscripcion.getVehiculo(opcion);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		setBounds(100, 100, 606, 410);
		comboBox_Pais.setEnabled(false);
		comboBox_ClaseCamiones.setVisible(false);
		comboBox_Combustible.setVisible(true);
		comboBox_CategoriaMotos.setVisible(false);
		comboBox_CategoriaCoches.setEnabled(false);
		textField_FechaInscripcion.setEditable(false);
		textField_CantCombustible.setVisible(false);
		textField_KM.setVisible(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setVisible(false);
		textField_Dorsal.setEditable(false);
		textField_Copiloto.setEditable(false);
		textField_Piloto.setEditable(false);
		textField_FechaInscripcion.setVisible(true);
		setTitle("Mostrar Coches");
		setBounds(100, 100, 606, 410);
		btnAadir.setVisible(false);
		btnBorrar.setVisible(false);
		lblTipoDeMoto.setVisible(false);
		repostar.setVisible(false);
		lblMecanico.setVisible(false);
		lblClase.setVisible(false);
		lblTipoDeMoto.setVisible(false);
		modificar.setVisible(false);
		abandonar.setVisible(false);
		textField_KM.setVisible(false);
		lblVelocidad.setVisible(false);
		rdbtnCoche.setSelected(true);
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		btnBuscar.setVisible(false);
		btnActualizar.setVisible(false);
		btnReparar.setVisible(false);
		comboBox_TipoMoto.setVisible(false);
		anterior.setEnabled(false);
		if(mostrar.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		if(mostrar.size()==0){
			JOptionPane.showMessageDialog(contentPanel,"No hay Coches en la inscripción");
			posterior.setEnabled(false);
		}
		else{
		mostrarVehiculosDakkar(mostrar.get(index));}
	}
	private void bottonTest() {
		
		if(index+1==mostrar.size())
			posterior.setEnabled(false);
		else
			posterior.setEnabled(true);

		if (index==0)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	
	private void mostrarSiguiente(){
		mostrarVehiculosDakkar(mostrar.get(++index));
		bottonTest();
	}
	private void mostrarAnterior(){
		mostrarVehiculosDakkar(mostrar.get(--index));
		bottonTest();
	}
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
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

}
