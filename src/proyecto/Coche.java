/**
 * Paquete que engloba las clases Camiones,Coches,Motos,VehiculoDakkar,excepciones,interfaces y enumeraciones
 */
package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;
/**
 * Clase cochem, Clase hija de la clase VehiculosDakkar
 * @author David Peralvo
 *@version 1.0
 */
public class Coche extends VehiculoDakkar implements Serializable {
	/**
	 * Campo copiloto
	 */
	private String copiloto;
	/**
	 * Campo combustible
	 */
	private  Combustible combustible;
	/**
	 * Campo Categor&iacute;a de vehiculos
	 */
	private  CategoriaVehiculos categoria;
	/**
	 * Patr&oacute;n para el campo piloto,copiloto,mecanico y escuder&iacute;a
	 */
	static final private Pattern partternNombre=Pattern.compile("^\\w+");
	/**
	 * 
	 * Constructor de camiones
	 * @param dorsal Identificador de cada participante
	 * @param nombre Nombre del piloto
	 * @param escuderia Nombre de la escuder&iacute;a
	 * @param pais Pa&iacute;s de procedencia
	 * @param cantidadCombustible Cantidad de combustible
	 * @param motor Estado del motor
	 * @param copiloto Nombre del copiloto
	 * @param combustible tipo de combustible
	 * @param categoria categor&iacute;a de veh&iacute;culos
	 * @param fecha Fecha de inscripci&oacute;n
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios
	 * @throws DorsalNoValidoException Excepci&oacute;n que a parece cuando hay alg&uacute;n fallo en el dorsal
	 */
	public Coche(String dorsal, String nombre, String escuderia, Paises pais,int cantidadCombustible, boolean motor,String copiloto,Combustible combustible,CategoriaVehiculos categoria, Date fecha) throws CampoNoValidoException, DorsalNoValidoException  {
		super(dorsal, nombre, escuderia, pais, cantidadCombustible, motor,fecha);
		this.categoria=categoria;
		this.combustible=combustible;
		setCopiloto(copiloto);
	
	}
	/**
	 * M&eacute;todo getter de copiloto
	 * @return nombre del copiloto
	 */
	public String getCopiloto() {
		return copiloto;
	}
	/**
	 *  M&eacute;todo setter de Copiloto.
	 * @param copiloto nombre del copiloto
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios.
	 */
	public void setCopiloto(String copiloto) throws CampoNoValidoException{
		if(copiloto==null| comprobarCampos(copiloto)){
			this.copiloto = copiloto;}
		else{
			throw new CampoNoValidoException("No se ha introducido el copiloto");
		}
	}
	/**
	 * M&eacute;todo getter del tipo de combustible
	 * @return tipo de combustible
	 */
	public Combustible getCombustible() {
		return combustible;
	}
	/**
	 * M&eacute;todo setter del tipo de combustible
	 * @param combustible tipo de combustible
	 */
	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}
	/**
	 *  M&eacute;todo getter del tipo de veh&iacute;culo
	 * @return Categoria de veh&iacute;culos.
	 */
	public  CategoriaVehiculos getCategoria() {
		return categoria;
	}
	@Override
	/**
	 * M&eacute;todo toString
	 */
	public String toString() {
		return  super.toString()+" nombre del copiloto "+copiloto + " , combustible: " + combustible
				+ ", categoria " + categoria;
	}
	/**
	 * M&eacute;todo setter del tipo de veh&iacute;culo
	 * @param categoria categor&iacute; de veh&iacute;culos
	 */
	public void setCategoria(CategoriaVehiculos categoria) {
		this.categoria = categoria;
	}
	/**
	 * M&eacute;todo para comprobar las expresiones regulares.
	 * @param campo Cadena de caracteres
	 * @return true si cumple la condici&oacute;n o false en caso contrario.
	 */
	private boolean comprobarCampos(String campo) {
		return partternNombre.matcher(campo).matches();
	}
	@Override
	/**
	 * M&eacute;todo sobreescrito de la interfaz combustiable para calcular el gasto de combustible.
	 */
	public float getGastoCombustible(GastoCombustible gastoCombustible,
			float etapaDakkar) {
		float gastoTotal;
		gastoTotal=gastoCombustible.getGasto()*etapaDakkar;
		return gastoTotal;
	}

}
