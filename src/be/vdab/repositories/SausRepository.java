package be.vdab.repositories;

import be.vdab.enteties.Saus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class SausRepository {

	private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();

	static {
		SAUZEN.put(1L, new Saus(1L,"Cocktail", asList("Mayonaise", "Cognac", "Ketchup")));
		SAUZEN.put(2L, new Saus(2L,"Mayonaise", asList("Ei", "Mosterd", "Olie")));
		SAUZEN.put(3L, new Saus(3L,"Mosterd", asList("Azijn", "Mosterd", "Witte Wijn")));
		SAUZEN.put(4L, new Saus(4L,"Tartare", asList("Mayonaise", "Agurk", "Tabasco")));
		SAUZEN.put(5L, new Saus(5L,"Vinaigrette", asList("Azijn", "Mosterd", "Olijfolie")));
	}

	public List<Saus> findAll() {
		return new ArrayList<>(SAUZEN.values());
	}

	public List<Saus> findByIngredient(String ingredient) {
		return SAUZEN.values().stream().filter(saus -> saus.getIngredienten().contains(ingredient)).collect(Collectors.toList());

	}
}
