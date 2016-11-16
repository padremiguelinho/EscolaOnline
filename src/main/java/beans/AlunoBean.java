package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import model.Aluno;
import model.Turma;
import persistence.GenericDAO;
import persistence.TurmaDAO;

@ManagedBean
public class AlunoBean {

	private Aluno aluno;

	private List<Aluno> alunos = new ArrayList<Aluno>();



	public AlunoBean() {
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		aluno = new Aluno();

	}

	public String Salvar() {
		new GenericDAO<Aluno>(Aluno.class).salvar(aluno);
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		aluno = new Aluno();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso!"));
		return "index_admin?faces-redirect=true";

	}
	
	public void enviarFoto(FileUploadEvent event){
		try {
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			aluno.setFoto(foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Turma> listarTurmas() {
		return new TurmaDAO().listarTodos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	
}
