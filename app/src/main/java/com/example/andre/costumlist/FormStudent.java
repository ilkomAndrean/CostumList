package com.example.andre.costumlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class FormStudent extends AppCompatActivity {
    EditText text1, text2, text3, text4, text5;
    ArrayList<Student> StudentList;
    FloatingActionButton Save, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);
        StudentList = StudentActivity.StudentList;
        text1 = (EditText) findViewById(R.id.editNo);
        text2 = (EditText) findViewById(R.id.editNoreg);
        text3 = (EditText) findViewById(R.id.editNama);
        text4 = (EditText) findViewById(R.id.editMail);
        text5 = (EditText) findViewById(R.id.editPhone);
        int auto = StudentList.size()+1;
        text1.setText(String.valueOf(auto));
        Save = (FloatingActionButton)findViewById(R.id.save);
        cancel = (FloatingActionButton)findViewById(R.id.batal);
        Intent i = getIntent();
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Save(){

        String getInput2 = text2.getText().toString();
        String getInput3 = text3.getText().toString();
        String getInput4 = text4.getText().toString();
        String getInput5 = text5.getText().toString();
        Student student = new Student(StudentList.size()+1, getInput2, getInput3, getInput4, getInput5);
        StudentList.add(student);
        finish();

        Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), StudentActivity.class);

        startActivity(i);
}
}