package com.example.themesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        int themeId = preferences.getInt("theme", R.style.Light_Theme_MyProject);
        setTheme(themeId);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int themeId;
        if (item.getItemId() == R.id.theme_light) {
            themeId = R.style.Light_Theme_MyProject;
        } else if (item.getItemId() == R.id.theme_dark) {
            themeId = R.style.Dark_Theme_MyProject;
        } else if (item.getItemId() == R.id.theme_blue) {
            themeId = R.style.Blue_Theme_MyProject;
        } else {
            return super.onOptionsItemSelected(item);
        }

        SharedPreferences preferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("theme", themeId);
        editor.apply();

        recreate();
        return true;
    }
}
