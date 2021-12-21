package org.your.reference.service.dataaccess;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.your.reference.service.entity.Expense;
import org.your.reference.service.impl.ExpenseServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExpenseServiceImplTest {

	@InjectMocks
	ExpenseServiceImpl expenseService;

	@Mock
	ExpenseRepository expenseRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListItemsWithPriceOver() {
		List<Expense> expenses = new ArrayList<>();
		Expense e = new Expense("breakfast", 500);
		expenses.add(e);
		
		when(expenseRepository.listItemsWithPriceOver(200)).thenReturn(expenses);
		List<Expense> actual = expenseService.listItemsWithPriceOver(200);
		
		assertEquals(actual.size(), 1);
		
	}

}
