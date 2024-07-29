package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.ClienteControlador;
import Modelo.Cliente;
import Modelo.Sesion;

public class Perfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JPasswordField txtContrasenia;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	ClienteControlador controlador = new ClienteControlador();

	/**
	 * Create the frame.
	 */
	public Perfil() {
		setBounds(0, 0, 784, 600);
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 784, 600);
		add(panelContenedor);
		panelContenedor.setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(42, 42, 42));
		panelHeader.setBounds(0, 0, 784, 59);
		panelContenedor.add(panelHeader);
		panelHeader.setLayout(null);

		// Etiqueta y campo de texto para el nombre
		Label lblNombre = new Label("NOMBRE COMPLETO");
		lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 18));
		lblNombre.setBounds(292, 107, 200, 25);
		panelContenedor.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBounds(217, 137, 350, 25);
		txtNombre.setBorder(null);
		panelContenedor.add(txtNombre);

		JSeparator separadorNombre = new JSeparator();
		separadorNombre.setForeground(Color.BLACK);
		separadorNombre.setBounds(217, 162, 350, 2);
		panelContenedor.add(separadorNombre);

		// Etiqueta y campo de texto para el teléfono
		Label lblTelefono = new Label("TELEFONO");
		lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 18));
		lblTelefono.setBounds(336, 182, 112, 25);
		panelContenedor.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(217, 212, 350, 25);
		panelContenedor.add(txtTelefono);

		JSeparator separadorTelefono = new JSeparator();
		separadorTelefono.setForeground(Color.BLACK);
		separadorTelefono.setBounds(217, 237, 350, 2);
		panelContenedor.add(separadorTelefono);

		// Etiqueta y campo de texto para el email
		Label lblEmail = new Label("EMAIL");
		lblEmail.setFont(new Font("Roboto Light", Font.PLAIN, 18));
		lblEmail.setBounds(359, 257, 66, 25);
		panelContenedor.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBounds(217, 287, 350, 25);
		panelContenedor.add(txtEmail);

		JSeparator separadorEmail = new JSeparator();
		separadorEmail.setForeground(Color.BLACK);
		separadorEmail.setBounds(217, 312, 350, 2);
		panelContenedor.add(separadorEmail);

		// Etiqueta y campo de texto para la contraseña
		Label lblContrasenia = new Label("CONTRASEÑA");
		lblContrasenia.setFont(new Font("Roboto Light", Font.PLAIN, 19));
		lblContrasenia.setBounds(322, 332, 140, 25);
		panelContenedor.add(lblContrasenia);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setEditable(false);
		txtContrasenia.setBorder(null);
		txtContrasenia.setBounds(217, 362, 350, 25);
		panelContenedor.add(txtContrasenia);

		JSeparator separadorContrasenia = new JSeparator();
		separadorContrasenia.setForeground(Color.BLACK);
		separadorContrasenia.setBounds(217, 387, 350, 2);
		panelContenedor.add(separadorContrasenia);

		JLabel lblDatosPersonales = new JLabel("DATOS PERSONALES");
		lblDatosPersonales.setBounds(273, 14, 238, 31);
		lblDatosPersonales.setForeground(Color.WHITE);
		lblDatosPersonales.setFont(new Font("Roboto", Font.PLAIN, 25));
		panelHeader.add(lblDatosPersonales);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnActualizar.setBackground(Color.RED);
				btnActualizar.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnActualizar.setBackground(new Color(42, 42, 42));
				btnActualizar.setForeground(Color.WHITE);
			}
		});
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = Sesion.getClienteActual();
				if (cliente != null) {
					cliente.setTelefono(txtTelefono.getText());
					cliente.setEmail(txtEmail.getText());
					if (controlador.actualizarCliente(cliente)) {
						JOptionPane.showMessageDialog(Perfil.this, "Actualización exitosa!", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						actualizarDatos();
					} else {
						JOptionPane.showMessageDialog(Perfil.this, "Error al actualizar!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(Perfil.this, "Cliente no encontrado en la sesión.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Roboto Light", Font.BOLD, 17));
		btnActualizar.setBackground(new Color(42, 42, 42));
		btnActualizar.setBounds(272, 476, 240, 30);
		panelContenedor.add(btnActualizar);

		actualizarDatos();
	}

	public void actualizarDatos() {
		Cliente cliente = Sesion.getClienteActual();
		if (cliente != null) {
			txtNombre.setText(cliente.getNombre());
			txtTelefono.setText(cliente.getTelefono());
			txtEmail.setText(cliente.getEmail());
			txtContrasenia.setText(cliente.getContrasenia());
		}
	}
}