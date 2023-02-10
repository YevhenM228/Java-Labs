package org.example.taxes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class Taxes extends Income {

    public List<Income> taxes;
    private static final Logger logger = Logger.getLogger(Taxes.class.getName());

    public Taxes(){
        taxes = createListOfTax();
    }

    public List<Income> getTaxes() {
        return taxes;
    }

    public List<Income> createListOfTax(){

        logger.finest("Створення списку податків для особи");
        List<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1500.00);
        Income income2 = new Income("main income", 60000.00);
        Income income3 = new Income("funds as a gift", 2500.00);

        addIncome(taxes, income1);
        addIncome(taxes, income2);
        addIncome(taxes, income3);

        return taxes;
    }
    public void addIncome(List<Income> taxes, Income income){
        logger.fine("Отримання розміру податку шляхом надання доходу та додавання податкової інформації до списку податків");
        income.getPercentageOfTax();
        income.getSizeOfTax();
        taxes.add(income);

    }

    public Set<Double> SetTaxes(){

        if (taxes.isEmpty()) {
            logger.info("Список податків порожній");
            return null;
        }

        logger.info("Визначення сукупності розмірів податків");
        Set<Double> taxesSet = new HashSet<>();
        for(Income tax: taxes){
            taxesSet.add(tax.getSizeOfTax());
        }
        System.out.println("\n Набір податків:");
        for (Double obj : taxesSet)
            System.out.println(obj);

        return taxesSet;
    }

    public double SumTaxes(){

        logger.info("Сума податку");
        if (taxes.isEmpty()) {
            logger.info("Список податків порожній");
            return -1;
        }

        double total = 0.0;
        for(Income tax: taxes){
            total += tax.getSizeOfTax();
        }
        System.out.println("\n Сума податків: " + total);

        return total;
    }
    public List<Income> sortTaxes(String choice){

        List<Income> sortedTaxes = new ArrayList<>(taxes);

        if (Objects.equals(choice, "Asc")) {
            logger.info("Сортування податків за розміром податку та за зростанням");
            System.out.println("\n Розсортовані податки за зростанням:");
            sortedTaxes.sort(new ComparatorSortAsc());
        }  if (Objects.equals(choice, "Desc")) {
            logger.info("Сортування податків за розміром податку та за спаданням");
            System.out.println("\n Розсортовані податки за спаданням:");
            sortedTaxes.sort(new ComparatorSortDesc());
        }
        info(sortedTaxes);
        return sortedTaxes;
    }
    public List<Income> searchTaxes(String type, double a, double b){

        if (Objects.equals(type, "ByIncome")){
            logger.info("Пошук податків за доходами");
            System.out.println("\n Пошук податків за доходами в діапазоні [" + a +"; "+ b +"]:");
        }
        else {
            logger.info("Пошук податків за розміром податку");
            System.out.println("\n Пошук податків за доходами в діапазоні [" + a + "; " + b + "]:");
        }
        taxes = filterTaxes(type,a,b);

        info(taxes);
        return taxes;
    }

    public List<Income> filterTaxes(String type, double a, double b){

        if (Objects.equals(type, "ByIncome")){
            return taxes.stream().filter(k -> k.getSizeOfIncome() > a && k.getSizeOfIncome() < b).collect(Collectors.toCollection(ArrayList::new));
        }
        else{
            return taxes.stream().filter(k -> k.getSizeOfTax() > a && k.getSizeOfTax() < b ).collect(Collectors.toCollection(ArrayList::new));
        }

    }

    public void info(List<Income> taxes){
        logger.info("Друк списку податків");
        for(int i = 0; i < taxes.size(); i++) {
            System.out.print((i + 1) + ". " + taxes.get(i).toString() + "\n");
        }
    }
}
