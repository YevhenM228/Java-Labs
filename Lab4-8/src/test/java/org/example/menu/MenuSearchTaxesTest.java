package org.example.menu;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class MenuSearchTaxesTest {

    MenuSearchTaxes searchByIncome = new MenuSearchTaxes("ByIncome", 1000,50000);
    MenuSearchTaxes searchByTax = new MenuSearchTaxes("ByTax", 110, 1000);

    @Test
    void executeSearchByIncome() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        searchByIncome.execute();
        String expected = "\n  Пошук податків за доходами в діапазоні [1000.0; 50000.0]:\r\n" +
                "1.  [ nameOfIncome: 'award', sizeOfIncome = 1970.0, sizeOfTax = 394.0, percentageOfTax = 20.0 ] \n" +
                "2.  [ nameOfIncome: 'funds as a gift', sizeOfIncome = 2460.0, sizeOfTax = 110.7, percentageOfTax = 4.5 ] \n";

        String actual = outputStreamCaptor.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void executeSearchByTax() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        searchByTax.execute();
        String expected = "\n  Пошук податків за доходами в діапазоні [110.0; 2000.0]:\r\n" +
                "1.  [ nameOfIncome: 'award', sizeOfIncome = 1970.0, sizeOfTax = 394.0, percentageOfTax = 20.0 ] \n" +
                "2.  [ nameOfIncome: 'funds as a gift', sizeOfIncome = 2460.0, sizeOfTax = 110.7, percentageOfTax = 4.5 ] \n";

        String actual = outputStreamCaptor.toString();
        Assert.assertEquals(expected, actual);
    }
}