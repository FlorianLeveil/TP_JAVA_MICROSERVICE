package ynov.architecturemicroservice.garagevoitureapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoitureapi.clients.GarageVoitureClient;
import ynov.architecturemicroservice.garagevoitureapi.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;

import java.util.ArrayList;

@Service
public class GarageVoitureService {

    Logger logger =  LoggerFactory.getLogger(GarageVoitureService.class);

    final
    GarageVoitureClient garageVoitureClient;

    public GarageVoitureService(GarageVoitureClient garageVoitureClient) {
        this.garageVoitureClient = garageVoitureClient;
    }

    public GarageVoituresDTO[] getAllGaragesVoitures() {
        return garageVoitureClient.getAllGaragesVoitures();
    }
    public GarageVoituresDTO[] getAllGaragesVoituresWithVoitureName(String voitureName) {
        return garageVoitureClient.getAllGaragesVoituresWithVoitureName(voitureName);
    }

    public GarageVoituresDTO getOneGarageVoitures(Integer garageid) {
        return garageVoitureClient.getOneGarageVoitures(garageid);
    }

    public ArrayList<Object> getGarageInformations(Integer voitureId) {
        return garageVoitureClient.getGarageInformations(voitureId);
    }

    public ArrayList<Garage> getGarageMoreThanFoursVoiture() {
        return garageVoitureClient.getGarageMoreThanFoursVoiture();
    }

}
