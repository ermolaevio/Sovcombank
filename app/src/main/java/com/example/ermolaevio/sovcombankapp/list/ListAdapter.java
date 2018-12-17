package com.example.ermolaevio.sovcombankapp.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ermolaevio.sovcombankapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder> {

    @NonNull
    private final List<Item> list = new ArrayList<>(100);

    void setItems(@NonNull List<Item> items) {
        list.clear();
        list.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int pos) {
        itemHolder.bind(list.get(pos));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {

        private final TextView first;
        private final TextView second;

        private ItemHolder(View view) {
            super(view);
            first = itemView.findViewById(R.id.first);
            second = itemView.findViewById(R.id.second);
        }

        private void bind(Item item) {
            first.setText(item.firstText);
            second.setText(item.secondText);
        }
    }

    static class Item {
        private final String firstText;
        private final String secondText;

        Item(String firstText, String secondText) {
            this.firstText = firstText;
            this.secondText = secondText;
        }
    }
}
