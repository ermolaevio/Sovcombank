package com.example.ermolaevio.sovcombankapp.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ermolaevio.sovcombankapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView list = findViewById(R.id.list);

        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        ListAdapter adapter = new ListAdapter();
        list.setAdapter(adapter);

        adapter.setItems(getItems());
    }

    private List<ListAdapter.Item> getItems() {
        List<ListAdapter.Item> items = new ArrayList<>();


        StringBuilder builder = new StringBuilder("1");
        items.add(new ListAdapter.Item(builder.toString(), "13:50"));
        for (int i = 2; i <= 100; i++) {
            String first = builder.append("_").append(i).toString();
            items.add(new ListAdapter.Item(first, "13:50"));
        }

        return items;
    }
}
