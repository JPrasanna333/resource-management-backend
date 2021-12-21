package org.your.reference.service.dataaccess;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.your.reference.service.entity.Expense;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ExpenseRepositoryTest {

	@Autowired
	private ExpenseRepository expenseRepository;
	

	@Test
	@Rollback(false)
	public void testSaveMethod() {
		expenseRepository.save(new Expense("breakfast", 5));
	}

	@Test
	public void testfindByItem() {
		List<Expense> exp = expenseRepository.findByItem("breakfast");
		assertTrue(exp.size() == 1);
		assertTrue(exp.get(0).getItem().equalsIgnoreCase("breakfast"));
	}
}
