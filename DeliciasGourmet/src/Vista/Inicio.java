package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Modelo.Sesion;

public class Inicio extends JFrame {

	int xMouse, yMouse;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setUndecorated(true);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel de encabezado
		JPanel panelHeader = new JPanel();
		panelHeader.setBounds(0, 0, 996, 30);
		panelHeader.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);

		// Listeners para mover la ventana con el mouse
		panelHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		panelHeader.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});

		// Botón de cerrar
		Button btnCerrar = new Button("X");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setBackground(Color.red);
				btnCerrar.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setBackground(Color.white);
				btnCerrar.setForeground(Color.black);
			}
		});
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar.setBackground(Color.white);
		btnCerrar.setBounds(994, 0, 30, 30);
		contentPane.add(btnCerrar);

		JPanel panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(240, 240, 240));
		panelContenedor.setBounds(240, 30, 784, 570);
		contentPane.add(panelContenedor);
		panelContenedor.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -29, 784, 599);
		panelContenedor.add(tabbedPane);

		JPanel panelInicio = new JPanel();
		tabbedPane.addTab("Inicio", null, panelInicio, null);
		panelInicio.setLayout(null);

		JLabel lblInicioPanel = new JLabel("INICIO");
		lblInicioPanel.setFont(new Font("Roboto", Font.BOLD, 25));
		lblInicioPanel.setBounds(351, 255, 77, 31);
		panelInicio.add(lblInicioPanel);

		JPanel panelReservas = new JPanel();
		tabbedPane.addTab("Reservas", null, panelReservas, null);
		panelReservas.setLayout(null);

		JLabel lblReservasPanel = new JLabel("RESERVAS");
		lblReservasPanel.setBounds(329, 255, 123, 31);
		lblReservasPanel.setFont(new Font("Roboto", Font.BOLD, 25));
		panelReservas.add(lblReservasPanel);

		JPanel panelHistorial = new JPanel();
		tabbedPane.addTab("Historial", null, panelHistorial, null);
		panelHistorial.setLayout(null);

		JLabel lblHistorialPanel = new JLabel("HISTORIAL");
		lblHistorialPanel.setBounds(326, 255, 126, 31);
		lblHistorialPanel.setFont(new Font("Roboto", Font.BOLD, 25));
		panelHistorial.add(lblHistorialPanel);

		Perfil perfil = new Perfil();
		JPanel panelPerfil = new JPanel();
		tabbedPane.addTab("Perfil", perfil);
		panelPerfil.setLayout(null);

		JLabel lblPerfillPanel = new JLabel("PERFIL");
		lblPerfillPanel.setBounds(349, 255, 81, 31);
		lblPerfillPanel.setFont(new Font("Roboto", Font.BOLD, 25));
		panelPerfil.add(lblPerfillPanel);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInicio.setBackground(Color.red);
				btnInicio.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnInicio.setBackground(new Color(42, 42, 42));
				btnInicio.setForeground(Color.white);
			}
		});
		btnInicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Roboto Light", Font.BOLD, 17));
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setBackground(new Color(42, 42, 42));
		btnInicio.setBounds(0, 60, 240, 30);
		contentPane.add(btnInicio);

		JButton btnReservas = new JButton("Reservas");
		btnReservas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReservas.setBackground(Color.red);
				btnReservas.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnReservas.setBackground(new Color(42, 42, 42));
				btnReservas.setForeground(Color.white);
			}
		});
		btnReservas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnReservas.setForeground(Color.WHITE);
		btnReservas.setFont(new Font("Roboto Light", Font.BOLD, 17));
		btnReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservas.setBackground(new Color(42, 42, 42));
		btnReservas.setBounds(0, 100, 240, 30);
		contentPane.add(btnReservas);

		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHistorial.setBackground(Color.red);
				btnHistorial.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnHistorial.setBackground(new Color(42, 42, 42));
				btnHistorial.setForeground(Color.white);
			}
		});
		btnHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnHistorial.setForeground(Color.WHITE);
		btnHistorial.setFont(new Font("Roboto Light", Font.BOLD, 17));
		btnHistorial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHistorial.setBackground(new Color(42, 42, 42));
		btnHistorial.setBounds(0, 140, 240, 30);
		contentPane.add(btnHistorial);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPerfil.setBackground(Color.red);
				btnPerfil.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPerfil.setBackground(new Color(42, 42, 42));
				btnPerfil.setForeground(Color.white);
			}
		});
		btnPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
				mostrarPerfil();
			}
		});
		btnPerfil.setFont(new Font("Roboto Light", Font.BOLD, 17));
		btnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPerfil.setBackground(new Color(42, 42, 42));
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setBounds(0, 180, 240, 30);
		contentPane.add(btnPerfil);

		JSeparator separatorBtnMenu = new JSeparator();
		separatorBtnMenu.setBounds(0, 550, 240, 2);
		contentPane.add(separatorBtnMenu);

		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrarSesion.setBackground(Color.red);
				btnCerrarSesion.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(42, 42, 42));
				btnCerrarSesion.setForeground(Color.white);
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Roboto Light", Font.BOLD, 17));
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setBackground(new Color(42, 42, 42));
		btnCerrarSesion.setBounds(0, 560, 240, 30);
		contentPane.add(btnCerrarSesion);

	}

	private void mostrarPerfil() {
		Perfil perfilPanel = new Perfil();

		// Mostrar el perfil en un nuevo JFrame
		JFrame perfilFrame = new JFrame("Perfil");
		perfilFrame.add(perfilPanel);
		perfilFrame.pack();
	}

	public void cerrarSesion() {
		Sesion.cerrarSesion();
		Login login = new Login();
		login.setVisible(true);
		Inicio.this.setVisible(false);
	}

}