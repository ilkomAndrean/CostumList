package com.example.andre.costumlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

        public StudentAdapter(Context context, ArrayList<Student> studentList) {
            super(context, 0, studentList);
        }



    @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Student studentList = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_student_adapter, parent, false);
            }
            TextView tvNo = (TextView) convertView.findViewById(R.id.id);
            TextView tvNoreg = (TextView) convertView.findViewById(R.id.noreg);
            TextView tvName = (TextView) convertView.findViewById(R.id.name);
            TextView tvMail = (TextView) convertView.findViewById(R.id.mail);
            TextView tvPhone = (TextView) convertView.findViewById(R.id.phone);
            tvNo.setText(studentList.getId() + "");
            tvNoreg.setText(studentList.getNoreg());
            tvName.setText(studentList.getNama());
            tvMail.setText(studentList.getMail());
            tvPhone.setText(studentList.getPhone());
            return convertView;
        }
    }