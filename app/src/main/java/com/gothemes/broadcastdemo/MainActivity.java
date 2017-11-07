package com.gothemes.broadcastdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStatic;
    private  Button btnDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * find the is of all resources.
        * */
        btnDynamic=(Button) findViewById(R.id.btn_dynamic_broad_casr);
        btnStatic=(Button)findViewById(R.id.btn_static_broad_cast);






        /*
        * Listener on static button
        * */
        btnStatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);


            }
        });


        /*
        * Listener on dynamic button
        * */
        btnDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);


            }
        });




    }
}
