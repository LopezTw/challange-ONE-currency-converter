package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;


import org.json.JSONObject;

public class testeProgram {

	//private final String USER_AGENT = "API Client/1.0";
	 
    public static void main(String[] args) throws Exception {
 
    	HashMap<Integer, String> currencyCodes = new HashMap<>();
    	
    	// Currencys Codes:
    	currencyCodes.put(1, "USD");
    	currencyCodes.put(2, "BRL");
    	
    	String fromCode, toCode; // De qual moeda p/ qual moeda...
    	
		double amount;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the currency converter: ");
		
		System.out.println("Currency converting FROM? ");		
		System.out.println("1: USD \t 2:BRL");
		fromCode = currencyCodes.get(sc.nextInt());

		System.out.println("Currency converting TO?");
		System.out.println("\"1: USD \\t 2:BRL\"");
		toCode = currencyCodes.get(sc.nextInt());
		 
		System.out.println("Amount you wish to convert?");
		amount = sc.nextFloat();
		
		sendHttpGETRequest(fromCode, toCode, amount);
			
		System.out.println("Thank you for using the currency converter!");
		
		sc.close();
	}
    
   
	private static void sendHttpGETRequest(String fromCode, String toCode, Double amount) throws IOException {
    	
    	String GET_URL = "https://v6.exchangerate-api.com/v6/a2e132c2cd27d1dc9e080744/latest/" + toCode;
    	
    	URL url = new URL(GET_URL);
    	HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // abro a conexao
    	httpURLConnection.setRequestMethod("GET");
    	int responseCode = httpURLConnection.getResponseCode();
    	
    	if(responseCode == HttpURLConnection.HTTP_OK) { //success
    		BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
    		String inputLine;
    		StringBuffer response = new StringBuffer();
    		
    		while((inputLine = in.readLine()) != null) {
    			response.append(inputLine);
    		}in.close();
    		
    		JSONObject obj = new JSONObject(response.toString());
    		Double exchangeRate = obj.getJSONObject("conversion_rates").getDouble(fromCode);
    		System.out.println(obj.getJSONObject("conversion_rates"));
    		//System.out.println(exchangeRate);
    		System.out.println();
    		
    		
    		System.out.println(amount + fromCode + " = " +  String.format("%.2f", amount/exchangeRate) + toCode);
    	}
    	else {
    		System.out.println("GET request failed!");
    	}
    	
    	
    	
    	
    	
    }

}
