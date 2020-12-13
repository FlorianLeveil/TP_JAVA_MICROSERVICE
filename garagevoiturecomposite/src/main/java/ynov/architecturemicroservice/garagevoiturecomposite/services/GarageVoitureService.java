package ynov.architecturemicroservice.garagevoiturecomposite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoiturecomposite.clients.GarageClient;
import ynov.architecturemicroservice.garagevoiturecomposite.clients.VoitureClient;
import ynov.architecturemicroservice.garagevoiturecomposite.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoiturecomposite.models.Garage;
import ynov.architecturemicroservice.garagevoiturecomposite.models.Voiture;

import java.util.ArrayList;

@Service
public class GarageVoitureService {

    Logger logger =  LoggerFactory.getLogger(GarageVoitureService.class);

    final
    GarageClient garageClient;

    final
    VoitureClient voitureClient;

    public GarageVoitureService(GarageClient garageClient, VoitureClient voitureClient) {
        this.garageClient = garageClient;
        this.voitureClient = voitureClient;
    }

    public ArrayList<GarageVoituresDTO> getAllGaragesVoitures(){
        ArrayList<GarageVoituresDTO> garagesVoitures = new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();
        for (Garage garage : garages) {
            garagesVoitures.add(
                    new GarageVoituresDTO (
                            garage.getId(),
                            garage.getName(),
                            garage.getCity(),
                            voitureClient.getAllVoituresForGarage(garage.getId())
                    )
            );
        }
        return garagesVoitures;
    }

    public ArrayList<Garage> getAllGaragesVoituresWithVoitureName(String nameVoiture){
        ArrayList<GarageVoituresDTO> getAllGaragesVoitures = getAllGaragesVoitures();
        ArrayList<Garage> garagelist= new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();
        for (GarageVoituresDTO garagevoiture : getAllGaragesVoitures) {
            for (Voiture voiture : garagevoiture.getVoitures()) {
                if (voiture.getModel().equals(nameVoiture)) {
                    for (Garage garage : garages) {
                        if (garage.getId().equals(voiture.getGarageId())) {
                            garagelist.add(garage);
                            break;
                        }
                    }
                }
            }
        }
        return garagelist;
    }

    public GarageVoituresDTO getOneGarageVoitures(Integer garageId){
        Garage garage = garageClient.getOneGarage(garageId);
        return new  GarageVoituresDTO(
                garageId,
                garage.getName(),
                garage.getCity(),
                voitureClient.getAllVoituresForGarage(garageId)
        );
    }

    public ArrayList<Object> getGarageInformations(Integer voitureId){
        Voiture voiture = voitureClient.getOneVoiture(voitureId);
        Integer garageId = voiture.getGarageId();
        Garage garage = garageClient.getOneGarage(garageId);
        ArrayList<Object> result = new ArrayList<Object>();
        result.add(voiture);
        result.add(new  GarageVoituresDTO(
                garageId,
                garage.getName(),
                garage.getCity(),
                voitureClient.getAllVoituresForGarage(garageId)
        ));
        return result;
    }

    public ArrayList<Garage> getGarageMoreThanFoursVoiture(){
        ArrayList<Garage> garagesHaveMoreThanFourVoiture= new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();
        for (Garage garage : garages) {
            Integer idGarage = garage.getId();
            if (voitureClient.getAllVoituresForGarage(idGarage).length >= 4) {
                garagesHaveMoreThanFourVoiture.add(garage);
            }
        }
        return garagesHaveMoreThanFourVoiture;
    }



}
