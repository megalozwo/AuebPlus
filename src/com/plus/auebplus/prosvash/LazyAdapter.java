package com.plus.auebplus.prosvash;


import java.util.ArrayList;

import com.plus.auebplus.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class LazyAdapter extends BaseAdapter {
 
    private Activity activity;
    private ArrayList<TransferObject> data;
    private static LayoutInflater inflater=null;
 
    public LazyAdapter(Activity a,ArrayList<TransferObject> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_view_row_item, null);
        vi.setOnClickListener(null);
        vi.setLongClickable(false);
        vi.setClickable(false);
          TextView name = (TextView) vi.findViewById(R.id.name); // title
          TextView caption = (TextView)vi.findViewById(R.id.description); // artist name
          ImageView icon = (ImageView)vi.findViewById(R.id.icon);
          
        TransferObject to = new TransferObject();
        to = data.get(position);
 
        // Setting all values in listview
        name.setText(to.getName());
        caption.setText(to.getCaption());
        if (to.getBus()) {
  	      icon.setImageResource(R.drawable.trolley);
  	    } else {
  	      icon.setImageResource(R.drawable.buss);
  	    }
        return vi;
    }
}