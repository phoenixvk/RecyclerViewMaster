package android.hashstar.com.recyclerviewmaster;

import java.io.Serializable;

/**
 * Created by vaibhav on 31/7/17 .
 */

public class Stark implements

        //Serilizable interface to transfer data effectively using intents
        Serializable{




    String name, description;
    int photo;

    Stark()
    {
        //We may need this constructor or may not
    }

    Stark(String name,String description,int photo)
    {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    //Name of Stark
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Photo of stark
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    //description of stark
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
