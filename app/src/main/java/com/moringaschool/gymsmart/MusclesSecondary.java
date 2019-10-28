
package com.moringaschool.gymsmart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MusclesSecondary {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_front")
    @Expose
    private Boolean isFront;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MusclesSecondary() {
    }

    /**
     * 
     * @param isFront
     * @param name
     * @param id
     */
    public MusclesSecondary(Integer id, String name, Boolean isFront) {
        super();
        this.id = id;
        this.name = name;
        this.isFront = isFront;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsFront() {
        return isFront;
    }

    public void setIsFront(Boolean isFront) {
        this.isFront = isFront;
    }

}
