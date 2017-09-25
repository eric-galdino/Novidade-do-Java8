package br.eric.newsjava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.function.Consumer;

import org.omg.Messaging.SyncScopeHelper;

public class Main {

	public static void main(String[] args) {
		
		Pergunta pp1 = new Pergunta("Qual é o melhor framework web?", "Paulo", Arrays.asList(
				new Resposta("VRaptor 4"), new Resposta("Play Framework"), new Resposta("JSF")));
		
		Pergunta pp2 = new Pergunta("Como ordenar com Java?", "Paulo", Arrays.asList(
				new Resposta("Usando um comparator!")));
		
		Pergunta pp3 = new Pergunta("Vai ter coffee break?", "Rodrigo", Arrays.asList(
				new Resposta("Sim"), new Resposta("Certamente")));
		
		List<Pergunta> perguntas = Arrays.asList(pp1,pp2,pp3);
		
		//Ordenar Perguntas 1.7 ou anterior
		/*Collections.sort(perguntas, new Comparator<Pergunta>(){
			public int compare(Pergunta p1, Pergunta p2){
				if(p1.getRespostas().size() < p2.getRespostas().size())
					return -1;
				if(p1.getRespostas().size() > p2.getRespostas().size())
					return 1;
				return 0;
			}
		});*/
		
		/*//Ordenar Perguntas 1.8
		perguntas.sort(new Comparator<Pergunta>(){
			public int compare(Pergunta p1, Pergunta p2){
				if(p1.getRespostas().size() < p2.getRespostas().size())
					return -1;
				if(p1.getRespostas().size() > p2.getRespostas().size())
					return 1;
				return 0;
			}
		});*/
		
		//Ordenar Perguntas usando Lambda Java 1.8
		perguntas.sort(
				(p1, p2) -> {
				if(p1.getRespostas().size() < p2.getRespostas().size())
					return -1;
				if(p1.getRespostas().size() > p2.getRespostas().size())
					return 1;
				return 0;
		});
		
		//Ordenar Perguntas usando Lambda Java 1.8 (Comparator sem IF)
		perguntas.sort(
				(p1, p2) -> Integer.compare(p1.getRespostas().size(), p2.getRespostas().size())
		);
		
		//Ordenar Perguntas usando Lambda Java 1.8 (Comparator sem IF) outra maneira
		perguntas.sort(Comparator.comparing(p -> p.getRespostas().size()));
		
		//Listas forEach
		perguntas.forEach(new Consumer<Pergunta>(){
			public void accept(Pergunta p){
				System.out.println(p.getTitulo());
			}
		});
		
		//forEach Lambda Java 1.8
		perguntas.forEach(p -> System.out.println(p.getTitulo()));
		
		System.out.println(perguntas);
		
		//Usando Thread 1.7 anterior
		Runnable r = new Runnable() {
			public void run(){
				System.out.println("Minha Thread está rodando");
			}
		};
		
		//Usando Thread 1.8 com lambda
		Runnable run = () -> System.out.println("Minha Thread está rodando");
		
		new Thread(() -> System.out.println()).start();
	}

}
