import java.util.ArrayList;
import java.util.AbstractCollection;
import java.io.File;
import java.io.File;
import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.String;

public class Trame{
	
	private String trame;
	private File fic;

	public Trame(){
		trame="";
	}
    
	
	public Trame(File fic) throws Exception{
		this.fic=fic;
		BufferedReader car = null;
	    String ligne;

	    try
	      {
			car = new BufferedReader(new FileReader(fic));
			while ((ligne = car.readLine()) != null)
	    		trame=ligne;
	      //System.out.println(trame);
	      }
	    catch(Exception exc)
	      {
			System.out.println("Erreur d'ouverture");
	      }
	    
	  	 
	  	  
	    car.close();
	    
	}

	public void setTrame(String s){
		trame=s;
	}


		
	public String getAddDest(){
		String res="";
			String tmp= this.getTrame();

		for(int i=18; i< 36; i++){
			
				char s= tmp.charAt(i);
				res=res+s;
		}
		return res;
		
	}

	public String getAddSource(){// adresse mac -> couche
		String res="";
		for(int i=0; i< 17; i++){
			char s= trame.charAt(i);
			if(s.equals(' ')){
				res=res
			}
			res=res+s;
		}
		return res;
		
	}

	/*public void identProtocole(){
		String tmp= this.getTrame();
		for(int i=0; i< tmp.length(); i++){
			char s= tmp.charAt(i);
			res=res+s;
		}
	}*/
	
	public String getTrame(){
		return this.trame;
	}

	public String toString(){
		return "Trame 1: \n"+this.trame;
	}


	public void lectureTrame(File fichierSortie){ //on met les resultat de la lecture dans fichierSortie
		//1 lecture de l'entete de la trame
		try{
			BufferedWriter fic = new BufferedWriter(fichierSortie);
			String add_src = trame.substring(0,17);
			add_src = add_asrc.replaceAll(" ",":");

			String add_dest = trame.substring(18,37);
			add_dest = add_dest.replaceAll(" ",":");

			String protocole = trame.substring(38,45);
			String type="Ipv"+protocole.charAt(6);
			fic.write("Ethernet II, Src : "+add_src+", Dest : "+add_dest+"\n");
			fic.write("     Adresse destination: "+add_dest+"\n");
			fic.write("     Adresse source: "+add_src+"\n");
			fic.write("     Type: "+type+"(0x"+protocole.substring(0,5)+")\n");
			fic.close();
			//lecture paquet
			Paquet p= new Paquet(trame.substring(44,trame.length()),fichierSortie); // s n'a pas d'entete de la couche 2
			p.lecturePaquet();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void main(String args[]){
		try{
			File fic= new File(args[0]);
			Trame t1= new Trame(fic);
			//System.out.println(t1.getTrame());
			//System.out.println(t1.toString());
			System.out.println(t1.getAddSource());
			System.out.println(t1.getAddDest());

		}
		catch(Exception e){
			System.out.println("Erreur fichier");
		}
		
		
	}



}