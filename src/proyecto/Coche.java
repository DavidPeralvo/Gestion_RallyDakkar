package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class Coche extends VehiculoDakkar implements Serializable {
	private String copiloto;
	private  Combustible combustible;
	private  CategoriaVehiculos categoria;
	private String tipoVehiculo;
	static final private Pattern partternNombre=Pattern.compile("^\\w+");
	public Coche(String dorsal, String nombre, String escuderia, Paises pais,int cantidadCombustible, boolean motor,String copiloto,Combustible combustible,CategoriaVehiculos categoria, Date fecha) throws CampoNoValidoException, DorsalNoValidoException  {
		super(dorsal, nombre, escuderia, pais, cantidadCombustible, motor,fecha);
		this.categoria=categoria;
		this.combustible=combustible;
		setCopiloto(copiloto);
	
	}
	public String getCopiloto() {
		return copiloto;
	}
	public void setCopiloto(String copiloto) throws CampoNoValidoException{
		if(copiloto==null| comprobarCampos(copiloto)){
			this.copiloto = copiloto;}
		else{
			throw new CampoNoValidoException("No se ha introducido el copiloto");
		}
	}
	
	public Combustible getCombustible() {
		return combustible;
	}
	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}
	public  CategoriaVehiculos getCategoria() {
		return categoria;
	}
	@Override
	public String toString() {
		return  super.toString()+" nombre del copiloto "+copiloto + " , combustible: " + combustible
				+ ", categoria " + categoria;
	}
	public void setCategoria(CategoriaVehiculos categoria) {
		this.categoria = categoria;
	}	
	private boolean comprobarCampos(String campo) {
		return partternNombre.matcher(campo).matches();
	}
	@Override
	public float getGastoCombustible(GastoCombustible gastoCombustible,
			float etapaDakkar) {
		float gastoTotal;
		gastoTotal=gastoCombustible.getGasto()*etapaDakkar;
		return gastoTotal;
	}

}
