import java.util.ArrayList;
import java.util.AbstractCollection;
import java.io.File;
import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Lecture{
	
	private ArrayList<Trame> trame; //un ensemble de trames du fichier trace
	private File entree;  //fichier source
    
	
	public Lecture(File entree) throws Exception{
		this.entree=entree;
		BufferedReader car = null;
		trame = new ArrayList<Trame>();
	    String ligne;

	    try
	      {
			car = new BufferedReader(new FileReader(entree));
			//System.out.println("llllllaaaa");
			int numTrame = -1; //numero de la trame
			String offset=""; //l'offset du debut de a ligne
			String s=""; //chaine de caracteres d'une seule trame
			
			while ((ligne = car.readLine()) != null){
				System.out.println("numTrame="+numTrame);
				offset= ligne.substring(0,2);
				String c="";
				c= ligne.substring(3,ligne.length());
				if(offset.equals("00")){
					s="";
					Trame t = new Trame();
					trame.add(t);
					numTrame++;
				}
				s=s+c;
				trame.get(numTrame).setTrame(s);
	     	}

	    }
	    catch(Exception exc)
	      {
			System.out.println(exc);
			
	      }
	  	  
	    car.close();
	    
	}

	public void construire(){
		for(int i =0; i<trame.size(); i++){
			File sortie = new File();
			trame.get(i).lectureTrame(sortie); //pour chaque trame on ecrit sur le ficheir sortie l'analyse faite
		}
	}



	
	
	public String toString(){
		return "Trame 1: \n"+this.trame;
	}

	public static void main(String args[]){
		try{
			File fic= new File(args[0]);
			Lecture ltt= new Lecture(fic);
			for(int i=0; i<ltt.trame.size(); i++){
				System.out.println("i="+i+"   "+ltt.trame.get(i).getTrame());
			}

		}
		catch(Exception e){
			System.out.println("Erreur fichier");
		}
		
		
	}




	//File fic;
    //fic= try(BufferedReader in = new BufferedReader(new FileReader(f))){

}