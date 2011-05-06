/*
 * Copyright 2010 asaph.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asaph.gravatar;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A helper class containing static methods to help with miscelaneous encodings.
 * 
 * @author asaph
 *
 */
 class EncodingHelper {

	/**
	 * Convert a byte array to a hex encoded string.
	 * 
	 * @param bytes The byte array to encode as hex.
	 * @return A hex encoded representation of <code>bytes</code>.
	 */
	static String hex(byte[] bytes) {        
	      StringBuilder sb = new StringBuilder();        
	      for (byte b : bytes) {            
	    	  String hexNumber = Integer.toHexString(b & 0xFF);
	    	  if (hexNumber.length() < 2) {
	    		  sb.append('0');
	    	  }
	    	  sb.append(hexNumber);
	      }        
	      return sb.toString();    
	}

	/**
	 * Calculate the MD5 hash of <code>message</code> and return a hex encoded representation of it.
	 * 
	 * @param message The string to hash and hex encode.
	 * @return Hex encoded MD5 hash of <code>message</code>
	 */
	static String md5Hex(String message) {         
	      try {             
	    	  MessageDigest md = MessageDigest.getInstance("MD5");             
	    	  return hex(md.digest(message.getBytes("UTF8")));         
	      } catch (NoSuchAlgorithmException e) {
	    	  throw new RuntimeException(e); // this should never ever happen
	      } catch (UnsupportedEncodingException e) {         
	    	  throw new RuntimeException(e); // this should never ever happen
	      }         
	}

	/**
	 * Apply the url encoding transformation to <code>unencoded</code>
	 * 
	 * @param unencoded The string to be url encoded.
	 * @return A url encoded representation of <code>unencoded</code>
	 */
	static String urlEncode(String unencoded) {
		try {
			return URLEncoder.encode(unencoded, "UTF8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e); // this should never ever happen
		}
	}

}
