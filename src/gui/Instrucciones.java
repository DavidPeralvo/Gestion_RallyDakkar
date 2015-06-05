package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instrucciones extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public Instrucciones() {
		setTitle("Instrucciones");
		setBounds(100, 100, 606, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 570, 328);
			contentPanel.add(scrollPane);
			{
				JTextPane txtpnInstruccionesDeUso = new JTextPane();
				txtpnInstruccionesDeUso.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtpnInstruccionesDeUso.setContentType("html\r\n");
				txtpnInstruccionesDeUso.setEditable(false);
				scrollPane.setViewportView(txtpnInstruccionesDeUso);
				txtpnInstruccionesDeUso.setText("Instrucciones de uso:\r\n\r\n1.A\u00F1adir veh\u00EDculo: para a\u00F1adir vehiculo es necesario cumplimentar todos los campos, es muy importante introducir bien el dorsal que es un n\u00FAmero que va desde 0000 al 9999.\r\n\r\n2.Borrar veh\u00EDculo: Para dar de baja una inscripci\u00F3n solo hay que introducir de foma correcta la matricula en el campo disponible y hacer click en borrar.\r\n\r\n3.Modificar veh\u00EDculo: Podemos realizar modificaciones de todos los campos de la inscripci\u00F3n excepto del dorsal ya que es unico por participante.\r\n\r\n4.Contar participantes: Nos permite saber el n\u00FAmero de participantes que tiene el rally, solo debemos hacer click en la opci\u00F3n y automaticamente nos devuelve el n\u00FAmero.\r\n\r\n5.Buscar por veh\u00EDculo: Permite listar los veh\u00EDculos seg\u00FAn si son : coches, motos o camiones.\r\n\r\n6.Buscar por categorias: Permite profundizar m\u00E1s la busqueda vehiculos ya que podemos elegir en que categoria est\u00E1n compitiendo.\r\n\r\n7.Lista de inscritos: Sirve para listar todos los participantes del rally, solo debemos hacer click y nos muestra todos los veh\u00EDculos con sus caracter\u00EDsticas.\r\n\r\n8.Ejecutar etapa: Una vez inscritos los pilotos con sus veh\u00EDculos, esta opci\u00F3n nos permite simular el gasto de combustible que tiene cada veh\u00EDculo dependiendo de su clase.\r\n\r\n9.Abandonos: Este apartado sirve para gestionar los abandonos de los vehiculos que deseemos y devolverlos a la competici\u00F3n cuando se quiera.Importante si un veh\u00EDculo ha abandonado no puede realizar una etapa.\r\n\r\n10. Repostar: Como su nombre indica permite repostar a los veh\u00EDculos que han ejecutado una etapa, cuando un veh\u00EDculo est\u00E1 lleno de combustible no puede ser repostado hasta que no consuma combustible.\r\n");
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					 setVisible(false);}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
