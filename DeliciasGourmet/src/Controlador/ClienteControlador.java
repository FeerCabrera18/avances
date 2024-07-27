package Controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import Modelo.Cliente;

public class ClienteControlador {
	Conexion cx;
	
	public ClienteControlador() {
		 cx = new Conexion();
	}
	
	// Funcion para registrar clientes
	public boolean insertarCliente(Cliente cliente) {
		PreparedStatement ps = null;
		
		try {
			ps = cx.conectar().prepareStatement("INSERT INTO Cliente VALUES(null, ?, ?, ?,?)");
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getTelefono());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, convertirSHA256(cliente.getContrasenia()));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Funcion para iniciar sesion
	public boolean iniciarSesion(String email, String contrasenia) {
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = cx.conectar().prepareStatement("SELECT contrasenia FROM Cliente WHERE email = ?");
	        ps.setString(1, email);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            String contraseniaCifrada = rs.getString("contrasenia");
	            String contraseniaIngresada = convertirSHA256(contrasenia);
	            return contraseniaCifrada.equals(contraseniaIngresada);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}

	
	// Funcion para cifrar contraseñas
		public String convertirSHA256(String contrasenia) {
			MessageDigest md = null;

			try {
				md = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}

			byte[] hash = md.digest(contrasenia.getBytes());
			StringBuffer sb = new StringBuffer();

			for (byte b : hash) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		}
}
