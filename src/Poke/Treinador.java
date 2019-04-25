package Poke;

public class Treinador {
	private int index;
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
	public void setAtivo(int novo)
	{
		this.ativo = novo;
	}
	public int getIndex()
	{
		return index;
	}
	public String getNome()
	{
		return nome;
	}
	public Pokemon[] getFesta()
	{
		return festa;
	}
	public Pokemon getPokemon(int index)
	{
		return festa[index];
	}
	public Item[] getItens()
	{
		return mochila;
	}
	
}
