package com.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.GestionProduitImp;
import dao.GestionUserImp;
import dao.IGestionUser;
import dao.User;
@WebServlet(urlPatterns = { "/pagelogin","/login"})
/**
 * Servlet implementation class ServletAuthentification
 */
public class ServletAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuthentification() {
        super();
        // TODO Auto-generated constructor stub
    }
    IGestionUser gestionU;
    
    
    public void init() throws ServletException {
    gestionU=new GestionUserImp();	
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
         if (path.equals("/pagelogin")) {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		 if (path.equals("/login")) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				User u = new User(email,password);
				String res = gestionU.verification(u);
				if ( res != "")
				{
					HttpSession session = request.getSession(true);
					session.setAttribute("username", res);
					response.sendRedirect(request.getContextPath()+"/listeproduits");
					
				}
				else
				{
					request.setAttribute("errerr", "login ou mot de passe incorrecte ");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}
	}

}
