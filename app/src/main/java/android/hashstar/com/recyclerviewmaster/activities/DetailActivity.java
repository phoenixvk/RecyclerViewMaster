package android.hashstar.com.recyclerviewmaster.activities;

import android.content.Intent;
import android.hashstar.com.recyclerviewmaster.R;
import android.hashstar.com.recyclerviewmaster.datamodel.Stark;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        ImageView imageView = (ImageView)findViewById(R.id.photo);
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);

        if(intent!=null)
        {
            if(intent.hasExtra("serelizedItem"))
            {
                Stark stark = (Stark) intent.getSerializableExtra("serelizedItem");
                imageView.setImageResource(stark.getPhoto());
                name.setText(stark.getName());
                description.setText(stark.getDescription());

            }
        }
    }
}
