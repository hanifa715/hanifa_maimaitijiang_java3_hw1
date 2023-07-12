package com.example.hanifa_maimaitijiang_java3_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText subject;
    private EditText message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et1);
        subject = findViewById(R.id.et2);
        message = findViewById(R.id.et3);
        button = findViewById(R.id.button_one);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty()
                        && !message.getText().toString().isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, new String[]{subject.getText().toString()});
                    intent.putExtra(Intent.EXTRA_TEXT, new String[]{message.getText().toString()});
                    intent.setType("message/rfc822");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {Toast.makeText(MainActivity.this,"There is no application that support this action",
                            Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this,"Please fill all the fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}