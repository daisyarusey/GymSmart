
package com.moringaschool.gymsmart;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("muscles")
    @Expose
    private List<Muscle> muscles = null;
    @SerializedName("muscles_secondary")
    @Expose
    private List<MusclesSecondary> musclesSecondary = null;
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param musclesSecondary
     * @param muscles
     * @param name
     * @param description
     * @param equipment
     * @param category
     */
    public Result(String name, Category category, String description, List<Muscle> muscles, List<MusclesSecondary> musclesSecondary, List<Equipment> equipment) {
        super();
        this.name = name;
        this.category = category;
        this.description = description;
        this.muscles = muscles;
        this.musclesSecondary = musclesSecondary;
        this.equipment = equipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }

    public List<MusclesSecondary> getMusclesSecondary() {
        return musclesSecondary;
    }

    public void setMusclesSecondary(List<MusclesSecondary> musclesSecondary) {
        this.musclesSecondary = musclesSecondary;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

}
