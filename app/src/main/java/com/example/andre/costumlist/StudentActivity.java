package com.example.andre.costumlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.andre.costumlist.Student;
import com.example.andre.costumlist.StudentAdapter;


public class StudentActivity extends AppCompatActivity  implements Serializable{
    private TextView emptyView;
    ListView listView1;
    static ArrayList<Student> StudentList;
    StudentAdapter studentAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_student, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_dummy:
                populateUsersList();

                return true;
            case R.id.clear_list:
                ClearList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        emptyView = (TextView)findViewById(R.id.emptyView);
        listView1 = (ListView)findViewById(R.id.listView);

        if (StudentList == null) StudentList = new ArrayList<Student>();
        studentAdapter = new StudentAdapter(this, StudentList);
        listView1 = (ListView) findViewById(R.id.listView);
        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormStudent.class);
                startActivity(intent);
            }
        });


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student StudentListItem = StudentList.get(position);
                Intent i = new Intent(StudentActivity.this, FormEdit.class);
                i.putExtra("StudentListItem", StudentListItem);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView empty_view = (TextView) findViewById(R.id.emptyView);
        if(StudentList.size() == 0) {
            studentAdapter = new StudentAdapter(this, new ArrayList<Student>());
            listView1.setEmptyView(empty_view);
            empty_view.setText("Data Not Found");
        } else {
            studentAdapter = new StudentAdapter(this, StudentList);
            empty_view.setText("");
        }
        listView1.setAdapter(studentAdapter);
    }


    private void ClearList() {
        StudentList.clear();
        studentAdapter = new StudentAdapter(this, StudentList);
        listView1.setAdapter(studentAdapter);

    }


    private void populateUsersList() {
        StudentList.add(new Student(StudentList.size()+1,"314513194","Mikael Yurubeli","0812323211","mikz@gmail.com"));
        StudentList.add(new Student(StudentList.size()+1,"3135136221","Agustinus Purimbaga","0876636311","agus@gmail.com"));
        StudentList.add(new Student(StudentList.size()+1,"3135136218","Gregorius Andito","0857641313","dito@gmail.com"));
        studentAdapter = new StudentAdapter(this, StudentList);
        listView1.setAdapter(studentAdapter);
    }



}