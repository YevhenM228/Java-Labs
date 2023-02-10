package org.example.menu;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainMenuTest {

    MainMenu menu = new MainMenu();

    @Test
    void helpDefineSet() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = "Set - Ця функція визначає набір податків для особи";
        menu.help("Set");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
    }
    @Test
    void helpDefineSum() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = "Sum - Ця функція визначає суму податків для особи";
        menu.help("Sum");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
    }
    @Test
    void helpSearchByIncome() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = "searchIncome - Ця функція шукає податки для особи в діапазоні доходів";
        menu.help("searchIncome");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
    }
    @Test
    void helpSearchByTax() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = "searchTax - Ця функція шукає податки для особи в діапазоні розміру податку";
        menu.help("searchTax");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
    }
    @Test
    void helpSortAsc() {

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = "sortAsc - Ця функція сортує податки для особи за зростанням";
        menu.help("sortAsc");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());

    }
    @Test
    void helpSortDesc() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = "sortDesc - Ця функція сортує податки для особи за спаданням";
        menu.help("sortDesc");

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());

    }

    @Test
    void executeDefineSum() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        menu.execute("Sum");
        String expected = "Сума податків: 12412.5";

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void printAllCommands() {

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        menu.printAllCommands();

        String expected = "Set - Ця функція визначає набір податків для особи\r\n" +
                " Sum - Ця функція визначає суму податків для особи\r\n" +
                " searchIncome - Ця функція шукає податки для особи в діапазоні доходів\r\n" +
                " searchTax - Ця функція шукає податки для особи в діапазоні розміру податку\r\n" +
                " sortAsc - Ця функція сортує податки для особи за зростанням\r\n" +
                " sortDesc - Ця функція сортує податки для особи за спаданням";

        Assert.assertEquals(expected, outputStreamCaptor.toString().trim());

    }
}