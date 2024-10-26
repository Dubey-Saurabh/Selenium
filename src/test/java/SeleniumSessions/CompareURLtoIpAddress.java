package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

public class CompareURLtoIpAddress {

	public static void main(String[] args) {
		 
		try {
			System.out.println(new URL("https://www.facebook.com").equals(new URL("https://176.32.103.205")));
		} catch (MalformedURLException e) {
			  
		     	e.printStackTrace();
			}

	}

}
