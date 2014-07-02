package com.example.magazinon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.magazinon.R;
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
        
        
        Map<String, String> params = new HashMap<String, String>();
        ServerConnection.sharedInstance().getRequest("/list/", params, new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(String js) 
                    {
                        super.onSuccess(js);
                        System.out.println("LIST Post Request Succesfull");

                        JSONArray jsonList;
                        try 
                        {
                            jsonList = new JSONArray(js);
                                for(int i = 0; i < jsonList.length(); i++) {
                                    JSONObject jsonElem = (JSONObject) jsonList.get(i);
                                    produse.add(jsonElem.toString());
                                    
                                    /*System.out.println(jsonElem.toString());*/
                                    }
                               
                        }  
                        catch (JSONException e) {
                            System.out.println(e);
                        }

                    }

                    @SuppressWarnings("deprecation")
                    @Override
                    public void onFailure(Throwable arg0) {
                        System.out.println("LIST Post Request Failed " + arg0.getMessage());
                        super.onFailure(arg0);
                    }
                });
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produse);
        setListAdapter(adapter);
	}
}
