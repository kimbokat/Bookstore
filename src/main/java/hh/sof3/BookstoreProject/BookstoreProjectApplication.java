package hh.sof3.BookstoreProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.BookstoreProject.domain.Book;
import hh.sof3.BookstoreProject.domain.BookRepository;

@SpringBootApplication
public class BookstoreProjectApplication {

	//lisätään loggeriattribuutti
	private static final Logger log = LoggerFactory.getLogger(BookstoreProjectApplication.class);
	
			public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			log.info("save some books");
			Book book1 = new Book("Devil in a Blue Dress (Easy Rawlins Mystery)", "Mosley Walter", 2002, "0743451791", 25.90);
			Book book2 = new Book("The Best American Mystery Stories of the Century", "Hillerman Tony", 2001, "0618012710", 29.90);
			bookRepository.save(book1);
			bookRepository.save(book2);
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
