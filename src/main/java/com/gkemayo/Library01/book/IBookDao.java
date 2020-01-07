package com.gkemayo.Library01.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


//Working with Spring Data Repositories
//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/repositories.html#repositories.query-methods

//annotation spring boot
//https://www.baeldung.com/spring-mvc-annotations
//https://www.baeldung.com/spring-core-annotations
@Repository
public interface IBookDao extends JpaRepository<Book, Integer> {
    // rech livre par isbn
    Book findByIsbnIgnoreCase(String isbn);
    //recheche des livres par le titre
    public List<Book> findByTitleLikeIgnoreCase(String title);
    //recherche des livres par categories en passant un code par parametre
    @Query(   "SELECT b "
            + "FROM Book b "
            + "INNER JOIN b.category cat "
            + "WHERE cat.code = :code"
    )
    public List<Book> 	findByCategory(@Param("code") String codeCategory);

}
