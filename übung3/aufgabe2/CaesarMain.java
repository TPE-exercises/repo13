package aufgabe2;
import java.io.*;

public class CaesarMain {

	public static void main(String[] args) throws IOException {
	
		String orginal ="Hallo";
		int key=5;
		
		CaesarWriter cw = new CaesarWriter(new FileWriter("caesar.txt"),key);
		cw.write(orginal,0, orginal.length());
		cw.flush();
		
		
		CaesarReader cr = new CaesarReader(new FileReader("caesar.txt"),key);
		char[] cbuf = new char[orginal.length()];
		cr.read(cbuf);
		
		
		String result = new String(cbuf);
		System.out.println(result);
		
	}

}
