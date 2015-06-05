/**
 * Paquete que engloba las clases Camiones,Coches,Motos,VehiculoDakkar,excepciones,interfaces y enumeraciones
 */
package proyecto;

import java.io.Serializable;

import java.util.Date;
import java.util.regex.Pattern;
 /**
  * Clase Camiones, se trata de las clase hija de vehiculosDakkar
  * @author David Peralvo
  * @version 1.0
  *
  */
public class Camiones extends VehiculoDakkar implements Serializable {
	/**
	 * campo copiloto
	 */
	private String copiloto;
	/**
	 * campo mecanico
	 */
	private String mecanico;
	/**
	 * campo clase camiones
	 */
	private ClaseCamiones clase;
	/**
	 * Patr&oacute;n para el campo piloto,copiloto,mecanico y escuder&iacute;a
	 */
	static final private Pattern partternNombre=Pattern.compile("^\\w+");
	/**
	 * Constructor de camiones
	 * @param dorsal Identificador de cada participante
	 * @param nombre Nombre del piloto
	 * @param escuderia Nombre de la escuder&iacute;a
	 * @param pais Pa&iacute;s de procedencia
	 * @param cantidadCombustible Cantidad de combustible
	 * @param motor Estado del motor
	 * @param copiloto Nombre del copiloto
	 * @param mecanico Nombre del mec&acute;nico
	 * @param clase Clase de camion
	 * @param fecha Fecha de inscripci&oacute;n
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios
	 * @throws DorsalNoValidoException Excepci&oacute;n que a parece cuando hay alg&uacute;n fallo en el dorsal
	 */
	public Camiones(String dorsal, String nombre, String escuderia, Paises pais,float cantidadCombustible, boolean motor,String copiloto,String mecanico,ClaseCamiones clase, Date fecha) throws CampoNoValidoException, DorsalNoValidoException  {
		super(dorsal, nombre, escuderia, pais, cantidadCombustible, motor,fecha);
		setCopiloto(copiloto);
		setMecanico(mecanico);
		this.clase=clase;
	}
	/**
	 * M&eacute; getter de Copiloto.
	 * @return nombre del copiloto.
	 */
	public String getCopiloto() {
		return copiloto;
	}
	/**
	 *  M&eacute;todo setter de Copiloto.
	 * @param copiloto nombre del copiloto
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios.
	 */
	public void setCopiloto(String copiloto) throws CampoNoValidoException {
		if(copiloto==null|comprobarCampos(copiloto)==false)
			throw new CampoNoValidoException("No se ha introducido el copiloto");
		this.copiloto = copiloto;
	}
	/**
	 * M&eacute;todo getter de mec&acute;nico.
	 * @return nombre del mec&acute;nico.
	 */
	public String getMecanico() {
		return mecanico;
	}
	/**
	 * M&eacute;todo setter de mec&acute;nico.
	 * @param mecanico nombre del mec&acute;nico.
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios.
	 */
	
	public void setMecanico(String mecanico) throws CampoNoValidoException {
		if(mecanico==null|comprobarCampos(mecanico)==false)
			throw new CampoNoValidoException("No se ha introducido el mecanico");
		this.mecanico = mecanico;
	}
	/**
	 * M&eacute;todo getter de las clases de camiones
	 * @return la clase del cami&oacute;n
	 */
	public ClaseCamiones getClase() {
		return clase;
	}
	/**
	 * M&eacute;todo setter de clase de camiones.
	 * @param clase clase de camiones.
	 */
	public void setClase(ClaseCamiones clase) {
		this.clase = clase;
	}
	/**
	 * M&eacute;todo para comprobar las expresiones regulares.
	 * @param campo Cadena de caracteres
	 * @return true si cumple la condici&oacute;n o false en caso contrario.
	 */
	private boolean comprobarCampos(String campo) {
		return partternNombre.matcher(campo).matches();
	}
	/**
	 * M&eacute;todo sobreescrito de la interfaz combustiable para calcular el gasto de combustible.
	 */
	@Override
	public float getGastoCombustible(GastoCombustible gastoCombustible,
			float etapaDakkar) {
		float gastoTotal;
		gastoTotal=gastoCombustible.CAMION.getGasto()*etapaDakkar;
		return gastoTotal;
	}
}
