package com.example.myaplication;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class NewActivity extends ListActivity {
	
	ListView lista;
	Button btn2;
	/*btn = (Button)findViewById(R.id.button1);*/
	ArrayAdapter<String> adapter;
	ArrayList<String> animale;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        
        lista = (ListView) findViewById(android.R.id.list);
        animale = new ArrayList<String>();
        animale.add("Pisoi"); animale.add("Panda");
        animale.add("Pinguini"); animale.add("Manguste");
        animale.add("Iepurasi"); animale.add("Bufnite");
        
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animale);
        setListAdapter(adapter);
        
        lista.setOnItemClickListener(new OnItemClickListener() {
        	@Override
            public void onItemClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
                // TODO Auto-generated method stub
                Toast.makeText(NewActivity.this, "Ai ales "+ adaptor.getItemAtPosition(position) + ". Mai bine iti iei un pisoi! :)", Toast.LENGTH_SHORT).show()    ;
            }
        }); 
        
        lista.setOnItemLongClickListener(new OnItemLongClickListener() {
        	@Override
        	public boolean onItemLongClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
				// TODO Auto-generated method stub
				animale.remove(position);
				adapter.notifyDataSetChanged();
				return true;
			}
		});
        
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 //Toast.makeText(getApplicationContext(), "Button clicked!!!", Toast.LENGTH_LONG).show();
            	animale.add("Catei");
            	adapter.notifyDataSetChanged();

            }
        });
    	
    

	}
}
