package com.hyt.budget;

import java.time.LocalDate;

public class BudgetService {

    private IBudgetRepo budgetRepo;

    public BudgetService(IBudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public double queryBudget(LocalDate startLocalDate, LocalDate endLocalDate) {
        return 0;
    }
}
