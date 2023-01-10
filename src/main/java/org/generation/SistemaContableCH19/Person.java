package org.generation.SistemaContableCH19;

public class Person {

	//Propiedades o atributos
	
	String nombre;
	String apellido;
	String direccion;
	String email;
	String telefono;
	
	//atributos para asignarle un id a nuestro usuario
	private int id;
	private static int total = 0;
	
	
	//Métodos
	//1. Método para imprimir el id del usuario
	public void imprimirID() {
		System.out.println("ID: " + id);
	}
	
	//2. Método para imprimir la información del usuario
	public void imprimirInfo(){
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Dirección: " + direccion);
		System.out.println("email: " + email);
		System.out.println("Teléfono: " + telefono);
	}

	//Constructores
	public Person(String nombre, String apellido, String direccion, String email, String telefono) {
		total++;//Contador de Id
		this.id = total;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}

	//Constructor vacío para el método POST, para poder crear nuevas personas sin atarme a agregar todos los campos
	//Necesitamos que siga obteniendo su id consecutivo
	public Person() {
		total++;
		this.id = total;
	}
	
	
	
	//Getters y Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Person.total = total;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	//toString

	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + "]";
	}
		
}
