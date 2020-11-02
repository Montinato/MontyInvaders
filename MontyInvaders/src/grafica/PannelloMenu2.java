package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


import logica.GestoreNemici;
import manager.GameManager;

public class PannelloMenu2 extends JPanel implements KeyListener{
 
	Image haiVinto = null;
	Image gameOver = null;
	Image bar = null;
	Image score = null;
	
	public static boolean livelloPassato=false;
	
	public PannelloMenu2()
	{
		super();
		this.setFocusable(true);
		this.addKeyListener(this);
		caricaImmagine();
	}
	
	public void caricaImmagine()
	{
		Toolkit tk= Toolkit.getDefaultToolkit();
		haiVinto=tk.getImage("immagini/youWin.gif");
		gameOver=tk.getImage("immagini/gameOver.gif");
		bar=tk.getImage("immagini/bar.png");
		score=tk.getImage("immagini/hi_score.png");
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(PannelloGioco.gm.getPlayer().getVite()<=0 || GestoreNemici.perso)
		{
			g.drawImage(gameOver, 0, 0, PannelloGioco.gm.getMondo().getLarghezza(), PannelloGioco.gm.getMondo().getAltezza(), this);
			GameManager.contLivello=1;
			livelloPassato=false;
		}
		else if(PannelloGioco.gm.getNemici().size()==0 && PannelloGioco.gm.getPlayer().getVite()>0)
		{
			g.drawImage(haiVinto, 0, 0, PannelloGioco.gm.getMondo().getLarghezza(), PannelloGioco.gm.getMondo().getAltezza(), this);
			livelloPassato=true;
		}
		
		
		g.drawImage(bar, 0, 600, 800, 50, this);
		g.drawImage(score, 400, 600, 150, 45, this);
		g.setFont(new Font("TimesRoman",Font.BOLD,40));
		g.setColor(new Color(255,255,255));
		g.drawString(PannelloGioco.s.getPunteggio(), 555, 637);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(livelloPassato && GameManager.contLivello<4)
				GameManager.contLivello++;
			
			if(GameManager.contLivello==4 && livelloPassato)
			GameManager.contLivello=1;
			
		
		
		
		StartMenu.Audio_gioco.stopSoundtrackSound();
		StartMenu.Menu_gioco.Menu2_gioco.setVisible(false);
		StartMenu.Menu_gioco.Menu2_gioco.setFocusable(false);
		
		
	    StartMenu.Menu_gioco.carica_pannello();
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
