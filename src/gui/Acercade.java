package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acercade extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public Acercade() {
		setModal(true);
		setTitle("Acerca de");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnGestinRallyDakkar = new JTextPane();
		txtpnGestinRallyDakkar.setEditable(false);
		txtpnGestinRallyDakkar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnGestinRallyDakkar.setBackground(Color.WHITE);
		txtpnGestinRallyDakkar.setText("Gesti\u00F3n Rally Dakkar, realizado por David Peralvo G\u00F3mez.\r\nQued\u00E1n reservados todos los derechos sobre este software.\r\n\r\nVersi\u00F3n de Java 7.\r\n\r\nVersi\u00F3n de software: 1.0");
		txtpnGestinRallyDakkar.setBounds(10, 11, 373, 145);
		contentPanel.add(txtpnGestinRallyDakkar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
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
