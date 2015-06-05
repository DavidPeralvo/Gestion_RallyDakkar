package proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class Moto extends VehiculoDakkar implements Serializable {
	private Mototipo tipo;
	private CategoriaMotos categoria;
	static final private Pattern patternDorsal = Pattern
			.compile("^\\d{4}$");
	public Moto(String dorsal, String nombre, String escuderia, Paises pais,float cantidadCombustible, boolean motor,Mototipo tipo,CategoriaMotos categoria,Date fecha) throws DorsalNoValidoException, CampoNoValidoException {
		super(dorsal, nombre, escuderia, pais, cantidadCombustible, motor,fecha);
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
	@Override
	public float getGastoCombustible(GastoCombustible gastoCombustible,
			float etapaDakkar) {
		float gastoTotal;
		gastoTotal=gastoCombustible.MOTO.getGasto()*etapaDakkar;
		return gastoTotal;
	}

}
