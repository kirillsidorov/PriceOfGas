package com.sidorov.pricetogas;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sidorov.pricetogas.model.GasStation;
import com.sidorov.pricetogas.service.GasStationList;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout mSwipeRefreshLayout;
    GasStationList gasStationList;
    //AGZS agzs;
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

        //agzs = new AGZS();
        gasStationList = new GasStationList();
        //agzs.execute();
        gasStationList.execute();

        adapter = getListAdapter(adapter);
        listView.setAdapter(adapter);

        //запуск второго активити
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                try {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    //intent.putExtra("1", agzs.get().get(position));
                    intent.putExtra("telephone", gasStationList.get().get(position).getTelephone());
                    intent.putExtra("address", gasStationList.get().get(position).getAddress());
                    intent.putExtra("name", gasStationList.get().get(position).getNAME());
                    intent.putExtra("mode", gasStationList.get().get(position).getMode());
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
                adapter = new SimpleAdapter(
                        this, gasStationList.get(), R.layout.list_item1,
                        new String[]{GasStation.NAME, GasStation.PRICE},
                        new int[]{R.id.tvName, R.id.tvPrice});
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

                //agzs = new AGZS();
                gasStationList = new GasStationList();

                //agzs.execute();
                gasStationList.execute();

                adapter = getListAdapter(adapter);
                listView.setAdapter(adapter);

                mSwipeRefreshLayout.setRefreshing(false);

            }
        }, 3000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return  true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Toast.makeText(MainActivity.this, getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
