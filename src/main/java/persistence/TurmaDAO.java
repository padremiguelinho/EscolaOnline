package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import model.Turma;
import util.JPAUtil;

public class TurmaDAO {
	
	public void salvar(Turma turma) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(turma);
		gerente.getTransaction().commit();
		gerente.close();
	}
	@SuppressWarnings("unchecked")
	public List<Turma> listarTodos() {
		EntityManager gerente = JPAUtil.geEntityManager();
		List<Turma> resultados = gerente.createQuery(
				"select from Turma ").getResultList();
		
		 gerente.close();
		
		return resultados;
		
	}
	public void deletar(Turma exercicio) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		exercicio = gerente.merge(exercicio);
		gerente.remove(exercicio);
		gerente.getTransaction().commit();
		gerente.close();
	}

}
