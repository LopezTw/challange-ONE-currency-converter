package application;

import java.io.IOException;

<<<<<<< HEAD
import javax.swing.JOptionPane;

import entities.GUI_JOption;
import exceptions.MyCustomException;
=======
import entities.GUI_JOption;
>>>>>>> 06bdef8c73e7621849c28e77e945f88e611a6186
import utility.API_Currency;

public class Program {

	public static void main(String[] args) {
		
<<<<<<< HEAD
		
		// Array pra fornecer os nomes na interface grafica
		Object[] fromPossibilities = {"Brasil - BRL", "Dólar - USD", "Euros - EUR", 
									"Libras - GBP", "Won Coreano - KRW", "Ienes - JPY"};
		
		
		GUI_JOption converter = new GUI_JOption(fromPossibilities);
		
		try {
			do {
				// Obter a opção selecionada pelo usuário
				String fromCode = converter.fromCode();

				// Pra qual moeda será convertida
				String toCode = converter.toCode();

				// Obter o valor a ser convertido
				Double amount = converter.getAmountFromUser();
				if(amount >= 0) {
					// Realizar a conversão
					API_Currency.sendHttpGETRequest(fromCode, toCode, amount);
				} 
				else { 
					JOptionPane.showMessageDialog(null, "O valor inserido é inválido !",
					 "Currency Converter v1.0", JOptionPane.INFORMATION_MESSAGE);	  
				 }
					 


			} while (converter.repeatProgram() == 0);
			
		} catch (MyCustomException | NumberFormatException | IOException e) {	
			JOptionPane.showMessageDialog(null, "O valor inserido é inválido !", "Currency Converter v1.0", JOptionPane.INFORMATION_MESSAGE);	 
		} 
		
		
		// Fim
		converter.finalizarPrograma();
=======
		Object[] fromPossibilities = {"Brasil - BRL", "Dólar - USD", "Euros - EUR", 
									"Libras - GBP", "Won Coreano - KRW", "Ienes - JPY"};

		
		
		GUI_JOption converter = new GUI_JOption(fromPossibilities);

		
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
>>>>>>> 06bdef8c73e7621849c28e77e945f88e611a6186
		
		
		
	}

}
