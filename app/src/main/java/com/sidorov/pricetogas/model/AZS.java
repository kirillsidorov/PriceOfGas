package com.sidorov.pricetogas.model;

import java.util.HashMap;

public class AZS extends HashMap<String, String>{

     public static final String NAME = "name";
     public static final String PRICE = "price";
     public static final String TELEPHONE = "telephone";
    public static final String ADDRESS = "address";
    public static final String MODE = "mode";

    // Конструктор с параметрами
    public AZS(String name, String price, String telNumber, String address, String mode) {
        super();
        super.put(NAME, name);
        super.put(PRICE, price);
        super.put(TELEPHONE, telNumber);
        super.put(ADDRESS, address);
        super.put(MODE, mode);
    }

    public String getTelephone(){
        return get(AZS.TELEPHONE);
    }

    public String getNAME() {
        return NAME;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getAddress() {
        return ADDRESS;
    }

}
