package org.example.taxes;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

class SortDescTest {
    Taxes person = new Taxes();
    @Test
    void compare() {
        Income income1 = new Income("award", 1500.00);
        Income income2 = new Income("main income", 60000.00);

        income1.getPercentageOfTax();
        income1.getSizeOfTax();
        income2.getPercentageOfTax();
        income2.getSizeOfTax();

        int expected = (int)(income2.sizeOfTax - income1.sizeOfTax);
        Income object1 = person.getTaxes().get(0);
        Income object2 = person.getTaxes().get(1);

        int comparator = new ComparatorSortDesc().compare(object1,object2);

        Assert.assertEquals(expected, comparator);
    }
}
