package Crypter;
public class main {

	public static void main(String[]args){
	
	CrypterReverse reverse = new CrypterReverse();
	CrypterCaesar caesar = new CrypterCaesar();

	String a="caesar";
	
	a=reverse.encrypt(a);
	System.out.println(a);
	a=reverse.decrypt(a);
	System.out.println(a);
	
	System.out.println("");
	
	a=caesar.encrypt(a);
	System.out.println(a);
	a=caesar.decrypt(a);
	System.out.println(a);
	
	
	
	
	
	}
	
	
	
}
