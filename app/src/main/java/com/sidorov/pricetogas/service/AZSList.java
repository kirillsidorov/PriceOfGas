package com.sidorov.pricetogas.service;

import android.os.AsyncTask;

import com.sidorov.pricetogas.model.AZS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class AZSList extends AsyncTask<Void, Void, ArrayList<AZS>> {
    private static final String HTTP_QUERY_AGZS = "http://rodnik.ua/content/set-agzs";

    @Override
    protected ArrayList<AZS> doInBackground(Void... params) {
        ArrayList<AZS> listAZS = new ArrayList<>();
        try {
            Document document = Jsoup.connect(HTTP_QUERY_AGZS).get();
            listAZS = listInit(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listAZS;
    }

    public ArrayList<AZS> listInit(Document document){
        ArrayList<AZS> list = new ArrayList<>();
        Elements names = document.select(".views-field-title");
        Elements prices = document.select(".views-field-field-gas-value");
        Elements telephones = document.select(".views-field-field-phone-value");
        Elements adresses = document.select(".views-field-field-address-value");
        Elements modes = document.select(".views-field-field-mode-value");
        for (int i = 0; i < names.size(); i++) {
            Element name = names.get(i);
            Element price = prices.get(i+1);
            Element telephone = telephones.get(i);
            Element address = adresses.get(i);
            Element mode = modes.get(i);
            list.add(new AZS(
                    name.text(),
                    price.text(),
                    telephone.text(),
                    address.text(),
                    mode.text()
            ));
        }
        return list;
    }
}
