package main;

import pista.*;
import apostador.*;
import veiculo.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int tamanhoPista;
		boolean ganhou = false;
		double posicaoMoto;
		double posicaoAutomovel;
		double posicaoOnibus;
		double posicaoTrator;
		double posicaoBike;
		String aposta;
		
		Scanner scan = new Scanner(System.in);
				
		Pista pista = new Pista();
		Veiculo ganhador = null;
		Veiculo moto = new Motocicleta();
		Veiculo automovel = new Automovel();
		Veiculo onibus = new Onibus();
		Veiculo trator = new Trator();
		Veiculo bike = new Bicicleta();
		
		Apostador a1 = new Apostador();
		Apostador a2 = new Apostador();
		
		tamanhoPista = pista.getComprimento();
		
		System.out.println("Digite o nome do apostador 1:");
		a1.setNome(scan.nextLine());
		
		System.out.println("Digite o nome do veículo que deseja apostar: ");
		aposta = scan.nextLine();
		do{
			switch(aposta){
				case "moto":
					a1.setAposta(moto);
					break;
				case "automovel":
					a1.setAposta(automovel);
					break;
				case "onibus":
					a1.setAposta(onibus);
					break;
				case "trator":
					a1.setAposta(trator);
					break;
				case "bike":
					a1.setAposta(bike);
					break;
				default:
					System.out.println("Comando inválido. Digite novamente.");
					aposta = scan.nextLine();
					break;
			}
		}while(!aposta.matches("moto|automovel|onibus|trator|bike"));
		
		System.out.println("Digite o nome do apostador 2: ");
		a2.setNome(scan.nextLine());
		
		System.out.println("Digite o nome do veículo que deseja apostar: ");
		aposta = scan.nextLine();
		do{
			switch(aposta){
				case "moto":
					a2.setAposta(moto);
					break;
				case "automovel":
					a2.setAposta(automovel);
					break;
				case "onibus":
					a2.setAposta(onibus);
					break;
				case "trator":
					a2.setAposta(trator);
					break;
				case "bike":
					a2.setAposta(bike);
					break;
				default:
					System.out.println("Comando inválido. Digite novamente.");
					aposta = scan.nextLine();
					break;
			}
		}while(!aposta.matches("moto|automovel|onibus|trator|bike"));
		
		while(ganhou == false){
			
			moto.mover(pista.getTerreno(moto.getPosicaoAtual()));
			posicaoMoto = moto.getPosicaoAtual();
			moto.imprimeSeta(pista);
			
			automovel.mover(pista.getTerreno(automovel.getPosicaoAtual()));
			posicaoAutomovel = automovel.getPosicaoAtual();
			automovel.imprimeSeta(pista);
			
			onibus.mover(pista.getTerreno(onibus.getPosicaoAtual()));
			posicaoOnibus = onibus.getPosicaoAtual();
			onibus.imprimeSeta(pista);
			
			trator.mover(pista.getTerreno(trator.getPosicaoAtual()));
			posicaoTrator = trator.getPosicaoAtual();
			trator.imprimeSeta(pista);
			
			bike.mover(pista.getTerreno(bike.getPosicaoAtual()));
			posicaoBike = bike.getPosicaoAtual();
			bike.imprimeSeta(pista);
			
			if(posicaoMoto >= tamanhoPista){
				ganhador = moto;
				ganhou = true;
			}
			
			if(posicaoAutomovel >= tamanhoPista){
				ganhador = automovel;
				ganhou = true;
			}
			
			if(posicaoOnibus >= tamanhoPista){
				ganhador = onibus;
				ganhou = true;
			}
			
			if(posicaoTrator >= tamanhoPista){
				ganhador = trator;
				ganhou = true;
			}
			
			if(posicaoBike >= tamanhoPista){
				ganhador = bike;
				ganhou = true;
			}
			
			TimeUnit.MILLISECONDS.sleep(250);
			
			if(!ganhou){
				System.out.println("\n\n\n\n\n\n");
			}
		}
		
		System.out.println("\nVeículo vencedor: "+ganhador.getNomeVeiculo());
		if(ganhador == a1.getAposta()){
			System.out.println("Apostador vencedor: "+a1.getNome());	
		}else if(ganhador == a2.getAposta()){
			System.out.println("Apostador vencedor: "+a2.getNome());
		}else{
			System.out.println("Nenhum dos apostadores venceu!");
		}
		
		scan.close();
		
	}

}
