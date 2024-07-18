package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.UsuarioControlador;
import Modelo.Usuario;

public class vUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTable tblUsuario;

	UsuarioControlador controlador = new UsuarioControlador();

	DefaultTableModel modelo = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	ArrayList<Usuario> lista;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vUsuario frame = new vUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("Id: ");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Arial", Font.BOLD, 14));
		lblId.setBounds(53, 71, 21, 17);
		contentPane.add(lblId);

		JLabel lbl = new JLabel("0");
		lbl.setHorizontalAlignment(SwingConstants.LEFT);
		lbl.setFont(new Font("Arial", Font.BOLD, 14));
		lbl.setBounds(130, 71, 8, 17);
		contentPane.add(lbl);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(194, 71, 63, 17);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(313, 71, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsuario.setBounds(455, 71, 62, 17);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(573, 70, 86, 20);
		contentPane.add(txtUsuario);

		JLabel lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasena.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasena.setBounds(715, 71, 89, 17);
		contentPane.add(lblContrasena);

		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(860, 70, 86, 20);
		contentPane.add(txtContrasena);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtNombre.getText().equals("") || txtUsuario.getText().equals("")
							|| txtContrasena.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
						return;
					} else {
						Usuario usuario = new Usuario();
						usuario.setNombre(txtNombre.getText());
						usuario.setUsuario(txtUsuario.getText());
						usuario.setContrasenia(txtContrasena.getText());
						if (controlador.insertarUsuario(usuario)) {
							actualizarTabla();
							limpiarCampos();
							JOptionPane.showMessageDialog(null, "Usuario agregado correctamente!");
						} else {
							JOptionPane.showMessageDialog(null, "Error al agregar usuario.");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		btnAgregar.setBounds(121, 120, 100, 23);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(342, 120, 100, 23);
		contentPane.add(btnEliminar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnActualizar.setBounds(563, 120, 100, 23);
		contentPane.add(btnActualizar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(784, 120, 100, 23);
		contentPane.add(btnLimpiar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 988, 371);
		contentPane.add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.setModel(modelo);
		modelo.setColumnIdentifiers(new Object[] { "ID", "Nombre", "Usuario", "Contraseña" });
		scrollPane.setViewportView(tblUsuario);
		actualizarTabla();
	}

	public void actualizarTabla() {
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		lista = controlador.listarUsuarios();
		for (Usuario u : lista) {
			Object[] usuario = new Object[4];
			usuario[0] = u.getId();
			usuario[1] = u.getNombre();
			usuario[2] = u.getUsuario();
			usuario[3] = u.getContrasenia();
			modelo.addRow(usuario);
		}
		tblUsuario.setModel(modelo);
	}

	public void limpiarCampos() {
		txtNombre.setText("");
		txtUsuario.setText("");
		txtContrasena.setText("");
	}
}
