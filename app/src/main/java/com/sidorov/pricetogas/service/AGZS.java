package com.sidorov.pricetogas.service;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

// TODO: 07.01.2017 delete

public class AGZS extends AsyncTask<Void, Void, ArrayList<String>> {
    private static final String HTTP_QUERY_AGZS = "http://rodnik.ua/content/set-agzs";

    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Document document = Jsoup.connect(HTTP_QUERY_AGZS).get();
            Elements elements = document.select(".views-row");
            for (int i = 1; i < elements.size(); i++) {
                Element infoAZS = elements.get(i);
                list.add(infoAZS.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
