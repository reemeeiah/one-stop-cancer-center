package com.onestopcancercenter.onestopcancercenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView IV = (ImageView) findViewById(R.id.imageView3);
        final Intent intent= new Intent(this, user_type_page.class);
        IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);

            }
        });

    }
}
