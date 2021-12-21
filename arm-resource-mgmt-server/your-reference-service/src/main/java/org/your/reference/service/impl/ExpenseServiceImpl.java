package org.your.reference.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.your.reference.service.dataaccess.ExpenseRepository;
import org.your.reference.service.entity.Expense;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public List<Expense> listItemsWithPriceOver(float amount) {
		return expenseRepository.listItemsWithPriceOver(amount);
	}

	@Override
	public void save(Expense expense) {
		expenseRepository.save(expense);
	}

}