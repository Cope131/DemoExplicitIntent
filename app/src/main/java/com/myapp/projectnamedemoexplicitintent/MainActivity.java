package com.myapp.projectnamedemoexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getSimpleName();

    // Request Codes
    private final int REQUEST_CODE_SUPERMAN = 1;
    private final int REQUEST_CODE_BATMAN = 2;

    // Views
    private TextView supermanTV, batmanTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supermanTV = findViewById(R.id.superman_text_view);
        batmanTv = findViewById(R.id.batman_text_view);

        supermanTV.setOnClickListener(this::onClick);
        batmanTv.setOnClickListener(this::onClick);

    } // <!-- end of main method -->

    // View is clicked
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, HeroStatsActivity.class);
        Hero hero = null;
        int request_code = 0;

        switch (v.getId()) {
            case R.id.superman_text_view:
                hero = new Hero("Superman", 100, 60);
                request_code = REQUEST_CODE_SUPERMAN;
                break;
            case R.id.batman_text_view:
                hero = new Hero("Batman", 60, 90);
                request_code = REQUEST_CODE_BATMAN;
                break;
            default:
        }
        if (hero != null) {
            intent.putExtra("hero", hero);
//            startActivity(intent);
            startActivityForResult(intent, request_code);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult" );
        Log.e(TAG, "onActivityResult: Result Code - " + resultCode + "");
        if (resultCode == RESULT_OK && data != null) {
            String message = "You ";
            String like = data.getStringExtra("like");
            message += like + " ";
            message += requestCode == REQUEST_CODE_SUPERMAN ? "Superman" : "Batman";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}