package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class Camiones extends VehiculoDakkar implements Serializable {
	private String copiloto;
	private String mecanico;
	private ClaseCamiones clase;
	static final private Pattern partternNombre=Pattern.compile("^\\w");
	public Camiones(String tipoVehiculo,String dorsal, String nombre, String escuderia, Paises pais,int velocidad, boolean motor,String copiloto,String mecanico,ClaseCamiones clase, Date fecha) throws NombreNoValidoException, EscuderiaNoValidoException, DorsalNoValidoException, CopilotoNoValidoException, MecanicoNoValidoException {
		super(tipoVehiculo,dorsal, nombre, escuderia, pais, velocidad, motor,fecha);
		setCopiloto(copiloto);
		setMecanico(mecanico);
		this.clase=clase;
	}

	public String getCopiloto() {
		return copiloto;
	}
	public void setCopiloto(String copiloto) throws CopilotoNoValidoException {
		if(copiloto==null|comprobarCampos(copiloto))
			throw new CopilotoNoValidoException("No se ha introducido el copiloto");
		this.copiloto = copiloto;
	}
	public String getMecanico() {
		return mecanico;
	}
	public void setMecanico(String mecanico) throws MecanicoNoValidoException {
		if(mecanico==null|comprobarCampos(mecanico))
			throw new MecanicoNoValidoException("No se ha introducido el mecanico");
		this.mecanico = mecanico;
	}
	public ClaseCamiones getClase() {
		return clase;
	}
	public void setClase(ClaseCamiones clase) {
		this.clase = clase;
	}
	private boolean comprobarCampos(String campo) {
		return partternNombre.matcher(campo).matches();
	}
}
