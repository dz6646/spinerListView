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
    int classChoice;
    String[] kitot = {"Select a class", "11-A", "11-B", "11-C", "11-D"};
    String[][] firstNames = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0"} ,
            {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b0"},
            {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c0"},
            {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d0"}};

    String[][] secondNames = {{"family name of a", "family name of a", "family name of a", "family name of a", "family name of a",
            "family name of a", "family name of a", "family name of a", "family name of a", "family name of a"},
            {"family name of b", "family name of b", "family name of b", "family name of b", "family name of b",
                    "family name of b", "family name of b", "family name of b", "family name of b", "family name of b"},
            {"family name of c", "family name of c", "family name of c", "family name of c", "family name of c", "family name of c", "family name of c",
                    "family name of c", "family name of c", "family name of c"},
            {"family name of d", "family name of d", "family name of d", "family name of d", "family name of d", "family name of d",
                    "family name of d", "family name of d", "family name of d", "family name of d"}};

    String[][] phoneNumbers = {{"058665150A1", "058665150A2", "058665150A3", "058665150A4", "058665150A5", "058665150A6", "058665150A7",
            "058665150A8", "058665150A9", "058665150A0"},
            {"058665150B1" , "058665150B1" , "058665150B1", "058665150B1", "058665150B1", "058665150B1", "058665150B1", "058665150B1",
                    "058665150B1", "058665150B1"},
            {"058665150C1","058665150C1", "058665150C1", "058665150C1", "058665150C1", "058665150C1", "058665150C1", "058665150C1"
            ,"058665150C1" , "058665150C1"},
            {"058665150D1", "058665150D1", "058665150D1", "058665150D1", "058665150D1", "058665150D1", "058665150D1", "058665150D1",
                    "058665150D1", "058665150D1"}};

    String[][] bDay = {{"AA/AA/AAAA", "AA/AA/AAAA", "AA/AA/AAAA", "AA/AA/AAAA", "AA/AA/AAAA", "AA/AA/AAAA", "AA/AA/AAAA", "AA/AA/AAAA",
            "AA/AA/AAAA", "AA/AA/AAAA"},
            {"BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB", "BB/BB/BBBB",
                    "BB/BB/BBBB"},
            {"CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC", "CC/CC/CCCC",
                    "CC/CC/CCCC"}
    ,{"DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD", "DD/DD/DDDD"}};

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
        students.setOnItemClickListener(this);

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
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstNames[0]);
                students.setAdapter(chose_adapter);
                classChoice = 0;
                break;

            case 2:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstNames[1]);
                students.setAdapter(chose_adapter);
                classChoice = 1;
                break;
            case 3:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstNames[2]);
                students.setAdapter(chose_adapter);
                classChoice = 2;
                break;

            case 4:
                chose_adapter = new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, firstNames[3]);
                students.setAdapter(chose_adapter);
                classChoice = 3;
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
        texts[0].setText("Family Name: " + secondNames[classChoice][i]);
        texts[1].setText("Name: " + firstNames[classChoice][i]);
        texts[2].setText("Bday Date: " + bDay[classChoice][i]);
        texts[3].setText("Phone Number: " + phoneNumbers[classChoice][i]);
    }
}