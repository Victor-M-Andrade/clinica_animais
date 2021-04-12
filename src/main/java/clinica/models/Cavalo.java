package clinica.models;

public class Cavalo extends Animal {

	public Cavalo(int id, String nome) {
		setId(id);
		setNome(nome);
		incrementarIdUnico();
	}
}
