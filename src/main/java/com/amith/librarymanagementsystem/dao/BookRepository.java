package com.amith.librarymanagementsystem.dao;

import com.amith.librarymanagementsystem.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {
}
