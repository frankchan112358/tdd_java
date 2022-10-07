package com.hyt.budget;

import java.time.LocalDate;

public class BudgetService {

    private IBudgetRepo budgetRepo;

    public BudgetService(IBudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public double queryBudget(LocalDate startLocalDate, LocalDate endLocalDate) {
        Period period = new Period(startLocalDate, endLocalDate);
        if (period.isInvalid()) {
            return 0;
        }

        return budgetRepo.findAll()
                .stream()
                .mapToDouble(budget -> budget.overlappingAmount(period))
                .sum();
    }

}