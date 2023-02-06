package com.amith.librarymanagementsystem.service;

import com.amith.librarymanagementsystem.dao.BookRepository;
import com.amith.librarymanagementsystem.entity.Book;
import com.amith.librarymanagementsystem.exceptionhandler.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements Services<Book> {
    private BookRepository bookRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> result=bookRepository.findById(id);
        Book book=null;
        if(result.isPresent()) {
            book=result.get();
        }else{
            throw new NotFoundException("Book with id : "+id+" not found.");
        }
        return book;
    }

    public int getMaxId(){
        final Query query = new Query()
                .limit(1)
                .with(Sort.by(Sort.Direction.DESC, "id"));
        return mongoTemplate.findOne(query, Book.class).getId();
    }
    @Override
    public void save(Book book) {
        if(book.getId() == 0){
            int id = getMaxId();
            book.setId(id+1);
        }
        bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

}
