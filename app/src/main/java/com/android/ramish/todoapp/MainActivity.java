package com.android.ramish.todoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private Button mTodoTaskButton;
    private Button mCompletedTaskButton;
    private Button mAddTaskButton;
    private EditText mTaskTitle;


    public static ArrayList<Task> mTodoList = new ArrayList<Task>();
    public static ArrayList<Task> mCompletedList = new ArrayList<Task>();;

//    private ArrayList<Task> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mAddTaskButton=(Button)findViewById(R.id.showAddTaskButton);
        mAddTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Task task = new Task();
                mTaskTitle=(EditText)findViewById(R.id.task_name);
                task.setTaskName(mTaskTitle.getText().toString());
                mTaskTitle.setText("");
                mTodoList.add(task);
                Toast.makeText(getApplicationContext(), "Task Added", Toast.LENGTH_SHORT).show();
            }
        });


        mTodoTaskButton=(Button)findViewById(R.id.showTodoTaskButton);
        mTodoTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start TodoActivity
                Intent i=new Intent(MainActivity.this, TodoActivity.class);
                startActivity(i);
            }
        });

        mCompletedTaskButton=(Button)findViewById(R.id.showCompletedTaskButton);
        mCompletedTaskButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View v){
                // Start CompletedActivity
                Intent i=new Intent(MainActivity.this, CompletedActivity.class);
                startActivity(i);
            }
        });

    }

}
