package org.example.menu;

import org.example.taxes.Taxes;

public class MenuDefineSum implements MenuItem {


    @Override
    public void execute(){

        new Taxes().SumTaxes();
    }

}