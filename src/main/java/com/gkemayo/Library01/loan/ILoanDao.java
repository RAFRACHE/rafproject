package com.gkemayo.Library01.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ILoanDao extends JpaRepository<Loan, Integer> {
    //recheche des prets par la date de fin de pret
    public List<Loan> findByEndDateBefore(LocalDate maxEndDate);

    //obtenir tous les prêts ouverts de ce client
    @Query(   "SELECT lo "
            + "FROM Loan lo "
            + "INNER JOIN lo.pk.customer c "
            + "WHERE UPPER(c.email) = UPPER(?1) "
            + "   AND lo.status = ?2 ")
    public List<Loan> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
    //recuperer les prets par critraires ;
    @Query(   "SELECT lo "
            + "FROM Loan lo "
            + "INNER JOIN lo.pk.book b "
            + "INNER JOIN lo.pk.customer c "
            + "WHERE b.id =	?1 "
            + "   AND c.id = ?2 "
            + "   AND lo.status = ?3 ")
    public Loan getLoanByCriteria(Integer bookId, Integer customerId, LoanStatus status);

}
