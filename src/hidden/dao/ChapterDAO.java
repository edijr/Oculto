package hidden.dao;

import hidden.modelo.Chapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChapterDAO {

	private Connection connection;
	
	public ChapterDAO(String db, String u, String p){
		this.connection = new ConnectionFactory().getConnection(db, u, p);
	}

	public ChapterDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insereCapitulo(ArrayList<Chapter> cs){
		try {
			for(Chapter c : cs){
				PreparedStatement stmt = connection.prepareStatement("insert into chapter (num, nome) values (?,?)");

				stmt.setInt(1,c.getNumero());
				stmt.setString(2,c.getHeroiRequerido());
				
				stmt.execute();
				stmt.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Integer> getAll(){
		int num;
		
		try{
			ArrayList<Integer> cs = new ArrayList<Integer>();
			PreparedStatement stmt = this.connection.prepareStatement("select distinct num from chapter");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				num = rs.getInt("num");
				cs.add(num);
			}
			rs.close();
			stmt.close();
			return cs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Chapter> getHeroesByChapter(int numero){
		int num;
		String nome;
		
		try{
			ArrayList<Chapter> cs = new ArrayList<Chapter>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from chapter where num=? order by nome asc");
			stmt.setInt(1,numero);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				nome = rs.getString("nome");
				num = rs.getInt("num");
				Chapter c = new Chapter(num,nome);
				cs.add(c);
			}
			rs.close();
			stmt.close();
			return cs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
