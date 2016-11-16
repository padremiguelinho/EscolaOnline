package converter;

import javax.faces.convert.FacesConverter;

import model.Turma;

@FacesConverter()
public class TurmaConverter extends EntityConverter<Turma> {

	public TurmaConverter() {
		super(Turma.class);
		
	}
	

}
