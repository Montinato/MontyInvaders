package logica;

import interfacce.Direzione;

public class Proiettile extends OggettoDinamicoAstratto {
 

private static final int ALTEZZA= 50;
  
  private static final int LARGHEZZA=50;

   public Proiettile(Mondo mondo, int x, int y, Direzione direzione, int velocit�) {
		super(mondo, x, y, direzione, velocit�, LARGHEZZA, ALTEZZA);
		// TODO Auto-generated constructor stub
	}
  
}
