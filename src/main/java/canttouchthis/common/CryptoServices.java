/*
 * CryptoServices.java
 * 
 * Provides encryption services for messages sent and received
 * by client and server.
 * 
 */

package canttouchthis.common;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class CryptoServices {

    /* 
     * Initialize constructor
     * for initialization vector for use in encryption/decryption with Cipher
     */
    public SecureRandom randomIVGenerator;
    public byte[] iv;
    public IvParameterSpec ivspec;

    public CryptoServices() {
        this.randomIVGenerator = new SecureRandom();
        this.iv = new byte[16];
        randomIVGenerator.nextBytes(iv);
        this.ivspec = new IvParameterSpec(iv);
    }

    /**
     * Encrypt plaintext with AES.
     * 
     * @param plaintext Byte array containing message.
     * @param key Key passed to method to encrypt under.
     * @throws Exception For all possible exceptions (i.e. invalid key, bad padding, etc.)
     */
    public byte[] encryptSymmetric(String plaintext, Key key) throws Exception {
        byte ptBytes[] = plaintext.getBytes();

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, key, ivspec);
        byte[] ciphertext = new byte[c.getOutputSize(ptBytes.length)];
        c.doFinal(ptBytes, 0, ptBytes.length, ciphertext);

        return ciphertext;
    }

    /**
     * Decrypt ciphertext with AES.
     * 
     * @param ciphertext Byte array containing message.
     * @param key Key passed to method to encrypt under.
     * @throws Exception For all possible exceptions (i.e. invalid key, bad padding, etc.)
     */
    public String decryptSymmetric(byte[] ciphertext, Key key) throws Exception {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, key, ivspec);
        byte[] newPlaintext = new byte[c.getOutputSize(ciphertext.length)];
        c.doFinal(ciphertext, 0, newPlaintext.length, newPlaintext);

        // find last non-zero byte (O(1) since there padding bits is upper bounded by blocksize)
        int lastCharInd = newPlaintext.length - 1;
        while (newPlaintext[lastCharInd] == 0)
            lastCharInd--;

        return new String(newPlaintext, 0, lastCharInd + 1);
    }
}
