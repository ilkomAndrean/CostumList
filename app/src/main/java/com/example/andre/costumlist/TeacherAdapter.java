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

public class TeacherAdapter extends ArrayAdapter<Teacher> {

    public TeacherAdapter(Context context, ArrayList<Teacher> teacherlist) {
        super(context, 0, teacherlist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Teacher teacherlist = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_teacher_adapter, parent, false);
        }
        TextView tvNo = (TextView) convertView.findViewById(R.id.id);
        TextView tvNip = (TextView) convertView.findViewById(R.id.nip);
        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvMail = (TextView) convertView.findViewById(R.id.mail);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.phone);
        tvNo.setText(teacherlist.getId() + "");
        tvNip.setText(teacherlist.getNip());
        tvName.setText(teacherlist.getNama());
        tvMail.setText(teacherlist.getMail());
        tvPhone.setText(teacherlist.getPhone());
        return convertView;
    }
}