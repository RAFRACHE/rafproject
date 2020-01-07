package com.gkemayo.Library01.book;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gkemayo.Library01.category.Category;
import com.gkemayo.Library01.loan.Loan;
/*
    Category(code, label) ;
    Book(id, isbn, title, creation_date, total_examplaries, author) ;
    Customer(id, first_name, last_name, job, address, email, creation_date) ;
    Loan(book_id, customer_id, begin_date, end_date, status).
*/
//toutes les annotations de base Spring framework
//http://javamidnight.blogspot.com/2017/11/le-guide-complet-des-annotations-du.html
@Entity
@Table(name = "BOOK")
public class Book {

    private Integer id;

    private String title;

    private String isbn;

    private LocalDate releaseDate;

    private LocalDate registerDate;

    private Integer totalExamplaries;

    private String author;

    private Category category;

    Set<Loan> loans = new HashSet<Loan>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "TITLE", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "ISBN", nullable = false, unique = true)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "RELEASE_DATE", nullable = false)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "REGISTER_DATE", nullable = false)
    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "TOTAL_EXAMPLARIES")
    public Integer getTotalExamplaries() {
        return totalExamplaries;
    }

    public void setTotalExamplaries(Integer totalExamplaries) {
        this.totalExamplaries = totalExamplaries;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "CAT_CODE", referencedColumnName = "CODE")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.book", cascade = CascadeType.ALL)
    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

}
