package org.example.taxes;

import java.util.Comparator;

class SortDesc implements Comparator<Income> {
    @Override
    public int compare(Income o1, Income o2) {

        return (int)(o2.sizeOfTax - o1.sizeOfTax);
    }
}
