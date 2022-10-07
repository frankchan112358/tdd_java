package com.hyt.budget;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BudgetServiceTests {

    private final IBudgetRepo budgetRepo = mock(IBudgetRepo.class);

    private final BudgetService budgetService = new BudgetService(budgetRepo);

    @Test
    void no_budgets() {
        givenBudgets();

        budgetShouldBe(0, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 27));
    }

    @Test
    void invalid_period() {
        givenBudgets();

        budgetShouldBe(0, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 26));
    }

    @Test
    void period_inside_budget_month() {
        givenBudgets(new Budget("202208", 310));

        budgetShouldBe(10, LocalDate.of(2022, 8, 27), LocalDate.of(2022, 8, 27));
    }

    @Test
    void period_no_overlap_before_budget_first_day() {
        givenBudgets(new Budget("202208", 310));

        budgetShouldBe(0, LocalDate.of(2022, 7, 27), LocalDate.of(2022, 7, 27));
    }

    @Test
    void period_no_overlap_after_budget_last_day() {
        givenBudgets(new Budget("202208", 310));

        budgetShouldBe(0, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 1));
    }

    @Test
    void period_overlap_budget_first_day() {
        givenBudgets(new Budget("202208", 310));

        budgetShouldBe(20, LocalDate.of(2022, 7, 27), LocalDate.of(2022, 8, 2));
    }

    @Test
    void period_overlap_budget_last_day() {
        givenBudgets(new Budget("202208", 310));

        budgetShouldBe(10, LocalDate.of(2022, 8, 31), LocalDate.of(2022, 9, 1));
    }

    @Test
    void multiple_budgets() {
        givenBudgets(new Budget("202207", 31), new Budget("202208", 310), new Budget("202209", 3000));

        budgetShouldBe(2 + 310 + 100 * 9, LocalDate.of(2022, 7, 30), LocalDate.of(2022, 9, 9));
    }

    private void budgetShouldBe(int expected, LocalDate startDate, LocalDate endDate) {
        Assertions.assertEquals(expected, budgetService.queryBudget(startDate, endDate), 0.00);
    }

    private void givenBudgets(Budget... budgets) {
        when(budgetRepo.findAll()).thenReturn(Arrays.asList(budgets));
    }
}
