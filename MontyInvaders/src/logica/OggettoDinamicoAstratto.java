package logica;

import interfacce.Direzione;
import interfacce.OggettoDinamico;

public abstract  class OggettoDinamicoAstratto extends OggettoStaticoAstratto implements OggettoDinamico {

	
	private Direzione direzione;
	private final int velocità;
	
	
	public OggettoDinamicoAstratto(Mondo mondo,final int x , int y,final Direzione direzione , final int velocità,final int larghezza,final int altezza) {
		super(mondo, x, y, larghezza, altezza);
		this.direzione=direzione;
		this.velocità=velocità;
	}

    @Override
    public Direzione getDirezione()
    {
    	return direzione;
    }
    @Override
    public int getVelocità()
    {
    	return velocità;
    	
    }
    
	@Override
	public void aggiorna() {
		switch(getDirezione())
		{
		case NORD:
			if(getY()>50)
				setY(getY()-getVelocità());
			break;
		case SUD:
			setY(getY()+getVelocità());
			break;
		 case EST:
         	setX(getX() - getVelocità());
             break;
         case OVEST:
             setX(getX() + getVelocità());
             break;
		default:
			break;
				
		}
		
	}

    protected void setDirezione(final Direzione direzione)
    {
    	this.direzione=direzione;
    }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
    	return "OggettoAstrattoDinamico [direzione=" + direzione + ", velocità=" + velocità + ", toString()=" + super.toString() + "]";

	}
	
	
	
	
	
	
	
}
