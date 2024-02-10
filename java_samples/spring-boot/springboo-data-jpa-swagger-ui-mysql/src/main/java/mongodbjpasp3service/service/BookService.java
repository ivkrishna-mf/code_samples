package mongodbjpasp3service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mongodbjpasp3service.model.Book;
import mongodbjpasp3service.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks(){
		
		List<Book> books = bookRepository.findAll();
		
		return Optional.of(books).orElseGet(null);
//		return Optional.of(books);
	}

	public Book addBook(Book book){
		return bookRepository.save(book);
	}

	public Page<Book> findByTitleContaining(String title, Pageable pageable){


        return bookRepository.findByTitleContaining(title, pageable);
    }

}
