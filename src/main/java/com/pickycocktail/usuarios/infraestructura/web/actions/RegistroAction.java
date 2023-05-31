package com.pickycocktail.usuarios.infraestructura.web.actions;

import static com.pickycocktail.usuarios.infraestructura.web.actions.Util.isNotEmpty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pickycocktail.usuarios.application.service.UsuarioService;
import com.pickycocktail.usuarios.dominio.model.Usuario;

@Component
public class RegistroAction implements Action {
	
	@Autowired
	private UsuarioService neg;

	@Override
	public String get(String path, HttpServletRequest req, HttpServletResponse resp) {
		return path;
	}

	@Override
	public String post(String path, HttpServletRequest req, HttpServletResponse resp) {
		String nombreP = req.getParameter("nombre");
		String usuarioP = req.getParameter("usuario");
		String emailP = req.getParameter("email");
		String passwordP = req.getParameter("password");
		String password2P = req.getParameter("password-bis");
		
		req.setAttribute("nombre", nombreP);
		req.setAttribute("usuario", usuarioP);
		
		HttpSession sesion = req.getSession();
		
		String vista;
		
		if (isNotEmpty(nombreP) && isNotEmpty(usuarioP) && isNotEmpty(passwordP) && isNotEmpty(password2P)) {
			
			if (passwordP.equals(password2P)) {
				
				Usuario nuevo = new Usuario(nombreP, usuarioP, passwordP, emailP);
				
				if(neg.crearUsuario(nuevo) != null) {
					vista = "redirect:registro_ok";
				} else {
					sesion.setAttribute("error", "ya_existe");
					vista = "redirect:" + path;
				}
			} else {
				sesion.setAttribute("error", "no_match_pwd");
				vista = "redirect:" + path;
			}
		} else {
			sesion.setAttribute("error", "campos_vacios");
			vista = "redirect:" + path;
		}
		return vista;
	}

}
