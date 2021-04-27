package com.myapp.projectnamedemoexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class HeroStatsActivity extends AppCompatActivity implements View.OnClickListener {

    // Views
    TextView nameTV, strengthTV, technicalProwessTV;
    MaterialButton likeBtn, dislikeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        // Get Hero
        Intent intent = getIntent();
        Hero hero = (Hero) intent.getSerializableExtra("hero");

        // Initialize Views
        initViews();

        // Set Description
        nameTV.setText(hero.getName());
        strengthTV.setText(hero.getStrength() + "");
        technicalProwessTV.setText(hero.getTechnicalProwess() + "");


    } // <-- end of main method -->


    private void initViews() {
        nameTV = findViewById(R.id.name_text_view);
        strengthTV = findViewById(R.id.strength_text_view);
        technicalProwessTV = findViewById(R.id.technical_text_view);
        likeBtn = findViewById(R.id.like_button);
        dislikeBtn = findViewById(R.id.dislike_button);
        likeBtn.setOnClickListener(this::onClick);
        dislikeBtn.setOnClickListener(this::onClick);
    }

    // View is clicked
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String state = "like";
        switch (v.getId()) {
            case R.id.like_button:
                break;
            case R.id.dislike_button:
                state = "dislike";
                break;
        }
        intent.putExtra("like", state);
        setResult(RESULT_OK, intent);
        finish();
    }

    

}