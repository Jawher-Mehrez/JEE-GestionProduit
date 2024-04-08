package com.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.GestionProduitImp;
import dao.IGestionProduit;
import dao.Produit;
@WebServlet(urlPatterns = { "/addProduit","/suppProduit","/modifProduit","/findProduit"})

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    IGestionProduit gestion;
    
    
    public void init() throws ServletException {
    gestion=new GestionProduitImp();	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path =request.getServletPath();
		if(path.equals("/listeproduits")) {
		List<Produit> liste =gestion.getAllProduits();
		request.setAttribute("listeP", liste);
		request.getRequestDispatcher("vue5.jsp").forward(request, response);
		}else if (path.equals("/addProduit")) {
			
			request.getRequestDispatcher("ajout.jsp").forward(request, response);
			
		}
		else if(path.equals("/suppProduit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			gestion.supprimeProduit(id);
			response.sendRedirect(request.getContextPath()+"/listeproduits");
			
		}
		else if (path.equals("/modifProduit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("produit", gestion.rechercherParId(id));
			request.getRequestDispatcher("modif.jsp").forward(request, response);
			
		}
		
		
		
		/*PrintWriter out= response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<table border=1>");
		for(Produit p:liste) {
			out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrix()+"</td><td>"+p.getQuantite()+"</td></tr>");
			
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path =request.getServletPath();
if (path.equals("/addProduit")) {
	String nom = request.getParameter("nom");
	double prix =Double.parseDouble(request.getParameter("prix"));
	int quantite = Integer.parseInt(request.getParameter("quantite"));
	gestion.ajoutProduit(new Produit(nom,prix,quantite));
	response.sendRedirect(request.getContextPath()+"/listeproduits");
			
			
		}
else if (path.equals("/modifProduit")) {
	int id = Integer.parseInt(request.getParameter("id"));
	String nom = request.getParameter("nom");
	double prix = Double.parseDouble(request.getParameter("prix"));
	int quantite = Integer.parseInt(request.getParameter("quantite"));
	gestion.modifProduit(new Produit(id,nom,prix,quantite));
	response.sendRedirect(request.getContextPath()+"/listeproduits");
	
}
else if (path.equals("/findProduit")) {
	String nom = request.getParameter("rech");
	request.setAttribute("listeP", gestion.getAllProduitsParNom(nom));
	request.getRequestDispatcher("vue5.jsp").forward(request, response);
	
}
		
		
	}

}
