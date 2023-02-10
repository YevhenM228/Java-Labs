package org.example.menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MainMenu {
    private final Map<String, MenuItem> menuItems;
    private static final Logger logger = Logger.getLogger(MainMenu.class.getName());
    public MainMenu(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("Set", new MenuDefineSet());
        menuItems.put("Sum", new MenuDefineSum());
        menuItems.put("searchIncome", new MenuSearchTaxes("ByIncome", 1000,50000));
        menuItems.put("searchTax", new MenuSearchTaxes("ByTax", 100, 2000));
        menuItems.put("sortAsc", new MenuSortTaxes("Asc"));
        menuItems.put("sortDesc", new MenuSortTaxes("Desc"));

    }
    public void help(String func){

        switch(func){
            case("Set")->
                    System.out.println(" Set - Ця функція визначає набір податків для особи");
            case("Sum")->
                    System.out.println(" Sum - Ця функція визначає суму податків для особи");
            case("searchIncome")->
                    System.out.println(" searchIncome - Ця функція шукає податки для особи в діапазоні доходів");
            case("searchTax")->
                    System.out.println(" searchTax - Ця функція шукає податки для особи в діапазоні розміру податку");
            case("sortAsc")->
                    System.out.println(" sortAsc - Ця функція сортує податки для особи за зростанням");
            case("sortDesc")->
                    System.out.println(" sortDesc - Ця функція сортує податки для особи за спаданням");
        }

    }

    public void execute(String command){
        if(menuItems.get(command) == null){

            logger.info("Inputting incorrect command");

            System.out.println("Incorrect command!");
            return;
        }
        logger.info("Executing command " + command);
        menuItems.get(command).execute();
    }

    public void printAllCommands(){

        for (Map.Entry<String, MenuItem> entry: menuItems.entrySet()) {
            String func = entry.getKey();
            help(func);
        }
    }
}
