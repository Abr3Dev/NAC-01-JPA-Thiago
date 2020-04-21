package br.com.uti.teste;

import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.uti.entity.Medicacao;
import br.com.uti.entity.Medico;
import br.com.uti.entity.TipoSanguineo;

public class RelacionamentoMedicoMedicacao {
	public static void main(String[] args) {

		Medico medico = new Medico("CRM123456", "Dr. Consulta", Calendar.getInstance(), "brasileira",
				TipoSanguineo.A_POSITVO);

		Medico medico2 = new Medico("CRM654321", "Dr. Áuzio", Calendar.getInstance(), "brasileira",
				TipoSanguineo.O_NEGATIVO);

		Medicacao medicacao = new Medicacao("Dipirona", 1.5f, "remédio para tratar as dores do paciente",
				"tomar a cada 8 horas durante 2 dias", Calendar.getInstance(), Arrays.asList(medico, medico2));

		Medicacao medicacao2 = new Medicacao("Dorflex", 1f, "remédio para tratar as dores do paciente",
				"tomar a cada 12 horas durante 2 dias", Calendar.getInstance(), Arrays.asList(medico, medico2));

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		try {
			em.persist(medico);
			em.persist(medico2);
			em.persist(medicacao);
			em.persist(medicacao2);

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

}