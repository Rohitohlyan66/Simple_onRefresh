package com.example.onrefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout refresh;
    TextView textView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh = findViewById(R.id.swipe_refresh);
        textView = findViewById(R.id.text);


        //------------OnRefreshing--------------->
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                //------------Increasing value of count every time you swipe it----------->
                count++;

                //------Adding count value to TextView--------------->
                textView.setText(String.valueOf(count));

                //---------Also showing a Toast----------->
                Toast.makeText(MainActivity.this, "Layout is Refreshed", Toast.LENGTH_SHORT).show();


                //----------When Task is done stop the refresh logo----------->
                refresh.setRefreshing(false);

            }
        });
    }
}