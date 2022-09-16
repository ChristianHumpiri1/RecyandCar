package com.example.myappre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ListElement> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement( "#775447", "Christian", "Lima", "ACTIVO"));
        elements.add(new ListElement( "#775447", "Gean", "Lima", "ACTIVO"));
        elements.add(new ListElement( "#775447", "Adriano", "Arequipa", "ACTIVO"));
        elements.add(new ListElement( "#775447", "Jayhtan", "Lima", "ACTIVO"));
        elements.add(new ListElement( "#775447", "Piero", "La Paz", "ACTIVO"));

        ListAdaptador listAdaptador = new ListAdaptador(elements,this);
        RecyclerView recyclerView = findViewById(R.id.listRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdaptador);
    }
}