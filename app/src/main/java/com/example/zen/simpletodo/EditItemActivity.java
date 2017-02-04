package com.example.zen.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String input = getIntent().getStringExtra("input");
        Integer position = getIntent().getIntExtra("position",0);

        EditText etItem = (EditText) findViewById(R.id.etItem);
        etItem.setText(input);
        etItem.setSelection(etItem.getText().length());


    }

    public void onEditItem(View v) {
        EditText etItem = (EditText) findViewById(R.id.etItem);
        String itemText = etItem.getText().toString();
        Integer position = getIntent().getIntExtra("position",0);
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("output", itemText);
        data.putExtra("position", position);
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }


}


//    public void onAddItem(View v) {
//        EditText etNewItem = (EditText) findViewById(etNewItem);
//        String itemText = etNewItem.getText().toString();
//        itemsAdapter.add(itemText);
//        etNewItem.setText("");
//        writeItems();
//    }