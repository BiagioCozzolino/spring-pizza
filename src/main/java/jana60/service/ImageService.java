package jana60.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jana60.model.Immagine;
import jana60.model.ImmagineForm;
import jana60.model.Pizza;
import jana60.repository.ImmagineRepository;
import jana60.repository.PizzaRepository;

@Service
public class ImageService {

	@Autowired
	private ImmagineRepository repo;

	@Autowired
	private PizzaRepository pizzaRepo;

	public List<Immagine> getImmagineByPizzaId(Integer pizzaId) {

		Pizza pizza = pizzaRepo.findById(pizzaId).get();
		return repo.findByPizza(pizza);

	}

	public ImmagineForm createImmagineForm(Integer pizzaId) {
		Pizza pizza = pizzaRepo.findById(pizzaId).get();
		ImmagineForm img = new ImmagineForm();
		img.setPizza(pizza);
		return img;
	}

	public Immagine createImmagine(ImmagineForm immagineForm) throws IOException {
		// creo un oggetto Image vuoto
		Immagine imgToSave = new Immagine();
		// lo inizializzo coi dati di ImageForm
		imgToSave.setPizza(immagineForm.getPizza());
		// trasformo il content MultipartFile in un byte[] e lo passo all'Image da
		// salvare
		if (immagineForm.getContentMultipart() != null) {
			byte[] contentSerialized = immagineForm.getContentMultipart().getBytes();
			imgToSave.setContent(contentSerialized);
		}
		// salvo Image su database
		return repo.save(imgToSave);
	}

	public byte[] getImmagineContent(Integer id) {
		Immagine img = repo.findById(id).get();
		return img.getContent();
	}
}
