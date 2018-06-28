package com.example.tyagi.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        button=(Button)findViewById(R.id.bt1);
        textView=(TextView)findViewById(R.id.tv5);
        String name;
        final SharedPreferences sharedPrefrences = getSharedPreferences(name="EXPENSES", MODE_PRIVATE);
        String key;
        int defValue;
        textView.setText(String.valueOf(sharedPrefrences.getInt(key="EXP", defValue= 0)));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int expense= Integer.valueOf(et1.getText().toString())+Integer.valueOf(et2.getText().toString())+Integer.valueOf(et3.getText().toString())+Integer.valueOf(et4.getText().toString());
                Toast.makeText(MainActivity.this,String.valueOf(expense), Toast.LENGTH_LONG).show();
                SharedPreferences.Editor edit= sharedPrefrences.edit();
                edit.putInt("EXP",expense);
                edit.apply();
                edit.clear();
                textView.setText("your pre exp was" + String.valueOf(expense)) ;
            }
        });
    }
}

