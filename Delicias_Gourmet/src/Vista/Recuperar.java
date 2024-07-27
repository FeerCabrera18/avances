package Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Recuperar extends JFrame {

	private static final long serialVersionUID = 1L;
	int xMouse, yMouse;
	private JPanel contentPane;
	private JTextField txtEmail;
	
	/**
	 * Create the frame.
	 */
	public Recuperar() {
		// Configuración de la ventana principal
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		
		// Creación del panel de contenido
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel de encabezado para mover la ventana
        JPanel panelHeader = new JPanel();
        panelHeader.setBounds(0, 0, 570, 30);
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
        
        // Botón para cerrar la ventana y volver al login
        Button btnVolver = new Button("X");
        btnVolver.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnVolver.setBackground(Color.red);
        		btnVolver.setForeground(Color.white);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnVolver.setBackground(Color.white);
        		btnVolver.setForeground(Color.black);
        	}
        });
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login login = new Login();
        		login.setVisible(true);
        		Recuperar.this.setVisible(false);
        	}
        });
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setBackground(Color.DARK_GRAY);
		btnVolver.setBounds(570, 0, 30, 30);
		contentPane.add(btnVolver);
		
		// Etiqueta para el título de la ventana
		JLabel lblRecuperar = new JLabel("RECUPERAR CONTRASEÑA");
		lblRecuperar.setFont(new Font("Roboto Light", Font.BOLD, 18));
		lblRecuperar.setBounds(177, 43, 229, 22);
		contentPane.add(lblRecuperar);
		
		// Texto de instrucciones para recuperar la contraseña
		JTextPane txtpnParaRecuperarSu = new JTextPane();
		txtpnParaRecuperarSu.setForeground(Color.BLACK);
		txtpnParaRecuperarSu.setBackground(new Color(240, 240, 240));
		txtpnParaRecuperarSu.setEditable(false);
		txtpnParaRecuperarSu.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		txtpnParaRecuperarSu.setText("Para recuperar su contraseña, ingrese el mail con el que se registro en el siguiente campo");
		txtpnParaRecuperarSu.setBounds(138, 76, 307, 49);
		contentPane.add(txtpnParaRecuperarSu);
		
		// Etiqueta y campo de correo electrónico
		Label lblEmail = new Label("CORREO");
		lblEmail.setFont(new Font("Roboto Light", Font.PLAIN, 19));
		lblEmail.setBounds(247, 150, 90, 30);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBounds(117, 190, 350, 30);
		contentPane.add(txtEmail);
		
		JSeparator separadorEmail = new JSeparator();
		separadorEmail.setForeground(Color.BLACK);
		separadorEmail.setBounds(117, 220, 350, 2);
		contentPane.add(separadorEmail);
		
		// Botón para enviar el correo de recuperación
		Button btnEnviar = new Button("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Enviar correo de recuperación de contraseña
			}
		});
		btnEnviar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnEnviar.setBackground(new Color(255, 0, 0));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnEnviar.setBackground(Color.DARK_GRAY);
        	}
        });
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setBackground(Color.DARK_GRAY);
		btnEnviar.setBounds(212, 284, 160, 30);
		contentPane.add(btnEnviar);
	}
}