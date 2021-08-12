import java.util.ArrayList;
import java.util.regex.Pattern;


public class Convert {
private ArrayList<Integer> resultat;

public Convert() {
this.resultat = new ArrayList<Integer>();
}

public ArrayList<Integer> getResultat() {
return resultat;
}

public void setResultat(ArrayList<Integer> resultat) {
this.resultat = resultat;
}
/**
* Méthode qui converti un nombre decimal en nombre binaire
* @param arg l'entier à convertir
* @return String, représentaion en caractère du résultat
*/
public String DecimalToBinaire(int arg){
try{
int leng;
String res="";
this.resultat.clear();
while(arg>1){
this.resultat.add(arg%2);
arg=(arg-(arg%2))/2;
}
this.resultat.add(arg);
leng=this.resultat.size();
for(int i=leng;i!=0;i--){
int a=this.resultat.get(i-1);
res=res+Integer.toString(a);
}
return res;
}
catch(NumberFormatException ex){
return "ce n'est pas un chiffre decimal";
}
}

/**
* Méthode qui converti un nombre decimal en nombre ocal
* @param arg l'entier à convertir
* @return String, représentaion en caractère du résultat
*/
public String DecimalToOctal(int arg){
try{
int leng;
String res="";
this.resultat.clear();
while(arg>7){
this.resultat.add(arg%8);
arg=(arg-(arg%8))/8;
}
this.resultat.add(arg);
leng=this.resultat.size();
for(int i=leng;i!=0;i--){
int a=this.resultat.get(i-1);
res=res+Integer.toString(a);
}
return res;
}
catch(NumberFormatException ex){
return "ce n'est pas un chiffre decimal";
}
}

/**
* Méthode qui converti un nombre decimal en nombre hexadecimal
* @param arg l'entier à convertir
* @return String, représentaion en caractère du résultat
*/
public String DecimalToHexadecimal(int arg){
try{
int leng;

String res="";
this.resultat.clear();
while(arg>15){
this.resultat.add(arg%16);
arg=(arg-(arg%16))/16;
}
this.resultat.add(arg);
leng=this.resultat.size();
for(int i=leng;i!=0;i--){
int a=this.resultat.get(i-1);
if(a==10)res=res+"A";
else if(a==11)res=res+"B";
else if(a==12)res=res+"C";
else if(a==13)res=res+"D";
else if(a==14)res=res+"E";
else if(a==15)res=res+"F";
else res=res+Integer.toString(a);
}
return res;
}
catch(NumberFormatException ex){
return "ce n'est pas un chiffre decimal";
}
}

public int power(int a,int p){
int res=1;
for(int i=0;i<p;i++)res*=a;
return res;
}

/**
* Méthode qui converti un nombre binaire en nombre decimal
* @param arg le chiffre binaire à convertir
* @return int, résultat en décimal
*/
public int BinaireToDecimal(String arg){
if (Pattern.matches("[0-1]*",arg)) {
int leng=arg.length();
int res=0;
for(int i=leng;i!=0;i--){
int a=Integer.parseInt(Character.toString(arg.charAt(i-1)));
res+=(a*power(2,leng-i));
}
return res;
}
else {
System.out.println("ce n'est pas un chiffre octal");
return -1;
}

}

/**
* Méthode qui converti un nombre octal en nombre decimal
* @param arg le chiffre octal à convertir
* @return int, résultat en décimal
*/
public int OctalToDecimal(String arg){
if (Pattern.matches("[0-7]*",arg)) {
int leng=arg.length();
int res=0;
for(int i=leng;i!=0;i--){
int a=Integer.parseInt(Character.toString(arg.charAt(i-1)));
res+=(a*power(8,leng-i));
}
return res;
}
else {
System.out.println("ce n'est pas un chiffre octal");
return -1;
}
}

/**
* Méthode qui converti un nombre hexadecimal en nombre decimal
* @param arg le chiffre hexadecimal à convertir
* @return int, résultat en décimal
*/
public int HexadecimalToDecimal(String arg){
if (Pattern.matches("([0-9]|[a-f]|[A-F])*",arg)) {
int leng=arg.length();
int res=0;
int a;
for(int i=leng;i!=0;i--){
if(arg.charAt(i-1)=='A' || arg.charAt(i-1)=='a')a=10;
else if(arg.charAt(i-1)=='B' || arg.charAt(i-1)=='b')a=11;
else if(arg.charAt(i-1)=='C' || arg.charAt(i-1)=='c')a=12;
else if(arg.charAt(i-1)=='D' || arg.charAt(i-1)=='d')a=13;
else if(arg.charAt(i-1)=='E' || arg.charAt(i-1)=='e')a=14;
else if(arg.charAt(i-1)=='F' || arg.charAt(i-1)=='f')a=15;
else a=Integer.parseInt(Character.toString(arg.charAt(i-1)));
res+=(a*power(16,leng-i));
}
return res;
}
else {
System.out.println("ce n'est pas un chiffre hexadecimal");
return -1;
}

}

public String HexadecimalToBinaire(String arg){
if (Pattern.matches("([0-9]|[a-f]|[A-F])*",arg)) {
return this.DecimalToBinaire(HexadecimalToDecimal(arg));
}
else {
return "ce n'est pas un nombre hexadecimal";
}
}

public String HexadecimalToOctal(String arg){
if (Pattern.matches("([0-9]|[a-f]|[A-F])*",arg)) {
return this.DecimalToOctal(HexadecimalToDecimal(arg));
}
else {
return "ce n'est pas un nombre hexadecimal";
}
}

public String BinaireToOctal(String arg){
if (Pattern.matches("[0-1]*",arg)) {
return this.DecimalToOctal(BinaireToDecimal(arg));
}
else {
return "ce n'est pas un nombre binaire";
}
}

public String BinaireToHexadecimal(String arg){
if (Pattern.matches("[0-1]*",arg)) {
return this.DecimalToHexadecimal(BinaireToDecimal(arg));
}
else {
return "ce n'est pas un nombre binaire";
}
}

public String OctalToHexadecimal(String arg){
if (Pattern.matches("[0-7]*",arg)) {
return this.DecimalToHexadecimal(OctalToDecimal(arg));
}
else {
return "ce n'est pas un nombre octal";
}
}

public String OctalToBinaire(String arg){
if (Pattern.matches("[0-7]*",arg)) {
return this.DecimalToBinaire(OctalToDecimal(arg));
}
else {
return "ce n'est pas un nombre octal";
}
}

public static void main(String args[]){
Convert con=new Convert();

System.out.println("----------------- sans erreur ------------------");

System.out.println(con.DecimalToHexadecimal(46));
System.out.println(con.DecimalToOctal(12));
System.out.println(con.DecimalToBinaire(46));

System.out.println(con.BinaireToDecimal("100101100"));
System.out.println(con.BinaireToOctal("10011100"));
System.out.println(con.BinaireToHexadecimal("10011100"));

System.out.println(con.OctalToDecimal("123"));
System.out.println(con.OctalToBinaire("55"));
System.out.println(con.OctalToHexadecimal("77"));

System.out.println(con.HexadecimalToDecimal("a4"));
System.out.println(con.HexadecimalToBinaire("e8"));
System.out.println(con.HexadecimalToOctal("ff"));

System.out.println("\n\n\n----------------- avec erreur ------------------");

System.out.println(con.BinaireToDecimal("100171100"));
System.out.println(con.BinaireToOctal("10011g100"));
System.out.println(con.BinaireToHexadecimal("10065411100"));

System.out.println(con.OctalToDecimal("1283"));
System.out.println(con.OctalToBinaire("595"));
System.out.println(con.OctalToHexadecimal("7v7"));

System.out.println(con.HexadecimalToDecimal("aze"));
System.out.println(con.HexadecimalToBinaire("kf"));
System.out.println(con.HexadecimalToOctal("azeaze"));

System.out.println("----------------- FIN !!!!!!!!!! ------------------");
}
}