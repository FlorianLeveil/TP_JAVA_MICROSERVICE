package ynov.architecturemicroservice.garagevoitureapi.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

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

    public Voiture addNewVoiture(Voiture newVoiture){
        logger.info(String.format("Add new voiture from url : %s", BASE_URL));
        try {
            return restTemplate.postForObject(BASE_URL, newVoiture,
                    Voiture.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    public Voiture updateVoiture (Integer id, Voiture updateVoiture){
        logger.info(String.format("Update one voiture with id %d from url : %s",id, BASE_URL + "/" + id));
        try {
            restTemplate.put(BASE_URL + "/" + id, updateVoiture,
                    Voiture.class);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Voiture deleteVoitureById(Integer id){
        logger.info(String.format("Delete voiture with %d from url : %s",id,BASE_URL + "/" + id));
        try {
            restTemplate.delete(BASE_URL + "/" + id);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Voiture getOneVoiture(Integer id){
        logger.info(String.format("Get one voiture with id %d from url : %s", id, BASE_URL + "/" + id));
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id,
                    Voiture.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
