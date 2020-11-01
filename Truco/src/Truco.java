
import java.util.Scanner;
import java.util.Random;

public class Truco {
	public static Controle control = new Controle();

	
	public static void main(String[] args) {
		int num = 0, pesoJogador = 0, pesoComputador = 0;
		int ganhouAMao = 0, contMaos = 0;
		int maoComputador = 0, maoJogador = 0;
		boolean acabouOJogo = false, jogadorVenceu = false, acabouARodada = false;
		do {
			while(!acabouARodada) {
				control.Baralho();  //distribui as cartas aleatórias
				num = PegarCarta(); //pergunta qual carta o jogador deseja jogar
				pesoJogador = control.Jogar(num); //joga a carta que o jogador pediu e retorna o peso da carta
				pesoComputador = control.ComputadorJoga(); //joga uma carta aleatoria do computador e retorna o peso da carta

				ganhouAMao = control.QuemGanhouAMao(pesoJogador, pesoComputador);
				if(ganhouAMao == 0) {
					maoJogador++;
				}else if(ganhouAMao == 1) {
					maoComputador++;
				}else {
					continue;
				}
				
				if(maoJogador >= 2) {
					jogadorVenceu = true;
					System.out.println("=======================================");
					System.out.println("Você venceu a rodada!");
					acabouOJogo = control.AcabouOJogo(jogadorVenceu);//confere se acabou o jogo
					maoJogador = 0;
					maoComputador = 0;
					
				}else if(maoComputador >= 2){
					jogadorVenceu = false;
					System.out.println("=======================================");
					System.out.println("O computador venceu a rodada.");
					acabouOJogo = control.AcabouOJogo(jogadorVenceu);
					maoJogador = 0;
					maoComputador = 0;
					
				}else {
					continue;
				}
				
				jogadorVenceu = false;//reseta
			}
		}while(!acabouOJogo);
	    
	}
	
	public static void limpaTela(){ 
		for(int count=0 ; count<50 ; count++)
		    System.out.println(""); 
	}
	public static int PegarCarta() {
		Scanner ler = new Scanner(System.in);
		System.out.println("Qual carta o(a) sr(a). deseja jogar?");
		System.out.println("1. " + control.cartaJogador[0]);
		System.out.println("2. " + control.cartaJogador[1]);
		System.out.println("3. " + control.cartaJogador[2]);
		int num = Integer.parseInt(ler.nextLine());
		while(num != 1 && num!= 2 && num != 3) {
			System.out.println("Digite um numero válido (1,2 ou 3)");
			System.out.println("1. " + control.cartaJogador[0]);
			System.out.println("2. " + control.cartaJogador[1]);
			System.out.println("3. " + control.cartaJogador[2]);
			num = Integer.parseInt(ler.nextLine());
		}
		return num;
	}
	
	
	
}
