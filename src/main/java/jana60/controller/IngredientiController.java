package jana60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jana60.model.Ingredienti;
import jana60.repository.IngredientiRepository;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

	@Autowired
	private IngredientiRepository repo;

	@GetMapping("/list")
	public String pizza(Model model) {
		List<Ingredienti> IngredientiList = (List<Ingredienti>) repo.findAll();
		model.addAttribute("IngredientiList", IngredientiList);
		return "/ingredienti/list";
	}
}
