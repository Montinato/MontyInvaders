package grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class PannelloMenu extends JPanel implements KeyListener {

  
  JButton info= new JButton("INFO");

     Image info2=null;
	Image sfondo = null;
    Image StartGame = null;
    Image bar_menu = null;
    boolean disegnaInfo=false;
    public PannelloMenu()
    {
    	
    	super();
    	this.setFocusable(true);
    	
    	caricaImmagine();
    	this.addKeyListener(this);


    	info.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			 disegnaInfo=true;
			 info.setVisible(false);
		}
		});
    	
    	
    	info.setBackground(Color.green);
    	
    	this.add(info);
    }
    
    public void caricaImmagine()
    {
    	
    	Toolkit tk=Toolkit.getDefaultToolkit();
    	sfondo= tk.getImage("immagini/Sfondomonty.jpg");
    	StartGame= tk.getImage("immagini/start.gif");
    	bar_menu= tk.getImage("immagini/bar_menu.png");
    	info2=tk.getImage("immagini/info.jpg");
    	
    }
    
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	g.drawImage(sfondo, 0, 0, 800, 600, this);
    	g.drawImage(bar_menu, 0, 600, 800, 50, this);
    	g.drawImage(StartGame, 300, 525, 200, 200, this);
    	if(disegnaInfo)
    		g.drawImage(info2, 0, 0, 800, 600, this);
    	
    	
    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		
		if(code==KeyEvent.VK_ENTER)
		{
			
			
			StartMenu.Menu_gioco.carica_pannello();
			
		}
	
    }

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
