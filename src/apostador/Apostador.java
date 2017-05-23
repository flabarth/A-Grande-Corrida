package apostador;

import veiculo.*;

public class Apostador {
	
	private String nome;
	private Veiculo aposta;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setAposta(Veiculo aposta){
		this.aposta = aposta;
	}
	
	public Veiculo getAposta(){
		return this.aposta;
	}

}
