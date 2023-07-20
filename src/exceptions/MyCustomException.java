package exceptions;


public class MyCustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyCustomException(String msg) { 
		super(msg); 
			  
	}
	
}
