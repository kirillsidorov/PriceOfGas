package com.sidorov.pricetogas.service;

import android.os.AsyncTask;

import com.sidorov.pricetogas.model.GasStation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

// no usages

class AZSListAll extends AsyncTask<Void, Void, ArrayList<GasStation>> {
   private static final String HTTP_QUERY_AGZS = "https://igas.com.ua/mobile#date=2016-12-09&area=20&station=average";

   @Override
   protected ArrayList<GasStation> doInBackground(Void... params) {
       ArrayList<GasStation> list = new ArrayList<>();
       try {
           Document document = Jsoup.connect(HTTP_QUERY_AGZS).get();
           Elements gasStation = document.getElementsByAttribute("gas");
           Elements names = gasStation.select(".group-price");
           Elements prices = gasStation.select(".price");

           for (int i = 0; i < names.size(); i++) {
               Element name = names.get(i);
               Element price = prices.get(i+1);
               //list.add(new GasStation(name.text(), price.text()));
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return list;
   }
}
