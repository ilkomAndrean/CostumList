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

public class FormEditTeacher extends AppCompatActivity {

    EditText editNo, editNip, editNama, editMail, editPhone;
    static ArrayList<Teacher> TeacherList;
    FloatingActionButton Save, cancel;
    private int position;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit_teacher);
        TeacherList = TeacherActivity.TeacherList;
        editNo = (EditText) findViewById(R.id.editNo);
        editNip = (EditText) findViewById(R.id.editNip);
        editNama = (EditText) findViewById(R.id.editNama);
        editMail = (EditText) findViewById(R.id.editMail);
        editPhone = (EditText) findViewById(R.id.editPhone);
        Save = (FloatingActionButton)findViewById(R.id.save);
        listView = (ListView) findViewById(R.id.listView);
        cancel = (FloatingActionButton)findViewById(R.id.batal);

        Teacher TeacherIsi = (Teacher) getIntent().getSerializableExtra("TeacherListItem");
        editNo.setText(String.valueOf(TeacherIsi.getId()));
        editNip.setText(TeacherIsi.getNip());
        editNama.setText(TeacherIsi.getNama());
        editMail.setText(TeacherIsi.getMail());
        editPhone.setText(TeacherIsi.getPhone());
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
        String getInput2 = editNip.getText().toString();
        String getInput3 = editNama.getText().toString();
        String getInput4 = editMail.getText().toString();
        String getInput5 = editPhone.getText().toString();
        Teacher Teacher = new Teacher(getInput1, getInput2, getInput3, getInput4, getInput5);
        TeacherList.set(position, Teacher);
        finish();

        Toast.makeText(getApplicationContext(), "Berhasil Diedit", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), TeacherActivity.class);

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
                for(int l = position+1; l < TeacherList.size(); l++){
                    TeacherList.get(position+l).setId(l);
                }
                position = getIntent().getIntExtra("position", 0);
                TeacherList.remove(position);
                Toast.makeText(getApplicationContext(), "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),TeacherActivity.class);

                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}