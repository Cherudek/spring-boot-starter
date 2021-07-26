package gregorio.springboot5.bootstrap;

import gregorio.springboot5.domain.Author;
import gregorio.springboot5.domain.Book;
import gregorio.springboot5.domain.Publisher;
import gregorio.springboot5.repositories.AuthorRepository;
import gregorio.springboot5.repositories.BookRepository;
import gregorio.springboot5.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher oreilly = new Publisher("O'Reilly", "233 South Patterson Avenue", "Springfield", "65802", "USA");
        publisherRepository.save(oreilly);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "122938482374082");
        ddd.setPublisher(oreilly);
        oreilly.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2424999999");
        noEJB.setPublisher(oreilly);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        oreilly.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());


    }
}
