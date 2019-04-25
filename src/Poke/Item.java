package Poke;

public class Item {
	private int cura;
	private String nome;
	Item(int cura, String nome)
	{
		this.cura = cura;
		this.nome = nome;
	}
	public int getCura()
	{
		return cura;
	}
	public String getNome()
	{
		return nome;
	}
}
