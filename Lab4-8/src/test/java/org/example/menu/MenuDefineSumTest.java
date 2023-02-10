package org.example.menu;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class MenuDefineSumTest {

    @Test
    void execute() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        new MenuDefineSum().execute();
        String expected = "\n" +
                " Сума податків: 12412.5\r\n";

        String actual = outputStreamCaptor.toString();
        Assert.assertEquals(expected, actual);
    }
}