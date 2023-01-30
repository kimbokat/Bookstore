package hh.sof3.BookstoreProject.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof3.BookstoreProject.domain.Book;

@Controller
public class BookController {

	List<Book> books = new ArrayList<>();

	@GetMapping("/index")
	public String welcomePage(Model model, Book book) {
	books.add(new Book("Lord of the Flies", "William Golding", 1954, "9780399529", 52.34));
	model.addAttribute("books", books);
	return "welcome";
	}
}
