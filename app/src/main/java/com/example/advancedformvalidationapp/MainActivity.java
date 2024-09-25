package com.example.advancedformvalidationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText imie;
    private EditText nazwisko;
    private EditText email;
    private EditText numerTelefonu;
    private EditText haslo;
    private EditText powtHasla;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        imie = findViewById(R.id.editTextImie);
        nazwisko = findViewById(R.id.editTextNazwisko);
        email = findViewById(R.id.editTextEmail);
        numerTelefonu = findViewById(R.id.editTextPhone);
        haslo = findViewById(R.id.editTextHaslo);
        powtHasla = findViewById(R.id.editTextPotwierdzenieHasla);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String imieTrim = imie.getText().toString().trim();
                String nazwiskoTrim = nazwisko.getText().toString().trim();
                String emailTrim = email.getText().toString().trim();
                String numerTrim = numerTelefonu.getText().toString().trim();
                String hasloTrim = haslo.getText().toString().trim();
                String powtHasloTrim = powtHasla.getText().toString().trim();

                if(imieTrim.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();
                }else if(nazwiskoTrim.isEmpty()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailTrim).matches()){
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić poprawny E-mail", Toast.LENGTH_SHORT).show();
                }else if(numerTrim.length() != 9){
                    Toast.makeText(MainActivity.this, "Numer telefonu musi miec 9 liczb", Toast.LENGTH_SHORT).show();
                }else if(hasloTrim.length() < 6){
                    Toast.makeText(MainActivity.this, "Hasło msui miec przynajniej 6 znaków", Toast.LENGTH_SHORT).show();
                }else if(!hasloTrim.equals(powtHasloTrim)){
                    Toast.makeText(MainActivity.this, "Hasła się nie zgadzają", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Gratulacje, stworzyłeś konto", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}