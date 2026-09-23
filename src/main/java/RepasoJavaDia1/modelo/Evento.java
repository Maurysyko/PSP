package RepasoJavaDia1.modelo;

import java.time.LocalDate;
import RepasoJavaDia1.exceptions.CraftersException;

public abstract class Evento {
	private static int contID = 0;
	private final int id;
	private String nombre;
	private final LocalDate fecha;
	private int numEntradasVendidas;
	private final int capMaxAsistentes;
	private Estado estado;
	// creamos todos los atributos. Importante la parte del static para llevar el
	// conteo
	// de los eventos y el id unico declarado como "final" al igual que fecha y
	// "capMaxAsistentes"

	// Creamos el constructor
	public Evento(String nombre, LocalDate fecha, int numEntradasVendidas, int capMaxAsistentes)
			throws CraftersException {
		if (capMaxAsistentes < 0 || numEntradasVendidas < 0 || numEntradasVendidas > capMaxAsistentes || nombre == null
				|| nombre.isEmpty()) {

			throw new CraftersException("No es posible construir un evento con esos datos");
		}
		this.nombre = nombre;
		this.fecha = fecha; // fecha
		this.numEntradasVendidas = numEntradasVendidas; // numEntradasVendidas
		this.capMaxAsistentes = capMaxAsistentes; // capMaxAsistentes
		this.id = ++contID;// para cada id creado con el objeto, se suma +1 al contador cuyo valor es 0
		this.estado = Estado.PENDIENTE;
	}
}
