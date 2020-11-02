package manager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import grafica.PannelloGioco;
import interfacce.Direzione;
import interfacce.OggettoStatico;

import logica.*;


public class GameManager {

	static final int MATRICE_L=16;
	static final int MATRICE_A=12;
	
	public static final int FATTORE=50;
	
	
	
	
  private static char [][] getMatriceVuota()
  {
	  final char[][] matrix = new char[12][16];
      for (int i = 0; i < MATRICE_A; i++)
      {
          for (int j = 0; j < MATRICE_L; j++)
          {
              matrix[i][j] = OggettoChar.VUOTO.getCarattere();
          }
      }
      return matrix;
  }
  
  public static void posiziona(final char [][] matrice,final OggettoStatico o)
  {
	  int x_m= o.getX()/FATTORE -1;
	 
	  x_m = x_m < 0 ? 0 : x_m;
	  
	  int y_m = o.getY() / FATTORE- 1;                
      y_m = y_m < 0 ? 0 : y_m;
      
      final OggettoChar oc=OggettoChar.daCharAOggetoChar(o);
      
      matrice[y_m][x_m]=oc.getCarattere();
      
	  
  }
  
  
  
  private static OggettoChar[][] leggiLivelloFile(final String filename)
  {
      final OggettoChar[][] matrice = new OggettoChar[MATRICE_A][MATRICE_L];

      List<String> allLines;
      try
      {
          allLines = Files.readAllLines(new File(filename).toPath());
      }
      catch (final IOException e)
      {
          throw new RuntimeException(String.format("Livello file '%s' not trovato", filename), e);
      }
      int i = 0, j = 0;
      for (final String line : allLines)
      {
          j = 0;
          for (final char c : line.toCharArray())
          {
              matrice[i][j] = OggettoChar.daCharAOggettoChar(c);
              j++;

          }
          i++;
      }
      
      return matrice;
  }
  public Mondo mondo;
  List<Nemico> nemici= null;
  private Player p;
  
  public GameManager()
  {
	  
  }
  
  public List<Nemico> getNemici()
  {
	  return nemici;
  }
  public Player getPlayer()
  {
	  return p;
  }
  
  public boolean gameOver()
  {
	  if(getPlayer().getVite()==0)
	  {
		 
		  return true;
	  }
	  return false;
  }
  public void setNemici(final ArrayList nemici)
  {
	  this.nemici=nemici;
	  
  }
  public void setPlayer(Player p)
  {
	  this.p=p;
  }
  public static int contLivello=1;
  
  
  public void startGame()
  {
	  
	 
	  final OggettoChar [][] matrice= leggiLivelloFile("Livelli/level"+contLivello+".dat");
	  daMatriceAmondo(matrice);
	 
	  
	 // convertiStampa();
	  
	  
  }
  
  public void aggiorna()
  {
	  p.aggiorna();
	  for(int i=0;i<nemici.size();i++)
	  {
		  Nemico e= (Nemico) nemici.get(i);
		  
		  
		  if(e!= null)
		  {
			  e.aggiorna();
			  if(p.getX()==e.getX() && p.getY()==e.getY())
			  {
				  
				  p.rimuoviUnaVita();
				  
				  if(getPlayer().getVite()<=0)
					 
				    PannelloGioco.fineGioco=true;
			  }
		  }
	  }
  }
  
  public void convertiStampa()
  {
	  final char[][] daMondoAmatrice= daMondoAmatrice();
	  stampa(daMondoAmatrice);
  }
  public static void stampa(final char [][] matrice)
  {
	  for (int i = 0; i < MATRICE_A; i++)
      {
          for (int j = 0; j < MATRICE_L; j++)
          {
              System.out.print(matrice[i][j]);
          }
          System.out.println();
      }
  }
  
  public void daMatriceAmondo(final OggettoChar [][] matrice)
  {
	  mondo=new Mondo();
	 
	  nemici=new ArrayList<>();
	  
	  for(int i=0;i<MATRICE_A;i++)
	  {
		  for(int j=0;j<MATRICE_L;j++)
		  {
			 
			  final int y = (i * FATTORE) + 50;
              final int x = (j * FATTORE) + 50;
			
			  
			  switch(matrice[i][j])
			  {
			  case NEMICO:
				  
				  nemici.add(new Nemico(mondo,x,y,Direzione.STOP,50));
				
				  break;
			  case PLAYER:
				 
				  
                  p= new Player(mondo,x, y, Direzione.STOP, 50);
                 
              default:
            	  break;
			  }
		  }
	  }
  }
  
  private void resetLivello()
  {
	  System.out.println("Reset livello");
  }
  
  
  private char[][] daMondoAmatrice()
  {
      final char[][] matrice = getMatriceVuota();
      for (final Nemico nemico : nemici)
      {
    	  
          posiziona(matrice, nemico);
         
         
      }

      posiziona(matrice, p);

      return matrice;
  }
  
  public Mondo getMondo()
  {
	  return mondo;
  }
  
  
  
}

