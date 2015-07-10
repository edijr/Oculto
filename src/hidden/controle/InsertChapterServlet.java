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
 * Servlet implementation class InsertChapterServlet
 */
public class InsertChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	
    	HeroDAO hdao;
    	ArrayList<Hero> herois = new ArrayList<Hero>();

    	hdao = new HeroDAO();
    	herois = hdao.getAll();
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<title>Cadastro de Capitulo</title>");
    	out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/Oculto/ProcessInsert\">");
		out.println("Numero do Capitulo: <input type=\"text\" name=\"numCap\"> <br/>");
		out.println("Selecione os herois requeridos: <br/>");
		for(Hero h : herois){
			out.println("<input type=\"checkbox\" name=\"heroi\" value=\""+ h.getNome() +"\" /> " + h.getNome() + "<br/>");
		}
		out.println("<input type=\"submit\" value=\"Gravar\" />");
		out.println("</form>");
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
