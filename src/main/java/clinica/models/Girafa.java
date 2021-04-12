package clinica.models;

public class Girafa extends Animal {

	public Girafa(int id, String nome) {
		setId(id);
		setNome(nome);
		incrementarIdUnico();
	}
}
