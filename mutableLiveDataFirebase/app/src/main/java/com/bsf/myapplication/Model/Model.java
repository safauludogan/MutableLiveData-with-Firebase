package com.bsf.myapplication.Model;

public class Model {

    private String foodName;
    private String foodCalori;
    private String foodProtein;
    private String foodFat;
    private String foodKardonhidrat;
    private String foodDescription;


    public Model(String foodName, String foodCalori, String foodProtein, String foodFat, String foodKardonhidrat, String foodDescription) {
        this.foodName = foodName;
        this.foodCalori = foodCalori;
        this.foodProtein = foodProtein;
        this.foodFat = foodFat;
        this.foodKardonhidrat = foodKardonhidrat;
        this.foodDescription = foodDescription;
    }

    public Model() {
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCalori() {
        return foodCalori;
    }

    public void setFoodCalori(String foodCalori) {
        this.foodCalori = foodCalori;
    }

    public String getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(String foodProtein) {
        this.foodProtein = foodProtein;
    }

    public String getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(String foodFat) {
        this.foodFat = foodFat;
    }

    public String getFoodKardonhidrat() {
        return foodKardonhidrat;
    }

    public void setFoodKardonhidrat(String foodKardonhidrat) {
        this.foodKardonhidrat = foodKardonhidrat;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }
}
