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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

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
	private MostrarCoches mostrarCoches;
	private MostrarMoto mostrarMoto;
	private MostrarCamiones mostrarCamiones;
	private BuscarCategoriaCoches buscarCategoriaCoches;
	private BuscarCategoriaMotos buscarCategoriaMotos;
	private BuscarClaseCamiones buscarClaseCamiones;
	private EjecutarEtapa ejecutarEtapa;
	private Abandonar abandonar;
	private Repostar repostar;
	private Acercade acerca;
	private Instrucciones instrucciones;
	
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
		frmDakkar.setResizable(false);
		frmDakkar.setTitle("Sintitulo");
		frmDakkar.setBounds(100, 100, 606, 410);
		frmDakkar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDakkar.getContentPane().setLayout(null);
		
		JLabel lblRallyDakkar = new JLabel("Gesti\u00F3n Rally Dakkar - David Peralvo");
		lblRallyDakkar.setForeground(Color.WHITE);
		lblRallyDakkar.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblRallyDakkar.setBounds(80, 289, 520, 84);
		frmDakkar.getContentPane().add(lblRallyDakkar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\David Peralvo\\workspace\\proyectoFinal\\imagenes\\Dakar-etape-11-Des-podiums-chamboules_articlethumbnail.jpg"));
		lblNewLabel.setBounds(0, -11, 604, 372);
		frmDakkar.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frmDakkar.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
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
		mnParticipante.setMnemonic('p');
		menuBar.add(mnParticipante);
		
		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadir=new Annadir(inscripcion);
				annadir.setVisible(true);
				modificado=true;
				
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
				modificado=true;
			}
		});
		mnParticipante.add(mntmBorrar);
		
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
				modificado=true;
			}
		});
		mntmModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		mnParticipante.add(mntmModificar);
		
		JSeparator separator_7 = new JSeparator();
		mnParticipante.add(separator_7);
		
		JMenuItem mntmContarParticipantes = new JMenuItem("Contar participantes");
		mnParticipante.add(mntmContarParticipantes);
		mntmContarParticipantes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmContarParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPanel,
						"Hay "+inscripcion.size()+" veh\u00EDculo");
				
			}
		});
		
		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('b');
		menuBar.add(mnBuscar);
		
		JMenu mnPorVehiculo = new JMenu("Por veh\u00EDculo");
		mnBuscar.add(mnPorVehiculo);
		
		JMenuItem mntmCoche = new JMenuItem("Coche");
		mntmCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.SHIFT_MASK));
		mntmCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				mostrarCoches=new MostrarCoches(inscripcion);
				mostrarCoches.setVisible(true);
				}
				
				
			}
		});
		mnPorVehiculo.add(mntmCoche);
		
		JMenuItem mntmMoto = new JMenuItem("Moto");
		mntmMoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.SHIFT_MASK));
		mntmMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				mostrarMoto=new MostrarMoto(inscripcion);
				mostrarMoto.setVisible(true);
				}
				
				
			}
		});
		mnPorVehiculo.add(mntmMoto);
		
		JMenuItem mntmCamin = new JMenuItem("Cami\u00F3n");
		mntmCamin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.SHIFT_MASK));
		mntmCamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				mostrarCamiones=new MostrarCamiones(inscripcion);
				mostrarCamiones.setVisible(true);}
			}
		});
		mnPorVehiculo.add(mntmCamin);
		
		JMenu mnPorCategoriaclase = new JMenu("Por categoria/clase");
		mnBuscar.add(mnPorCategoriaclase);
		
		JMenuItem mntmCategoriaDeCoches = new JMenuItem("Categoria de Coches");
		mntmCategoriaDeCoches.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmCategoriaDeCoches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				buscarCategoriaCoches=new BuscarCategoriaCoches(inscripcion);
				buscarCategoriaCoches.setVisible(true);}
			}
		});
		mnPorCategoriaclase.add(mntmCategoriaDeCoches);
		
		JMenuItem mntmCategoriaDeMotos = new JMenuItem("Categoria de Motos");
		mntmCategoriaDeMotos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmCategoriaDeMotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				buscarCategoriaMotos=new BuscarCategoriaMotos(inscripcion);
				buscarCategoriaMotos.setVisible(true);}
			}
		});
		mnPorCategoriaclase.add(mntmCategoriaDeMotos);
		
		JMenuItem mntmClaseDeCamiones = new JMenuItem("Clase de Camiones");
		mntmClaseDeCamiones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmClaseDeCamiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				buscarClaseCamiones=new BuscarClaseCamiones(inscripcion);
				buscarClaseCamiones.setVisible(true);}
				
			}
		});
		mnPorCategoriaclase.add(mntmClaseDeCamiones);
		
		JSeparator separator_2 = new JSeparator();
		mnBuscar.add(separator_2);
		
		JMenuItem mntmMostrar = new JMenuItem("Lista de Inscritos");
		mnBuscar.add(mntmMostrar);
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
		
		JSeparator separator_4 = new JSeparator();
		mnBuscar.add(separator_4);
		
		JMenu mnRally = new JMenu("Rally");
		mnRally.setMnemonic('r');
		menuBar.add(mnRally);
		
		JMenuItem mntmAsignarTiempo = new JMenuItem("Ejecutar etapa");
		mntmAsignarTiempo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmAsignarTiempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				ejecutarEtapa=new EjecutarEtapa(inscripcion);
				ejecutarEtapa.setVisible(true);}
				modificado=true;
				
			}
		});
		mnRally.add(mntmAsignarTiempo);
		
		JSeparator separator_5 = new JSeparator();
		mnRally.add(separator_5);
		
		JMenuItem mntmAbandonos = new JMenuItem("Abandonos");
		mntmAbandonos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmAbandonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				abandonar=new Abandonar(inscripcion);
				abandonar.setVisible(true);
				}
				modificado=true;
			}
		});
		mnRally.add(mntmAbandonos);
		
		JMenuItem mntmClasificacin = new JMenuItem("Repostar");
		mntmClasificacin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmClasificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inscripcion.size()==0){
					JOptionPane.showMessageDialog(contentPanel,
							"No hay vehiculos inscritos", "Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				repostar=new Repostar(inscripcion);
				repostar.setVisible(true);}
				modificado=true;
			}
		});
		
		JSeparator separator_6 = new JSeparator();
		mnRally.add(separator_6);
		mnRally.add(mntmClasificacin);
		
		JMenu mnAyuda = new JMenu("Help");
		mnAyuda.setMnemonic('h');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mntmInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instrucciones=new Instrucciones();
				instrucciones.setVisible(true);
			}
		});
		mntmInstrucciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mnAyuda.add(mntmInstrucciones);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			acerca=new Acercade();
			acerca.setVisible(true);}
		});
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
