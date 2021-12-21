package org.your.reference.service.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.your.reference.service.entity.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
     
    public List<Expense> findByItem(String item);
     
    @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
    public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);
}
