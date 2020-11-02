package logica;

import interfacce.*;


public abstract class OggettoStaticoAstratto implements OggettoStatico {
 
	private int x;
	
	private int y;
	
	private final int larghezza;
	private final int altezza;
	protected final Mondo mondo;
	
	public  OggettoStaticoAstratto (final Mondo mondo, final int x,final int y, final int larghezza,final int altezza) {
		
		 this.mondo = mondo;
	        this.x = x;
	        this.y = y;
	        this.larghezza = larghezza;
	        this.altezza = altezza;
	}

	@Override
	public int getAltezza() {
		// TODO Auto-generated method stub
		return altezza;
	}

	@Override
	public int getLarghezza() {
		// TODO Auto-generated method stub
		return larghezza;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public boolean intersect(OggettoStatico altro) {
		// TODO Auto-generated method stub
		  return intersezioneInterna(altro) || altro instanceof OggettoStaticoAstratto
	                ? ((OggettoStaticoAstratto) altro).intersezioneInterna(this)
	                : false;
	}

	public boolean intersezioneInterna(final OggettoStatico altro)
	{
		if(altro.getX()>= x && altro.getX()<=x+larghezza && altro.getY()>=y && altro.getY()<=y+altezza)
			return true;
		
		if(altro.getX()>= x && altro.getX()<=x+larghezza && altro.getY()+altro.getAltezza()>=y && altro.getY()+altro.getAltezza()<=y+altezza)
			return true;
		if (altro.getX() >= x && altro.getX() <= x + larghezza && altro.getY() <= y && altro.getY() + altro.getAltezza() >= y + altezza)
            return true;
        
		 if (altro.getX() <= x && altro.getX() + altro.getLarghezza() >= x + larghezza && altro.getY() + altro.getAltezza() >= y
	                && altro.getY() + altro.getAltezza() <= y + altezza)
	        {
	            return true;
	        }
	        return false;
	   }
	
	protected Mondo getMondo()
	{
		return mondo;
	}
	
	public void setX(final int x)
	{
		if(x<0)
		{
			this.x=0;
			
		}
		else if(x>mondo.getLarghezza())
		{
			this.x=mondo.getLarghezza();
			
		}
		else
		{
			this.x=x;
		}
	}
	
	 public void setY(final int y)
	    {
	        if (y < 0)
	        {
	            this.y = 0;
	        }
	        else if (y > mondo.getAltezza())
	        {
	            this.y = mondo.getAltezza();
	        }
	        else
	        {
	            this.y = y;
	        }
	    }
	
		
	}

