package co.simplon.apipokemondemo.service;

import co.simplon.apipokemondemo.model.Pokemon;
import co.simplon.apipokemondemo.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private static final Logger logger = LoggerFactory.getLogger(PokemonService.class);

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemon() {
        logger.info("Retrieving all Pokemon");
        return pokemonRepository.findAll();
    }

    public Pokemon savePokemon(Pokemon pokemon) {
        logger.info("Processing Pokemon: {}", pokemon);
        validatePokemon(pokemon);
        return pokemonRepository.save(pokemon);
    }

    private void validatePokemon(Pokemon pokemon) {
        if (pokemon.getId() == null) {
            throw new IllegalArgumentException("Pokemon ID cannot be null");
        }
        if (pokemon.getName() == null || pokemon.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Pokemon name cannot be null or empty");
        }
    }
}

