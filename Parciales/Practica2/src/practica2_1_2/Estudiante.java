package practica2_1_2;

public class Estudiante {

	private String nombre;
	private int comision;
	private String email;
	private int direc;
	
	public Estudiante(String nombre, int comision, String email, int direc) {
		this.nombre = nombre;
		this.comision = comision;
		this.email = email;
		this.direc = direc;
	}
	
	public String tusDatos() {
		return "Nombre: " + nombre + " Comision: " + comision + " Email: " + email + " Direccion: " + direc; 
	}
}
