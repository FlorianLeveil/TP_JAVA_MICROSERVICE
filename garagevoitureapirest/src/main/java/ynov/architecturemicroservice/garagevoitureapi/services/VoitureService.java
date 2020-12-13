package ynov.architecturemicroservice.garagevoitureapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoitureapi.clients.VoitureClient;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

@Service
public class VoitureService {

    Logger logger =  LoggerFactory.getLogger(VoitureService.class);

    final
    VoitureClient voitureClient;

    public VoitureService(VoitureClient voitureClient) {
        this.voitureClient = voitureClient;
    }

    public Voiture[] getAllVoitures() {
        return voitureClient.getAllVoiture();
    }

    public Voiture getOneVoiture(Integer id) {
        return voitureClient.getOneVoiture(id);
    }

    public Voiture updateVoiture(Integer id, Voiture updateVoiture) {
        return voitureClient.updateVoiture(id, updateVoiture);
    }

    public Voiture deleteVoitureById(Integer id) {
        return voitureClient.deleteVoitureById(id);
    }

    public Voiture addNewVoiture(Voiture voiture) {
        return voitureClient.addNewVoiture(voiture);
    }
}
