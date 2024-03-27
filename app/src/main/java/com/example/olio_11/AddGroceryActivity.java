package com.example.olio_11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddGroceryActivity extends AppCompatActivity {
    private EditText editGroceryName, editGroceryNote;
    private Button addGroceryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);
        addGroceryButton = findViewById(R.id.buttonAddGrocery);

        addGroceryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textGroceryName = editGroceryName.getText().toString();
                String textGroceryNote = editGroceryNote.getText().toString();

                Grocery grocery = new Grocery(textGroceryName, textGroceryNote);

                // Lisäämme ostoksen ListGrocery-oliolle
                ListGrocery.getInstance().addGrocery(grocery);

                // Päivitämme RecyclerView-näkymän MainActivityssä
                MainActivity.updateGroceryList();

                // Sulje lisäysnäkymä ja palaa takaisin MainActivityyn
                finish();
            }
        });
    }
}




