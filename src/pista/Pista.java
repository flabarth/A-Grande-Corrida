package pista;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Pista {
	
	private final int COMPRIMENTO_MAX = 1000; // metros
	
	private int comprimentoTerra;
	private int comprimentoAtoleiro;
	private int comprimentoAsfalto;
	private int comprimentoGrama;
	
	private ArrayList<Setor> setor = new ArrayList<Setor> ();
	
	public Pista(){
		int comprimentoRestante = COMPRIMENTO_MAX;
		int terreno;
		
		while(comprimentoRestante > 0){
					
			terreno = ThreadLocalRandom.current().nextInt(1, 4 + 1);
						
			switch(terreno){
				case 1: // terra
					
					if(comprimentoRestante >= 500) {
						comprimentoTerra = ThreadLocalRandom.current().nextInt(100, 500 + 1);
					}else{
						comprimentoTerra = ThreadLocalRandom.current().nextInt(1, comprimentoRestante + 1);
					}
																				
					comprimentoRestante = comprimentoRestante - comprimentoTerra;
					
					setor.add(new Setor("terra", comprimentoTerra));
					
					break;
				
				case 2: // atoleiro
					
					if(comprimentoRestante >= 500){
						comprimentoAtoleiro = ThreadLocalRandom.current().nextInt(100, 500 + 1);
					}else{
						comprimentoAtoleiro = ThreadLocalRandom.current().nextInt(1, comprimentoRestante + 1);
					}
					
					comprimentoRestante = comprimentoRestante - comprimentoAtoleiro;
					
					setor.add(new Setor("atoleiro", comprimentoAtoleiro));
					
					break;
					
				case 3: // asfalto
					
					if(comprimentoRestante >= 500){
						comprimentoAsfalto = ThreadLocalRandom.current().nextInt(1, 500 + 1);
					}else{
						comprimentoAsfalto = ThreadLocalRandom.current().nextInt(1, comprimentoRestante + 1);
					}
					
					comprimentoRestante = comprimentoRestante - comprimentoAsfalto;
					
					setor.add(new Setor("asfalto", comprimentoAsfalto));
					
					break;
					
				case 4: // grama
					
					if(comprimentoRestante >= 500){
						comprimentoGrama = ThreadLocalRandom.current().nextInt(100, 500 + 1);
					}else{
						comprimentoGrama = ThreadLocalRandom.current().nextInt(1, comprimentoRestante + 1);
					}
					
					comprimentoRestante = comprimentoRestante - comprimentoGrama;
					
					setor.add(new Setor("grama", comprimentoGrama));
					
					break;
			}
			
		}
		
	}
	
	public void imprimePista(){
		
		System.out.println("Pista: ");
		for(Setor pequenoSetor : this.setor){
			System.out.print("| == "+pequenoSetor.getTerreno()+": "+pequenoSetor.getDistancia()+"m == |");
		}
		
	}
	
	public int getComprimento(){
		return this.COMPRIMENTO_MAX;
	}
	
	public String getTerreno(double posicao){
		double distanciaPercorrida = 0;
		String terreno = "";
		for(Setor pequenoSetor : this.setor){
			distanciaPercorrida += pequenoSetor.getDistancia();
			if(posicao <= distanciaPercorrida){
				terreno = pequenoSetor.getTerreno();
				break;
			}
		}
		return terreno;
	}
	
}
