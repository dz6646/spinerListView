package com.example.spinerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Spinner classes;
    ListView students;
    TextView[] texts = new TextView[4];
    String[] kitot = {"Select a class", "11-A", "11-B", "11-C", "11-D"};
    String[] class1 = {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
    String[] class2 = {"b", "b", "b", "b", "b", "b", "b", "b", "b", "b"};
    String[] class3 = {"c", "c", "c", "c", "c", "c", "c", "c", "c", "c"};
    String[] class4 = {"d", "d", "d", "d", "d", "d", "d", "d", "d", "d"};
    ArrayAdapter<String> spinner_adapter;
    ArrayAdapter<String> chose_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, kitot);

        initAll();
        classes.setAdapter(spinner_adapter);
        classes.setOnItemSelectedListener(this);

    }

    public void initAll()
    {
        classes = findViewById(R.id.classes);
        students = findViewById(R.id.students);
        texts[0] = findViewById(R.id.family);
        texts[1] = findViewById(R.id.name);
        texts[2] = findViewById(R.id.birth);
        texts[3] = findViewById(R.id.phone);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();
        switch (i)
        {
            case 1:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, class1);
                students.setAdapter(chose_adapter);
                break;

            case 2:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, class2);
                students.setAdapter(chose_adapter);
                break;
            case 3:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, class3);
                students.setAdapter(chose_adapter);
                break;

            case 4:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, class4);
                students.setAdapter(chose_adapter);
                break;
            default:
                //Toast.makeText()
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch(i)
        {
            case 0:

        }
    }
}