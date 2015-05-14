package com.android.ramish.todoapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Ramish on 4/23/2015.
 */
public class Task implements Serializable {
    private UUID mId;
    private String mTaskName;
    private boolean mTaskDone=false;
    public static ArrayList<Task> mTodoList;
    public static ArrayList<Task> mCompletedList;

    public boolean isTaskDone() {
        return mTaskDone;
    }

    public void setTaskDone(boolean mTaskDone) {
        this.mTaskDone = mTaskDone;
    }

    public Task(){
        mId=UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTaskName() {
        return mTaskName;
    }

    public void setTaskName(String mTaskName) {
        this.mTaskName = mTaskName;
    }


}
