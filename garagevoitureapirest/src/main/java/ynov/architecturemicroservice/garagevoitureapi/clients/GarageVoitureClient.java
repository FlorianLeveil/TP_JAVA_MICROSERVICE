package ynov.architecturemicroservice.garagevoitureapi.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

import java.util.ArrayList;


@Component
public class GarageVoitureClient {
    private static final String BASE_URL = "http://localhost:8083/garagevoitures";

    private final RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(GarageClient.class);

    public GarageVoitureClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GarageVoituresDTO[] getAllGaragesVoitures() {
        logger.info(String.format("Fetching all garages voitures from url : %s", BASE_URL));
        try {
            return restTemplate.getForObject(BASE_URL, GarageVoituresDTO[].class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public GarageVoituresDTO[] getAllGaragesVoituresWithVoitureName(String nameVoiture){
        logger.info(String.format("Fetching all garages with voiture name: %s from url : %s", nameVoiture,BASE_URL + "voiturename/" + nameVoiture));
        try {
            return restTemplate.getForObject(BASE_URL + "/voiturename/" + nameVoiture, GarageVoituresDTO[].class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;

        }
    }

    public GarageVoituresDTO getOneGarageVoitures(Integer garageId){
        logger.info(String.format("Get one GarageVoiture with garageid %d from url : %s", garageId,BASE_URL +"garageid/" + garageId));
        try {
            return restTemplate.getForObject(BASE_URL + "/garageid/" + garageId, GarageVoituresDTO.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public ArrayList<Object> getGarageInformations(Integer voitureId){
        logger.info(String.format("Get GarageInformation with voiture id %d url : %s",voitureId,BASE_URL+ "garageinformation/" + voitureId));
        try {
            return restTemplate.getForObject(BASE_URL + "/garageinformation/" + voitureId, ArrayList.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    public ArrayList<Garage> getGarageMoreThanFoursVoiture(){
        logger.info(String.format("Get garage when they have more than 4 voitures from url : %s", BASE_URL + "morethanfourvoiture"));
        try {
            return restTemplate.getForObject(BASE_URL + "/morethanfourvoiture", ArrayList.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }


}
