package logica;

import interfacce.Direzione;

public class Nemico extends OggettoDinamicoAstratto {
	 
	private static final int ALTEZZA = 50;

    private static final int LARGHEZZA = 50;
    
    private int vite;
    
    public Nemico(Mondo mondo, int x, int y, Direzione direzione, final int velocità)
    {
        super(mondo, x, y, direzione, velocità, LARGHEZZA, ALTEZZA);
        
        vite = 1;
    }
    public int getVite()
    {
    	return vite;
    }
    public boolean inVita()
    {
    	if(vite==0)
    		return false;
    	return true;
    }
    
    public void rimuoviUnaVita()
    {
    	vite--;
    }
    @Override
    public void setDirezione(Direzione direzione)
    {
    	super.setDirezione(direzione);
    }
	@Override
	public String toString() {
		 return "Nemico [getDirezione()=" + getDirezione() + ", getVelocità()=" + getVelocità() + ", getAltezza()=" + getAltezza()
         + ", getLarghezza()=" + getLarghezza() + ", getX()=" + getX() + ", getY()=" + getY() + "]";
		
	}
}