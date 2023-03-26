package hh.sof3.BookstoreProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.sof3.BookstoreProject.domain.Book;
import hh.sof3.BookstoreProject.domain.BookRepository;
import hh.sof3.BookstoreProject.domain.Category;
import hh.sof3.BookstoreProject.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreProjectApplication {

	// lisätään loggeriattribuutti
	private static final Logger log = LoggerFactory.getLogger(BookstoreProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category category1 = new Category("Mystery");
			crepository.save(category1);
			Category category2 = new Category("Thriller");
			crepository.save(category2);
			Category category3 = new Category("Romance");
			crepository.save(category3);
			
			brepository.save(new Book("Devil in a Blue Dress (Easy Rawlins Mystery)", "Mosley Walter", 2002, "0743451791",
					25.90, category1));
			brepository.save(new Book("The Best American Mystery Stories of the Century", "Hillerman Tony", 2001,
					"0618012710", 29.90, category1));	
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

