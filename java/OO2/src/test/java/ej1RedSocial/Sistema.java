package ej1RedSocial;

import java.util.List;


public class Sistema {
	private List<Usuario> usuarios;
	
	public void eliminarUsuario(Usuario usu) {
		usu.eliminarMensajes();
		usuarios.remove(usu);
	}
	public boolean agregarUsuario(String screenname) {
		if (usuarios.isEmpty() || usuarios.stream()
				.anyMatch(u->u.getNombre().equals(screenname))
				) {
			return false;
		}
		usuarios.add(new Usuario(screenname));
		return true;
	}
}
