package org.your.reference.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.your.reference.service.entity.Expense;
import org.your.reference.service.impl.ExpenseService;

@RestController
public class ExpenseApi {

	@Autowired
	private ExpenseService expenseService;

	/**
	 * Ignore the syntax and reality this is just to demo
	 */
	@GetMapping("/expense/create")
	public void createExpanses() {
		expenseService.save(new Expense("breakfast", 5));
		expenseService.save(new Expense("coffee", 2));
		expenseService.save(new Expense("New SSD drive", 200));
		expenseService.save(new Expense("Tution for baby", 350));
		expenseService.save(new Expense("Some apples", 5));
	}
	

	@GetMapping("/expense/list")
	public List<Expense> listItems() {
		List<Expense> expensiveItems = expenseService.listItemsWithPriceOver(200);	
		return expensiveItems;
	}

}
