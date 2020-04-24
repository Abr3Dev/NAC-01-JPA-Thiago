package br.com.fiap.jpa.uti.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.uti.dao.EnfermeiroDAO;
import br.com.fiap.jpa.uti.dao.PacienteDAO;
import br.com.fiap.jpa.uti.dao.impl.EnfermeiroDAOImpl;
import br.com.fiap.jpa.uti.dao.impl.PacienteDAOImpl;
import br.com.fiap.jpa.uti.entity.Endereco;
import br.com.fiap.jpa.uti.entity.Enfermeiro;
import br.com.fiap.jpa.uti.entity.EstadoPaciente;
import br.com.fiap.jpa.uti.entity.Exame;
import br.com.fiap.jpa.uti.entity.Medicacao;
import br.com.fiap.jpa.uti.entity.Medico;
import br.com.fiap.jpa.uti.entity.Paciente;
import br.com.fiap.jpa.uti.entity.Responsavel;
import br.com.fiap.jpa.uti.entity.TipoSanguineo;
import br.com.fiap.jpa.uti.entity.UF;
import br.com.fiap.jpa.uti.exception.CommitException;
import br.com.fiap.jpa.uti.singleton.EntityManagerFactorySingleton;

public class CreatePacienteView {
	public static void main(String[] args) {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();

		PacienteDAO pacienteDAO = new PacienteDAOImpl(em);
		EnfermeiroDAO enfermeiroDAO = new EnfermeiroDAOImpl(em);

		Medico medico = new Medico("CRM654321", "Dr. Áuzio", Calendar.getInstance(), "brasileira",
				TipoSanguineo.O_NEGATIVO);

		Responsavel responsavel = new Responsavel("Ricardo", new GregorianCalendar(1964, Calendar.APRIL, 5), 'M',
				"19865482536", "945258641", "Avô");

		responsavel.addEndereco(
				new Endereco("Av Sapopemba", "15A", "casa 4", "08330-180", "Jardim Ester", "São Paulo", UF.SP));
		responsavel
				.addEndereco(new Endereco("Av Paulista", "1123A", "casa 2", "07310-180", "Centro", "São Paulo", UF.SP));

		Paciente paciente = new Paciente("Karina", new GregorianCalendar(2005, Calendar.MAY, 26), 'F',
				TipoSanguineo.A_NEGATIVO, "nenhuma", "branca", EstadoPaciente.ESTAVEL, responsavel, medico);

		Enfermeiro enfermeiro = new Enfermeiro("COREN123456", "Gonçalves",
				new GregorianCalendar(1980, Calendar.APRIL, 3), TipoSanguineo.AB_POSITIVO);

		List<Medicacao> medicacao = new ArrayList<Medicacao>();
		medicacao.add(new Medicacao("Dipirona", 1.5f, "remédio para tratar as dores de cabeça",
				"tomar a cada 8 horas durante 5 dias", Calendar.getInstance()));
		medicacao.add(new Medicacao("Dorflex", 1f, "remédio para tratar as dores no corpo",
				"tomar a cada 8 horas durante 6 dias", Calendar.getInstance()));

		List<Exame> exame = new ArrayList<Exame>();
		exame.add(new Exame("Sangue", "Estar em jejum por 12 horas", Calendar.getInstance()));
		exame.add(new Exame("Urina", "Estar em jejum por 8 horas", Calendar.getInstance()));

		paciente.setMedicacoes(medicacao);
		paciente.setExames(exame);
		medico.setMedicacoes(medicacao);
		medico.setExames(exame);
		enfermeiro.setMedicacoes(medicacao);

		pacienteDAO.cadastrar(paciente);
		enfermeiroDAO.cadastrar(enfermeiro);

		try {
			pacienteDAO.commit();
			enfermeiroDAO.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.out.println("Erro ...");
		}
		em.close();
		emf.close();
	}
}
