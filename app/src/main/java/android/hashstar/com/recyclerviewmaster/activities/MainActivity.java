package android.hashstar.com.recyclerviewmaster.activities;

import android.hashstar.com.recyclerviewmaster.utilities.DividerItemDecoration;
import android.hashstar.com.recyclerviewmaster.R;
import android.hashstar.com.recyclerviewmaster.datamodel.Stark;
import android.hashstar.com.recyclerviewmaster.adapter.StarksAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Stark>  winterfell = new ArrayList<>();
    StarksAdapter starksAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call method to init recyclerview
        initAssignRecyclerView();

        //Add data to dataset
        addDataToDataset();

    }
    private void initAssignRecyclerView() {
        //Initilize RecyclerView
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        /*
        * RecyclerView size changes every time you add something no matter what.
        * What setHasFixedSize does is that it makes sure (by user input) that this change of size of RecyclerView is constant.
         * The height (or width) of the item won't change. Every item added or removed will be the same.
         * If you dont set this it will check if the size of the item has changed and thats expensive.*/
        recyclerView.setHasFixedSize(true);

        //LayoutManager For recyclerView
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // https://gist.githubusercontent.com/alexfu/0f464fc3742f134ccd1e/raw/9076d97b0ec05b39602ec088c0b2c03916224c54/DividerItemDecoration.java
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //init Dataset
        starksAdapter = new StarksAdapter(winterfell,MainActivity.this);
        //set dataset
        recyclerView.setAdapter(starksAdapter);
    }

    private void addDataToDataset() {

        //INIT dataset
        String[] nameArray =
                getApplicationContext().getResources().getStringArray(R.array.namearray);
        String[] descArray =
                getApplicationContext().getResources().getStringArray(R.array.descarray);
        int [] imageArray =
                {
                        R.drawable.arya,
                        R.drawable.brandon,
                        R.drawable.catlyn,
                        R.drawable.eddard,
                        R.drawable.lyanna,
                        R.drawable.rickon,
                        R.drawable.robb,
                        R.drawable.sansa,
                };

        // Adding data
        for (int i = 0 ; i < nameArray.length;i++)
        {
            Stark stark = new Stark(nameArray[i],descArray[i],imageArray[i]);
            winterfell.add(stark);//Add stark to winterfell
        }

        //After adding data tell RecyclerViewAdapter to notify change in the dataset
        starksAdapter.notifyDataSetChanged();

    }

}
