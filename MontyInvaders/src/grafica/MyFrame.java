package grafica;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;



public class MyFrame  extends JFrame{
	
	public PannelloMenu Menu_gioco;
	public static PannelloGioco Pannello_gioco;
	public PannelloMenu2 Menu2_gioco;
	
	
	private static final String nome_gioco= "MONTY INVADERS";	
	
	public MyFrame()
	{
		super();
		this.setPreferredSize(new Dimension(805,677));
	
		
		
		this.setTitle(nome_gioco);
		this.setLocation(200,50);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void carica_Menu()
	{
		Menu_gioco=new PannelloMenu();
		this.add(Menu_gioco);
		Menu_gioco.setVisible(true);
		this.pack();
	}
	
	public void carica_pannello()
	{
		Menu_gioco.setVisible(false);
		Menu_gioco.setFocusable(false);
		Pannello_gioco=new PannelloGioco();
		this.add(Pannello_gioco);
		Pannello_gioco.requestFocus();
		Pannello_gioco.setVisible(true);
		Pannello_gioco.setFocusable(true);
		this.pack();
	}
	
	public void carica_Menu2Panel()
	{
		Pannello_gioco.setVisible(false);
		Pannello_gioco.setFocusable(false);
		Menu2_gioco= new PannelloMenu2();
		this.add(Menu2_gioco);
		Menu2_gioco.requestFocus();
		Menu2_gioco.setVisible(true);
		Menu2_gioco.setFocusable(true);
		this.pack();
	}
	

}
