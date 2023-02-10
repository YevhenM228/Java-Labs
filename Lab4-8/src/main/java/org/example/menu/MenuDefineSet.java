package org.example.menu;


import org.example.taxes.Taxes;

public class MenuDefineSet implements MenuItem {
    public MenuDefineSet() {
    }

    @Override
    public void execute(){
        new Taxes().SetTaxes();
    }
}
