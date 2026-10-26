package com.example.taskdonescreen;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        android.view.View root = findViewById(R.id.main);

        int nightMode = getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK;

        boolean isDark =
                nightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES;

        root.setBackgroundColor(
                android.graphics.Color.parseColor(
                        isDark ? "#1E1006" : "#FFF5EC"
                )
        );

        if (root instanceof android.widget.LinearLayout) {
            android.widget.LinearLayout layout =
                    (android.widget.LinearLayout) root;

            for (int i = 0; i < layout.getChildCount(); i++) {
                android.view.View child = layout.getChildAt(i);

                if (child instanceof android.widget.TextView) {
                    ((android.widget.TextView) child).setTextColor(
                            android.graphics.Color.parseColor(
                                    isDark ? "#F4E7E0" : "#21150F"
                            )
                    );
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}