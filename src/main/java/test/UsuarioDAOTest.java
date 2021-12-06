package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import connection.Conecta;
import model.Usuario;
import model.UsuarioDAO;

class UsuarioDAOTest extends Conecta{

	public UsuarioDAOTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	void testGetLista() throws Exception{
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		this.conectar();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()) {
			Usuario u = new Usuario();
			u.setIdUsuario(rs.getInt("idUsuario"));
			u.setNome(rs.getString("nome"));
			
			lista.add(u);
		}
		assertTrue(lista.size()>0);
	}

	@Test
	void testGetCarregaPorID() throws Exception{
		int idUsuario  = 4;
		UsuarioDAO instance = new UsuarioDAO();
		Usuario result = instance.getCarregaPorID(idUsuario);
		assertNotNull(result);
		assertEquals(idUsuario, result.getIdUsuario());
	}

}
