import java.util.Scanner;

public class Partida {
	private int pontosComputador;
	private int pontosJogador;
	
		
	public boolean AcabouOJogo(){
		Scanner ler = new Scanner(System.in);
		if(this.pontosComputador > 10) {
			System.out.println("=======================================");
			System.out.println("VOC� PERDEU O JOGO.");
			System.out.println("Deseja jogar novamente? 1.sim 2.n�o");
			System.out.println("=======================================");
			int num = Integer.parseInt(ler.nextLine());
			if(num == 1) {
				this.pontosComputador = 0;
				this.pontosJogador = 0;
			}else if(num ==2) {
				System.exit(0);
			}else {
				System.out.println("N�mero inv�lido");
				System.out.println("Deseja jogar novamente? 1.sim 2.n�o");
			}
			return true;
		}else if( this.pontosJogador > 10){
			System.out.println("=======================================");
			System.out.println("VOC� VENCEU O JOGO!!!");
			System.out.println("Deseja jogar novamente? 1.sim 2.n�o");
			System.out.println("=======================================");
			int num = Integer.parseInt(ler.nextLine());
			if(num == 1) {
				this.pontosJogador = 0;
				this.pontosComputador = 0;
			}else if(num ==2) {
				System.exit(0);
			}else {
				System.out.println("N�mero inv�lido");
				System.out.println("Deseja jogar novamente? 1.sim 2.n�o");
			}
			return true;
		}else {
			System.out.println("A partida continua");
			System.out.println("=======================================");
			return false;
		}
	}
	
	 public int getpontosComputador() {
	     return this.pontosComputador;
	  }

	  public int getpontosJogador() {
	    return this.pontosJogador;
	  }

	  public void setpontosComputador (int pontosComputador) {
	    this.pontosComputador += pontosComputador;
	  }

	  public void setpontosJogador (int pontosJogador) {
	    this.pontosJogador += pontosJogador;
	  }
	
}
