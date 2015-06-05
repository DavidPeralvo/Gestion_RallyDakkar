/**
 * 
 */
package proyecto;
/**
 * Presenta los distintos gastos de combustibles de los veh&iacute;culos
 * @author David Peralvo
 * @version 1.0
 */
public enum GastoCombustible {
	/**
	 * Representa el gasto de combustible de moto.
	 */
	MOTO(0.036f),
	/**
	 * Representa el gasto de combustible de coche
	 */
	COCHE(0.090f),
	/**
	 * Representa el gasto de combustible de cami&oacute;n
	 */
	CAMION(0.204f);
	/**
	 * Gasto de combustible
	 */
	private float gasto;
	/**
	 * Construye el gasto de combustible espef&iacute;co
	 * @param gasto Representa el gasto del nuevo gasto de combustible
	 */
	private GastoCombustible(float gasto){
		this.gasto=gasto;
	}
	/**
	 * Devuelve el gasto de combustible del tipo de veh&iacute;culo
	 * @return Gasto del tipo de veh&iacute;culo
	 */
	
	public float getGasto(){
		return gasto;
		
	}

}
