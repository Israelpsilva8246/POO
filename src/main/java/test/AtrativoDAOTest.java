package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Atrativo;
import model.AtrativoDAO;
import connection.Conecta;

class AtrativoDAOTest extends Conecta{
	
	public AtrativoDAOTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	void testGetLista() throws Exception{
		ArrayList<Atrativo> lista = new ArrayList<Atrativo>();
		String sql = "SELECT * FROM atrativosbd";
		this.conectar();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next()) {
			Atrativo a = new Atrativo();
			a.setIdAtrativo(rs.getInt("idAtrativo"));
			a.setNomeDoAtrativo(rs.getString("nomeAtrativo"));
			
			lista.add(a);
		}
		assertTrue(lista.size()>0);
	}

	@Test
	void testGetCarregaPorID() {
		int idAtrativo  = 6;
		AtrativoDAO instance;
		try {
			instance = new AtrativoDAO();
			Atrativo result = instance.getCarregaPorID(idAtrativo);
			assertNotNull(result);
			assertEquals(idAtrativo, result.getIdAtrativo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testDeletar() {
		Atrativo atrativo = new Atrativo();
		atrativo.setIdAtrativo(1);
		try {
			AtrativoDAO instance = new AtrativoDAO();
			instance.deletar(atrativo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
