package com.hyt.budget;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Period {
    private final LocalDate startLocalDate;
    private final LocalDate endLocalDate;

    public Period(LocalDate startLocalDate, LocalDate endLocalDate) {
        this.startLocalDate = startLocalDate;
        this.endLocalDate = endLocalDate;
    }

    public LocalDate getStartLocalDate() {
        return startLocalDate;
    }

    public LocalDate getEndLocalDate() {
        return endLocalDate;
    }

    long overlappingDays(Period another) {
        if (hasNoOverlapping(another)) {
            return 0;
        }

        LocalDate overlappingStart = startLocalDate.isAfter(another.startLocalDate)
                ? startLocalDate
                : another.startLocalDate;

        LocalDate overlappingEnd = endLocalDate.isBefore(another.endLocalDate)
                ? endLocalDate
                : another.endLocalDate;

        return DAYS.between(overlappingStart, overlappingEnd) + 1;
    }

    private boolean hasNoOverlapping(Period another) {
        return startLocalDate.isAfter(another.endLocalDate) || endLocalDate.isBefore(another.startLocalDate);
    }

    public boolean isInvalid() {
        return startLocalDate.isAfter(endLocalDate);
    }
}
