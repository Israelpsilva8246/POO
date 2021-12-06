package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Conecta;

public class UsuarioDAO extends Conecta{

	public UsuarioDAO() throws Exception{
		
	}
	
	public ArrayList<Usuario> getLista() throws Exception{
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		
		this.conectar();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			Usuario u = new Usuario();
			u.setIdUsuario(rs.getInt("idUsuario"));
			u.setNome(rs.getString("nome"));
			u.setLogin(rs.getString("login"));
			u.setIdade(rs.getString("idade"));
			u.setDataNascimento(rs.getString("data_nascimento"));
			u.setTelefone(rs.getString("telefone"));
			u.setSexo(rs.getString("sexo"));
			lista.add(u);
		}
		this.desconectar();
		return lista;
	}
	
	public boolean gravar(Usuario u) {
		try {
			String sql;
			this.conectar();
			if(u.getIdUsuario()==0) {
				sql = "INSERT INTO usuarios(nome, login, senha, telefone, data_nascimento, idade, sexo) "
						+ "VALUES (?,?,?,?,?,?,?)";
			}else {
				sql = "UPDATE usuarios SET nome=?, login=?, senha=?, telefone=?, data_nascimento=?, idade=?, sexo=?"
						+ "WHERE idUsuario=?";
			}
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getNome());
			pstm.setString(2, u.getLogin());
			pstm.setString(3, u.getSenha());
			pstm.setString(4, u.getTelefone());
			pstm.setString(5, u.getDataNascimento());
			pstm.setString(6, u.getIdade());
			pstm.setString(7, u.getSexo());
			if(u.getIdUsuario()>0) {
				pstm.setInt(8, u.getIdUsuario());
			}
			pstm.execute();
			this.desconectar();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Usuario getCarregaPorID(int idUsuario) throws Exception{
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuarios WHERE idUsuario=?";
		this.conectar();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idUsuario);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			u.setIdUsuario(rs.getInt("idUsuario"));
			u.setLogin(rs.getString("login"));
			u.setSenha(rs.getString("senha"));
			u.setNome(rs.getString("nome"));
			u.setTelefone(rs.getString("telefone"));
			u.setDataNascimento(rs.getString("data_nascimento"));
			u.setIdade(rs.getString("idade"));
			u.setSexo(rs.getString("sexo"));
		}
		this.desconectar();
		return u;
	}
	
	public Usuario getRecuperarUsuario(String login) {
		
		Usuario u = new Usuario();
		String sql = "SELECT u.* FROM usuarios u "
				+ "WHERE u.login=?";
		
		try {
			this.conectar();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, login);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				u.setIdUsuario(rs.getInt("u.idUsuario"));
				u.setLogin(rs.getString("u.login"));
				u.setSenha(rs.getString("senha"));
				u.setNome(rs.getString("u.nome"));
				u.setTelefone(rs.getString("u.telefone"));
				u.setDataNascimento(rs.getString("u.data_nascimento"));
				u.setIdade(rs.getString("u.idade"));
				u.setSexo(rs.getString("u.sexo"));
			}
			this.desconectar();
			return u;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public boolean deletar(Usuario u) {
		try {
			 this.conectar();
			 String sql = "DELETE FROM usuarios WHERE idUsuario=?";
			 PreparedStatement pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, u.getIdUsuario());
			 pstm.execute();
			 this.desconectar();
			 return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
