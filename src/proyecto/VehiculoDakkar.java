/**
 * Paquete que engloba las clases Camiones,Coches,Motos,VehiculoDakkar,excepciones,interfaces y enumeraciones
 */
package proyecto;

import java.io.Serializable;

import java.util.Date;
import java.util.regex.Pattern;
/**
 * Clase vehiculosDakkar, Clase padre de las clases Moto,Coche y Camiones
 * @author David Peralvo
 *@version 1.0
 */
public abstract class VehiculoDakkar implements Serializable, Combustiable{
	/**
	 * Campo dorsal
	 */
	protected  String dorsal;
	/**
	 * Campo nombre
	 */
	private  String nombre;
	/**
	 * Campo Escuder&iacute;a
	 */
	private  String escuderia;
	/**
	 * Campo pa&iacute;s
	 */
	private  Paises pais;
	/**
	 * Campo cantidad de combustible
	 */
	private float cantidadCombustible;
	/**
	 * Campo motor
	 */
	private boolean motor;
	/**
	 * Patr&oacute;n para verificar los dorsales
	 */
	static final private Pattern patternDorsal = Pattern.compile("^\\d{4}$");
	/**
	 *  Patr&oacute;n para el campo piloto,copiloto,mecanico y escuder&iacute;a
	 */
	static final private Pattern partternNombre=Pattern.compile("^\\w+");
	/**
	 * Campo fechaCreacion
	 */
	private Date fechaCreacion;
	
	/**
	 * Constructor de VehiculoDakkar
	 * @param dorsal Identificador de cada participante
	 * @param nombre Nombre del piloto
	 * @param escuderia Nombre de la escuder&iacute;a
	 * @param pais Pa&iacute;s de procedencia
	 * @param cantidadCombustible Cantidad de combustible
	 * @param motor Estado del motor
	 * @param fechaCreacion Fecha de inscripci&oacute;n
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios
	 * @throws DorsalNoValidoException Excepci&oacute;n que a parece cuando hay alg&uacute;n fallo en el dorsal
	 */
	public VehiculoDakkar(String dorsal,String nombre,String escuderia,Paises pais,float cantidadCombustible,boolean motor, Date fechaCreacion) throws CampoNoValidoException, DorsalNoValidoException{
		this.cantidadCombustible=cantidadCombustible;
		setDorsal(dorsal);
		setNombre(nombre);
		setEscuderia(escuderia);
		this.pais=pais;
		this.motor=motor;
		this.fechaCreacion=fechaCreacion;}
	
	
	/**
	 * M&eacute;todo getter del nombre
	 * @return nombre del piloto
	 */
	
	public String getNombre() {
		return nombre;
	}
	/**
	 * M&eacute;todo que comprueba que nombre este escrito como lo dicta la expresio&oacute;n regular
	 * @param nombre nombre del piloto
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios
	 */
	public void setNombre(String nombre)throws CampoNoValidoException {
		if(nombre==null|comprobarCampos(nombre)==false){
			throw new CampoNoValidoException("No se ha introducido nombre");}
		this.nombre=nombre;
		
	}
	/**
	 * M&eacute;todo getter de dorsal
	 * @return dorsal del participante
	 */
	public String getDorsal() {
		return dorsal;
	}
	/**
	 * M&eacute;todo getter de escuder&iacute;a
	 * @return El nombre de la escuder&aiacute;a
	 */
	public String getEscuderia() {
		return escuderia;
	}
	/**
	 * M&eacute;todo setter de escuder&aiacute;a
	 * @param escuderia nombre de escuder&iacute;a
	 * @throws CampoNoValidoException Excepci&oacute;n que a parece cuando hay campos vacios
	 */
	public void setEscuderia(String escuderia) throws CampoNoValidoException{
		if(escuderia==null|comprobarCampos(escuderia)==false){
			throw new CampoNoValidoException("No se ha introducido ninguna escuderia");}
		else{
		this.escuderia = escuderia;}
	}
	/**
	 * M&eacute;todo setter de dorsal
	 * @param dorsal dorsal del participante
	 * @throws DorsalNoValidoException  Excepci&oacute;n que a parece cuando hay alg&uacute;n fallo en el dorsal
	 */
	public void setDorsal(String dorsal)throws DorsalNoValidoException {
		if(dorsal==null|comprobarValidez(dorsal)==false)
			throw new DorsalNoValidoException("Dorsal no valido");
		this.dorsal=dorsal;
	}
	 /**
	  * M&eacute;todo getter de Paises
	  * @return un pais de procedencia
	  */
	public Paises getPais() {
		return pais;
	}
	/**
	 * M&eacute;todo getter de fecha
	 * @return la fecha de creaci&oacute;n
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * M&eacute;todo setter de fecha
	 * @param fechaCreacion
	 */
	private void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * M&eacute;todo setter de pais
	 * @param pais pais de procedencia 
	 */
	public void setPais(Paises pais) {
		this.pais = pais;
	}

	/**
	 * M&eacute;todo setter de motor
	 * @return true si el motor esta bien y false si  esta roto
	 */
	public boolean isMotor() {
		return motor;
	}
	/**
	 * M&eacute;todo getter de motor
	 * @param motor estado del motor
	 */
	public void setMotor(boolean motor) {
		this.motor = motor;
	}
	/**
	 * M&eacute;todo que compruna la validez de los campos
	 * @param campo Texto que introducimos
	 * @return true si esta bien y false si no esta bien.
	 */
	private static boolean comprobarCampos(String campo){
		
		return partternNombre.matcher(campo).matches();
		
	}
	/**
	 * M&eacute;todo que compruna la validez del dorsal
	 * @param dorsal Dorsal que introducimos
	 * @return true si esta bien y false si no esta bien.
	 */
	private static boolean comprobarValidez(String dorsal) {
		return patternDorsal.matcher(dorsal).matches() ;
	}
	/**
	 * M&eacute;todo getter de la cantidad de Combustible
	 * @return la cantidad de combustible del veh&iacute;culo
	 */
	public float getCantidadCombustible() {
		return cantidadCombustible;
	}
	/**
	 * M&eacute;todo setter de la cantidad de combustible.
	 * @param cantidadCombustible cantidad de combustible a a&nacute;adir.
	 */
	public void setCantidadCombustible(float cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}
	@Override
	/**
	 * Calcula el consumo de combustible dependiendo del veh&iacute;culo
	 */
	public abstract float getGastoCombustible(GastoCombustible gastoCombustible,float etapaDakkar);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dorsal == null) ? 0 : dorsal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VehiculoDakkar))
			return false;
		VehiculoDakkar other = (VehiculoDakkar) obj;
		if (dorsal == null) {
			if (other.dorsal != null)
				return false;
		} else if (!dorsal.equals(other.dorsal))
			return false;
		return true;
	}


	
}
