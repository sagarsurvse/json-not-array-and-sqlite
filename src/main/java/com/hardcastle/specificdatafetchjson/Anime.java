package com.hardcastle.specificdatafetchjson;

/**
 * Created by Aws on 11/03/2018.
 */

public class Anime {

    private String name ;
    private String Description;
    private String Studio;

    public Anime() {
    }

    public Anime(String name, String description) {
        this.name = name;
        Description = description;

    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }




    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

}
