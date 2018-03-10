package com.wuriyanto.tutorial11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerLanguage;
    private ArrayAdapter<String> languageAdapter;

    private String[] languages = {"Java", "Golang", "Javascript", "C", "C++", "PHP", "Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLanguage = (Spinner) findViewById(R.id.spinner_language);

        loadLanguageDatas();

        spinnerLanguage.setAdapter(languageAdapter);

        spinnerLanguage.setOnItemSelectedListener(new SpinnerSelected());
    }

    private void loadLanguageDatas() {
        languageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    //class for handle event selected item
    private class SpinnerSelected implements AdapterView.OnItemSelectedListener{

        private TextView textViewLanguage = (TextView) findViewById(R.id.tv_language);

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            String language = languageAdapter.getItem(position);
            textViewLanguage.setText(language);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
