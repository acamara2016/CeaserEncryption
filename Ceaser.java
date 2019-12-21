/*Written by Adama Camara
 * Ceaser.java is the file that will be used
 * to encrypt or decrypt a given string*/
public class Ceaser {
	public String alphabet="abcdefghijklmnopqrstuvwxyz";
	
	public String shift(String txt) {//encrypt the string by shifting the character up by 18 chars.
		txt=txt.toLowerCase();
		String cipher="";
		for(int i=0; i<txt.length(); i++) {
			cipher +=(char)((txt.charAt(i))+18);
		}
		return cipher;
	}
	public String Deshift(String txt) {//decrypt the string shifting the character back by 18 chars.
		txt=txt.toLowerCase();
		String cipher="";
		for(int i=0; i<txt.length(); i++) {
			cipher +=(char)((txt.charAt(i))-18);
		}
		return cipher;
	}
}
