package com.example.andre.costumlist;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormStudent extends AppCompatActivity {

    private EditText idText;
    private EditText nameText;
    private EditText noregText;
    private EditText phoneText;
    private EditText mailText;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);

        idText = (EditText) findViewById(R.id.editNo);
        nameText = (EditText) findViewById(R.id.editNama);
        noregText = (EditText) findViewById(R.id.editNoreg);
        phoneText = (EditText) findViewById(R.id.editPhone);
        mailText = (EditText) findViewById(R.id.editMail);

        FloatingActionButton tambah = (FloatingActionButton) findViewById(R.id.tambah);
        FloatingActionButton batal = (FloatingActionButton) findViewById(R.id.batal);


        tambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                saveNewData();
            }
        });
        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();            }
        });

    }

    protected void saveNewData(){
        int id = Integer.parseInt(idText.getText().toString());
        String noreg = noregText.getText().toString();
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        String mail = mailText.getText().toString();
        student = new Student(id, noreg, name, mail, phone);
        SStudent staticStudent = SStudent.getInstance();
        staticStudent.addStudent(student);
        Toast success = Toast.makeText(getApplicationContext(), "New Student Data Added", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }

}