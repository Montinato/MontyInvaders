package logica;

import java.util.TimerTask;

import grafica.PannelloGioco;

public class TaskIncrementaVelocità  extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(GestoreNemici.timeSleep>750)
			GestoreNemici.timeSleep-=250;
		if(GestoreNemici.timeSleep==750)
		{
			
			PannelloGioco.timer.cancel();
		}
		
	}
  
}
