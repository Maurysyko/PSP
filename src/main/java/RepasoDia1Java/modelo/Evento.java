package RepasoDia1Java.modelo;
import java.time.LocalDate;
import java.util.Objects;

import RepasoJavaDia1.exceptions.CrafterException;

public class Evento {

	private int identificador;
	private String nombre;
	private LocalDate fecha;
	private int numEntradas;
	private int capMaxAsistentes;
	private Estado estado;
	
	
	public Evento(int identificador, String nombre, LocalDate fecha, int numEntradas, int capMaxAsistentes,
			Estado estado) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.fecha = fecha;
		if(numEntradas <= capMaxAsistentes && capMaxAsistentes > 0) {
			this.numEntradas = numEntradas;
			this.capMaxAsistentes = capMaxAsistentes;
		}
		
		this.estado = estado;
	}


	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getNumEntradas() {
		return numEntradas;
	}


	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}


	public int getCapMaxAsistentes() {
		return capMaxAsistentes;
	}


	public void setCapMaxAsistentes(int capMaxAsistentes) {
		this.capMaxAsistentes = capMaxAsistentes;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(identificador));
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return identificador == other.identificador;
	}


	@Override
	public String toString() {
		return "Evento [identificador=" + identificador + ", nombre=" + nombre + ", fecha=" + fecha + ", estado="
				+ estado + "]";
	}
	
	
	
	
	
}
