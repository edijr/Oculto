package hidden.controle;

import hidden.dao.ChapterDAO;
import hidden.modelo.Chapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessInsertServlet
 */
public class ProcessInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	
    	ChapterDAO cdao;
    	Chapter cap;
    	int cont;
    	ArrayList<Chapter> cs = new ArrayList<Chapter>();
    	String num = request.getParameter("numCap");
    	String[] s = request.getParameterValues("heroi");
    	
    	cdao = new ChapterDAO();
    	for(cont = 0;cont < s.length; cont++){
    		cap = new Chapter(Integer.parseInt(num),s[cont]);
    		cs.add(cap);
    	}
    	cdao.insereCapitulo(cs);
    	out.println("<html>");
		out.println("<body>");
		out.println("Capitulo cadastrado com sucesso!</br>");
    	out.println("<a href=\"/Oculto/index.html\"> Inicio </a> <br/>");
    	out.println("<a href=\"/Oculto/GetChapter\"> Listar Herois Requeridos </a>");
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
