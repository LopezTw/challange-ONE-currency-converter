package entities;

import java.text.NumberFormat;
<<<<<<< HEAD
import java.util.Currency;
=======
>>>>>>> 06bdef8c73e7621849c28e77e945f88e611a6186
import java.util.HashMap;
import java.util.Locale;

import javax.swing.JOptionPane;

public class GUI_JOption {

	private Object[] fromPossibilities;
<<<<<<< HEAD
	
	// Uma lista em formato HashMap pra receber uma Chave / Valor
	private HashMap<String, String> currencyCodeMap = new HashMap<>();
	
	
	public GUI_JOption() {

	}

	public GUI_JOption(Object[] possibilities) {
		this.fromPossibilities = possibilities;

		currencyCodeMap.put((String) "Brasil - BRL", "BRL");
		currencyCodeMap.put((String) "Dólar - USD", "USD");
		currencyCodeMap.put((String) "Euros - EUR", "EUR");
		currencyCodeMap.put((String) "Libras - GBP", "GBP");
		currencyCodeMap.put((String) "Won Coreano - KRW", "KRW");
		currencyCodeMap.put((String) "Ienes - JPY", "JPY");

	}

	// Recebe a sigla da moeda que vai ser convertida
	public String fromCode() {
		String code = (String) JOptionPane.showInputDialog(null,
				"Select the Currency which will be converted: " + "", "Currency Converter v1.0",
				JOptionPane.INFORMATION_MESSAGE, null, fromPossibilities, "Brasil - BRL");

		String currencyCode = tratamento(code);

		return currencyCode;
	}

	// Recebe a sigla da moeda que irá receber a conversão
	public String toCode() {
		String code = (String) JOptionPane.showInputDialog(null,
				"Select the Currency which will be converted: " + "", "Currency Converter v1.0",
				JOptionPane.INFORMATION_MESSAGE, null, fromPossibilities, "Dólar - USD");

		String toCodeTratada = tratamento(code);

		return toCodeTratada;
	}

	// Recebe a quantidade de dinheiro que a pessoa deseja converter
	public double getAmountFromUser() {

		String input = JOptionPane.showInputDialog(null, "Insert the value: ", "Currency Converter v1.0",
				JOptionPane.PLAIN_MESSAGE);

		
		return Double.parseDouble(input);

	}

	
	// Ao final da conversão, será perguntado ao usuário se deseja fazer mais uma consulta
	public int repeatProgram() {

		String[] responses = { "Yes", "No" };

		return JOptionPane.showOptionDialog(null, "Do you want to convert again?", "Currency Converter v1.0",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);

	}
	 
	// Formataçao do Símbolo da Moeda
	public String formatCurrency(double amount, String currencyCode) {
		
		Currency currency = Currency.getInstance(currencyCode);
		
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        
        // Apenas uma brincadeira formatando a moeda Brasileira com Virgula ao Invés de Ponto.
        if(currencyCode == "BRL") {
        	Locale brasilLocale = new Locale("pt", "BR");
			nf = NumberFormat.getCurrencyInstance(brasilLocale);
		}
        
        nf.setCurrency(currency);

        return nf.format(amount);
			
	}

	// Formatar corretamente a saída da sigla da Moeda, importante pra API
	
	public String tratamento(String code) {
		String currencyCode = currencyCodeMap.get(code);

		return currencyCode;
	}
	
	public void finalizarPrograma() {
		
		JOptionPane.showMessageDialog(null, "Programa Finalizado !", "Currency Converter v1.0", JOptionPane.INFORMATION_MESSAGE);

		
	}

}
=======
	//private String[] codesCurrency = {"BRL", "USD", "EUR", "GBP", "KRW", "JPY" };
	private String fromCode;
	
	
	private HashMap<String, String> currencyCodeMap = new HashMap<>();
	
	
	public GUI_JOption(){
		
	}
	
    public GUI_JOption(Object[] possibilities) {
        this.fromPossibilities = possibilities;
        
        currencyCodeMap.put((String) "Brasil - BRL", "BRL"); 
        currencyCodeMap.put((String) "Dólar - USD", "USD"); 
        currencyCodeMap.put((String) "Euros - EUR", "EUR");
        currencyCodeMap.put((String) "Libras - GBP", "GBP");
        currencyCodeMap.put((String) "Won Coreano - KRW", "KRW");
        currencyCodeMap.put((String) "Ienes - JPY", "JPY");
        
        
    }
    
    

    public String showCurrencyDialog() {
        String code = (String) JOptionPane.showInputDialog(
                null,
                "Select the Currency which will be converted:\n" + "Customized Dialog",
                null,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                fromPossibilities,
                "Brasil - BRL");
        
        String currencyCode = tratamento(code);
        
        return currencyCode;
    }
    
    public String toCode() {
    	String code = (String) JOptionPane.showInputDialog(
                null,
                "Select the Currency which will be converted:\n" + "Customized Dialog",
                null,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                fromPossibilities,
                "Dólar - USD");
    	
    	String toCodeTratada = tratamento(code);
    	
    	return toCodeTratada;
    }

    public double getAmountFromUser() {
        String input = JOptionPane.showInputDialog(null, "Insert the value: ", "Currency Converter", JOptionPane.PLAIN_MESSAGE);
        return Double.parseDouble(input);
    }

     // Formataçao do Símbolo da Moeda
    public String formatCurrency(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        return nf.format(amount);
    }
    
    public String tratamento(String code) {
    	String currencyCode = currencyCodeMap.get(code);
        
        if (currencyCode != null) {
            this.fromCode = currencyCode;
        }
        
        return currencyCode;
    }
    
    
}
	

>>>>>>> 06bdef8c73e7621849c28e77e945f88e611a6186
