/**
 * Paquete que contiene la GUI del programa
 */
package gui;

import java.io.File;
import java.security.Principal;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Clase Abrir
 * @author David Peralvo
 *@version 1.0
 */
public class Abrir extends JDialog {
	/**
	 * Campo Fitro
	 */
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
	/**
	 * Campo contentPanel
	 */
	JComponent contentPanel;

	/**
	 * M&eacute;todo que nos permite abrir arhcivos mediante interfaz gr&aacute;fica.
	 */
	public Abrir() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION)
           	principal.seleccion = fileChooser.getSelectedFile();
        if (respuesta == JFileChooser.CANCEL_OPTION)
        	setVisible(false);
        
	}

}
