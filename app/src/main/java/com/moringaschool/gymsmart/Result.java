
package com.moringaschool.gymsmart; ;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("license_author")
    @Expose
    private String licenseAuthor;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_original")
    @Expose
    private String nameOriginal;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("license")
    @Expose
    private Integer license;
    @SerializedName("category")
    @Expose
    private Integer category;
    @SerializedName("language")
    @Expose
    private Integer language;
    @SerializedName("muscles")
    @Expose
    private List<Integer> muscles = null;
    @SerializedName("muscles_secondary")
    @Expose
    private List<Integer> musclesSecondary = null;
    @SerializedName("equipment")
    @Expose
    private List<Integer> equipment = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param musclesSecondary
     * @param licenseAuthor
     * @param description
     * @param equipment
     * @param language
     * @param creationDate
     * @param uuid
     * @param license
     * @param nameOriginal
     * @param muscles
     * @param name
     * @param id
     * @param category
     * @param status
     */
    public Result(Integer id, String licenseAuthor, String status, String description, String name, String nameOriginal, String creationDate, String uuid, Integer license, Integer category, Integer language, List<Integer> muscles, List<Integer> musclesSecondary, List<Integer> equipment) {
        super();
        this.id = id;
        this.licenseAuthor = licenseAuthor;
        this.status = status;
        this.description = description;
        this.name = name;
        this.nameOriginal = nameOriginal;
        this.creationDate = creationDate;
        this.uuid = uuid;
        this.license = license;
        this.category = category;
        this.language = language;
        this.muscles = muscles;
        this.musclesSecondary = musclesSecondary;
        this.equipment = equipment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseAuthor() {
        return licenseAuthor;
    }

    public void setLicenseAuthor(String licenseAuthor) {
        this.licenseAuthor = licenseAuthor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public List<Integer> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Integer> muscles) {
        this.muscles = muscles;
    }

    public List<Integer> getMusclesSecondary() {
        return musclesSecondary;
    }

    public void setMusclesSecondary(List<Integer> musclesSecondary) {
        this.musclesSecondary = musclesSecondary;
    }

    public List<Integer> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Integer> equipment) {
        this.equipment = equipment;
    }

}
