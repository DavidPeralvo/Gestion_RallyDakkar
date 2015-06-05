/**
 * Paquete que engloba las clases Camiones,Coches,Motos,VehiculoDakkar,excepciones,interfaces y enumeraciones
 */
package proyecto;
/**
 * Clase ArrayListDakkar, donde se concentra toda la informaci&oacute;n del las inscripciones y se gestiona.
 * @autor David Peralvo
 * @version 1.0
 */

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListDakkar implements Serializable {
	/**
	 * ArrayList inscripci&oacute;n donde se almacena la informaci&oacute;n.
	 */
	private ArrayList<VehiculoDakkar> inscripcion= new ArrayList<VehiculoDakkar>();
	/**
	 * M&eacute;todo que nos permite a&nacute;adir nuevos participantes.
	 * @param vehiculo El veh&iacute;culo del participante.
	 * @throws VehiculoYaExisteException  Excepci&oacute;n para que no se repitan participantes con el mismo dorsal.
	 */
	public void annadirVehiculo(VehiculoDakkar vehiculo) throws VehiculoYaExisteException{
		
		if(inscripcion.contains(vehiculo))
			throw new VehiculoYaExisteException("El vehiculo ya existe");
		inscripcion.add(vehiculo);
		
	}
	 /**
	  * M&eacute;todo que nos devuelve el tama&nacute;o del arraylist
	  * @return La cantidad de participantes
	  */
	 public int size(){
		 return inscripcion.size();
	 }
	 /**
	  * M&eacute;todo que sirve para borrar participantes.
	  * @param dorsal El idendificador &uacute;nico para cada participante.
	  * @throws DorsalNoValidoException Excepci&oacute;n para cuando el dorsal no es valido.
	  * @throws vehiculoNoExisteException Excepci&oacute;n para cuando no existe ning&uacute;n coche con ese dorsal.
	  */
	 public void borrarVehiculo(String dorsal) throws DorsalNoValidoException, vehiculoNoExisteException{
		 VehiculoDakkar vehiculo=getVehiculo(dorsal);
		 if(inscripcion.contains(vehiculo))
			 inscripcion.remove(vehiculo);
		 
		 
	 }
	/**
	 * Nos devuelve el veh&iacute;culo por dorsal
	 * @param dorsal El idendificador &uacute;nico para cada participante.
	 * @return un vehiculo con toda su información
	 * @throws vehiculoNoExisteException Excepci&oacute;n para cuando no existe ning&uacute;n coche con ese dorsal.
	 */
	 public VehiculoDakkar getVehiculo(String dorsal) throws vehiculoNoExisteException{
		 for(VehiculoDakkar vehiculo:inscripcion){
			 if(vehiculo.getDorsal().equals(dorsal))
				 	return vehiculo;
		 }
		throw new vehiculoNoExisteException("El vehiculo no existe");	
		 
	 }
	 
	 /**
	  * M&eacute;todo que devuelve una inscipci&oacute;n por el lugar que ocupa en en el arraylist
	  * @param index n&uacute;mero de posici&oacute;n que ocupa una inscripci&oacute;n de un participante.
	  * @return una inscripci&oacute;n de un participante
	  */
	 public VehiculoDakkar get(int index){
		return inscripcion.get(index);
		 
	 }
	 /**
	  * M&acute;todo que crea arraylist seg&uacute;n el tipo de veh&iacute;culo.
	  * @param opcion valor para identificar los veh&iacute;culos.
	  * @return arraylist de tipos de veh&iacute;culos
	  */
	 public ArrayList<VehiculoDakkar> getVehiculo(int opcion){
		 ArrayList<VehiculoDakkar> arrayCoches =new ArrayList<VehiculoDakkar>();
		 ArrayList<VehiculoDakkar> arrayMotos =new ArrayList<VehiculoDakkar>();
		 ArrayList<VehiculoDakkar> arrayCamiones =new ArrayList<VehiculoDakkar>();
		 for(VehiculoDakkar vehiculo:inscripcion){
			 if(vehiculo instanceof Coche){
			 Coche coche=(Coche)vehiculo;
			 	arrayCoches.add(coche);	
			 }
			 if(vehiculo instanceof Moto){
				 Moto moto=(Moto)vehiculo;
				 	arrayMotos.add(moto);	
				 }
			 if(vehiculo instanceof Camiones){
				 Camiones camion=(Camiones) vehiculo;
				 arrayCamiones.add(camion);
			 }
		 }
		 if(opcion==1){
			 return arrayCoches;
		 }
		 else{if(opcion==2){
			 return arrayMotos;
		 }
		 else{return arrayCamiones;}
			 
		 }
		 
	 }
	 /**
	  * M&eacute;todo toString
	  */
	  @Override
		public String toString() {
			return "ArrayListDakkar [inscripcion=" + inscripcion + "]";
		}
	  
	  /**
	   * M&eacute;todo que crea arraylist seg&uacute;n el tipo de coche que sea.
	   * @param seleccionarCategoria tipo de coche
	   * @return arraylist con una categor&iacute;a espec&iacute;fica de coches
	   */
	public ArrayList<VehiculoDakkar> categoriaCoches(CategoriaVehiculos seleccionarCategoria) {
		ArrayList<VehiculoDakkar>ArrCategoriaCoches=new ArrayList<VehiculoDakkar>();
		for(VehiculoDakkar vehiculo:inscripcion){
			if(vehiculo instanceof Coche){
			Coche coche=(Coche)vehiculo;
			 if(coche.getCategoria().equals(seleccionarCategoria))
				 	ArrCategoriaCoches.add(coche);}}
		return ArrCategoriaCoches;
	}
	 /**
	   * M&eacute;todo que crea arraylist seg&uacute;n la categor&iacute;a de moto que sea.
	   * @param seleccionarCategoria tipo de moto
	   * @return arraylist con una categor&iacute;a espec&iacute;fica de moto
	   */
	public ArrayList<VehiculoDakkar> categoriaMotos(CategoriaMotos seleccionarCategoria) {
		ArrayList<VehiculoDakkar>ArrCategoriaMotos=new ArrayList<VehiculoDakkar>();
		for(VehiculoDakkar vehiculo:inscripcion){
			if(vehiculo instanceof Moto){
				Moto moto=(Moto)vehiculo;
			 if(moto.getCategoria().equals(seleccionarCategoria))
				 	ArrCategoriaMotos.add(moto);}}
		return ArrCategoriaMotos;
	}
	 /**
	   * M&eacute;todo que crea arraylist seg&uacute;n la clase de cami&oacute;n que sea.
	   * @param seleccionarCategoria tipo de cami&oacute;n.
	   * @return arraylist con una categor&iacute;a espec&iacute;fica de camiones
	   */
	public ArrayList<VehiculoDakkar> claseCamiones(ClaseCamiones seleccionarCategoria) {
		ArrayList<VehiculoDakkar>ArrClaseCamiones=new ArrayList<VehiculoDakkar>();
		for(VehiculoDakkar vehiculo:inscripcion){
			if(vehiculo instanceof Camiones){
			Camiones camion=(Camiones)vehiculo;
			 if(camion.getClase().equals(seleccionarCategoria))
				 	ArrClaseCamiones.add(camion);}}
		return ArrClaseCamiones;
	}
	
	
	
		
	
	

}
