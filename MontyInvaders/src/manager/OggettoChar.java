package manager;

import interfacce.OggettoStatico;
import logica.Nemico;
import logica.Player;

public enum OggettoChar {

	VUOTO('-'), PLAYER('|'), NEMICO('O');
	
	 public static OggettoChar daCharAOggettoChar(final char c)
	    {
	        switch (c)
	        {
	            case '|':
	                return PLAYER;
	            case 'O':
	                return NEMICO;
	            default:
	                return VUOTO;
	        }
	    }
	 
	 public static OggettoChar daCharAOggetoChar(final OggettoStatico o)
	 {
		 if(o instanceof Nemico)
		 {
			 return NEMICO;
		 }
			 
		 if(o instanceof Player )
		 {
			 return PLAYER;
		 }
			 
		 return VUOTO;
	 }
	 private final char c;
	 
	 private OggettoChar (final char c)
	 {
		 this.c=c;
	 }
	 
	 public char getCarattere()
	 {
		 return c;
	 }
	 
}
