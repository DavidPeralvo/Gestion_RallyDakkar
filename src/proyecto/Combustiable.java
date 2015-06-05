/**
 * 
 */
package proyecto;
/**
 * Interfaz que calcula el gasto de combustible de los vehiculos del dakkar.
 * @author David Peralvo
 * @version 1.0
 */

public interface Combustiable {
	/**
	 * Calcula el gasto de combustible
	 * @param gastoCombustible Representa el gasto de combustible por kilometro.
	 * @param etapaDakkar representa los kilometros de la etapa.
	 * @return Gasto de combustible
	 */
	
	float getGastoCombustible(GastoCombustible gastoCombustible,float etapaDakkar);

}
