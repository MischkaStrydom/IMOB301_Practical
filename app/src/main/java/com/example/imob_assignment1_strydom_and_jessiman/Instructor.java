package com.example.imob_assignment1_strydom_and_jessiman;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.DatePicker;

import android.content.ClipData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Instructor extends AppCompatActivity {
    Boolean completed = Boolean.FALSE;
    private DatabaseHelper myDb;
    final Calendar myCalendar = Calendar.getInstance();

//    ArrayList<String> TaskNames=new ArrayList<String>();
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);


        EditText taskName = (EditText)findViewById(R.id.taskName);
        EditText taskDue = (EditText) findViewById(R.id.taskDueDate);
        EditText taskMod = (EditText) findViewById(R.id.taskMod);

//        final Spinner tasks = (Spinner)findViewById(R.id.spTask);
//
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,TaskNames);



//        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int day) {
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH,month);
//                myCalendar.set(Calendar.DAY_OF_MONTH,day);
//
//                String myFormat="MM/dd/yy";
//                SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
//                taskDue.setText(dateFormat.format(myCalendar.getTime()));
//            }
//        };
//
//
//        taskDue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DatePickerDialog(
//                        Instructor.this, date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)
//                ).show();
//            }
//        });

        Button btn = (Button) findViewById(R.id.createTaskBtn);
        myDb = new DatabaseHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = taskName.getText().toString();
                String due = taskDue.getText().toString();
                String mod = taskMod.getText().toString();
                int modID = 1;



                boolean isTaskInserted = myDb.insertTaskData(name, due, mod, completed, modID);
                if(isTaskInserted){
                    Toast.makeText(getBaseContext(), "Task added", Toast.LENGTH_LONG).show();
                    taskName.setText("");
                    taskDue.setText("");
                    taskMod.setText("");

                }
                else{
                    Toast.makeText(getBaseContext(), "Task not added", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}