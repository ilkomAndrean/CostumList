package com.example.andre.costumlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FormEdit extends AppCompatActivity {

    EditText editNo, editNoreg, editNama, editMail, editPhone;
    static ArrayList<Student> StudentList;
    FloatingActionButton Save, cancel;
    private int position;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit);
        StudentList = StudentActivity.StudentList;
        editNo = (EditText) findViewById(R.id.editNo);
        editNoreg = (EditText) findViewById(R.id.editNoreg);
        editNama = (EditText) findViewById(R.id.editNama);
        editMail = (EditText) findViewById(R.id.editMail);
        editPhone = (EditText) findViewById(R.id.editPhone);
        Save = (FloatingActionButton)findViewById(R.id.save);
        listView = (ListView) findViewById(R.id.listView);
        cancel = (FloatingActionButton)findViewById(R.id.batal);

        Student studentIsi = (Student) getIntent().getSerializableExtra("StudentListItem");
        editNo.setText(String.valueOf(studentIsi.getId()));
        editNoreg.setText(studentIsi.getNoreg());
        editNama.setText(studentIsi.getNama());
        editMail.setText(studentIsi.getMail());
        editPhone.setText(studentIsi.getPhone());
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void edit(){

        int getInput1 = Integer.parseInt(editNo.getText().toString());
        String getInput2 = editNoreg.getText().toString();
        String getInput3 = editNama.getText().toString();
        String getInput4 = editMail.getText().toString();
        String getInput5 = editPhone.getText().toString();
        Student student = new Student(getInput1, getInput2, getInput3, getInput4, getInput5);
        StudentList.set(position, student);
        finish();

        Toast.makeText(getApplicationContext(), "Berhasil Diedit", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), StudentActivity.class);

        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteItem:
                for(int l = position+1; l < StudentList.size(); l++){
                    StudentList.get(position+l).setId(l);
                }
                position = getIntent().getIntExtra("position", 0);
                StudentList.remove(position);
                Toast.makeText(getApplicationContext(), "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),StudentActivity.class);

                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}