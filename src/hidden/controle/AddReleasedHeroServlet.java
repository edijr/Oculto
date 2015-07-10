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
 * Servlet implementation class AddReleasedHeroServlet
 */
public class AddReleasedHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReleasedHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	PrintWriter out = response.getWriter();
    	
    	HeroDAO dao;
    	Hero h;
    	String nome = request.getParameter("nome");
    	String custo = request.getParameter("custo");
    	String[] s = request.getParameterValues("isObtido");
    	
    	String erro = "";

		try {
			String valido = validaCampos(nome,custo);
			if(valido != null){
				out.println(valido);
			} else {
				dao = new HeroDAO();
				h = dao.pesquisa(nome);
				if(h != null){
					erro = "Heroi já cadastrado !!";
					out.println(erro);
				} else {
					int cp = Integer.parseInt(custo);
					if(s != null && s[0].equals("true")){
						h = new Hero(nome, cp, 1);
					} else {
						h = new Hero(nome, cp, 0);
					}
					dao.insereHeroi(h);
					out.println("<html>");
					out.println("<body>");
					out.println("Heroi adicionado com sucesso!</br>");
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
    
    private String validaCampos(String cod, String nome) {
		// TODO Auto-generated method stub
		String erro = null;
		if(cod.equals("") || cod.length() == 0){
			erro = "Código de fornecedor não preenchido !!";
		} else {
			if(nome.equals("") || nome.length() == 0){
				erro = "Nome do fornecedor não preenchido !!";
			}
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
