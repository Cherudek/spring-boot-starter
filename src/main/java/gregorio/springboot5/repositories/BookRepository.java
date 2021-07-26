package gregorio.springboot5.repositories;

import gregorio.springboot5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
