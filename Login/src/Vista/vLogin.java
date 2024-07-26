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
import javax.swing.JButton;
import java.awt.SystemColor;

public class vLogin extends JFrame {

    int xMouse, yMouse;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField txtContrasenia;
    private JTextField txtUsuario;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    vLogin frame = new vLogin();
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
    public vLogin() {
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
        btnCerrar.setBackground(Color.white);
        btnCerrar.setBounds(575, 0, 25, 27);
        panelContenedor.add(btnCerrar);

        // Etiqueta de iniciar sesión
        Label lblIniciarSesion = new Label("INICIAR SESIÓN");
        lblIniciarSesion.setFont(new Font("Roboto Light", Font.BOLD, 22));
        lblIniciarSesion.setBounds(214, 90, 171, 35);
        panelContenedor.add(lblIniciarSesion);

        // Etiqueta y campo de texto para el usuario
        Label lblUsuario = new Label("USUARIO");
        lblUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 19));
        lblUsuario.setBounds(255, 172, 90, 30);
        panelContenedor.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(125, 212, 350, 30);
        txtUsuario.setBorder(null);
        panelContenedor.add(txtUsuario);

        JSeparator separadorUsuario = new JSeparator();
        separadorUsuario.setForeground(new Color(0, 0, 0));
        separadorUsuario.setBounds(125, 242, 350, 2);
        panelContenedor.add(separadorUsuario);

        // Etiqueta y campo de texto para la contraseña
        Label lblContrasenia = new Label("CONTRASEÑA");
        lblContrasenia.setFont(new Font("Roboto Light", Font.PLAIN, 19));
        lblContrasenia.setBounds(230, 262, 140, 30);
        panelContenedor.add(lblContrasenia);

        txtContrasenia = new JPasswordField();
        txtContrasenia.setBounds(125, 302, 350, 30);
        txtContrasenia.setBorder(null);
        panelContenedor.add(txtContrasenia);

        JSeparator separadorContrasenia = new JSeparator();
        separadorContrasenia.setForeground(Color.BLACK);
        separadorContrasenia.setBounds(125, 332, 350, 2);
        panelContenedor.add(separadorContrasenia);

        // Botón de iniciar sesión
        Button btnLogin = new Button("Iniciar sesión");
        btnLogin.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnLogin.setBackground(Color.blue);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnLogin.setBackground(Color.DARK_GRAY);
        	}
        });
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnLogin.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(Color.DARK_GRAY);
        btnLogin.setBounds(205, 382, 190, 30);
        panelContenedor.add(btnLogin);

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
            	Registro registro  = new Registro();
            	registro.setVisible(true);
            	vLogin.this.setVisible(false);
            }
        });
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setFont(new Font("Roboto Light", Font.PLAIN, 16));
        btnRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegistro.setBackground(Color.DARK_GRAY);
        btnRegistro.setBounds(220, 449, 160, 30);
        panelContenedor.add(btnRegistro);
        
        JLabel lblRecuperar = new JLabel("Olvidaste tu contraseña ");
        lblRecuperar.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        lblRecuperar.setBounds(176, 570, 160, 20);
        panelContenedor.add(lblRecuperar);
        
        
        Button btnRecuperar = new Button("Recuperar");
        btnRecuperar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnRecuperar.setBackground(new Color(255, 0, 0));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnRecuperar.setBackground(Color.DARK_GRAY);
        	}
        });
        btnRecuperar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Recuperar recuperar = new Recuperar();
        		recuperar.setVisible(true);
        		vLogin.this.setVisible(false);
        	}
        });
        btnRecuperar.setForeground(Color.WHITE);
        btnRecuperar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
        btnRecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRecuperar.setBackground(Color.DARK_GRAY);
        btnRecuperar.setBounds(334, 569, 107, 20);
        panelContenedor.add(btnRecuperar);
    }
}