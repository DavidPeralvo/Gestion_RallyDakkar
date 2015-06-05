package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.ArrayListDakkar;
import proyecto.DorsalNoValidoException;
import proyecto.vehiculoNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Borrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Dorsal;


	public Borrar(final ArrayListDakkar inscripcion) {
		setTitle("Borrar vehiculo");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField_Dorsal = new JTextField();
		
		textField_Dorsal.setBounds(206, 119, 86, 20);
		contentPanel.add(textField_Dorsal);
		textField_Dorsal.setColumns(10);
		
		JLabel lblIntroduzcaElDorsal = new JLabel("Introduzca el dorsal para borrar la inscripcion:");
		lblIntroduzcaElDorsal.setBounds(41, 94, 327, 14);
		contentPanel.add(lblIntroduzcaElDorsal);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Borrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try {
								inscripcion.borrarVehiculo(textField_Dorsal.getText());
								JOptionPane.showMessageDialog(contentPanel,"Vehículo borrado con \u00e9xito.");
							} catch (DorsalNoValidoException | vehiculoNoExisteException e1) {
								JOptionPane.showMessageDialog(contentPanel,
										e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
							}
							
						}
					});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
