package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class Moto extends VehiculoDakkar implements Serializable {
	private Mototipo tipo;
	private CategoriaMotos categoria;
	static final private Pattern patternDorsal = Pattern
			.compile("^\\d{4}$");
	public Moto(String tipoVehiculo,String dorsal, String nombre, String escuderia, Paises pais,int velocidad, boolean motor,Mototipo tipo,CategoriaMotos categoria,Date fecha) throws NombreNoValidoException, EscuderiaNoValidoException, DorsalNoValidoException {
		super(tipoVehiculo,dorsal, nombre, escuderia, pais, velocidad, motor,fecha);
		this.tipo=tipo;
		this.categoria=categoria;
	}
	@Override
	public String toString() {
		return "Moto [tipo=" + tipo + ", categoria=" + categoria + "]";
	}
	public Mototipo getTipo() {
		return tipo;
	}
	public void setTipo(Mototipo tipo) {
		this.tipo = tipo;
	}
	public CategoriaMotos getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaMotos categoria) {
		this.categoria = categoria;
	}

}
