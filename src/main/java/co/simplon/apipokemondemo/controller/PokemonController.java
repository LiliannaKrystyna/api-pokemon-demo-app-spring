package co.simplon.apipokemondemo.controller;

import co.simplon.apipokemondemo.model.Pokemon;
import co.simplon.apipokemondemo.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);
    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Test endpoint called");
        return ResponseEntity.ok("API is working!");
    }

    @PostMapping
    public ResponseEntity<?> savePokemon(@RequestBody Pokemon pokemon) {
        try {
            logger.info("Received Pokemon: {}", pokemon);

            if (pokemon == null) {
                logger.error("Pokemon object is null");
                return ResponseEntity.badRequest().body("Pokemon object cannot be null");
            }

            if (pokemon.getId() == null) {
                logger.error("Pokemon ID is null");
                return ResponseEntity.badRequest().body("Pokemon ID cannot be null");
            }

            if (pokemon.getName() == null || pokemon.getName().trim().isEmpty()) {
                logger.error("Pokemon name is null or empty");
                return ResponseEntity.badRequest().body("Pokemon name cannot be null or empty");
            }

            Pokemon savedPokemon = pokemonRepository.save(pokemon);
            logger.info("Successfully saved Pokemon: {}", savedPokemon);
            return ResponseEntity.ok(savedPokemon);

        } catch (Exception e) {
            logger.error("Error saving Pokemon: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError()
                    .body("Error saving Pokemon: " + e.getMessage());
        }
    }
}