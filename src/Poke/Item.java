package Poke;

public class Item {
	private int cura;
	private String nome;
	
	public Item(String nome) {
		this(0, nome);
	}
	
	public Item(int cura, String nome)
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
