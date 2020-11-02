package logica;

import java.util.ArrayList;

import interfacce.Direzione;

public class Player extends OggettoDinamicoAstratto {
	

	private static final int ALTEZZA= 50;
	
	private static final int LARGHEZZA=50;
	
	private int vite;
	
	public static ArrayList proiettili;
	public static ArrayList getProiettili()
	{
		return proiettili;
	}
	
	public void caricaProiettili()
	{
		Proiettile proiettile= new Proiettile (mondo,this.getX(),this.getY(),Direzione.OVEST,50);
		proiettili.add(proiettile);
	}
	
	public Player(Mondo mondo, final int x,final int y, Direzione direzione, int velocità) {
		super(mondo, x, y, direzione, velocità, LARGHEZZA, ALTEZZA);
		// TODO Auto-generated constructor stub
		
		proiettili = new ArrayList();
		vite=3;
	}
	public void rimuoviUnaVita()
	{
		vite--;
	}
	
	


	@Override
	public void setDirezione(Direzione direzione) {
		// TODO Auto-generated method stub
		super.setDirezione(direzione);
	}

	@Override
	public String toString() {
		return "Gunner [vite=" + vite + ", getDirezione()=" + getDirezione() + ", getVelocità()=" + getVelocità() + ", getAltezza()="
                + getAltezza() + ", getLarghezza()=" + getLarghezza() + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}

   public int getVite()
   {
	   return vite;
   }
}
