/*
 * En el personService nosotros emularemos una "pequeña base de datos" a base de un arrayList, para poder hacer nuestras operaciones del CRUD (Create, Read, Update, Delete). Esto va enfocado a cualquier entidad que ustedes tengan (palyeras, cafe, cervezas, animales, mascotas, veterinarios, post, etc). 

 * Estas entidades que estare usando aqui, en un ArrayList, tomaran los datos que ya defini en el modelo (atributos).
 
 *La anotacion para decirle a mi clase "PersonService" que es un servicio, es @Service

 */

package org.generation.SistemaContableCH19;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

	// Crear una lista o ArrayList de personas llamado lista y aquí pondré varias personas (Person) como si fuera una base de datos
	public final ArrayList<Person> lista = new ArrayList<Person>();
	
		//Voy a instaciar personas y las voy a agregar a mi lista de personas
		public PersonService() {
			lista.add(new Person ("Daniel", "Maldonado", "Villahermosa", "danieldlcm86@gmail.com", "993211311"));
			lista.add(new Person ("Felipe", "Maqueda", "Tlalnepantla", "felipemaquedag@gmail.com", "5531302688"));
			lista.add(new Person ("Zabdiel", "Diaz", "Aguascalientes", "zabdieldiaz@gmail.com", "5512345678"));
			lista.add(new Person ("Magali", "Vega", "EdoMex", "magalivega@gmail.com", "5512345678"));
			lista.add(new Person ("Karen", "Montejo", "Villahermosa", "montejo1595@gmail.com", "9933857580"));	
			
		}
	
	//Métodos CRUD para poder iterar con los usuarios.
		//CRUD. Operaciones que te permiten modificar información
		/*
		 * C (Create) Crear algo - 		POST para mandarlo al servidor
		 * R (Read) Leer algo - 		GET para traerlo del servidor
		 * U (Update) Actualizar algo - PUT para modificar algo que ya existe en mi servidor
		 * D (Delete) Borrar algo - 	DELETE para borrar algo de mi servidor
		 */
		
		//Métodos para traer a todos los usuarios
		public ArrayList<Person> getPersons(){
			return lista;
		}
		
		//Método para traer una sola persona de lista y la vamos a traer por su id (foreach)
		public Person getPerson(Long personId) { //defino mi método, iterando con el id de la persona
			Person temporalPersona = null; //Con esto evito el error 404 not found 
			for(Person pers : lista) {//para cada persona de la lista, la voy a sacar y la pongo en un lugar temporal
				if (pers.getId()==personId) {
					temporalPersona = pers;
				}
			}
			return temporalPersona;// si la persona no existe, termina el proceso
		}
		
		

		//Métodos para eliminar a una persona de la lista por su id (foreach)
		public void deletePerson(Long personId) {//metodo que pide un id para eliminar personas
			for(Person pers: lista) {//para cada persona de la lista...
				if(pers.getId()==personId) { //...evaluo si coincide, y si si, paso a la siguiente linea
					lista.remove(pers);//remover al usuario de la lista
					break;//termino el proceso para que no quede el ciclo infinito
				}
			}
		}
		
		//Método para agregar personas
		public void addPerson(Person persona) {
			lista.add(persona);
		}
		
		//Método para modificar personas (valores) usando foreach
		
		
		public void updatePerson(Long persId, String nombre, String apellido, String direccion, String email, String telefono) {
			for(Person pers : lista) {
				if (pers.getId() == persId) {
					if(nombre!=null)pers.setNombre(nombre);
					if(apellido!=null)pers.setApellido(apellido);
					if(direccion!=null)pers.setDireccion(direccion);
					if(email!=null)pers.setEmail(email);
					if(telefono!=null)pers.setTelefono(telefono);
				}
			}
		}
		
}
