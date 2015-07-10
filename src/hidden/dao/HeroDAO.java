package hidden.dao;

import hidden.modelo.Hero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HeroDAO {

	private Connection connection;
	
	public HeroDAO(String db, String u, String p){
		this.connection = new ConnectionFactory().getConnection(db, u, p);
	}

	public HeroDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insereHeroi(Hero h){
		try {
			PreparedStatement stmt = connection.prepareStatement("insert into hero (nome, cp, obt) values (?,?,?)");

			stmt.setString(1,h.getNome());
			stmt.setInt(2,h.getCusto());
			stmt.setInt(3,h.getObtido());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alteraHeroi(Hero h){
		try {
			PreparedStatement stmt = connection.prepareStatement("update hero set obt=? where nome=?");

			stmt.setInt(1,h.getObtido());
			stmt.setString(2,h.getNome());			

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Hero pesquisa(String nome) throws SQLException{
		Hero h = null;
		
		PreparedStatement stmt = this.connection.prepareStatement("select * from hero where nome = ?");
		stmt.setString(1,nome);
		
		ResultSet rs = stmt.executeQuery();

		if (rs.next()){
			String n = rs.getString("nome");
			int cp = rs.getInt("cp");
			int obt = rs.getInt("obt");
			h = new Hero(n,cp,obt);
		}
		rs.close();
		stmt.close();
		return h;
	}
	
	public ArrayList<Hero> getRecrutados(){
		String n;
		int cp;
		int obt;
		
		try{
			ArrayList<Hero> hs = new ArrayList<Hero>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from hero where obt=? order by nome asc");
			stmt.setInt(1,1);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				n = rs.getString("nome");
				cp = rs.getInt("cp");
				obt = rs.getInt("obt");
				Hero h = new Hero(n,cp,obt);
				hs.add(h);
			}
			rs.close();
			stmt.close();
			return hs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Hero> getAll(){
		String n;
		int cp;
		int obt;
		
		try{
			ArrayList<Hero> hs = new ArrayList<Hero>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from hero order by nome asc");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				n = rs.getString("nome");
				cp = rs.getInt("cp");
				obt = rs.getInt("obt");
				Hero h = new Hero(n,cp,obt);
				hs.add(h);
			}
			rs.close();
			stmt.close();
			return hs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
