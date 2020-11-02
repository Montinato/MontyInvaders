package logica;
import java.util.TimerTask;
import logica.*;
import grafica.PannelloGioco;
import grafica.StartMenu;
import interfacce.Direzione;


public class TaskDue extends TimerTask {

	public static boolean exit=false;
	
	public static int RandomWithRange(int min,int max) {
		int range=(max-min)+1;
		return (int)(Math.random()*range)+min;
	}
	public static int pos=RandomWithRange(0,PannelloGioco.gm.getNemici().size()-1);
	public static Proiettile p=new Proiettile(PannelloGioco.gm.getMondo(),PannelloGioco.gm.getNemici().get(pos).getX()+PannelloGioco.gm.FATTORE,PannelloGioco.gm.getNemici().get(pos).getY(),Direzione.EST,50);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 pos=RandomWithRange(0,PannelloGioco.gm.getNemici().size()-1);
		 
		if(pos<=PannelloGioco.gm.getNemici().size()-1)
		{
			p.aggiorna();
		}
		if(p.getX()==PannelloGioco.gm.getPlayer().getX() && p.getY()==PannelloGioco.gm.getPlayer().getY())
		{
			PannelloGioco.gm.getPlayer().rimuoviUnaVita();
			StartMenu.Audio_gioco.playSuonoNemicoUcciso();
		}
		
		if(p.getX()==0)
		{
			exit=true;
			p=new Proiettile(PannelloGioco.gm.getMondo(),PannelloGioco.gm.getNemici().get(pos).getX()+PannelloGioco.gm.FATTORE, PannelloGioco.gm.getNemici().get(pos).getY(),Direzione.EST,50);
		    p.aggiorna();
		    
		    if(PannelloGioco.gm.getNemici().isEmpty())
		    	PannelloGioco.timer2.cancel();
		}
		
		
	}

}
