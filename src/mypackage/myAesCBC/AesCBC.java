package mypackage.myAesCBC;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCBC {
	private static String sKey = "1234567890123456";
	private static String ivParameter = "1234567890123456";
	private static AesCBC instance = null;
	
	private AesCBC() { }
	private AesCBC getInstance() {
		if(instance == null)
			instance = new AesCBC();
		return instance;
	}
	public String encrypt(String sSrc, String encodingFormat, 
			String sKey, String ivParameter) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
		return new BASE64Encoder().encode(encrypted);
	}
}
