package Crypter;
public class CrypterReverse implements Crypter {

	@Override
	public String encrypt(String message) {
		String crypted ="";
		for(int i=message.length()-1;i>=0;i--){
			crypted = crypted+message.charAt(i);
		}
		return crypted;
	}

	@Override
	public String decrypt(String cryperText) {
		String decrypted="";
		for(int i=cryperText.length()-1;i>=0;i--){
			decrypted= decrypted+cryperText.charAt(i);
		}
		return decrypted;
	}

}
