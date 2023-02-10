package org.example;

import org.example.menu.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


import static org.example.message.SendEmail.sendMessage;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        try {

            FileHandler handler = new FileHandler("logs.txt");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.info("Оголошення змінних: Сканер, Консольне меню");

            try (Scanner sc = new Scanner(System.in)) {
                MainMenu menu = new MainMenu();

                logger.info("Викличте функцію, в якій ми використовуємо меню, і виберіть команду");
                while (true) {
                    System.out.println("\n Доступні команди: ");
                    menu.printAllCommands();
                    System.out.println("\n Введіть вашу команду (якщо ви хочете вийти - надрукуйте 'exit'): ");
                    String command = sc.next();
                    if (Objects.equals(command.toLowerCase(), "exit")) {
                        break;
                    }
                    menu.execute(command);
                }
            }
        } catch (Exception error) {
            logger.log(Level.WARNING, "Finding critical error: ", error);
            System.out.println("The error occurred.\n");
            sendMessage("Founded critical error: " + error);
            error.printStackTrace();

        }
    }
}