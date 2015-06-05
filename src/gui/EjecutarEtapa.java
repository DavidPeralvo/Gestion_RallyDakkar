/**
 * Paquete que contiene la GUI del programa
 */
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
import proyecto.CampoNoValidoException;
import proyecto.Coche;
import proyecto.GastoCombustible;
import proyecto.Moto;
import proyecto.VehiculoDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

public class EjecutarEtapa extends VentanaPadre {
	/**
	 * Campo km
	 */
		private float km;
		/**
		 * Campo combustible
		 */
		private float combustible;
		/**
		 * Campo combustibleTotal
		 */
		private float combustibleTotal;
		/**
		 * Campo index
		 */
		private int index=0;
		/**
		 * Campo ValorCalculado
		 */
		private String valorCalculado;
		/**
		 * Campo etapa
		 */
		private ArrayListDakkar etapa;
		/**
		 * Campo exp.regular
		 */
		static final private Pattern partternKM=Pattern.compile("^\\d\\d\\d$");
		

	public EjecutarEtapa(final ArrayListDakkar inscripcion) {
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
		this.etapa=inscripcion;
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				modificarCombustible(inscripcion, etapa.get(index));
			} catch (CampoNoValidoException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						e1.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		setTitle("Ejecutar Etapa");
		textField_FechaInscripcion.setEditable(false);
		textField_CantCombustible.setEditable(false);
		comboBox_TipoMoto.setEnabled(false);
		comboBox_CategoriaCoches.setEnabled(false);
		comboBox_CategoriaMotos.setEnabled(false);
		comboBox_ClaseCamiones.setEnabled(false);
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
		btnAadir.setVisible(false);
		btnActualizar.setVisible(false);
		btnBorrar.setVisible(false);
		btnReparar.setVisible(false);
		btnBuscar.setVisible(false);
		abandonar.setVisible(false);
		repostar.setVisible(false);
		lblVelocidad.setVisible(true);
		textField_KM.setVisible(true);
		modificar.setText("Ejecutar");
		setModal(true);
		setBounds(100, 100, 606, 410);
		if(etapa.size()==1){
			posterior.setEnabled(false);
			anterior.setEnabled(false);
		}
		anterior.setEnabled(false);
		mostrarVehiculosDakkar(etapa.get(index));
	}
	/**
	 * M&eacute;todo que gestiona la el combustibles en los veh&iacute;culos.
	 * @param inscripcion arraylist donde se guarda toda la inforamci&oacute;
	 * @param vehiculo vehiculo del particpante
	 * @throws CampoNoValidoException Excepci&oacute;on para la cantidad de km recorridos
	 */
	private void modificarCombustible(ArrayListDakkar inscripcion,VehiculoDakkar vehiculo)throws CampoNoValidoException {
		if(partternKM.matcher(textField_KM.getText()).matches()==false){
			throw new CampoNoValidoException("Kilometros mal introducidos(000-999)");}
		else{
		
		km=Integer.parseInt(textField_KM.getText());
		if(vehiculo instanceof Coche){
			Coche coche=(Coche)vehiculo;
			combustible=coche.getCantidadCombustible();
			combustibleTotal=combustible-coche.getGastoCombustible(GastoCombustible.COCHE, km);
			if(combustibleTotal<0){
				JOptionPane.showMessageDialog(contentPanel,
						"No hay suficiente combustible para cubrir la etapa", "Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
			valorCalculado=String.valueOf(combustibleTotal);
			textField_CantCombustible.setText(valorCalculado);
			coche.setCantidadCombustible(combustibleTotal);
			JOptionPane.showMessageDialog(contentPanel,"El gasto ha sido de "+Math.rint(coche.getGastoCombustible(GastoCombustible.COCHE, km)*100)/100+" litros");}
		}
		else{if(vehiculo instanceof Moto){
			Moto moto=(Moto)vehiculo;
			combustible=moto.getCantidadCombustible();
			combustibleTotal=combustible-moto.getGastoCombustible(GastoCombustible.MOTO, km);
			if(combustibleTotal<0){
				JOptionPane.showMessageDialog(contentPanel,
						"No hay suficiente combustible para cubrir la etapa", "Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
			valorCalculado=String.valueOf(combustibleTotal);
			textField_CantCombustible.setText(valorCalculado);
			moto.setCantidadCombustible(combustibleTotal);
			JOptionPane.showMessageDialog(contentPanel,"El gasto ha sido de "+Math.rint(moto.getGastoCombustible(GastoCombustible.COCHE, km)*100)/100+" litros");
			}
		}
		else{
			Camiones camion=(Camiones)vehiculo;
			combustible=camion.getCantidadCombustible();
			combustibleTotal=combustible-camion.getGastoCombustible(GastoCombustible.CAMION, km);
			if(combustibleTotal<0){
				JOptionPane.showMessageDialog(contentPanel,
						"No hay suficiente combustible para cubrir la etapa", "Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
			valorCalculado=String.valueOf(combustibleTotal);
			textField_CantCombustible.setText(valorCalculado);
			camion.setCantidadCombustible(combustibleTotal);
			JOptionPane.showMessageDialog(contentPanel,"El gasto ha sido de "+Math.rint(camion.getGastoCombustible(GastoCombustible.COCHE, km)*100)/100+" litros");
		}
		}	
			
		}
		}
		
		
	}
	/**
	 * M&eacute;todo que comprueba los botones para listar
	 */
	private void bottonTest(){
	if(index+1==etapa.size())
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
	mostrarVehiculosDakkar(etapa.get(++index));
	bottonTest();
}
/**
 * M&eacute;todo para mostrar al anterior participante
 */
private void mostrarAnterior(){
	mostrarVehiculosDakkar(etapa.get(--index));
	bottonTest();
}
	/**
	* M&eacute;todo que muestra los veh&iacute;culos
	* @param vehiculo vehiculo de la inscripci&oacute;
	*/
	private void mostrarVehiculosDakkar(VehiculoDakkar vehiculo){
		if(vehiculo instanceof Coche){
			Coche coche=(Coche) vehiculo;
			lblFechaDeInscripcion.setVisible(false);
			textField_FechaInscripcion.setVisible(false);
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
			lblMecanico.setVisible(false);
			lblCombustible.setVisible(true);
			cancelButton.setVisible(true);
			textField_CantCombustible.setText(Float.toString(coche.getCantidadCombustible()));
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
				modificar.setEnabled(false);
				JOptionPane.showMessageDialog(contentPanel,
						"El vehiculo no se encuentra en competicion", "Error",JOptionPane.ERROR_MESSAGE);
				
			}
				
		}
		else{if(vehiculo instanceof Moto){
			Moto moto=(Moto) vehiculo;
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
			
		}
		else{
			Camiones camion= (Camiones) vehiculo;
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
			textField_CantCombustible.setText(Float.toString(camion.getCantidadCombustible()));
			textField_Dorsal.setText(camion.getDorsal());
			textField_Piloto.setText(camion.getNombre());
			textField_Copiloto.setText(camion.getCopiloto());
			textField_Mecanico.setText(camion.getMecanico());
			textField_Escuderia.setText(camion.getEscuderia());
			comboBox_Pais.setSelectedItem(camion.getPais());
			rdbtnCamion.setSelected(true);
			comboBox_ClaseCamiones.setSelectedItem(camion.getClase());
			textField_FechaInscripcion.setText(camion.getFechaCreacion().toString());
			
			
			
		}
			
		}
	}

}
