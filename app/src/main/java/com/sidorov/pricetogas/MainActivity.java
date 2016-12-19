package com.sidorov.pricetogas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sidorov.pricetogas.model.AZS;
import com.sidorov.pricetogas.service.AGZS;
import com.sidorov.pricetogas.service.AZSList;

import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout mSwipeRefreshLayout;
    AZSList l;
    AGZS agzs;
    ListAdapter adapter=null;
    ListView listView;


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView) findViewById(R.id.listView);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);

        agzs = new AGZS();
        l = new AZSList();
        agzs.execute();
        l.execute();

        adapter = getListAdapter(adapter);
        listView.setAdapter(adapter);

        //запуск второго активити
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                try {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("1", agzs.get().get(position));
                    intent.putExtra("telephone", l.get().get(position).getTelephone());
                    intent.putExtra("address", l.get().get(position).getAddress());
                    intent.putExtra("name", l.get().get(position).getNAME());
                    startActivity(intent);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ListAdapter getListAdapter(ListAdapter adapter) {
        if (isNetworkConnected()) {
            try {
                adapter = new SimpleAdapter(this, l.get(), R.layout.list_item1,
                        new String[]{AZS.NAME, AZS.PRICE}, new int[]{
                        R.id.tvName, R.id.tvPrice});
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "Connection is off!",
                    Toast.LENGTH_LONG).show();
        }
        return adapter;
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {

                agzs = new AGZS();
                l = new AZSList();

                agzs.execute();
                l.execute();

                adapter = getListAdapter(adapter);
                listView.setAdapter(adapter);

                mSwipeRefreshLayout.setRefreshing(false);

            }
        }, 3000);
    }
}
