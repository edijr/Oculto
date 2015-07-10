package hidden.controle;

import hidden.dao.ChapterDAO;
import hidden.dao.HeroDAO;
import hidden.modelo.Chapter;
import hidden.modelo.Hero;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetChapterServlet
 */
public class GetChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	
    	ChapterDAO cdao;
    	HeroDAO hdao;
    	Hero hero;
    	ArrayList<Integer> caps = new ArrayList<Integer>();
    	ArrayList<Chapter> req = new ArrayList<Chapter>();
    	
    	cdao = new ChapterDAO();
    	hdao = new HeroDAO();
    	caps = cdao.getAll();
    	out.println("<html>");
		out.println("<body>");
	    for(int c : caps){
	    	out.println("<div style=\"float: left;\">");
	    	out.println("<table border=\"1\">");
	    	out.println("<tr>");
	    	out.println("<th> Cap.: "+c+"</th>");
	    	out.println("</tr>");
	    	req = cdao.getHeroesByChapter(c);
	    	for(Chapter h : req){
	    		try {
					hero = hdao.pesquisa(h.getHeroiRequerido());
					if(hero.getObtido() != 1) {
						out.println("<tr>");
						out.println("<td> " + h.getHeroiRequerido() + "</td>");
						out.println("</tr>");
		    		} //else {
//		    			out.println("<tr>");
//						out.println("<td> " + h.getHeroiRequerido() + "(obt) </td>");
//						out.println("</tr>");
//		    		}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    	out.println("</table>");
	    	out.println("</div>");
	    }
	    out.println("<div style=\"float: right;\">");
		out.println("<br /><a href=\"/Oculto/index.html\"> Inicio </a>");
		out.println("</div>");
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
