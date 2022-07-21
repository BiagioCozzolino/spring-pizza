package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.repository.PizzaRepository;
import jana60.repository.UniversityRepository;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired 
	private PizzaRepository repo;
}
