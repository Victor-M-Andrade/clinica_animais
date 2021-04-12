package clinica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clinica.models.Animal;
import clinica.models.Cavalo;
import clinica.models.Girafa;

public class Main {

	public static void main(String[] args) {

		Main app = new Main();
		app.start();

	}

	private Scanner ler = new Scanner(System.in);
	private List<Animal> listaAnimais = new ArrayList<Animal>();

	private void start() {

		boolean emExecucao = true;

		while (emExecucao) {

			menu();

			int opcao = 9;

			try {
				opcao = ler.nextInt();
			} catch (Exception e) {

				ler.next();
				System.out.println("Ocorreu um erro. Provavelmente o usuário digitou algo inválido.");
				continue;
			}

			switch (opcao) {

			case 1:
				// cadastrarCavalo();
				cadastrarAnimal(opcao);
				break;

			case 2:
				// cadastrarGirafa();
				cadastrarAnimal(opcao);
				break;

			case 3:
				listarCavalos();
				break;

			case 4:
				listarGirafas();
				break;

			case 5:
				listarAnimais();
				break;

			case 6:
				
				try {
					System.out.println("-----");
					System.out.println("Insira o ID do animal a ser removido: ");
					int idDoAnimal = ler.nextInt();
					
					removerAnimalPorID(idDoAnimal);
				} catch (Exception e) {
					ler.next();
					System.out.println("Ocorreu um erro ao obter o ID do animal");
				}
				break;

			case 7:
				break;

			case 8:
				System.out.println("Obrigado por usar o programa =D");
				emExecucao = false;
				break;

			default:
				System.out.println("Opção inválida.");
				break;

			}

		}

		System.out.println("A aplicação foi finalizada =D");

	}

	private void removerAnimalPorID(int idDoAnimal) {
		
		int indiceDaListaDeAnimais = -1;
		
		for (int i = 0; i < listaAnimais.size(); i++) {
			
			Animal animal = listaAnimais.get(i);
			
			if(animal.getId() == idDoAnimal) {
				indiceDaListaDeAnimais = i;
				break;
			}
		}
		
		if(indiceDaListaDeAnimais == -1) {
			System.out.println("Não foi encontrado nenhum animal com esse ID");
			return;
		}
		
		listaAnimais.remove(indiceDaListaDeAnimais);
		
	}

	private void listarAnimais() {
		System.out.println("-----------");

		for (Animal animal : listaAnimais) {

			if (animal instanceof Cavalo) {
				System.out.println("Dados do animal: CAVALO | " + animal.getId() + " | " + animal.getNome());
			} else if (animal instanceof Girafa) {
				System.out.println("Dados do animal: GIRAFA | " + animal.getId() + " | " + animal.getNome());
			}
		}

	}

	private void listarCavalos() {

		System.out.println("-----------");

		for (Animal animal : listaAnimais) {

			if (animal instanceof Cavalo) {
				System.out.println("Dados do cavalo: " + animal.getId() + " | " + animal.getNome());
			}
		}

	}

	private void listarGirafas() {

		System.out.println("-----------");

		for (Animal animal : listaAnimais) {

			if (animal instanceof Girafa) {
				System.out.println("Dados da girafa: " + animal.getId() + " | " + animal.getNome());
			}
		}

	}

	private void cadastrarAnimal(int numero) {

		Animal animal = null;

		if (numero == 1) {
			animal = new Cavalo(Animal.getIdUnico(), "nome do cavalo");

		} else if (numero == 2) {
			animal = new Girafa(Animal.getIdUnico(), "nome da girafa");

		} else {
			System.out.println("Tipo de animal invalido");
			return;
		}

		listaAnimais.add(animal);

		if (animal instanceof Cavalo) {
			System.out.println("O cavalo foi inserido com sucesso");
		} else if (animal instanceof Girafa) {
			System.out.println("A girafa foi inserida com sucesso");
		}

	}

	private void menu() {

		System.out.println("1 - Cadastrar cavalo");
		System.out.println("2 - Cadastrar girafa");
		System.out.println("3 - Listar cavalos");
		System.out.println("4 - Listar girafas");
		System.out.println("5 - Listar animais");
		System.out.println("6 - Remover um animal por ID");
		System.out.println("7 - Exibir a quantidade");
		System.out.println("8 - Sair");

	}

}
