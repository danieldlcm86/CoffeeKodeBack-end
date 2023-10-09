package org.generation.CoffeeKode;

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


@RestController
@RequestMapping(path= "/api/CoffeeKode/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class UserController {

	//constante para utilizar el autowired (para crear una instancia del tipo Usuario aqui adentro, y reconocer todos los metodos que implemente la union de User+ServiceUser) BASICAMENTE ES DECIRLE AL CONTROLLER LO QUE PUEDE HACER EL USUARIO (SERVICE)

	private final UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
		
	//GET para traer usuarios
	@GetMapping
	public List<User> getUsuarios(){
		return userService.getUsers();
	}//getUsuarios

	//GET para traer un usuario por Id
	@GetMapping(path="{userId}")
	public User getUsuario(@PathVariable ("userId") Long userId) {
		return userService.getUser(userId);
	}//getUsuario
	
	
	//DELETE para borrar un usuario por id
	@DeleteMapping(path="{userId}")
	public void deleteUsuario(@PathVariable ("userId") Long userId) {
		userService.deleteUser(userId);
	}//deleteUsuario

	//POST para agregar un nuevo usuario
	@PostMapping
	public void postUsuario(@RequestBody User user) {
		userService.addUser(user);
	}//postUsuario
	
	//PUT para modificar un usuario ya existente, por medio de su id
	@PutMapping(path="{userId}")
	public void updateUsuario (@PathVariable ("userId") Long userId,
			@RequestParam String currentPassword,
			@RequestParam String newPassword) {	
		userService.updateUser(userId, currentPassword, newPassword);
	}

}

