package ynov.architecturemicroservice.garagevoitureapi.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

@Component
public class GarageClient {

    private static final String BASE_URL = "http://localhost:8081/garages/";

    private final RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(GarageClient.class);

    public GarageClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Garage[] getAllGarages() {
        logger.info(String.format("Fetching all garages from url : %s", BASE_URL));
        try {
            return restTemplate.getForObject(BASE_URL, Garage[].class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    public Garage addNewGarage(Garage newGarage){
        logger.info(String.format("Add new garage from url : %s", BASE_URL));
        try {
            return restTemplate.postForObject(BASE_URL, newGarage,
                    Garage.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    public Garage updateGarage (Integer id, Garage updateGarage){
        logger.info(String.format("Update garage with id %d from url : %s", id,BASE_URL + "/" + id));
        try {
            restTemplate.put(BASE_URL + id, updateGarage,
                    Garage.class);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Garage deleteGarageById(Integer id){
        logger.info(String.format("Delete garage with id %d from url : %s",id,BASE_URL));
        try {
            restTemplate.delete(BASE_URL + id);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Garage getOneGarage(Integer id){
        logger.info(String.format("Fetching garage wth id %d from url : %s",id,BASE_URL + "/" + id));
        try {
            return restTemplate.getForObject(BASE_URL + id,
                    Garage.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
