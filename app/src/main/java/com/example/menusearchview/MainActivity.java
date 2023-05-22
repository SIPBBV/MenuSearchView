package com.example.menusearchview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String>list1;
    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phanxa();
        list1=new ArrayList<String>();
        list1.add("Monday");
        list1.add("Tuesday");
        list1.add("Wednesday");
        list1.add("Thursday");
        list1.add("Thursday");
        list1.add("Saturday");
        list1.add("Sunday");
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,list1);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
    void phanxa(){
        lv=findViewById(R.id.listview);
        sv=findViewById(R.id.searchViewID);
    }
}