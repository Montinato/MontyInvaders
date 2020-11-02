package logica;

import java.util.List;

import grafica.PannelloGioco;
import interfacce.Direzione;


public class GestoreNemici implements Runnable{

	List<Nemico> nemici=null;
	
	public static boolean perso;
	
	public static int timeSleep;
	
	public GestoreNemici() {
		perso=false;
		
		timeSleep=700;
	}
	
	public void stampaNemici()
	{
		nemici=PannelloGioco.gm.getNemici();
		
		for(int i=0;i<nemici.size();i++)
		{
			Nemico e= (Nemico) nemici.get(i);
			
		}
	}
	
	public void movimentoNemici()
	{
		nemici=PannelloGioco.gm.getNemici();
		
	    while(nemici.size()>0)
	    {
	    	for(int i=0; i<nemici.size(); i++)
			{
				if(nemici.get(i).getX()<=50)
				{
					perso = true;
					break;
				}
			}
	    
	    	for(int i=0;i<nemici.size();i++)
	    	{
	    		nemici.get(i).setDirezione(Direzione.NORD);
	    	}
	    	PannelloGioco.gm.aggiorna();
	    	
	    	try
	    	{
	    		Thread.sleep(timeSleep);
	    		
	    	}
	    	catch(Exception e) {}
	    	
	    	for(int i=0;i<nemici.size();i++)
	    	{
	    		nemici.get(i).setDirezione(Direzione.EST);
	    		
	    	}
	    	PannelloGioco.gm.aggiorna();
	    	try
	    	{
	    		Thread.sleep(timeSleep);
	    		
	    	}
	    	catch(Exception e) {}
	    	for(int i=0;i<nemici.size();i++)
	    	{
	    		nemici.get(i).setDirezione(Direzione.SUD);
	    		
	    	}
	    	PannelloGioco.gm.aggiorna();
	    	try
	    	{
	    		Thread.sleep(timeSleep);
	    		
	    	}
	    	catch(Exception e) {}
	    	for(int i=0;i<nemici.size();i++)
	    	{
	    		nemici.get(i).setDirezione(Direzione.EST);
	    		
	    	}
	    	PannelloGioco.gm.aggiorna();
	    	try
	    	{
	    		Thread.sleep(timeSleep);
	    		
	    	}
	    	catch(Exception e) {}
	}
	}

	@Override
	public void run() {
	 movimentoNemici();
		
	}
}

