package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.User;
import hello.UserRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping(path="/add") // Map ONLY GET Requests
	public ResponseEntity addNewUser (@RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		User n = new User();

		Employee employee = new Employee();
		employee.setFirstName(name);

		n.setEmployee(employee);

		employeeRepository.save(employee);
		userRepository.save(n);

//		userRepository.save(n);
		//userRepository.

		return ResponseEntity.ok(n);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity getAllUsers() {
		// This returns a JSON or XML with the users
		return ResponseEntity.ok( employeeRepository.findAll() );
	}
}
