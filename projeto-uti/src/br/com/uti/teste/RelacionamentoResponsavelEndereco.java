package br.com.uti.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.uti.entity.Endereco;
import br.com.uti.entity.Responsavel;
import br.com.uti.entity.UF;

public class RelacionamentoResponsavelEndereco {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();
		Responsavel responsavel1 = new Responsavel();
		responsavel1.setNome("Ivo Roberto");
		responsavel1.setSexo('M');
		responsavel1.setTelefone("948462005");
		responsavel1.setCpf("42579931899");
		responsavel1.setParentesco("pai");
		responsavel1.setDataNascimento(new GregorianCalendar(1992, Calendar.MARCH, 21));
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNome("Ivo");
		responsavel.setSexo('M');
		responsavel.setTelefone("948462005");
		responsavel.setCpf("42579931899");
		responsavel.setParentesco("pai");
		responsavel.setDataNascimento(new GregorianCalendar(1992, Calendar.MARCH, 21));

		List<Endereco> ends = new ArrayList<Endereco>();
		ends.add(new Endereco("Av Sapopemba", "15A", "casa 4", "08330-180", "Jardim Ester", "São Paulo", UF.SP, responsavel));
		ends.add(new Endereco("Av Paulista", "1123A", "casa 2", "07310-180", "Centro", "São Paulo", UF.SP, responsavel));

	
		responsavel.setEnderecos(ends);
		responsavel1.setEnderecos(ends);
		try {
			em.getTransaction().begin();
				em.persist(responsavel);
				em.persist(responsavel1);
				em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

	}
}
