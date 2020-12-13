package ynov.architecturemicroservice.garagevoitureapi.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoitureapi.clients.GarageClient;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

@Service
public class GarageService {
    Logger logger =  LoggerFactory.getLogger(GarageService.class);

    final
    GarageClient garageClient;

    public GarageService(GarageClient garageClient) {
        this.garageClient = garageClient;
    }

    public Garage[] getAllGarages() {
        return garageClient.getAllGarages();
    }

    public Garage getOneGarage(Integer id) {
        return garageClient.getOneGarage(id);
    }

    public Garage updateGarage(Integer id, Garage updateGarage) {
        return garageClient.updateGarage(id, updateGarage);
    }

    public Garage deleteGarageById(Integer id) {
        return garageClient.deleteGarageById(id);
    }

    public Garage addNewGarage(Garage newGarage) {
        return garageClient.addNewGarage(newGarage);
    }

}
