package com.example.threadsiw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button task1, task2;

    private static final String TAG=MainActivity.class.getName();


//    //create a task
//    private Runnable task = new Runnable() {
//        @Override
//        public void run() {
//            Log.d("Mausam - Thread Task", Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    };


    // every looper will have a message queue asoicated with it
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task1=findViewById(R.id.btnOne);
        task2=findViewById(R.id.btnTwo);

        WorkerThread workerThread=new WorkerThread();
        workerThread.start();

        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             workerThread.addTaskToMessageQueue(taskOne);
            }
        });


        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
            }
        });
//        Log.d("Mausam", Thread.currentThread().getName());
//
//        Thread thread = new Thread(task); // thread object
//        thread.start(); // thread starts here run() -- write logic in run ()
//
//        Log.d("Mausam", Thread.currentThread().getName());
    }


    private Runnable taskOne=new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task One"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo=new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task Two"+Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


}




/*

------------------------------ main

------------------------------ thread

// no relation between main and thread
 */