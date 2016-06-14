package com.example.jennytlee.ontask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Intent i = getIntent();
        EditText editedText = (EditText) findViewById(R.id.editText);
        editedText.setText(i.getStringExtra("oldText"));

        int position = editedText.length();
        Editable etext = editedText.getText();
        Selection.setSelection(etext, position);
    }

    public void onSubmit(View v) {
        Intent i = getIntent();
        int pos = i.getExtras().getInt("pos");

        EditText editedText = (EditText) findViewById(R.id.editText);

        Intent data = new Intent();

        data.putExtra("editedText", editedText.getText().toString());
        data.putExtra("pos", pos);

        setResult(RESULT_OK, data);
        editedText.setText("");
        finish();
    }

}
