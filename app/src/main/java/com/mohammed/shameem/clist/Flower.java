package com.mohammed.shameem.clist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shameem on 6/5/2016.
 */

public class Flower implements Serializable {

    /**
     * category : Shrubs
     * price : 15.99
     * instructions : Large double. Good grower, heavy bloomer. Early to mid-season, acid loving plants. Plant in moist well drained soil with pH of 4.0-5.5.
     * photo : california_snow.jpg
     * name : Azalea
     * productId : 1
     */
    @SerializedName("category")
    private String category;
    @SerializedName("price")
    private double price;
    @SerializedName("instructions")
    private String instructions;
    @SerializedName("photo")
    private String photo;
    @SerializedName("name")
    private String name;
    @SerializedName("productId")
    private int productId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

