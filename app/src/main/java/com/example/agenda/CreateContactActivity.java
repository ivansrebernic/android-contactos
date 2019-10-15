package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class CreateContactActivity extends AppCompatActivity {

    EditText name;
    EditText surname;
    EditText phoneNumber;
    EditText birthday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        
        name = (EditText)findViewById(R.id.etName);
        surname = (EditText)findViewById(R.id.etSurname);
        phoneNumber = (EditText) findViewById(R.id.etPhonenumber);
        birthday = (EditText) findViewById(R.id.etBirthday);
        birthday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.etBirthday:
                        showDatePickerDialog();
                        break;
                }
            }
        });



    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                birthday.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    //Agregar contacto a la base de datos
    public void addContact(View v) {

        Intent intent = new Intent(this, MainActivity.class);
        Contact c = new Contact(name.getText().toString(),surname.getText().toString(),phoneNumber.getText().toString(), birthday.getText().toString());


        intent.putExtra("newContact", c);

        startActivity(intent);

    }
}
