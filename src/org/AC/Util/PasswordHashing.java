package org.AC.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class PasswordHashing {

	
	 public  String doHash(String pass) throws NoSuchAlgorithmException, NoSuchProviderException 
	    {
	        String passwordToHash = pass;
	        String salt = "[B@692ec047";
	         
	        String securePassword = getSecurePassword(passwordToHash, salt);
	        return securePassword;
	    }
		    
		   
		
		 private static String getSecurePassword(String passwordToHash, String salt)
		    {
		        String generatedPassword = null;
		        try {
		            // Create MessageDigest instance for MD5
		            MessageDigest md = MessageDigest.getInstance("MD5");
		            //Add password bytes to digest
		            md.update(salt.getBytes());
		            //Get the hash's bytes 
		            byte[] bytes = md.digest(passwordToHash.getBytes());
		            //This bytes[] has bytes in decimal format;
		            //Convert it to hexadecimal format
		            StringBuilder sb = new StringBuilder();
		            for(int i=0; i< bytes.length ;i++)
		            {
		                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		            }
		            //Get complete hashed password in hex format
		            generatedPassword = sb.toString();
		        } 
		        catch (NoSuchAlgorithmException e) {
		            e.printStackTrace();
		        }
		        return generatedPassword;
		    }
}
