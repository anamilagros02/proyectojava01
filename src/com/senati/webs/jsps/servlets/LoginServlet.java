// Paquete que contiene este Servlet
package com.senati.webs.jsps.servlets;
// Librerias que emplea el Servlet
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.senati.web.jsps.servlets.vo.VOLogin;

/**
 * Servlet implementation class LoginServlet
 */

// Ruta del servlet
@WebServlet("/loginWeb.jr")
// inicio de la clase
public class LoginServlet extends HttpServlet {
	//Constante 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Constructor
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Metodo DoGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//Metodo doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// obtener el valor del usuario
		String usuario = request.getParameter("usuario");
		// obtener el valor de la clave
		String clave = request.getParameter("clave");

		// si usuario y clave son correctos
		if (usuario.equals("jorge") && clave.equals("123456")){
			VOLogin vo = new VOLogin();
			vo.setUsuario(usuario);
			vo.setClave(clave);
			vo.setNombre("Jorge Luque Chambi");
			vo.setEdad(43);
			System.out.println("Bienvenido " + usuario);
			HttpSession session = request.getSession(true);
			session.setAttribute("usuarioLogueado",vo);
			request.getRequestDispatcher("bienvenida.jsp").forward(request,response);
		}else{
			System.out.println("No tiene acceso");
			//response.sendRedirect("login.html");

		}
	}

}
