/*
 * Para poder decirle a esta clase llamada PersonController, tengo que inyectarle o agregarle una anotacion para que tome ese papel. Usamos la anotacion @RestController para decirle que este controlador manejara la entidad a base de metodos HTTP (esto significa que tendra ciertos metodos que puedan soportar estas solicitudes, y ademas gracias a esta anotacion podremos trabajar con el fetch que tengamos en nuestro front.
 * 
 * Con esta notación de RestController vamos a manejar el GET, POST, PUT, DELETE
 */
package org.generation.SistemaContableCH19;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Decimos que es una API del tipo REST (que trabaja con métodos HTTP)
@RequestMapping(path = "/api/personas") //http://localhost:8080/api/personas //Construimos la ruta de nuestra api
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })


public class PersonController {

		//Definimos primero una instancia. Le digo a Spring que voy a conectar mi PersonController con mi PersonService, para que el controlador sepa lo que sabe el servicio y no tenga que preguntar a cada rato.
		//constante para utilizar el autowired (para crear una instancia del tipo Person aquí dentro y reconocer todos los métodos que implemente la union Person+ServicePerson
		private final PersonService perService;
		
		@Autowired
		
		//Constructor que va a tomar el objeto de PersonService como un argumento y luego ese objeto se va a almacenar en un campo llamado this
		public PersonController(PersonService perService) {
			this.perService = perService;
		}
		
		//Ya se que mi Controller depende de mi Service. También se que estas entidades están conectadas entre sí con el Autowired. Lo único que hace falta es poder decirle o mostrarle a mi Controller lko que se puede hacer desde el Service
		
		@GetMapping
		public List <Person> getPerson(){
			return perService.getPersons();
		}
		
		//Método Get para traer a una sola persona de la lista por su ID
		//Para que funcione nuestra variable, tenemos que agregar la anotacion @PathVariable

		@GetMapping (path = "{persId}") //necesito decirle que habra una variable en la ruta
		public Person getPerson(@PathVariable("persId")Long personId) {
			return perService.getPerson(personId);//cuando pasamos el valor, disparamos el metodo del service
		}

		//Antes del metodo que trae personas, agregar el @GetMapping

		//Método Delete para borrar a una persona de la lista por su ID
		@DeleteMapping (path = "{persId}") 
		public void deletePerson(@PathVariable("persId")Long personId) {
			perService.deletePerson(personId);
		}
		
		//Método POST para agregar una nueva persona a la lista
		@PostMapping
		public void addPerson(@RequestBody Person persona) {
			perService.addPerson(persona);
			//Cuando trabajamos con el método POST, debemos cuidar el cuerpo de la solicitud. 
			//En Postman debemos activar la opción de Body, luego RAW y por ultimo cambiar el tipo de texto a JSON

		}
		
		//Método PUT para modificar los parámetros o valores de una persona ya existente
		@PutMapping(path = "{PersId}")
		public void updatePerson(@PathVariable("PersId")Long persId,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido,
			@RequestParam(required = false) String direccion,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String telefono){
			perService.updatePerson(persId, nombre, apellido, direccion, email, telefono);
			}
		
		
		
		
		/*Método para borrar toda la lista
		public void deletePerson() {
			perService.deletePerson();
		}*/
}
