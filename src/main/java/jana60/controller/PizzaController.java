package jana60.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jana60.model.Pizza;
import jana60.repository.PizzaRepository;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired 
	private PizzaRepository repo;
	
	@GetMapping
	public String pizza(Model model) {
		List<Pizza> PizzaList = (List<Pizza>)repo.findAll();
		model.addAttribute("PizzaList", PizzaList);
		return "pizza";
	}
	
	@GetMapping("/add")
	  public String pizzaForm(Model model) {
	    model.addAttribute("pizza", new Pizza());
	    return "/pizza/edit";
	  }
	
	 @PostMapping("/add")
	  public String save(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult br) {
	    if (br.hasErrors()) {
	      return "/pizza/edit";
	    } else {
	      repo.save(formPizza);
	      return "redirect:/"; 
	    }
	  }
}
