package logica;

import interfacce.Direzione;
import interfacce.OggettoDinamico;

public abstract  class OggettoDinamicoAstratto extends OggettoStaticoAstratto implements OggettoDinamico {

	
	private Direzione direzione;
	private final int velocitÓ;
	
	
	public OggettoDinamicoAstratto(Mondo mondo,final int x , int y,final Direzione direzione , final int velocitÓ,final int larghezza,final int altezza) {
		super(mondo, x, y, larghezza, altezza);
		this.direzione=direzione;
		this.velocitÓ=velocitÓ;
	}

    @Override
    public Direzione getDirezione()
    {
    	return direzione;
    }
    @Override
    public int getVelocitÓ()
    {
    	return velocitÓ;
    	
    }
    
	@Override
	public void aggiorna() {
		switch(getDirezione())
		{
		case NORD:
			if(getY()>50)
				setY(getY()-getVelocitÓ());
			break;
		case SUD:
			setY(getY()+getVelocitÓ());
			break;
		 case EST:
         	setX(getX() - getVelocitÓ());
             break;
         case OVEST:
             setX(getX() + getVelocitÓ());
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
    	return "OggettoAstrattoDinamico [direzione=" + direzione + ", velocitÓ=" + velocitÓ + ", toString()=" + super.toString() + "]";

	}
	
	
	
	
	
	
	
}
