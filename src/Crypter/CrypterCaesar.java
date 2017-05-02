package Crypter;
import java.util.HashMap;
import java.util.Map;

import org.omg.Messaging.SyncScopeHelper;

public class CrypterCaesar implements Crypter {
	
	
	
	public Map<String,String> myMap = new HashMap<String,String>();
	
	@Override
	public String encrypt(String message){
		myMap.put("a", "D"); myMap.put("b", "E"); myMap.put("c", "F"); myMap.put("d", "G");
		myMap.put("e", "H"); myMap.put("f", "I"); myMap.put("g", "J"); myMap.put("h", "K");
		myMap.put("i", "L"); myMap.put("j", "M"); myMap.put("k", "N"); myMap.put("l", "O");
		myMap.put("m", "P"); myMap.put("n", "Q"); myMap.put("o", "R"); myMap.put("p", "S");
		myMap.put("q", "T"); myMap.put("r", "U"); myMap.put("s", "V"); myMap.put("t", "W");
		myMap.put("u", "X"); myMap.put("v", "Y"); myMap.put("w", "Z"); myMap.put("x", "A");
		myMap.put("y", "B"); myMap.put("z", "C");
	  
		String encrypt="";
		String key=message;
	
		for(int i=0;i<key.length();i++){
		char z= key.charAt(i);
		String y = Character.toString(z);
	
		
		encrypt =encrypt+myMap.get(y);
		//System.out.println(encrypt);
		}
	
		return encrypt;
	}

	@Override
	public String decrypt(String cryperText) {
		myMap.put("D", "a"); myMap.put("E", "b"); myMap.put("F", "c"); myMap.put("G", "d");
		myMap.put("H", "e"); myMap.put("I", "f"); myMap.put("J", "g"); myMap.put("K", "h");
		myMap.put("L", "i"); myMap.put("M", "j"); myMap.put("N", "k"); myMap.put("O", "l");
		myMap.put("P", "m"); myMap.put("Q", "n"); myMap.put("R", "o"); myMap.put("S", "p");
		myMap.put("T", "q"); myMap.put("U", "r"); myMap.put("V", "s"); myMap.put("W", "t");
		myMap.put("X", "u"); myMap.put("Y", "v"); myMap.put("Z", "w"); myMap.put("A", "x");
		myMap.put("B", "y"); myMap.put("C", "z");
		String decrypt="";
		String key=cryperText;
	
		for(int i=0;i<key.length();i++){
		char z= key.charAt(i);
		String y = Character.toString(z);
	
		
		decrypt =decrypt+myMap.get(y);
		//System.out.println(encrypt);
		}
	
		return decrypt;
		
	}
	
	
}
