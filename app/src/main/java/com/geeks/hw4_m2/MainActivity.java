package com.geeks.hw4_m2;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button button ;
    private EditText editText ;
    private EditText editTextPasword ;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
         button = findViewById(R.id.button);
         editText = findViewById(R.id.edit_text_mail_id);
         editTextPasword = findViewById(R.id.pasword_text);
         textView = findViewById(R.id.text_view);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence inscription, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence inscription, int start, int before, int count) {
                appAdmin();
                if (inscription.length() > 0) {
                    button.setBackgroundColor(Color.parseColor("#B76D00"));
                    button.setEnabled(true);
                } else {
                    button.setBackgroundColor(Color.parseColor("#828282"));
                    button.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable inscription) {

            }


        });

        editTextPasword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence password, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence password, int start, int before, int count) {
               appAdmin();
                if (password.length() > 0) {
                    button.setBackgroundColor(Color.parseColor("#B76D00"));
                    button.setEnabled(true);
                } else {
                    button.setBackgroundColor(Color.parseColor("#828282"));
                    button.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable password) {

            }


        });

    }
    private void appAdmin() {
        String edt1 = editText.getText().toString();
        String edt2 = editTextPasword.getText().toString();
    findViewById(R.id.button).setOnClickListener(v -> {
        if (edt1.equals("admin") && edt2.equals("admin")) {
            editText.setVisibility(View.GONE);
            editTextPasword.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            Snackbar.make(v,"Вы успешно зарегистрировались!", Snackbar.LENGTH_SHORT).show();
        }else {
            Snackbar.make(v,"Произошла ошибка", Snackbar.LENGTH_SHORT).show();
        }
    });

    }
}