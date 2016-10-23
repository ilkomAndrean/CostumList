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

import com.example.andre.costumlist.Teacher;
import com.example.andre.costumlist.TeacherAdapter;


public class TeacherActivity extends AppCompatActivity  implements Serializable{
    private TextView emptyView;
    ListView listView1;
    static ArrayList<Teacher> TeacherList;
    TeacherAdapter TeacherAdapter;

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
        setContentView(R.layout.activity_teacher);
        emptyView = (TextView)findViewById(R.id.emptyView);
        listView1 = (ListView)findViewById(R.id.listView);

        if (TeacherList == null) TeacherList = new ArrayList<Teacher>();
        TeacherAdapter = new TeacherAdapter(this, TeacherList);
        listView1 = (ListView) findViewById(R.id.listView);
        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormTeacher.class);
                startActivity(intent);
            }
        });


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Teacher TeacherListItem = TeacherList.get(position);
                Intent i = new Intent(TeacherActivity.this, FormEdit.class);
                i.putExtra("TeacherListItem", TeacherListItem);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView empty_view = (TextView) findViewById(R.id.emptyView);
        if(TeacherList.size() == 0) {
            TeacherAdapter = new TeacherAdapter(this, new ArrayList<Teacher>());
            listView1.setEmptyView(empty_view);
            empty_view.setText("Data Not Found");
        } else {
            TeacherAdapter = new TeacherAdapter(this, TeacherList);
            empty_view.setText("");
        }
        listView1.setAdapter(TeacherAdapter);
    }


    private void ClearList() {
        TeacherList.clear();
        TeacherAdapter = new TeacherAdapter(this, TeacherList);
        listView1.setAdapter(TeacherAdapter);

    }


    private void populateUsersList() {
        TeacherList.add(new Teacher(TeacherList.size()+1,"413414124","Dian Rakasiwi","0812323211","dian@gmail.com"));
        TeacherList.add(new Teacher(TeacherList.size()+1,"252525455","M Fakhri Ali Ibrahim","086647247","fakhri@gmail.com"));
        TeacherList.add(new Teacher(TeacherList.size()+1,"341341344","Rahmi Putri","08952525245","putri@gmail.com"));
        TeacherAdapter = new TeacherAdapter(this, TeacherList);
        listView1.setAdapter(TeacherAdapter);
    }



}