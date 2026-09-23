package RepasoJavaDia1.modelo;

import java.time.LocalDate;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	// Punto 3 ejercicio .equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

	// Metodo getPorcentajeOcupacion sin parámetro
	public double getPorcentajeOcupacion() {
		double porcentaje = (double) numEntradasVendidas / capMaxAsistentes * 100;
		return porcentaje;
	}

	// Metodo getPorcentajeOcupacion con parámetro
	public double getPorcentajeOcupacion(int numEntradas) {
		double porcentajeResultado = (double) (numEntradasVendidas + numEntradas) / capMaxAsistentes * 100;
		return porcentajeResultado;
	}

	// Punto 5 del ejercicio NO HE PODIDO HACERLO SOLO!!!
	public void modificaEstado(Estado nuevo) throws CraftersException {

		switch (this.estado) {

		case PENDIENTE:
			if (nuevo != Estado.PROGRAMADO && nuevo != Estado.CANCELADO && nuevo != Estado.FINALIZADO) {
				throw new CraftersException("No es posible pasar al estado: " + nuevo);
			}
			break;

		case APLAZADO:
			if (nuevo != Estado.PROGRAMADO) {
				throw new CraftersException("No es posible pasar al estado: " + nuevo);
			}
			break;

		default:
			// PROGRAMADO, CANCELADO o FINALIZADO como estado actual: nunca se puede avanzar
			throw new CraftersException("No es posible pasar al estado: " + nuevo);
		}

		// Si el switch no lanzó ninguna excepción, la transición es válida: se aplica
		// el cambio
		this.estado = nuevo;
	}

	// Método abstracto que implica a las clases hjjas que es donde se implementa
	public abstract double calcularCosteBase();

	// To String
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + "]";
	}

}
