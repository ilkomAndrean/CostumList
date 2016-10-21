package com.example.andre.costumlist;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class FormEdit extends AppCompatActivity {

    private EditText idText;
    private EditText nameText;
    private EditText noregText;
    private EditText phoneText;
    private EditText mailText;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit);

        idText = (EditText) findViewById(R.id.editNo);
        nameText = (EditText) findViewById(R.id.editNama);
        noregText = (EditText) findViewById(R.id.editNoreg);
        phoneText = (EditText) findViewById(R.id.editPhone);
        mailText = (EditText) findViewById(R.id.editMail);

        //get parcel
        Student object = getIntent().getParcelableExtra("StudentList");
        //implements parcel
        idText.setText("" + object.getId());
        nameText.setText(object.getName());
        noregText.setText(object.getNoreg());
        phoneText.setText(object.getPhone());
        mailText.setText(object.getMail());

        FloatingActionButton save = (FloatingActionButton) findViewById(R.id.tambah);
        FloatingActionButton batal = (FloatingActionButton) findViewById(R.id.batal);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEditedData();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    protected void saveEditedData(){
        int id = Integer.parseInt(idText.getText().toString());
        String noreg = noregText.getText().toString();
        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        String mail = mailText.getText().toString();
        student = new Student(id, noreg, name, mail, phone);
        SStudent sStudent = SStudent.getInstance();
        sStudent.set(id, student);
        Toast success = Toast.makeText(getApplicationContext(), "Data Berhasil Diedit", Toast.LENGTH_SHORT);
        success.show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.deleteItem:
                Student object = getIntent().getParcelableExtra("StudentList");
                int id = object.getId();
                SStudent data = SStudent.getInstance();
                data.remove(id);
                finish();
                return true;
        }
        return false;
    }
}
