package Poke;

public class Treinador {
	private int index;
	private int pokeMortos = 0;
	private String nome;
	private Pokemon festa[];
	private Item mochila[];
	private int ativo = 0;
	public Treinador(int index, String nome, Pokemon festa[], Item itens[])
	{
		this.index = index;
		this.nome = nome;
		this.festa = festa;
		this.mochila = itens;
	}
	public boolean setAtivo(int novo)
	{
		if(festa[novo].estaVivo())
		{
			this.ativo = novo;
			return true;
		}
		return false;
	}
	public int getIndex(){
		return index;
	}
	
	public String getNome(){
		return nome;
	}
	
	public Pokemon[] getFesta(){
		return festa;
	}
		
	public Pokemon getPokeAtual(){
		return festa[ativo];
	}
	
	public Item getItens(int index){
		return mochila[index];
	}
	
	public void addPokeMortos(int add) {
		pokeMortos += add;
	}
	
	public Item[] getMochila() {
		return mochila;
	}
	
	public int getPokeMortos() {
		return pokeMortos;
	}
}
