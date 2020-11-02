package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JPanel;

import interfacce.Direzione;
import logica.GestoreNemici;
import logica.Proiettile;
import manager.GameManager;
import logica.*
;public class PannelloGioco extends JPanel implements Runnable,KeyListener {
	
	Image exit = null;
	Image restart = null;
	Image sfondo = null;
	Image player = null;
	Image nemico = null;
	Image nemicoUcciso = null;
	Image pausa = null;
	Image proiettile = null;
	Image youWin = null;
	Image score = null;
	Image vite = null;
	Image bar = null;
			
   public static GameManager gm;
   
   Thread muoviNemici=null;
   
   Thread muoviProiettili=null;
   Thread t=null;
   
   public static Timer timer=null;
   public static Timer timer2=null;

   
   public PannelloGioco()
   {
	   super();
	   this.setFocusable(true);
	   this.addKeyListener(this);
	   caricaImmagine();
	   
	   gm=new GameManager();
	   
	   if(!PannelloMenu2.livelloPassato)
		   s=new Punteggio();
	  
	   gm.startGame();
	   
	   muoviNemici=new Thread(new GestoreNemici());
	
	   muoviNemici.start();
	  
	   StartMenu.Menu_sound.stopSound();
	   
	   
	   StartMenu.Audio_gioco.playSoundtrackSound();
	   
	   runTask();
   }
   
   
   public void caricaImmagine()
   {
	   Toolkit tk=Toolkit.getDefaultToolkit();
	   sfondo=tk.getImage("immagini/sfondo.png");
	   player= tk.getImage("immagini/player.png");
	   nemico=tk.getImage("immagini/enemy.gif");
	   nemicoUcciso=tk.getImage("immagini/enemyKilled.png");
	   proiettile=tk.getImage("immagini/bullet.png");
	   score=tk.getImage("immagini/hi_score.png");
	   vite=tk.getImage("immagini/lives.png");
	   bar=tk.getImage("immagini/bar.png");
	   
	 
	   
   }
   
   Proiettile p=null;
   List<Nemico> nemici=null;
   ArrayList proiettili=null;
   boolean nemicoColpito=false;
   boolean puòSparare=true;
   public static boolean fineGioco=false;
   public static Punteggio s=null;
   
   
   
protected void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	super.paintComponent(g);
	
	g.drawImage(sfondo, 0, 0, gm.getMondo().getLarghezza(),  gm.getMondo().getAltezza(), this);
	g.drawImage(player, gm.getPlayer().getX()-gm.FATTORE, gm.getPlayer().getY()-gm.FATTORE, this);
	g.drawImage(bar, 0, 600, 800, 50, this);
	g.drawImage(score, 500, 600, 150, 45, this);
	g.setFont(new Font("Arial",Font.BOLD,40));
	g.setColor(new Color(255,255,255));
	g.drawString(s.getPunteggio(), 657, 637);
	
	
	if(gm.getPlayer().getVite()==3)
	{
		g.drawImage(vite, 0, 600, 50, 50, this);
		g.drawImage(vite, 50, 600, 50, 50, this);
		g.drawImage(vite, 100, 600, 50, 50, this);
	}
	else if(gm.getPlayer().getVite()==2)
	{
		g.drawImage(vite, 100, 600, 50, 50, this);
		g.drawImage(vite, 150, 600, 50, 50, this);
	}
	else
	{
		g.drawImage(vite, 100, 600, 50, 50, this);
	}
	
	nemici=gm.getNemici();
	
	for(int j=0;j<nemici.size();j++)
	{
		Nemico e=(Nemico) nemici.get(j);
		
		if(e.getVite()==0)
		{
	
			g.drawImage(nemicoUcciso, e.getX()-gm.FATTORE, e.getY()-gm.FATTORE, this);
			this.updateUI();
			nemici.remove(j);
			s.aggiungiPunteggio();
			if(nemici.size()==0)
			{
				
				fineGioco=true;
				puòSparare=false;
			}
		}
		else
		{
			g.drawImage(nemico, e.getX()-gm.FATTORE, e.getY()-gm.FATTORE, this);
			
		}
		if(TaskDue.exit) {
			g.drawImage(proiettile, TaskDue.p.getX()-gm.FATTORE, TaskDue.p.getY()-gm.FATTORE, this);
			this.updateUI();
		}
		else {
			
		}
	}
	
	proiettili=gm.getPlayer().getProiettili();
	
	if(proiettili.size()>0)
	{
		Proiettile p=(Proiettile) proiettili.get(0);
		g.drawImage(proiettile,  p.getX()-gm.FATTORE, p.getY()-gm.FATTORE, this);
	}
	
	if(gm.getPlayer().getVite()<=0 || gm.getNemici().size()==0 || GestoreNemici.perso)
	{
		muoviNemici.stop();
		
		StartMenu.Menu_gioco.carica_Menu2Panel();
	}
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void keyPressed(KeyEvent e) {
	
	int code = e.getKeyCode();
	/*if(code==KeyEvent.VK_LEFT)
	{
		gm.getPlayer().setDirezione(Direzione.EST);
		gm.getPlayer().aggiorna();
		gm.getPlayer().setDirezione(Direzione.STOP);
	}
	if(code==KeyEvent.VK_RIGHT)
	{
		gm.getPlayer().setDirezione(Direzione.OVEST);
		gm.getPlayer().aggiorna();
		gm.getPlayer().setDirezione(Direzione.STOP);
	}*/
	if(code== KeyEvent.VK_UP)
	{
		gm.getPlayer().setDirezione(Direzione.NORD);
		gm.getPlayer().aggiorna();
		gm.getPlayer().setDirezione(Direzione.STOP);
	}
	else if(code==KeyEvent.VK_DOWN)
	{
		gm.getPlayer().setDirezione(Direzione.SUD);
		gm.getPlayer().aggiorna();
		gm.getPlayer().setDirezione(Direzione.STOP);
	}
	else if(code==KeyEvent.VK_SPACE)
	{
		if(puòSparare)
		{
			puòSparare=false;
			gm.getPlayer().caricaProiettili();
			//OGNI THREAD è UN PROIETTILE SPARATO
			t=new Thread(this);
			t.start();
			
			StartMenu.Audio_gioco.playSuonoSparo();
		}
	}
	
	this.validate();
	this.repaint();
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

public void runTask()
{
	timer=new Timer ();
	timer2=new Timer();
	TaskIncrementaVelocità task=new TaskIncrementaVelocità();
	TaskDue taskdue=new TaskDue();
	timer.scheduleAtFixedRate(task, 0, 3000);
	timer2.scheduleAtFixedRate(taskdue, 0, 200);
}

boolean run=true;
@Override
public void run() {
	// TODO Auto-generated method stub
	
	
	proiettili =gm.getPlayer().getProiettili();
	
	Proiettile p=(Proiettile) proiettili.get(0);
	
	while(p.getX()<800 && run)
	{
		p.aggiorna();
		this.validate();
		this.repaint();
		
		try
		{
			t.sleep(30);
		}
		catch (Exception e) { }
		
		
	
	
	for(int j=0;j<nemici.size();j++)
	{
		Nemico e= (Nemico) nemici.get(j);
		if(p.getX()==e.getX() && p.getY()==e.getY())
		{
			
			nemicoColpito=true;
			e.rimuoviUnaVita();
			if(e.getVite()==0)
			{
				
				StartMenu.Audio_gioco.playSuonoNemicoUcciso();
			}
			run=false;
		
		}
		
	}
	}
	if((p.getX()==800 || nemicoColpito) && (proiettili.size()>0))
	{
		
		nemicoColpito=false;
		puòSparare=true;
		proiettili.remove(0);
		
	}
	
	run =true;
	
}

}
