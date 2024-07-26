package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {
	
	// Declaración elementos usados en la pantalla
	int xMouse, yMouse;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtRepetirContrasenia;
    private JTextField txtNombre;
    private JPasswordField txtContrasenia;
    private JTextField txtTelefono;
    private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		
		// Configuración de la ventana principal
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setBackground(new Color(255, 255, 255));
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 600);
        
        // Panel principal
        contentPane = new JPanel();
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
        
        // Panel de fondo
        JPanel panelFondo = new JPanel();
        panelFondo.setBackground(Color.DARK_GRAY);
        panelFondo.setBounds(0, 0, 424, 600);
        contentPane.add(panelFondo);
        panelFondo.setLayout(null);
        
        // Imagen de fondo
        JLabel lblImagen = new JLabel("");
        lblImagen.setIcon(new ImageIcon(vLogin.class.getResource("/Img/Fondo.png")));
        lblImagen.setBounds(0, 0, 424, 600);
        panelFondo.add(lblImagen);

        // Panel contenedor
        Panel panelContenedor = new Panel();
        panelContenedor.setBounds(424, 0, 600, 600);
        contentPane.add(panelContenedor);
        panelContenedor.setLayout(null);
        
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
        btnCerrar.setBackground(Color.WHITE);
        btnCerrar.setBounds(575, 0, 25, 27);
        panelContenedor.add(btnCerrar);
        
        // Etiqueta de registro
        Label lblRegistro = new Label("REGISTRO");
        lblRegistro.setFont(new Font("Roboto Light", Font.BOLD, 22));
        lblRegistro.setBounds(235, 40, 130, 35);
        panelContenedor.add(lblRegistro);
        
        // Etiqueta y campo de texto para el nombre
        Label lblNombre = new Label("NOMBRE COMPLETO");
        lblNombre.setFont(new Font("Roboto Light", Font.PLAIN, 18));
        lblNombre.setBounds(200, 107, 200, 25);
        panelContenedor.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBackground(new Color(255, 255, 255));
        txtNombre.setForeground(Color.BLACK);
        txtNombre.setBounds(125, 137, 350, 25);
        txtNombre.setBorder(null);
        panelContenedor.add(txtNombre);

        JSeparator separadorNombre = new JSeparator();
        separadorNombre.setForeground(new Color(0, 0, 0));
        separadorNombre.setBounds(125, 162, 350, 2);
        panelContenedor.add(separadorNombre);
        
        // Etiqueta y campo de texto para el teléfono
        Label lblTelefono = new Label("TELEFONO");
        lblTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 18));
        lblTelefono.setBounds(244, 182, 112, 25);
        panelContenedor.add(lblTelefono);
        
        txtTelefono = new JTextField();
        txtTelefono.setBorder(null);
        txtTelefono.setBounds(125, 212, 350, 25);
        panelContenedor.add(txtTelefono);
        
        JSeparator separadorTelefono = new JSeparator();
        separadorTelefono.setForeground(Color.BLACK);
        separadorTelefono.setBounds(125, 237, 350, 2);
        panelContenedor.add(separadorTelefono);
        
        // Etiqueta y campo de texto para el email
        Label lblEmail = new Label("EMAIL");
        lblEmail.setFont(new Font("Roboto Light", Font.PLAIN, 18));
        lblEmail.setBounds(267, 257, 66, 25);
        panelContenedor.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBorder(null);
        txtEmail.setBounds(125, 287, 350, 25);
        panelContenedor.add(txtEmail);
        
        JSeparator separadorEmail = new JSeparator();
        separadorEmail.setForeground(Color.BLACK);
        separadorEmail.setBounds(125, 312, 350, 2);
        panelContenedor.add(separadorEmail);
        
        // Etiqueta y campo de texto para la contraseña
        Label lblContrasenia = new Label("CONTRASEÑA");
        lblContrasenia.setFont(new Font("Roboto Light", Font.PLAIN, 19));
        lblContrasenia.setBounds(230, 332, 140, 25);
        panelContenedor.add(lblContrasenia);
        
        txtContrasenia = new JPasswordField();
        txtContrasenia.setBorder(null);
        txtContrasenia.setBounds(125, 362, 350, 25);
        panelContenedor.add(txtContrasenia);
        
        JSeparator separadorContrasenia = new JSeparator();
        separadorContrasenia.setForeground(Color.BLACK);
        separadorContrasenia.setBounds(125, 387, 350, 2);
        panelContenedor.add(separadorContrasenia);

        // Etiqueta y campo de texto para repetir la contraseña
        Label lblRepetirContrasenia = new Label("REPETIR CONTRASEÑA");
        lblRepetirContrasenia.setFont(new Font("Roboto Light", Font.PLAIN, 19));
        lblRepetirContrasenia.setBounds(181, 407, 237, 25);
        panelContenedor.add(lblRepetirContrasenia);

        txtRepetirContrasenia = new JPasswordField();
        txtRepetirContrasenia.setBounds(125, 437, 350, 25);
        txtRepetirContrasenia.setBorder(null);
        panelContenedor.add(txtRepetirContrasenia);

        JSeparator separadorRepetirContrasenia = new JSeparator();
        separadorRepetirContrasenia.setForeground(Color.BLACK);
        separadorRepetirContrasenia.setBounds(125, 462, 350, 2);
        panelContenedor.add(separadorRepetirContrasenia);

        // Botón de registro
        Button btnRegistro = new Button("Registrarse");
        btnRegistro.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnRegistro.setBackground(new Color(255, 0, 0));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnRegistro.setBackground(Color.DARK_GRAY);
        	}
        });
        btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setBackground(Color.DARK_GRAY);
        btnRegistro.setBounds(205, 512, 190, 30);
        panelContenedor.add(btnRegistro);
	}
}