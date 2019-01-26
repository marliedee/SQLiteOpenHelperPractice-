package org.pursuit.sqlitehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.pursuit.sqlitehelper.model.Cat;
import org.pursuit.sqlitehelper.model.CatDataBaseHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText legs;
    private EditText color;
    private EditText tail;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        legs = findViewById(R.id.textView);
        color = findViewById(R.id.textView2);
        tail = findViewById(R.id.textView3);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                legs.getText().toString();
                color.getText().toString();
                tail.getText().toString();

                CatDataBaseHelper cats = new CatDataBaseHelper(getApplicationContext(),CatDataBaseHelper.DATABASE_NAME, null,1);
                List<Cat> newCats = cats.getCatList();

                for(Cat c : newCats) {
                    Log.d("Cats ", c.getLegs() + " " + c.getColor() + " - " + c.isTail());
                }

            }
        });
    }

}
