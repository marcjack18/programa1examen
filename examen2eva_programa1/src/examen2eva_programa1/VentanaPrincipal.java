//Marcos Pallas Perez
package examen2eva_programa1;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.regex.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal {
	HashMap<String,Integer> agenda_telf=new HashMap<>();
	
	String nombre="";
	String telefono="";
	
	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private JTextField textFieldNombreBuscar;
	private JTextField textFieldNombreBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 665, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(75, 33, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(75, 75, 70, 15);
		frame.getContentPane().add(lblTelefono);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(165, 31, 114, 19);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(165, 73, 114, 19);
		frame.getContentPane().add(textFieldTelefono);
		
		
		JTextArea textAreaMostrar = new JTextArea();
		textAreaMostrar.setEditable(false);
		textAreaMostrar.setBounds(364, 75, 289, 179);
		frame.getContentPane().add(textAreaMostrar);
		
		JLabel lblIntroduceNombreA = new JLabel("Introduce nombre a buscar:");
		lblIntroduceNombreA.setBounds(75, 289, 206, 15);
		frame.getContentPane().add(lblIntroduceNombreA);
		
		JLabel lblIntroduceNombreA_2 = new JLabel("Introduce nombre a borrar:");
		lblIntroduceNombreA_2.setBounds(75, 377, 206, 15);
		frame.getContentPane().add(lblIntroduceNombreA_2);
		
		JLabel lblSuNmeroEs = new JLabel("Su número es:");
		lblSuNmeroEs.setBounds(112, 329, 114, 15);
		frame.getContentPane().add(lblSuNmeroEs);
		
		textFieldNombreBuscar = new JTextField();
		textFieldNombreBuscar.setBounds(316, 287, 114, 19);
		frame.getContentPane().add(textFieldNombreBuscar);
		textFieldNombreBuscar.setColumns(10);
		
		JLabel lblTelefonoBusqueda = new JLabel("");
		lblTelefonoBusqueda.setBounds(316, 329, 114, 15);
		frame.getContentPane().add(lblTelefonoBusqueda);
		
		textFieldNombreBorrar = new JTextField();
		textFieldNombreBorrar.addMouseListener(new MouseAdapter() {
		});
		textFieldNombreBorrar.setColumns(10);
		textFieldNombreBorrar.setBounds(316, 375, 114, 19);
		frame.getContentPane().add(textFieldNombreBorrar);
		
	
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombre=textFieldNombreBuscar.getText();
				
				for(String nom:agenda_telf.keySet()) {
					if(nombre.equals(nom)) {
						lblTelefonoBusqueda.setText(String.valueOf(agenda_telf.get(nom)));
					}else {
						lblTelefonoBusqueda.setText(" ");
					}
				}
				
			}
		});
		btnBuscar.setBounds(472, 284, 117, 25);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombre=textFieldNombreBorrar.getText();
				
				for(String nom:agenda_telf.keySet()) {
					if(nombre.equals(nom)) {
						agenda_telf.remove(nom);
						lblTelefonoBusqueda.setText(" ");
					}
				}
			}
		});
		btnBorrar.setBounds(472, 372, 117, 25);
		frame.getContentPane().add(btnBorrar);
		
		
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombre=textFieldNombre.getText();
				telefono=textFieldTelefono.getText();
				Pattern movil=Pattern.compile("^[67]\\d{8}");
				Matcher mat=movil.matcher(telefono);
				Pattern nomb=Pattern.compile("^[A-Z]\\w+[a-z]");
				Matcher mat2=nomb.matcher(nombre);
				if(mat.matches()&&mat2.matches()) {
				agenda_telf.put(nombre, Integer.parseInt(telefono));
				}else {
					JOptionPane.showMessageDialog(null, "TELEFONO O NOMBRE INCORRECETO");
				}
				
				
			}
		});
		btnAgregar.setBounds(162, 118, 117, 25);
		frame.getContentPane().add(btnAgregar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaMostrar.setText("");
				for(String nom:agenda_telf.keySet()) {
					textAreaMostrar.setText(textAreaMostrar.getText() +"\nNombre del cliente " + nom + " \nNumero de telefono: " + agenda_telf.get(nom) + " \n");
				}
				
			}
		});
		btnMostrar.setBounds(418, 28, 117, 25);
		frame.getContentPane().add(btnMostrar);
	}
}
