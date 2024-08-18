package com.os.opendialogonsinglelistitem;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.os.opendialogonsinglelistitem.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("John Lee");
        arrayList.add("Mickel Jorden");
        arrayList.add("Steve Handrikson");
        arrayList.add("Keanue Reeves");
        arrayList.add("John Cena");
        arrayList.add("Bob Marley");
        arrayList.add("Robin Hood");
        arrayList.add("Millie Bobby");
        arrayList.add("Nancy Wheeler");
        arrayList.add("Dexter Jackson");
        arrayList.add("Jay Cutler");
        arrayList.add("Sandra Bullock");
        arrayList.add("Ketty Perry");

        binding.rvForItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ListAdapter listAdapter = new ListAdapter(this, arrayList);
        binding.rvForItem.setAdapter(listAdapter);
    }
}