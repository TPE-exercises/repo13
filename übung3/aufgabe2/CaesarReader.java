package aufgabe2;

import java.io.*;

public class CaesarReader extends FilterReader {
	
	private int key;
	
	public static final char[] caesartable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü' };

	
	public CaesarReader(Reader arg0,int key){
		super(arg0);
		this.key=key;
		}

	@Override
	public int read() throws IOException {	
		int toDecrypt = super.read();
		if(toDecrypt == -1){
			return -1;
		}else return caesarDecrypt((char)toDecrypt);
	}

	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int ret = super.read(cbuf, off, len);
		for(int i = 0; i < cbuf.length; i++){
			cbuf[i] = caesarDecrypt(cbuf[i]);
		}
		return ret;
	}

	/**
	 * decrypt char 
	 * @param toDecrypt
	 * @return char
	 */
	private char caesarDecrypt(char toDecrypt){
		int position = caesartable.length;
		for(int i = 0; i < caesartable.length; i++){
			if(caesartable[i] == toDecrypt){
				position = i - key;
			}
		}
		//if there is an underflow
		while(position < 0){
			position += caesartable.length;
		}
		if(position < caesartable.length){
			return caesartable[position];
		}
		//else:= toCrypt is special char
		else{
			return toDecrypt;
		}
	}
}
