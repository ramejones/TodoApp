package com.android.ramish.todoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TodoActivity extends ActionBarActivity {

    private ListView viewTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        viewTasks=(ListView)findViewById(R.id.taskListView);

        TaskAdapter adapter = new TaskAdapter(MainActivity.mTodoList);
        viewTasks.setAdapter(adapter);

    }

    public class TaskAdapter extends BaseAdapter{

        List<Task> users;

        public TaskAdapter(List<Task> users) {
            this.users = users;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Task taskItem = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) TodoActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item_task, parent, false);
            }

            // Lookup view for data population
            TextView taskTitle = (TextView) convertView.findViewById(R.id.list_item);
//            Populate the data into the template view using the data object
            taskTitle.setText(taskItem.getTaskName());

            CheckBox taskCheck= (CheckBox) convertView.findViewById(R.id.check_task);

            taskCheck.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.i("onCheckedListener: ", " checked");
                    Task a = users.get(position);
                    users.remove(position);
                    notifyDataSetChanged();

                    a.setTaskDone(true);
                    MainActivity.mCompletedList.add(a);
                    Toast.makeText(getApplicationContext(),"Task Done",Toast.LENGTH_SHORT).show();
                }

            });

            Button deleteTask=(Button)convertView.findViewById(R.id.item_delete);

            deleteTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Task task=users.get(position);
                    users.remove(position);
                    notifyDataSetChanged();

                    MainActivity.mTodoList.remove(task);
                    Toast.makeText(getApplicationContext(),"Task Deleted",Toast.LENGTH_SHORT).show();
                }
            });

            // Return the completed view to render on screen
            return convertView;
        }
        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public Task getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }

}

