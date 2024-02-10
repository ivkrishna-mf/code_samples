package mongodbjpasp3service.controller;


import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import mongodbjpasp3service.model.Book;
import mongodbjpasp3service.service.BookService;
@Slf4j
@Tag(name = "Book", description = "Book mgnt APIs")
@RestController
@RequestMapping("/api/v1")
public class BookController {

	
	@Autowired
	private BookService bookService;

	/*
	produces xml and json outpus from Get mapping
	THe first media type is the priority when multiple are present when no default configuration was set.
	 */
	@GetMapping(path = "/books", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Book> findBooks(){
		
		return bookService.getBooks();
		
	}
	@PostMapping(path = "/books")
	public Book addBook(@RequestBody Book book){

		return  bookService.addBook(book);
	}

	@GetMapping(path = "/books/search")
	public ResponseEntity<Map<String, Object>> searchBooks(@RequestParam(required = false) String title,
								  @RequestParam(defaultValue = "0") int page,
								  @RequestParam(defaultValue = "2") int size
								  ){

		log.info("after SJ"+ title);

		String sortBy = "price";
		String sortDirection = "desc";
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		Pageable paging = PageRequest.of(page,size, sort);

		Page<Book> pageable = bookService.findByTitleContaining(title,paging);

		List<Book> books = pageable.getContent();

		int totalPage = pageable.getTotalPages();

		long totalElements = pageable.getTotalElements();

		int pageSize = pageable.getSize();



		Map<String, Object> response = new HashMap<>();

		response.put("books", books);
		response.put("currentPage", pageable.getNumber());
		response.put("totalItems", pageable.getTotalElements());
		response.put("totalPages", pageable.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);




	}
	
}
