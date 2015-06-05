/**
 * Paquete que engloba las clases Camiones,Coches,Motos,VehiculoDakkar,excepciones,interfaces y enumeraciones
 */
package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;
/**
 * Clase Moto, se trata de las clase hija de vehiculosDakkar
 * @author David Peralvo
 * @version 1.0
 */
public class Moto extends VehiculoDakkar implements Serializable {
	/**
	 * campo tipo de moto
	 */
	private Mototipo tipo;
	/**
	 * campo categor&iacute;a de motos
	 */
	private CategoriaMotos categoria;
	/**
	 *  Patr&oacute;n para el campo piloto,copiloto,mecanico y escuder&iacute;a
	 */
	static final private Pattern patternDorsal = Pattern
			.compile("^\\d{4}$");
	/**
	 * Constructor de Moto
	 * @param dorsal Identificador de cada participante
	 * @param nombre Nombre del piloto
	 * @param escuderia Nombre de la escuder&iacute;a
	 * @param pais Pa&iacute;s de procedencia
	 * @param cantidadCombustible Cantidad de combustible
	 * @param motor Estado del motor
	 * @param tipo Tipo de moto
	 * @param categoria Categor&iacute;a moto
	 * @param fecha Fecha de inscripci&oacute;n
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios
	 * @throws DorsalNoValidoException Excepci&oacute;n que a parece cuando hay alg&uacute;n fallo en el dorsal
	 */
	public Moto(String dorsal, String nombre, String escuderia, Paises pais,float cantidadCombustible, boolean motor,Mototipo tipo,CategoriaMotos categoria,Date fecha) throws DorsalNoValidoException, CampoNoValidoException {
		super(dorsal, nombre, escuderia, pais, cantidadCombustible, motor,fecha);
		this.tipo=tipo;
		this.categoria=categoria;
	}
	/**
	 * M&eacute;todo toString
	 */
	@Override
	public String toString() {
		return "Moto [tipo=" + tipo + ", categoria=" + categoria + "]";
	}
	/**
	 * M&eacute;todo getter de tipo de moto
	 * @return tipo de moto
	 */
	public Mototipo getTipo() {
		return tipo;
	}
	/**
	 * M&eacute;todo setter de tipo de moto
	 * @param tipo tipo de moto
	 */
	public void setTipo(Mototipo tipo) {
		this.tipo = tipo;
	}
	/**
	 * M&eacute;todo getter de Categor&iacute;a de moto
	 * @return categor&iacute;a de motos
	 */
	public CategoriaMotos getCategoria() {
		return categoria;
	}
	/**
	 *  M&eacute;todo setter de Categor&iacute;a de moto
	 * @param categoria categor&iacute;a de moto
	 */
	public void setCategoria(CategoriaMotos categoria) {
		this.categoria = categoria;
	}
	@Override
	/**
	 * M&eacute;todo sobreescrito de la interfaz combustiable para calcular el gasto de combustible.
	 */
	public float getGastoCombustible(GastoCombustible gastoCombustible,
			float etapaDakkar) {
		float gastoTotal;
		gastoTotal=gastoCombustible.MOTO.getGasto()*etapaDakkar;
		return gastoTotal;
	}

}
