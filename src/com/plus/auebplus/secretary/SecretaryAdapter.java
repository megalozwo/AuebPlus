package com.plus.auebplus.secretary;

import java.util.ArrayList;
import java.util.List;

import com.plus.auebplus.R;
 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class SecretaryAdapter extends BaseAdapter {
    private LayoutInflater li;
 
    //holds Message objects
    private List<SecretaryObject> messages = new ArrayList<SecretaryObject>();
 
    public SecretaryAdapter(Context context, List<SecretaryObject> items)
    {
        li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(items != null)
            messages = items;
    }
 
    public int getCount() {
        return messages.size();
    }
 
    public Object getItem(int position) {
        return messages.get(position);
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
 
        View v = convertView;
        final String title = messages.get(position).getTitle();
        if (v == null) {
            v = li.inflate(R.layout.secretaryitem, null);
        }
 
        final TextView mTitle = (TextView) v.findViewById(R.id.mLine1);
        mTitle.setText(title);
        
 
        return v;
    }
}