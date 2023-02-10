package org.example.taxes;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class TaxesTest {

    Taxes person = new Taxes();

    @Test
    void testCreateTaxes(){
        List<Income> taxes = new ArrayList<>();

        Income income1 = new Income("award", 1500.00);
        Income income2 = new Income("main income", 60000.00);
        Income income3 = new Income("funds as a gift", 2500.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        person.addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.createListOfTax().toString());
    }

    @Test
    void testDefineSet(){

        Set<Double> testSet = new HashSet<>();
        testSet.add(12000.0);
        testSet.add(300.0);
        testSet.add(112.5);
        Assert.assertEquals(testSet, person.SetTaxes());

    }

    @Test
    void testDefineSum(){
        Assert.assertEquals(12412.5, person.SumTaxes());
    }

    @Test
    void testSortTaxesAsc(){

        List<Income> taxes = new ArrayList<>();

        Income income1 = new Income("funds as a gift",  2700.00);
        Income income2 = new Income("award", 1500.00);
        Income income3 = new Income("main income", 60000.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        person.addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.sortTaxes("Asc").toString());

    }
    @Test
    void testSortTaxesDesc(){

        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("main income", 60000.00);
        Income income2 = new Income("award", 1500.00);
        Income income3 = new Income("funds as a gift", 2700.00);


        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        person.addIncome(taxes, income3);

        Assert.assertEquals(taxes.toString(), person.sortTaxes("Desc").toString());

    }

    @Test
    void testSearchTaxesByIncome(){

        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("main income", 60000.00);
        Income income2 = new Income("funds as a gift", 2500.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);
        Assert.assertEquals(taxes.toString(), person.searchTaxes("ByIncome",1000,50000).toString());
    }
    @Test
    void testSearchTaxesByTax(){

        ArrayList<Income> taxes = new ArrayList<>();
        Income income1 = new Income("award", 1500.00);
        Income income2 = new Income("funds as a gift", 2700.00);
        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(), person.searchTaxes("ByTax",110,2000).toString());
    }
    @Test
    void testFilterByIncome(){
        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("main income", 60000.00);
        Income income2 = new Income("funds as a gift", 2500.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(), person.filterTaxes("ByIncome", 1000,50000).toString());
    }
    @Test
    void testFilterByTax(){
        List<Income> taxes = new ArrayList<>();
        Income income1 = new Income("award", 1500.00);
        Income income2 = new Income("funds as a gift", 2700.00);

        person.addIncome(taxes, income1);
        person.addIncome(taxes, income2);

        Assert.assertEquals(taxes.toString(),person.filterTaxes("ByTax", 110, 2000).toString());
    }

}