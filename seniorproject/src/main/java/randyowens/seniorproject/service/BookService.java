package randyowens.seniorproject.service;

import randyowens.seniorproject.dao.BookRepository;

public class BookService {

    // BookRepository -- Books DAO Class
    private BookRepository bookRepository;

    // default constructor -- inject BookRepository
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
