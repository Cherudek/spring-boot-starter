package gregorio.springboot5.repositories;

import gregorio.springboot5.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
