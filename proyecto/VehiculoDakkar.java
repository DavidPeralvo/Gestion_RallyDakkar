package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class VehiculoDakkar implements Serializable{
	protected  String dorsal;
	private  String nombre;
	private  String escuderia;
	private  Paises pais;
	private int velocidad;
	private boolean motor;
	private String tipoVehiculo;
	static final private Pattern patternDorsal = Pattern.compile("^\\d{4}$");
	static final private Pattern partternNombre=Pattern.compile("^\\w+");
	private Date fechaCreacion;
	
	public String getDorsal() {
		return dorsal;
	}
	public VehiculoDakkar(String tipoVehiculo,String dorsal,String nombre,String escuderia,Paises pais,int velocidad,boolean motor, Date fechaCreacion) throws NombreNoValidoException, EscuderiaNoValidoException, DorsalNoValidoException{
		this.tipoVehiculo=tipoVehiculo;
		setDorsal(dorsal);
		setNombre(nombre);
		setEscuderia(escuderia);
		this.pais=pais;
		this.motor=motor;
		this.fechaCreacion=fechaCreacion;}
	public VehiculoDakkar(String dorsal) throws DorsalNoValidoException{
		setDorsal(dorsal);
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre)throws NombreNoValidoException {
		if(nombre==null|comprobarCampos(nombre)==false){
			throw new NombreNoValidoException("No se ha introducido nombre");}
		this.nombre=nombre;
		
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) throws EscuderiaNoValidoException{
		if(escuderia==null|comprobarCampos(escuderia)==false){
			throw new EscuderiaNoValidoException("No se ha introducido ninguna escuderia");}
		else{
		this.escuderia = escuderia;}
	}
	
	public void setDorsal(String dorsal)throws DorsalNoValidoException {
		if(dorsal==null|comprobarValidez(dorsal)==false)
			throw new DorsalNoValidoException("Dorsal no valido");
		this.dorsal=dorsal;
	}
	 
	public Paises getPais() {
		return pais;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	private void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}

	private int getVelocidad() {
		return velocidad;
	}

	private void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	private boolean isMotor() {
		return motor;
	}

	private void setMotor(boolean motor) {
		this.motor = motor;
	}
	
	private static boolean comprobarCampos(String campo){
		
		return partternNombre.matcher(campo).matches();
		
	}
	
	private static boolean comprobarValidez(String dorsal) {
		return patternDorsal.matcher(dorsal).matches() ;
	}
	@Override
	public String toString() {
		return tipoVehiculo+" con dorsal " + dorsal + " , nombre del piloto: " + nombre
				+ " , nombre de las escuderia: " + escuderia + " , pais de procedencia " + pais
				+ ", velocidad " + velocidad + " km/h , motor " + motor+", ";
	}
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
