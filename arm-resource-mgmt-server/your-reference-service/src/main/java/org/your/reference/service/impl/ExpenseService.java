package org.your.reference.service.impl;

import java.util.List;

import org.your.reference.service.entity.Expense;

public interface ExpenseService {

	public List<Expense> listItemsWithPriceOver(float amount);
	
	public void save(Expense expense);
}
