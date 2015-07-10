package hidden.controle;

import hidden.dao.HeroDAO;
import hidden.modelo.Hero;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllHeroServlet
 */
public class GetAllHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	HeroDAO dao;
    	ArrayList<Hero> herois = new ArrayList<Hero>();
    	
    	dao = new HeroDAO();
    	herois = dao.getAll();
    	out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\">");
	    out.println("<tr>");
	    out.println("<td>Nome</td>");
	    out.println("<td>Custo</td>");
	    out.println("<td>Obtido</td>");
	    out.println("</tr>");
	    for(Hero h : herois){
	    	out.println("<tr>");
	    	out.println("<td> " + h.getNome() + "</td>");
	        out.println("<td> " + h.getCusto() + "</td>");
	        if(h.getObtido() == 1){
	        	out.println("<td> Ja Obtido </td>");
	        } else {
	        	out.println("<td> Nao Obtido </td>");
	        }
	        out.println("</tr>");
	    }
	    out.println("</table><br/>");
		out.println("<a href=\"/Oculto/index.html\"> Inicio </a>");
		out.println("</body>");
		out.println("</html>");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
