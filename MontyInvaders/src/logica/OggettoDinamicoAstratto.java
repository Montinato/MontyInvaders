package logica;

import interfacce.Direzione;
import interfacce.OggettoDinamico;

public abstract  class OggettoDinamicoAstratto extends OggettoStaticoAstratto implements OggettoDinamico {

	
	private Direzione direzione;
	private final int velocit�;
	
	
	public OggettoDinamicoAstratto(Mondo mondo,final int x , int y,final Direzione direzione , final int velocit�,final int larghezza,final int altezza) {
		super(mondo, x, y, larghezza, altezza);
		this.direzione=direzione;
		this.velocit�=velocit�;
	}

    @Override
    public Direzione getDirezione()
    {
    	return direzione;
    }
    @Override
    public int getVelocit�()
    {
    	return velocit�;
    	
    }
    
	@Override
	public void aggiorna() {
		switch(getDirezione())
		{
		case NORD:
			if(getY()>50)
				setY(getY()-getVelocit�());
			break;
		case SUD:
			setY(getY()+getVelocit�());
			break;
		 case EST:
         	setX(getX() - getVelocit�());
             break;
         case OVEST:
             setX(getX() + getVelocit�());
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
    	return "OggettoAstrattoDinamico [direzione=" + direzione + ", velocit�=" + velocit� + ", toString()=" + super.toString() + "]";

	}
	
	
	
	
	
	
	
}
