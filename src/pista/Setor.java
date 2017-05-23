package pista;

public class Setor {
	
	private String terreno;
	private int distancia;
	
	public Setor(String terreno, int distanica){
		this.terreno = terreno;
		this.distancia = distanica;
	}
	
	public void setTerreno(String terreno){
		this.terreno = terreno;
	}
	
	public void setDistancia(int distancia){
		this.distancia = distancia;
	}
	
	public String getTerreno(){
		return this.terreno;
	}
	
	public int getDistancia(){
		return this.distancia;
	}

}
