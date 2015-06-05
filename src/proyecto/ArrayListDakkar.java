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
	
	  @Override
		public String toString() {
			return "ArrayListDakkar [inscripcion=" + inscripcion + "]";
		}

	public ArrayList<VehiculoDakkar> categoriaCoches(CategoriaVehiculos seleccionarCategoria) {
		ArrayList<VehiculoDakkar>ArrCategoriaCoches=new ArrayList<VehiculoDakkar>();
		for(VehiculoDakkar vehiculo:inscripcion){
			if(vehiculo instanceof Coche){
			Coche coche=(Coche)vehiculo;
			 if(coche.getCategoria().equals(seleccionarCategoria))
				 	ArrCategoriaCoches.add(coche);}}
		return ArrCategoriaCoches;
	}
	
	public ArrayList<VehiculoDakkar> categoriaMotos(CategoriaMotos seleccionarCategoria) {
		ArrayList<VehiculoDakkar>ArrCategoriaMotos=new ArrayList<VehiculoDakkar>();
		for(VehiculoDakkar vehiculo:inscripcion){
			if(vehiculo instanceof Moto){
				Moto moto=(Moto)vehiculo;
			 if(moto.getCategoria().equals(seleccionarCategoria))
				 	ArrCategoriaMotos.add(moto);}}
		return ArrCategoriaMotos;
	}
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
