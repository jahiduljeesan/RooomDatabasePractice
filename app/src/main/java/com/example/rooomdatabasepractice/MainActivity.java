package com.example.rooomdatabasepractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rooomdatabasepractice.RoomDataBase.UserDatabase;
import com.example.rooomdatabasepractice.RoomDataBase.UserEntity;
import com.example.rooomdatabasepractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding actMain;
    String firstName, lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actMain = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(actMain.getRoot());


        actMain.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                firstName = actMain.etFirstName.getText().toString();
                lastName = actMain.etLastName.getText().toString();
                if (firstName.isEmpty() || lastName.isEmpty()) return;

                UserDatabase.getUserDatabase(MainActivity.this)
                        .userDAO()
                        .insertData(new UserEntity(0,firstName,lastName));
            }
        });
    }
}