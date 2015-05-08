package com.plus.auebplus;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.plus.auebplus.secretary.SecretaryAdapter;
import com.plus.auebplus.secretary.SecretaryObject;



public class Secretary extends ListActivity{

	List<SecretaryObject> messages = new ArrayList<SecretaryObject>();
	public Activity activity;
	
    public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     this.activity=this;
     
     initList();

     ListView list1 = getListView();
     list1.setAdapter(new SecretaryAdapter(this, messages));
     list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    	 public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
    		 //I think we need to put the targeted Secretary activity here.
    		 Intent i =new Intent(Secretary.this,SecretaryViewer.class);
    		 i.putExtra("layout", messages.get(position).getLayout());
    			//i.setData(Uri.parse(messages.get(position).getLink().toString()));
    			activity.startActivity(i);    
             }
                
     });
        
     
    }
    
    private void initList() {
	   
    	messages.add(new SecretaryObject("����������� ���������",R.layout.secretarygoe));
    	messages.add(new SecretaryObject("������� ��� ���������� �������",R.layout.secretarygdes));
    	messages.add(new SecretaryObject("����������",R.layout.secretarym));
    	messages.add(new SecretaryObject("����������",R.layout.secretaryl));
    	messages.add(new SecretaryObject("����������� ���������",R.layout.secretaryde));
    	messages.add(new SecretaryObject("������������",R.layout.secretaryde));
    	messages.add(new SecretaryObject("�����������",R.layout.secretarysta));
    	messages.add(new SecretaryObject("��������� ��� ���������",R.layout.secretaryokd));
    	
	}
}