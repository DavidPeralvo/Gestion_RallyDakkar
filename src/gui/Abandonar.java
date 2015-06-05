package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

import javax.swing.JLabel;

public class Abandonar extends VentanaPadre {

		private ArrayListDakkar mostrarAbandonos;
		private int index=0;
		private JLabel estado;
		private JLabel compitiendo;
	public Abandonar(final ArrayListDakkar inscripcion) {
		setTitle("Abandonos");
		comboBox_TipoMoto.setEnabled(false);
		comboBox_ClaseCamiones.setEnabled(false);
		comboBox_CategoriaMotos.setEnabled(false);
		btnReparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repararVehiculo(inscripcion, mostrarAbandonos.get(index));
				mostrarVehiculosDakkar(mostrarAbandonos.get(index));
				JOptionPane.showMessageDialog(contentPanel,"El vehiculo con dorsal "+mostrarAbandonos.get(index).getDorsal()+" ha reparado el vehiculo");
					
				}
			
		});
		textField_FechaInscripcion.setEditable(false);
		textField_FechaInscripcion.setEnabled(false);
		comboBox_CategoriaCoches.setEnabled(false);
		comboBox_Combustible.setEnabled(false);
		comboBox_Pais.setEnabled(false);
		textField_Escuderia.setEnabled(false);
		textField_Escuderia.setEditable(false);
		textField_Mecanico.setEditable(false);
		textField_Mecanico.setEnabled(false);
		textField_Mecanico.setLocation(380, 85);
		textField_Copiloto.setEditable(false);
		textField_Copiloto.setEnabled(false);
		textField_Piloto.setEnabled(false);
		textField_Piloto.setEditable(false);
		rdbtnCamion.setEnabled(false);
		rdbtnMoto.setEnabled(false);
		anterior.setEnabled(false);
		rdbtnCoche.setEnabled(false);
		textField_Dorsal.setEnabled(false);
		textField_Dorsal.setEditable(false);
		btnReparar.setEnabled(false);
		estado = new JLabel("Estado del vehiculo: Averiado");
		estado.setBounds(25, 294, 209, 14);
		contentPanel.add(estado);
		compitiendo = new JLabel("Estado del vehiculo: En competici\u00F3n");
		compitiendo.setBounds(25, 294, 209, 14);
		contentPanel.add(compitiendo);
			this.mostrarAbandonos=inscripcion;
		abandonar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abandonoVehiculo(inscripcion, mostrarAbandonos.get(index));
				mostrarVehiculosDakkar(mostrarAbandonos.get(index));
				JOptionPane.showMessageDialog(contentPanel,"El vehiculo con dorsal "+mostrarAbandonos.get(index).getDorsal()+" ha abandonado");
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
		setModal(true);
		setBounds(100, 100, 606, 410);
		repostar.setVisible(false);
		btnAadir.setVisible(false);
		btnBorrar.setVisible(false);
		modificar.setVisible(false);
		btnBuscar.setVisible(false);
		btnActualizar.setVisible(false);
		lblVelocidad.setVisible(false);
		textField_CantCombustible.setVisible(false);
		textField_KM.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		estado.setVisible(false);
		if(mostrarAbandonos.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		mostrarVehiculosDakkar(mostrarAbandonos.get(index));
		
	}
	private void bottonTest(){
	if(index+1==mostrarAbandonos.size())
		posterior.setEnabled(false);
	else
		posterior.setEnabled(true);

	if (index==0)
		anterior.setEnabled(false);
	else
		anterior.setEnabled(true);
}

private void mostrarSiguiente(){
	mostrarVehiculosDakkar(mostrarAbandonos.get(++index));
	bottonTest();
}
private void mostrarAnterior(){
	mostrarVehiculosDakkar(mostrarAbandonos.get(--index));
	bottonTest();
}
private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
	if(vehiculo instanceof Coche){
		Coche coche=(Coche) vehiculo;
		comboBox_CategoriaCoches.setVisible(true);
		lblCategoria.setVisible(true);
		comboBox_Combustible.setVisible(true);
		lblCombustible.setVisible(true);
		textField_CantCombustible.setVisible(false);
		lblCantidadDeCombustible.setVisible(false);
		lblFechaDeInscripcion.setVisible(false);
		lblVelocidad.setVisible(false);
		comboBox_CategoriaMotos.setVisible(false);
		comboBox_ClaseCamiones.setVisible(false);
		comboBox_TipoMoto.setVisible(false);
		lblClase.setVisible(false);
		lblTipoDeMoto.setVisible(false);
		textField_Mecanico.setVisible(false);
		textField_KM.setVisible(false);
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
		if(coche.isMotor()==false){
			abandonar.setEnabled(false);
			estado.setVisible(true);
			compitiendo.setVisible(false);
			btnReparar.setEnabled(true);

		}
		else{
			abandonar.setEnabled(true);
			estado.setVisible(false);
			compitiendo.setVisible(true);
			btnReparar.setEnabled(false);
		}
		
			
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
		if(moto.isMotor()==false){
			abandonar.setEnabled(false);
			estado.setVisible(true);
			compitiendo.setVisible(false);
			btnReparar.setEnabled(true);

		}
		else{
			abandonar.setEnabled(true);
			estado.setVisible(false);
			compitiendo.setVisible(true);
			btnReparar.setEnabled(false);
		}
		
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
		if(camion.isMotor()==false){
			abandonar.setEnabled(false);
			estado.setVisible(true);
			compitiendo.setVisible(false);
			btnReparar.setEnabled(true);

		}
		else{
			abandonar.setEnabled(true);
			estado.setVisible(false);
			compitiendo.setVisible(true);
			btnReparar.setEnabled(false);
		}
		
		
	}
		
	}
}
	private void abandonoVehiculo(ArrayListDakkar inscripcion,VehiculoDakkar vehiculo){
		if(vehiculo instanceof Coche){
			Coche coche=(Coche)vehiculo;
			
			coche.setMotor(false);
		}
		else{if(vehiculo instanceof Moto){
			Moto moto=(Moto)vehiculo;
			moto.setMotor(false);
		}
		else{
			Camiones camion=(Camiones)vehiculo;
			camion.setMotor(false);
		}
			
		}
	}
	private void repararVehiculo(ArrayListDakkar inscripcion,VehiculoDakkar vehiculo){
		if(vehiculo instanceof Coche){
			Coche coche=(Coche)vehiculo;
			
			coche.setMotor(true);
		}
		else{if(vehiculo instanceof Moto){
			Moto moto=(Moto)vehiculo;
			moto.setMotor(true);
		}
		else{
			Camiones camion=(Camiones)vehiculo;
			camion.setMotor(true);
		}
			
		}

	}
}
