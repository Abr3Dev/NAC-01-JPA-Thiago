package br.com.uti.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.uti.entity.EstadoPaciente;
import br.com.uti.entity.Paciente;
import br.com.uti.entity.Responsavel;
import br.com.uti.entity.TipoSanguineo;
import br.com.uti.singleton.EntityManagerFactorySingleton;

public class RelacionamentoPacienteResponsável {
	public static void main(String[] args) {
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		
		EntityManager em = emf.createEntityManager();
		
		Responsavel responsavel = new Responsavel("Ivo", new GregorianCalendar(1992, Calendar.MARCH, 21), 'M', "42579931899", "948462005", "Pai");
		
		Paciente paciente = new Paciente("Karina", Calendar.getInstance(), 'F', TipoSanguineo.A_NEGATIVO, EstadoPaciente.ESTAVEL, responsavel);
		


		
		em.getTransaction().begin();
		
		em.persist(paciente);
		em.getTransaction().commit();
		
		em.close();
		
	}
}
