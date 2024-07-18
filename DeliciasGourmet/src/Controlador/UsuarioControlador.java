package Controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.Usuario;

public class UsuarioControlador {
	Conexion cx;

	public UsuarioControlador() {
		cx = new Conexion();
	}

	// Funcion para insertar usuario en base de datos
	public boolean insertarUsuario(Usuario usuario) {
		PreparedStatement ps = null;

		try {
			ps = cx.conectar().prepareStatement("INSERT INTO usuario VALUES(null,?,?,?)");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, convertirSHA256(usuario.getContrasenia()));
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = cx.conectar().prepareStatement("SELECT * FROM usuario");
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				lista.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
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