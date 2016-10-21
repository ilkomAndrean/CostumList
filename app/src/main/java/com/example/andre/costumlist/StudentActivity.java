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

import java.util.ArrayList;

import com.example.andre.costumlist.Student;
import com.example.andre.costumlist.StudentAdapter;


public class StudentActivity extends AppCompatActivity {
    private ListView listView;
    private TextView emptyView;
    private FloatingActionButton tambah;
    private StudentAdapter studentAdapter;
    private static ArrayList<Student> studentList;
    private SStudent sStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        listView = (ListView)findViewById(R.id.listView);
        emptyView = (TextView)findViewById(R.id.emptyView);
        listView.setEmptyView(emptyView);
        sStudent = SStudent.getInstance();
        FloatingActionButton tambah = (FloatingActionButton)findViewById(R.id.add);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormStudent.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), FormEdit.class);
                Student student = sStudent.get(position);
                intent.putExtra("StudentList", student);
                startActivity(intent);
            }
        });
    }

    private void populateUsersList() {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "3135136188", "TRI FEBRIANA SIAMI", "tri.febriana@unj.ac.id", "021577888"));
        studentList.add(new Student(2, "3135136192", "UMMU KULTSUM", "ummu.kultsum@unj.ac.id", "021577888"));
        studentList.add(new Student(3, "3135136215", "ANDREAN OKTAVIANUS H.S.", "andrean.ohs@unj.ac.id", "021577888"));
//        staticStudent.setStudentList(studentList);
//        customUsersAdapter = new CustomUsersAdapter(this,staticStudent.getStudentList());
        sStudent.AddStudents(studentList);
        studentAdapter = new StudentAdapter(this,sStudent.getList());
        listView.setAdapter(studentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_student, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_dummy:
                populateUsersList();
                return true;
            case R.id.clear_list:
                SStudent.getInstance().clearList();
                studentAdapter = new StudentAdapter(this, new ArrayList<Student>());
                listView.setAdapter(studentAdapter);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onResume() {
        //overriding method to handle list
        super.onResume();
        if(sStudent.count()==0) {
            studentAdapter = new StudentAdapter(this, new ArrayList<Student>());
            emptyView.setText("Data Not Found");
        } else{
            studentAdapter = new StudentAdapter(this, sStudent.getList());
        }
        listView.setAdapter(studentAdapter);
    }
}
