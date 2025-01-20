package co.simplon.apipokemondemo.controller;

import co.simplon.apipokemondemo.model.Pokemon;
import co.simplon.apipokemondemo.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API is working!");
    }

    @GetMapping("/allPokemons")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        try {
            List<Pokemon> pokemons = pokemonService.getAllPokemon();
            if (pokemons.isEmpty()) {
                // Retourner 204 si aucun Pokémon trouvé
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(pokemons);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> savePokemon(@RequestBody Pokemon pokemon) {
        try {
            if (pokemon == null) {
                return ResponseEntity.badRequest().body("Pokemon object cannot be null");
            }
            Pokemon savedPokemon = pokemonService.savePokemon(pokemon);
            return ResponseEntity.ok(savedPokemon);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error saving Pokemon: " + e.getMessage());
        }
    }
}
