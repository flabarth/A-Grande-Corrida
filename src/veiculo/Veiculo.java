package veiculo;

import pista.*;

public abstract class Veiculo {

	protected final double VELOCIDADE_TERRA;
	protected final double VELOCIDADE_ATOLEIRO;
	protected final double VELOCIDADE_ASFALTO;
	protected final double VELOCIDADE_GRAMA;
	
	protected double posicaoAtual;
	protected String terrenoAtual = "";
	protected String terrenoAnterior = "";
	protected String caminhoPercorrido = "";
	protected String caminhoTotal = "";
	protected String nomeVeiculo;
	
	protected Veiculo(double velTerra, double velAtoleiro, double velAsfalto, double velGrama){
		this.VELOCIDADE_TERRA = velTerra;
		this.VELOCIDADE_ATOLEIRO = velAtoleiro;
		this.VELOCIDADE_ASFALTO = velAsfalto;
		this.VELOCIDADE_GRAMA = velGrama;
	}
	
	public void mover(String terreno){
		if(!this.terrenoAtual.equals(terreno)){
			this.terrenoAnterior = this.terrenoAtual;
			this.terrenoAtual = terreno;
		}else{
			this.terrenoAtual = terreno;
		}
		if(terreno.equals("terra")){
			this.posicaoAtual += this.VELOCIDADE_TERRA / 3.6;
		}
		if(terreno.equals("atoleiro")){
			this.posicaoAtual += this.VELOCIDADE_ATOLEIRO / 3.6;
		}
		if(terreno.equals("asfalto")){
			this.posicaoAtual += this.VELOCIDADE_ASFALTO / 3.6;
		}
		if(terreno.equals("grama")){
			this.posicaoAtual += this.VELOCIDADE_ATOLEIRO / 3.6;
		}
	}
	
	public double getPosicaoAtual(){
		return this.posicaoAtual;
	}
	
	public String getNomeVeiculo(){
		return this.nomeVeiculo;
	}
	
	public void imprimeSeta(Pista pista){
		
		final int METRO_POR_PASSOS = 10;
		
		double numeroSeta = this.posicaoAtual / METRO_POR_PASSOS;
		String terrenoPista = "";
		for(int x = 0; x < numeroSeta; x++){
			terrenoPista = pista.getTerreno(x * METRO_POR_PASSOS);
			switch(terrenoPista){
				case "terra":
					this.caminhoPercorrido += "-";
					break;
				case "atoleiro":
					this.caminhoPercorrido += "~";
					break;
				case "asfalto":
					this.caminhoPercorrido += "=";
					break;
				case "grama":
					this.caminhoPercorrido += ",";
					break;
			}
		}
		System.out.print(this.caminhoPercorrido+"> "+this.nomeVeiculo+"\n");
		this.caminhoPercorrido = "";
	}
	
}
