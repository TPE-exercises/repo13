package aufgabe2;

import java.io.*;

public class CaesarWriter extends FilterWriter {

	public static final char[] caesartable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü' };
	
	private int key;
	
	public CaesarWriter(Writer arg0, int key) {
		super(arg0);
		this.key = key;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		char [] copyCbuf = copyCharArr(cbuf);
		for(int i = 0; i < copyCbuf.length ; i++){
			copyCbuf[i] = caesarCrypt(copyCbuf[i]);
		}
		super.write(copyCbuf, off, len);
	}

	/**
	 * crypting int c and write down
	 * @param c
	 */
	@Override
	public void write(int c) throws IOException {
		int copyC = c;
		copyC = caesarCrypt((char) copyC);
		super.write(copyC);
	}

	/**
	 * write down String 
	 * @param str
	 * @param off - startpoint
	 * @param len - endpoint 
	 */
	@Override
	public void write(String str, int off, int len) throws IOException {
		char[] copyStrC = str.toCharArray();
		for(int i = 0; i < copyStrC.length ; i++){
			copyStrC[i] = caesarCrypt(copyStrC[i]);
		}
		String copyStrS = new String(copyStrC);
		super.write(copyStrS, off, len);
	}
	
	/**
	 * copying char array
	 * @param tca
	 * @return copyArr
	 */
	private char[] copyCharArr(char[] tca){
		char [] copyArr = new char[tca.length];
		for(int i = 0; i < tca.length; i++){
			copyArr[i] = tca[i];
		}
		return copyArr;
	}
	
	/**
	 * crypting char
	 * @param toCrypt
	 * @return crypted char
	 */
 	private char caesarCrypt(char toCrypt){
		int position = -1;
		for(int i = 0; i < caesartable.length; i++){
			if(caesartable[i] == toCrypt){
				position = i + key;
			}
		}
		//if there is an overflow
		while(position > caesartable.length-1){
			position -= caesartable.length;
		}
		if(position>=0){
			return caesartable[position];
		}
		//else:= toCrypt is special char
		else{
			return toCrypt;
		}
	}
}
