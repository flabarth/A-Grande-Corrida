package main;

import pista.*;
import veiculo.*;
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
		Veiculo ganhador = null;
		
		Pista pista = new Pista();
		Veiculo moto = new Motocicleta();
		Veiculo automovel = new Automovel();
		Veiculo onibus = new Onibus();
		Veiculo trator = new Trator();
		Veiculo bike = new Bicicleta();
		
		tamanhoPista = pista.getComprimento();
		
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
			
			TimeUnit.SECONDS.sleep(1);
			if(!ganhou){
				System.out.println("\n\n\n\n\n\n");
			}
		}
		
		System.out.println("Vencedor: "+ganhador.getNomeVeiculo());
		
	}

}
