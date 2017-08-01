package android.hashstar.com.recyclerviewmaster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vaibhav on 31/7/17 .
 */

public class StarksAdapter extends RecyclerView.Adapter<StarksAdapter.MyCustomViewHolder> {

    private List<Stark> winterfell;
    private Activity context;

    class MyCustomViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView photo;

        MyCustomViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            photo = (ImageView) view.findViewById(R.id.photo);
        }
    }


    StarksAdapter(List<Stark> moviesList, Activity context) {
        this.context =context;
        this.winterfell = moviesList;
    }

    @Override
    public MyCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        return new MyCustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyCustomViewHolder holder, int position) {
        final Stark stark = winterfell.get(position);
        holder.name.setText(stark.getName());

        //TODO It will thow runtime exception if description in less than 15 letters handle this carefully
        holder.description.setText(stark.getDescription().substring(0,14)+"...........");

        holder.photo.setImageResource(stark.getPhoto());

        //Clicking on photo
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("serelizedItem",stark);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return winterfell.size();
    }
}
