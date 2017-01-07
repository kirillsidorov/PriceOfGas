package com.sidorov.pricetogas.model;

import java.util.HashMap;

public class GasStation extends HashMap<String, String>{

     public static final String NAME = "name";
     public static final String PRICE = "price";
     public static final String TELEPHONE = "telephone";
     public static final String ADDRESS = "address";
     public static final String MODE = "mode";

    // Конструктор с параметрами
    public GasStation(String name, String price, String telNumber, String address, String mode) {
        super();
        super.put(NAME, name);
        super.put(PRICE, price);
        super.put(TELEPHONE, telNumber);
        super.put(ADDRESS, address);
        super.put(MODE, mode);
    }

    public String getNAME() {
        return get(GasStation.NAME);
    }

    public String getPRICE() {
        return get(GasStation.PRICE);
    }

    public String getTelephone(){
        return get(GasStation.TELEPHONE);
    }

    public String getAddress() {
        return get(GasStation.ADDRESS);
    }

    public String getMode () {
        return get(GasStation.MODE);
    }

}
