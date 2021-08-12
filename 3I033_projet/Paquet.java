import java.util.ArrayList;
import java.util.AbstractCollection;
import java.io.File;
import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Paquet{
	String paquet;
	File sortie;
	public Paquet(String p, File f){
		paquet = p;
		sortie = f;
	}

	public void lecturePaquet(){
		try{
			BufferdWriter fic = new BufferdWriter(sortie);
			String add_ip_dest;
			String  add_ip_src;

			fic.write("Internet Protocole Version "+paquet.substring(0,1)+," Src: "+);
			String version ="     "+HexadecimalToOctal(paquet.substring(0,1))+" ...."+" = version : "+paquet.substring(0,1+"\n");
			fic.write(version);
			
			//longeur de l'entete = headerLine * 4;
			int longueurEntete = HexadecimalToDecimal(paquet.substring(1,2));
			longueurEntete = longueurEntete*4;
			String headerLine = "     .... "+HexadecimalToOctal(paquet.substring(1,2))+" = Header Length : "+longueuerEntete+" bytes\n";
			fic.write(headLine);

			String service = "     Differentiated Services Field: 0x00\n";
			fic.write(service);

			int ipLength =HexadecimalToDecimal(paquet.substring(7,9)+paquet.substring(10,12));
			String totalLength = "     TotalLength: "+ipLength+" (0x"+paquet.substring(7,12)+")\n";
			fic.write(totalLength);

			String identifier = "     Identifier: 0x"+paquet.substring(13,15)+paquet.substring(16,18)+" ("+HexadecimalToDecimal(paquet.substring(13,15)+paquet.substring(16,18))+")\n";
			fic.write(identifier);

			String flags = "Flags: 0x"+paquet.substring(18,20);



		}catch(EXception e){
			e.printStackTrace();
		}
	}
}