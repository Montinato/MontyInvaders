package grafica;

import javax.swing.JFrame;

import audio.AudioGioco;
import audio.MenuSuono;

public class StartMenu {

	static MyFrame Menu_gioco = new MyFrame();
	static MenuSuono Menu_sound = new MenuSuono();
	public static AudioGioco Audio_gioco = new AudioGioco();

	public static void main(String[] args)
	{		
		
		Menu_gioco.carica_Menu();
	    
		Menu_gioco.setVisible(true);
		
	
		Menu_gioco.setResizable(true);
		
		
		Menu_sound.playSound();
	}
}
