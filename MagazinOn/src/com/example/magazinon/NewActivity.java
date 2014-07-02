package com.example.magazinon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.magazinon.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewActivity  extends ListActivity{
	ListView lista;
	ArrayAdapter<String> adapter;
	ArrayList<String> produse;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        
        lista = (ListView) findViewById(android.R.id.list);
        produse = new ArrayList<String>();
        
        
        
	}
}
