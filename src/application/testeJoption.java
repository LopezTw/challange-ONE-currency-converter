package application;

import java.io.IOException;



import entities.GUI_JOption;
import utility.API_Currency;

public class testeJoption {

	public static void main(String[] args) {

		Object[] possibilities = { "REAIS -> DÓLAR", "REAIS -> EURO", "REAIS -> PESOS-ARGENTINOS" };

		GUI_JOption converter = new GUI_JOption(possibilities);

		// Obter a opção selecionada pelo usuário
		String fromCode = converter.showCurrencyDialog();

		// Pra qual moeda será convertida
		String toCode = converter.toCode();
		
		
		// Obter o valor a ser convertido
		Double amount = converter.getAmountFromUser();

		// Realizar a conversão
		
		try {
			
			API_Currency.sendHttpGETRequest(fromCode, toCode, amount);
		
		} 
		catch (IOException e) {
			e.getMessage();
		}
		// Formatar o valor convertido 
		//String formattedConvertedAmount = converter.formatCurrency(convertedAmount);

		
		

	}
}
