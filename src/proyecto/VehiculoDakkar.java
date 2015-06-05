package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public abstract class VehiculoDakkar implements Serializable, Combustiable{
	protected  String dorsal;
	private  String nombre;
	private  String escuderia;
	private  Paises pais;
	private float cantidadCombustible;
	private boolean motor;
	static final private Pattern patternDorsal = Pattern.compile("^\\d{4}$");
	static final private Pattern partternNombre=Pattern.compile("^\\w+");
	private Date fechaCreacion;
	
	public String getDorsal() {
		return dorsal;
	}
	public VehiculoDakkar(String dorsal,String nombre,String escuderia,Paises pais,float cantidadCombustible,boolean motor, Date fechaCreacion) throws CampoNoValidoException, DorsalNoValidoException{
		this.cantidadCombustible=cantidadCombustible;
		setDorsal(dorsal);
		setNombre(nombre);
		setEscuderia(escuderia);
		this.pais=pais;
		this.motor=motor;
		this.fechaCreacion=fechaCreacion;}
	public VehiculoDakkar(String dorsal) throws DorsalNoValidoException{
		setDorsal(dorsal);
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre)throws CampoNoValidoException {
		if(nombre==null|comprobarCampos(nombre)==false){
			throw new CampoNoValidoException("No se ha introducido nombre");}
		this.nombre=nombre;
		
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) throws CampoNoValidoException{
		if(escuderia==null|comprobarCampos(escuderia)==false){
			throw new CampoNoValidoException("No se ha introducido ninguna escuderia");}
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


	public boolean isMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}
	
	private static boolean comprobarCampos(String campo){
		
		return partternNombre.matcher(campo).matches();
		
	}
	
	private static boolean comprobarValidez(String dorsal) {
		return patternDorsal.matcher(dorsal).matches() ;
	}
	public float getCantidadCombustible() {
		return cantidadCombustible;
	}
	public void setCantidadCombustible(float cantidadCombustible) {
		this.cantidadCombustible = cantidadCombustible;
	}
	@Override
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
