package ynov.architecturemicroservice.garagevoitureapi.models;

public class Voiture {

    private Integer id;

    private Integer garageId;

    private String year;

    private String model;

    public Voiture(Integer id, Integer garageId, String year, String model) {
        this.id = id;
        this.garageId = garageId;
        this.year = year;
        this.model = model;
    }

    public Voiture() {
    }

    public Integer getGarageId() {
        return garageId;
    }

    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
