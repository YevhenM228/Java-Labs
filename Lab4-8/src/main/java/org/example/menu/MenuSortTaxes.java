package org.example.menu;

import org.example.taxes.Taxes;

public class MenuSortTaxes implements MenuItem{
    public String type;

    public MenuSortTaxes(String type) {
        this.type = type;
    }

    @Override
    public void execute(){
        new Taxes().sortTaxes(type);
    }
}
