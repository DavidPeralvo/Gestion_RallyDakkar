/**
 * Paquete que engloba las clases Camiones,Coches,Motos,VehiculoDakkar,excepciones,interfaces y enumeraciones
 */

package proyecto;
import gui.GuardarComo;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase que gestiona los ficheros
 * @author David Peralvo
 *@version 1.0
 */
public class GestionarFicheros {
	/**
	 * Campo fichero
	 */
	static File fichero;
	/**
	 * Campo fichero modificado
	 */
	private File ficheroModificado;
	/**
	 * Campo ruta
	 */
	private static String ruta;
	/**
	 * Campo content Panel
	 */
	private final static JPanel contentPanel = new JPanel();
	/**
	 * M&eacute;todo para abrir ficheros
	 * @param fichero archivo para abrir
	 * @return La lectura de un arraylist
	 * @throws IOException Excepci&oacute;n de entrada y salida de datos.
	 * @throws ClassNotFoundException Excepci&oacute;n cuando termina de leer el archivo.
	 */
	public static ArrayListDakkar abrirFichero(File fichero) throws IOException, ClassNotFoundException{
		try(ObjectInputStream leerObjeto = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			return ((ArrayListDakkar)leerObjeto.readObject());
		}
	}
	/**
	 * M&eacute;todo que sirve para comprobar la extension del fichero.
	 * @param arrayListDakkar arraylist con los datos a guardar.
	 * @param fichero archivo
	 * @return un archivo con extensi&oacute;n .obj
	 */
	public static File comprobarExtension(ArrayListDakkar arrayListDakkar, File fichero){
		ruta=fichero.getPath();
		if(!ruta.endsWith(".obj")){
			return new File(fichero+".obj");}
		else{
			return fichero;	
		}
		
	}
	/**
	 * M&eacute;todo que sirve para guardar ficheros.
	 * @param arrayListDakkar arraylist con los datos a guardar
	 * @param fichero archivo a guardar
	 * @throws IOExceptionExcepci&oacute;n de entrada y salida de datos.
	 */
	public static void guardarComoFichero(ArrayListDakkar arrayListDakkar, File fichero) throws IOException {
		try(ObjectOutputStream escribirObjeto = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(comprobarExtension(arrayListDakkar, fichero))))){
				escribirObjeto.writeObject(arrayListDakkar);
				
			}
		}

	
	
}

	


