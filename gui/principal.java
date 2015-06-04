package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;



import proyecto.GestionarFicheros;
import proyecto.ArrayListDakkar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class principal {
	private Borrar borrar;
	private Annadir annadir;
	private JFrame frmDakkar;
	private ArrayListDakkar inscripcion= new ArrayListDakkar();
	private final JPanel contentPanel = new JPanel();
	static File seleccion;
	private JFileChooser fileChooser = new JFileChooser();
	private FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.obj", "obj");
	private boolean guardado=false;
	private boolean modificado;
	private static Component parentComponent;
	private Modificar modificar;
	private Mostrar mostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
					window.frmDakkar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDakkar = new JFrame();
		frmDakkar.setTitle("Sintitulo");
		frmDakkar.setBounds(100, 100, 450, 300);
		frmDakkar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDakkar.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmDakkar.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mnArchivo.add(mntmNuevo);
		
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			abrir();
			}
		});
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guardado==false){
					guardar();
				}
				if(modificado==true){
				guardar();}
			}
		});
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guardado==false){
					guardarComo();}
					else{
						guardar();
						guardarComo();
					}
			}
		});
		mnArchivo.add(mntmGuardarComo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnArchivo.add(separator_1);
		mnArchivo.add(mntmSalir);
		
		JMenu mnParticipante = new JMenu("Participante");
		menuBar.add(mnParticipante);
		
		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir=new Annadir(inscripcion);
				annadir.setVisible(true);
				
			}
		});
		mnParticipante.add(mntmAadir);
		
		JMenuItem mntmBorrar = new JMenuItem("Borrar");
		mntmBorrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				borrar=new Borrar(inscripcion);
				borrar.setVisible(true);}
			}
		});
		mnParticipante.add(mntmBorrar);
		
		JSeparator separator_2 = new JSeparator();
		mnParticipante.add(separator_2);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				mostrar=new Mostrar(inscripcion);
				mostrar.setVisible(true);}
			}
		});
		mntmMostrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		mnParticipante.add(mntmMostrar);
		
		JSeparator separator_3 = new JSeparator();
		mnParticipante.add(separator_3);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				modificar=new Modificar(inscripcion);
				modificar.setVisible(true);}
			}
		});
		mntmModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		mnParticipante.add(mntmModificar);
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmPorVehiculo = new JMenuItem("Por vehiculo");
		mntmPorVehiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnBuscar.add(mntmPorVehiculo);
		
		JMenuItem mntmPorMarca = new JMenuItem("Por marca");
		mntmPorMarca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnBuscar.add(mntmPorMarca);
		
		JMenuItem mntmPorDorsal = new JMenuItem("Por dorsal");
		mntmPorDorsal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnBuscar.add(mntmPorDorsal);
		
		JMenuItem mntmContarParticipantes = new JMenuItem("Contar participantes");
		mntmContarParticipantes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmContarParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPanel,
						"Hay "+inscripcion.size()+" coches");
				
			}
		});
		
		JSeparator separator_4 = new JSeparator();
		mnBuscar.add(separator_4);
		mnBuscar.add(mntmContarParticipantes);
		
		JMenu mnRally = new JMenu("Rally");
		menuBar.add(mnRally);
		
		JMenuItem mntmAsignarTiempo = new JMenuItem("Asignar Tiempo");
		mnRally.add(mntmAsignarTiempo);
		
		JSeparator separator_5 = new JSeparator();
		mnRally.add(separator_5);
		
		JMenuItem mntmPenalizaciones = new JMenuItem("Penalizaciones");
		mnRally.add(mntmPenalizaciones);
		
		JMenuItem mntmAbandonos = new JMenuItem("Abandonos");
		mnRally.add(mntmAbandonos);
		
		JSeparator separator_6 = new JSeparator();
		mnRally.add(separator_6);
		
		JMenuItem mntmClasificacin = new JMenuItem("Clasificaci\u00F3n");
		mnRally.add(mntmClasificacin);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mntmInstrucciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mnAyuda.add(mntmInstrucciones);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
		mnAyuda.add(mntmAcercaDe);
	}
	void nuevo() {
		if(guardado==true && modificado==true){
		if(sobrescribirFichero()==true){
			try {
				GestionarFicheros.guardarComoFichero(inscripcion, seleccion);
			} catch (IOException e) {
			}
			guardado=false;
			this.inscripcion=new ArrayListDakkar();
			frmDakkar.setTitle("Sin titulo");
		}
		}
		else{
			int valor=quieresGuardarNuevo();
			if(valor==1){
			guardarComo();
			guardado=true;}
			else{if(valor==2){
				this.inscripcion=new ArrayListDakkar();
				frmDakkar.setTitle("Sin titulo");
				return;}
				else{return;}
			}
		}
				
		}
		
			


		private void abrir() {
			try {
				Abrir abrir= new Abrir();
				inscripcion=(ArrayListDakkar)GestionarFicheros.abrirFichero(seleccion);
				guardado=true;
				modificado=false;
				frmDakkar.setTitle(seleccion.getName());
			} catch(ClassNotFoundException | IOException e1){
				JOptionPane.showMessageDialog(parentComponent, e1, "Error.", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		private void guardar() {
			if(guardado==true){
				try {
					if(sobrescribirFichero())
						GestionarFicheros.guardarComoFichero(inscripcion, seleccion);
						guardado=true;
						modificado=false;
				} catch (IOException e) {
					JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				GuardarComo guardarComo = new GuardarComo();
				try {
					if(seleccion != null){
						GestionarFicheros.guardarComoFichero(inscripcion, seleccion);
						guardado=true;
						modificado=false;
					}
					else
						JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
			
			
		
		private void guardarComo() {
			GuardarComo guardarComo = new GuardarComo();
			try {
				if(seleccion != null){
					GestionarFicheros.guardarComoFichero(inscripcion, seleccion);
					guardado=true;
					modificado=false;
					frmDakkar.setTitle(seleccion.getName());
				}
				else
					JOptionPane.showMessageDialog(guardarComo, "Debe indicar el nombre con el que desea guardar el archivo");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(parentComponent, e, "Error.", JOptionPane.ERROR_MESSAGE);
			}	
		
		}

		private static boolean sobrescribirFichero() {
			int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Desea sobreescribir el archivo",
					"Sobrescritura", JOptionPane.YES_NO_OPTION);
			if(eleccion == JOptionPane.YES_OPTION)
				return true;
			else
				return false;
		}
		private static int quieresGuardarNuevo() {
			int eleccion = JOptionPane.showConfirmDialog(parentComponent, "Quieres guardar el archivo, antes de crear un concesionario nuevo?",
					"Sobrescritura", JOptionPane.YES_NO_CANCEL_OPTION);
			if(eleccion == JOptionPane.YES_OPTION)
				return 1;
			else{if(eleccion == JOptionPane.NO_OPTION){
				return 2;}
				else{return 3; }
			}
		}
}
