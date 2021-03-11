package com.senati.webs.jsps.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senati.web.jsps.servlets.vo.VOLogin;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/adminUsuarios.servlet")
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// Recibiendo el parametro de la accion
		String accion = request.getParameter("accion");
		// Mostrando la accion recibida
		System.out.println("Accion es: " + accion);
		//Creando una lista de objetos
		List<VOLogin> lista = (List<VOLogin>)request.getSession().getAttribute("listaUsuario");
		//objeto vo de la clase VOLogin
		VOLogin vo = new VOLogin();
		//Asignando los valores del formulario al objeto
		vo.setUsuario(request.getParameter("usuario"));
		vo.setClave(request.getParameter("clave"));
		vo.setNombre(request.getParameter("nombre"));
		vo.setEdad(Integer.parseInt(request.getParameter("edad")));
		//si la accion guardar
		if (accion.equals("guardar")) {
			lista.add(vo);
			//de lo contrario si la accion es actualizar
		}else if(accion.equals("actualizar")) {
			// Lectura de cada registro
			for (VOLogin obj : lista) {
				// Comparando si el usuario que esta buscando ha sido encontrado
				if(obj.getUsuario().contentEquals(vo.getUsuario())) {
					//actualiza la lista
					obj.setClave(vo.getClave());
					obj.setNombre(vo.getNombre());
					obj.setEdad(vo.getEdad());
				}
			}//de lo contrario si la accion es eliminar
		}else if(accion.equals("eliminar")) {
			// lectura de cada registro
			for (VOLogin obj:lista) {
				//si hay coincidencia
				if (obj.getUsuario().equals(vo.getUsuario())) {
					//remover el registro de la lista
					lista.remove(obj);
				}
			}
		}
		response.sendRedirect("usuarios/usuarios.jsp");
	}

}
