package com.onestopcancercenter.onestopcancercenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class List_of_Hospitals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of__hospitals);

        final   ArrayList<ListItem> Hospitals=new  ArrayList<ListItem> ();
        Hospitals.add(new ListItem("Noura"));
        Hospitals.add(new ListItem("Reemeeiah"));
        Hospitals.add(new ListItem("Nawal"));



        final MyCustomAdapter myadpter= new MyCustomAdapter(Hospitals);
        ListView Ls = (ListView)findViewById(R.id.ListView);
        Ls.setAdapter(myadpter);


            }

    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<ListItem> Hospitals= new ArrayList<ListItem>();

        MyCustomAdapter(ArrayList<ListItem> Hospitals){
            this.Hospitals=Hospitals;


        }

        @Override
        public int getCount() {
            return Hospitals.size();
        }

        @Override
        public Object getItem(int position) {
            return Hospitals.get(position).HName;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater = getLayoutInflater();
            View view1=linflater.inflate(R.layout.row_view, null);

            TextView txtname =(TextView) view1.findViewById(R.id.Text_Hname);
            txtname.setText(Hospitals.get(i).HName);
            return view1;

        }
    }


        }






