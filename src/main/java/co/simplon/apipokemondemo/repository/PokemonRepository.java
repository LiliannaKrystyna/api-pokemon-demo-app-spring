package co.simplon.apipokemondemo.repository;

import co.simplon.apipokemondemo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
