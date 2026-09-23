package RepasoJavaDia1.exceptions;

public class CraftersException extends Exception {// creamos la clase CraftersException que extiende de la clase
													// Exception

	public CraftersException(String mensaje) {// constructor de la propia clase, que llama al mensaje de la clase
												// "Evento" el mensaje es donde pone throw new CraftersException. Lo que
												// salga en ese mensaje es lo que recoge el super de la clase Crafters
		super(mensaje);
	}
}
