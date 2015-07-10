package hidden.controle;

import hidden.dao.HeroDAO;
import hidden.modelo.Hero;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddHeroServlet
 */

//commit de teste
public class AddHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	
    	HeroDAO dao;
    	Hero h;
    	String nome = request.getParameter("nome");
    	
    	String erro = "";

		try {
			String valido = validaCampos(nome);
			if(valido != null){
				out.println(valido);
			} else {
				dao = new HeroDAO();
				h = dao.pesquisa(nome);
				if(h == null){
					erro = "Heroi nao cadastrado !!";
					out.println(erro);
				} else {
					h.setObtido(1);
					dao.alteraHeroi(h);
					out.println("<html>");
					out.println("<body>");
					out.println("Heroi alterado com sucesso!</br>");
					out.println("<a href=\"/Oculto/index.html\"> Inicio </a>");
					out.println("<br/>");
					out.println("</body>");
					out.println("</html>");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private String validaCampos(String nome) {
		// TODO Auto-generated method stub
		String erro = null;
		if(nome.equals("") || nome.length() == 0){
			erro = "Nome do fornecedor não preenchido !!";
		}
		return erro;
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
