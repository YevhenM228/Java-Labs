package org.example.menu;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class MenuDefineSetTest {

    @Test
    void execute() {

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        new MenuDefineSet().execute();
        String expected = "\n" +
                " Набір податків:\r\n" +
                "300.0\r\n" +
                "12000.0\r\n" +
                "112.5\r\n";

        String actual = outputStreamCaptor.toString();
        Assert.assertEquals(expected, actual);

    }
}