package br.com.valhalla.ohwaiter.exceptions;

public class FaltandoEstoqueException extends RuntimeException{
    
	public FaltandoEstoqueException(String message, Throwable cause) {
		super(message, cause);
	}

	public FaltandoEstoqueException(String message) {
		super(message);
	}
	
}
