package org.example.menu;

import org.example.taxes.Taxes;

public class MenuSearchTaxes implements MenuItem{
    public String type;
    public double a,b;

    public MenuSearchTaxes(String type, double a, double b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute(){
        new Taxes().searchTaxes(type,a,b);
    }

}