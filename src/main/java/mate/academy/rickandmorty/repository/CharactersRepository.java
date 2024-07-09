package mate.academy.rickandmorty.repository;

import java.util.List;
import mate.academy.rickandmorty.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends JpaRepository<Character, Long> {
    List<Character> findAllByName(String name);

    @Query(value =
                      "SELECT * "
                    + "FROM characters "
                    + "ORDER BY RAND() "
                    + "LIMIT 1",
            nativeQuery = true)
    Character getRandom();
}
