//package mypackage.myAesCBC;
//
//import java.util.Random;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//public class AesCBC {
//	private static String sKey = "1234567890123456";
//	private static String ivParameter = "1234567890123456";
//	private static AesCBC instance = null;
//	
//	private AesCBC() { }
//	/**
//	 * 生成一个实例, 一个类只有一个实例
//	 * @return 
//	 */
//	public static AesCBC getInstance() {
//		if(instance == null)
//			instance = new AesCBC();
//		return instance;
//	}
//	/**
//	 * 使用AES-CBC加密
//	 * @param sSrc 加密源
//	 * @param encodingFormat 编码
//	 * @param sKey	密钥
//	 * @param ivParameter iv向量
//	 * @return	加密的字符串
//	 * @throws Exception
//	 */
//	public String encrypt(String sSrc, String encodingFormat, 
//			String sKey, String ivParameter) throws Exception {
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//		byte[] raw = sKey.getBytes();
//		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
//		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//		byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
//		return new BASE64Encoder().encode(encrypted);
//	}
//	
//	public String decrypt(String sSrc, String encodingFormat, 
//			String sKey, String ivParameter) throws Exception {
//		try {
//			byte[] raw = sKey.getBytes("ASCII");
//			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
//			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
//			byte[] original = cipher.doFinal(encrypted1);
//			String originalString = new String(original, encodingFormat);
//			return originalString;
//  		} catch (Exception e) {
//  			return null;
//  		}
//	}
//	public static void main(String... args) throws Exception {
//		String cSrc = "123456";		//需要加密的字符串
//		
//		Random ran = new Random(47);
//		while(ran.nextInt(100) > 5)
//			cSrc += ran.nextInt(100);
//		
//		System.out.println("加密前的字符串是: " + cSrc);
//		String enString = AesCBC.getInstance().encrypt(cSrc, "utf-8", sKey, ivParameter);
//		System.out.println("加密后的字符串是: " + enString);
//		
//		// 解密
//		String DeString = AesCBC.getInstance().decrypt(enString,"utf-8",sKey,ivParameter);
//		System.out.println("解密后的字串是：" + DeString);
//		
//	}
//	
//}
