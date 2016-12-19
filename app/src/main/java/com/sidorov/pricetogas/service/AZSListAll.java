package com.sidorov.pricetogas.service;

import android.os.AsyncTask;

import com.sidorov.pricetogas.model.AZS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

class AZSListAll extends AsyncTask<Void, Void, ArrayList<AZS>> {
   private static final String HTTP_QUERY_AGZS = "https://igas.com.ua/mobile#date=2016-12-09&area=20&station=average";

   @Override
   protected ArrayList<AZS> doInBackground(Void... params) {
       ArrayList<AZS> list = new ArrayList<>();
       try {
           Document document = Jsoup.connect(HTTP_QUERY_AGZS).get();
           Elements gasStation = document.getElementsByAttribute("gas");
           Elements names = gasStation.select(".group-price");
           Elements prices = gasStation.select(".price");

           for (int i = 0; i < names.size(); i++) {
               Element name = names.get(i);
               Element price = prices.get(i+1);
               //list.add(new AZS(name.text(), price.text()));
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return list;
   }
}
