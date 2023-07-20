package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import entities.GUI_JOption;

public class API_Currency {

	/*private String fromCode;
	private String toCode;
	private Double amount;
	*/
	
	public API_Currency() {}
	
	public static void sendHttpGETRequest(String fromCode, String toCode, Double amount) throws IOException {

		String GET_URL = "https://v6.exchangerate-api.com/v6/a2e132c2cd27d1dc9e080744/latest/" + toCode;

		URL url = new URL(GET_URL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // abro a conexao
		httpURLConnection.setRequestMethod("GET");
		int responseCode = httpURLConnection.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject obj = new JSONObject(response.toString());
			Double exchangeRate = obj.getJSONObject("conversion_rates").getDouble(fromCode);
			//System.out.println(obj.getJSONObject("conversion_rates"));
			// System.out.println(exchangeRate);
			System.out.println();
			
			GUI_JOption n = new GUI_JOption();
			
			Double result;
			
			result =  amount / exchangeRate;
			
			
			
<<<<<<< HEAD
			JOptionPane.showMessageDialog(null, "Converted amount: " +  n.formatCurrency(result, toCode) + toCode + " " + "", 
				"Conversion Result", JOptionPane.INFORMATION_MESSAGE);
			
=======
			JOptionPane.showMessageDialog(null, "Converted amount: " +  n.formatCurrency(result) + toCode + " " + "", 
				"Conversion Result", JOptionPane.INFORMATION_MESSAGE);
			
			//System.out.println(amount + fromCode + " = " + String.format("%.2f", amount / exchangeRate) + toCode);
>>>>>>> 06bdef8c73e7621849c28e77e945f88e611a6186
		
		} else {
			System.out.println("GET request failed!");
		}

	}
}
