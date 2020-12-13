package ynov.architecturemicroservice.garagevoiturecomposite.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ynov.architecturemicroservice.garagevoiturecomposite.models.Garage;

@Component
public class GarageClient {

    private static final String BASE_URL = "http://localhost:8081/garages";

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

    public Garage getOneGarage(Integer id){
        logger.info(String.format("Fetching all voitures from url : %s", BASE_URL));
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id,
                    Garage.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
