package logica;

public class Punteggio {
   
	private int punteggio;
	
	public Punteggio()
	{
		punteggio=0;
	}
	
	public String getPunteggio()
	{
		return String.valueOf(punteggio);
	}
	public void aggiungiPunteggio()
	{
		punteggio+=100;
	}
}
