package org.example.menu;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MenuSortTaxesTest {

    MenuSortTaxes sortTaxesAsc = new MenuSortTaxes("Asc");
    MenuSortTaxes sortTaxesDesc = new MenuSortTaxes("Desc");

    @Test
    void executeSortAsc() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        sortTaxesAsc.execute();
        String expected = "\n Розсортовані податки за зростанням:\r\n" +
                "1.  [ nameOfIncome: 'funds as a gift', sizeOfIncome = 2500.0, sizeOfTax = 112.5, percentageOfTax = 4.5 ] \n" +
                "2.  [ nameOfIncome: 'award', sizeOfIncome = 1500.0, sizeOfTax = 300.0, percentageOfTax = 20.0 ] \n" +
                "3.  [ nameOfIncome: 'main income', sizeOfIncome = 60000.0, sizeOfTax = 12000.0, percentageOfTax = 20.0 ] \n";

        String actual = outputStreamCaptor.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void executeSortDesc() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        sortTaxesDesc.execute();
        String expected = "\n Розсортовані податки за спаданням:\r\n" +
                "1.  [ nameOfIncome: 'main income', sizeOfIncome = 60000.0, sizeOfTax = 12000.0, percentageOfTax = 20.0 ] \n" +
                "2.  [ nameOfIncome: 'award', sizeOfIncome = 1500.0, sizeOfTax = 300.0, percentageOfTax = 20.0 ] \n" +
                "3.  [ nameOfIncome: 'funds as a gift', sizeOfIncome = 2500.0, sizeOfTax = 112.5, percentageOfTax = 4.5 ] \n";

        String actual = outputStreamCaptor.toString();
        Assert.assertEquals(expected, actual);
    }
}