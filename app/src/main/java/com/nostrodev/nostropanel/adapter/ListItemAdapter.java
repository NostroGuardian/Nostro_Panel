package com.nostrodev.nostropanel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostrodev.nostropanel.R;
import com.nostrodev.nostropanel.model.ListItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ListItemHolder> {

    Context context;
    List<ListItem> listItems;

    public ListItemAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @NotNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View listItems = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        return new ListItemHolder(listItems);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListItemHolder holder, int position) {
        holder.itemHeader.setText(listItems.get(position).getTitle());
        holder.itemContent.setText(listItems.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static final class ListItemHolder extends RecyclerView.ViewHolder {

        TextView itemHeader, itemContent;

        public ListItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            itemHeader = itemView.findViewById(R.id.itemHeader);
            itemContent = itemView.findViewById(R.id.itemContent);
        }
    }

}
