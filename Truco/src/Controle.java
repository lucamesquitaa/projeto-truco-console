

import java.util.Random;

public class Controle {//vai controlar toda chamada de uma classe para outra
	
	public static Carta card = new Carta();
	public static Partida pontos = new Partida();
	
	public static String[] cartaJogador = new String[3];
	public static String[] cartaComputador = new String[3];

	public static String cartaJogada;
	
	public void Baralho() {
		
		for(int i = 0; i < 3; i++) {
			cartaJogador[i] = card.getCarta();
			cartaComputador[i] = card.getCarta();
		}
		boolean repetida = temRepetida(cartaJogador,cartaComputador); 
		//confere se tem alguma carta repetida e retorna um boolean
		//o while vai embaralhar as cartas de novo ate que nao exista carta repetida
		while(repetida) {
			for(int i = 0; i < 3; i++) {
				cartaJogador[i] = card.getCarta();
				cartaComputador[i] = card.getCarta();
			}
			repetida = temRepetida(cartaJogador,cartaComputador); 
		}
	}
	
	public int Jogar(int num) {
		int peso;
		if(num == 1) {
			String carta = cartaJogador[0]; 
			peso = AtribuiValor(carta);
			System.out.println("carta escolhida: "+ carta);
			return peso;
		}else if(num == 2) {
			String carta = cartaJogador[1];
			peso = AtribuiValor(carta);
			System.out.println("carta escolhida: "+ carta);
			return peso;
		}else {
			String carta = cartaJogador[2];
			peso = AtribuiValor(carta);
			System.out.println("carta escolhida: "+ carta);
			return peso;
		}
	}
	public int ComputadorJoga(){
		
		Random random = new Random();
		int valorAleatorio = random.nextInt(3);
		int peso = 0;
		if(valorAleatorio == 0) {
			String carta = cartaComputador[0];
			peso = AtribuiValor(carta);
			System.out.println("carta computador: "+ carta+"\n");
			return peso;
			
		}else if(valorAleatorio == 1) {
			String carta = cartaComputador[1];
			peso = AtribuiValor(carta);
			System.out.println("carta computador: "+ carta+"\n");
			return peso;
		}else {
			String carta = cartaComputador[2];
			peso = AtribuiValor(carta);
			System.out.println("carta computador: "+ carta+"\n");
			return peso;
			
		}
	}
 	
	public static int AtribuiValor(String card) {
		int retorno = 0;
		String[] vetCartas = {"4P","7C","AE","7O","3C", "3O","3E","3P","2C","2O","2E","2P",
				"AC","AO","AP","KC","KO","KE","KP","JC","JO","JE","JP","QC","QO","QE","QP",
			"7E","7P","6C","6O","6E","6P","5C","5O","5E","5P","4C","4O","4E"};
		
		int[] vetPesos = {41,40,39,38,37,37,37,37,36,36,36,36,35,35,35,34,34,34,34,33,33,33,
				33,32,32,32,32,31,31,30,30,30,30,29,29,29,29,28,28,28};
		
		for(int i = 0; i < vetCartas.length; i++) {
			String cartaDoVetor = vetCartas[i];
			if(cartaDoVetor.equals(card)) {
				return vetPesos[i];
			}
		}
		return retorno;	
		
		
	}
	public static boolean temRepetida(String[]cartaJogador, String[] cartaComputador) {
		String cartaAtual;
		String cartaVar;
		//Dois for para comparar todas as 6 cartas
		for(int x= 0; x < 6; x++) {
			if(x < 3) {
				cartaAtual = cartaJogador[x];
			}
			else {
				int indicex = x - 3; //o vetor do computador so vai de 0 - 3 tambem
				cartaAtual = cartaComputador[indicex];
			}
			
			for (int i = 0; i < 6; i++) {
				if(x == i) {
					continue;
				}
				else if(i < 3) {
					cartaVar = cartaJogador[i];
				}
				else {
					int indicei = i - 3; //o vetor do computador so vai de 0 - 3 tambem
					cartaVar = cartaComputador[indicei]; 
				}
				
		        if (cartaAtual.equals(cartaVar)) {
		        	return true; //se existir qualquer carta igual retorna true
		        }
		    }
		}
		return false;
	}
	public int QuemGanhouAMao(int peso1, int peso2) {
		//codigos para saber quem ganhou
		if(peso1 > peso2) {
			System.out.println("(Jogador ganhou) \n");
			return 0; //jogador ganhou
		}else if(peso2 > peso1) {
			System.out.println("(Computador ganhou) \n");
			return 1; //comp ganhou
		}else if(peso1 == peso2) {
			return 2; //empate
		}else {
			return 3; //erro
		}
	}
	
	public boolean AcabouOJogo(boolean jogadorVenceu) {
		boolean acabou = false;
		if(jogadorVenceu) {
			pontos.setpontosJogador(2);
			System.out.println("->Pontos jogador: "+ pontos.getpontosJogador());		
			System.out.println("->Pontos computador: "+ pontos.getpontosComputador());
			acabou = pontos.AcabouOJogo();
		}else if(!jogadorVenceu) {
			pontos.setpontosComputador(2);
			System.out.println("->Pontos jogador: "+ pontos.getpontosJogador());	
			System.out.println("->Pontos computador: "+ pontos.getpontosComputador());
			acabou = pontos.AcabouOJogo();
		}else {
			System.out.println("Erro nos pontos");
		}
		return acabou;
		
	}
	
}
