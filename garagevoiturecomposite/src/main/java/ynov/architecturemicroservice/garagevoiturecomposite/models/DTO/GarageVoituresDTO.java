package ynov.architecturemicroservice.garagevoiturecomposite.models.DTO;

import ynov.architecturemicroservice.garagevoiturecomposite.models.Voiture;

public class GarageVoituresDTO {

    private Integer id;

    private String name;

    private String city;

    private Voiture[] voitures;


    public GarageVoituresDTO(Integer id, String name, String city, Voiture[] voitures) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.voitures = voitures;
    }

    public GarageVoituresDTO() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Voiture[] getVoitures() {
        return voitures;
    }

    public void setVoitures(Voiture[] voitures) {
        this.voitures = voitures;
    }
}
