package com.artsystem.gmailapplocal.searchactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.artsystem.gmailapplocal.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    EditText editSearch;
    ImageView closeImg;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int selectedTheme = getIntent().getIntExtra("themeid",R.style.AppTheme);
        setTheme(selectedTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        // if light theme is selected we change to light status bar
        if (selectedTheme == R.style.AppTheme) {
            setLightStatusBar(getWindow().getDecorView(),this);
        }

        setEditSearchFocus();
        setBackClickListener();
        setupSimpleSearchList();


    }

    private void setupSimpleSearchList() {
        listView = findViewById(R.id.lvSearch);
        listView.setDivider(null);
        List<String> lst = new ArrayList<>();
        lst.add("Google Mail");
        lst.add("Anna Steve");
        lst.add("Microsoft Store ");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_simple_search,R.id.searchtvshow,lst);
        listView.setAdapter(adapter);

    }

    private void setBackClickListener() {
        closeImg = findViewById(R.id.menu_icon);
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
                onBackPressed();
            }
        });
    }

    private void openKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void setLightStatusBar(View view, Activity activity){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.WHITE);
        }

    }

    private void setEditSearchFocus(){

        editSearch = findViewById(R.id.eidtsearch);
    }

}