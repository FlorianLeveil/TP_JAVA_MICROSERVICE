package ynov.architecturemicroservice.garagevoiturecomposite.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ynov.architecturemicroservice.garagevoiturecomposite.models.Voiture;

@Component
public class VoitureClient {

    private static final String BASE_URL = "http://localhost:8082/voitures";

    private final RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(VoitureClient.class);

    public VoitureClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Voiture[] getAllVoiture(){
        logger.info(String.format("Fetching all voitures from url : %s", BASE_URL));
        try {
            final Voiture[] response;
            response = restTemplate.getForObject(BASE_URL,
                    Voiture[].class);
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Voiture getOneVoiture(Integer voitureId) {
        logger.info(String.format("Fetching voiture with id %d", voitureId));
        String targetUrl = BASE_URL + "/" + voitureId;
        try {
            return restTemplate.getForObject(targetUrl, Voiture.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Voiture[] getAllVoituresForGarage(Integer garageId){
        String targetUrl = BASE_URL + "?garageId=" + garageId.toString();
        logger.info(String.format("Fetching all voitures from garage %d from url : %s", garageId, targetUrl));
        try {
            return restTemplate.getForObject(targetUrl, Voiture[].class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
