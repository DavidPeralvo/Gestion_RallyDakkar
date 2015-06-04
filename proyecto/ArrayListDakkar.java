package proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ArrayListDakkar implements Serializable {
	private ArrayList<VehiculoDakkar> inscripcion= new ArrayList<VehiculoDakkar>();
	private ArrayList listaDorsales=new ArrayList();
	
	public void annadirVehiculo(VehiculoDakkar vehiculo) throws VehiculoYaExisteException{
		
		if(inscripcion.contains(vehiculo))
			throw new VehiculoYaExisteException("El vehiculo ya existe");
		inscripcion.add(vehiculo);
		
	}
	 
	 public int size(){
		 return inscripcion.size();
	 }
	 
	 public void borrarVehiculo(String dorsal) throws DorsalNoValidoException, vehiculoNoExisteException{
		 VehiculoDakkar vehiculo=getVehiculo(dorsal);
		 if(inscripcion.contains(vehiculo))
			 inscripcion.remove(vehiculo);
		 
		 
	 }
	
	 public VehiculoDakkar getVehiculo(String dorsal) throws vehiculoNoExisteException{
		 for(VehiculoDakkar vehiculo:inscripcion){
			 if(vehiculo.getDorsal().equals(dorsal))
				 	return vehiculo;
		 }
		throw new vehiculoNoExisteException("El vehiculo no existe");	
		 
	 }
	 
	 public int dimension(){
		 return inscripcion.size();
	 }
	 
	 public VehiculoDakkar get(int index){
		return inscripcion.get(index);
		 
	 }
	 public VehiculoDakkar getVehiculoExiste(String dorsal) throws VehiculoYaExisteException{
		 for(VehiculoDakkar vehiculo:inscripcion){
			 if(vehiculo.getDorsal().equals(dorsal))
				 	return vehiculo;
		 }
		throw new VehiculoYaExisteException("El vehiculo ya existe");	
		 
	 }
	 
	 
	 
	
	  @Override
		public String toString() {
			return "ArrayListDakkar [inscripcion=" + inscripcion + "]";
		}
	
	

}
