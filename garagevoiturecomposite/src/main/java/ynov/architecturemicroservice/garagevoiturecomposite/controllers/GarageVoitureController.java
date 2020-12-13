package ynov.architecturemicroservice.garagevoiturecomposite.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagevoiturecomposite.clients.GarageClient;
import ynov.architecturemicroservice.garagevoiturecomposite.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoiturecomposite.models.Garage;
import ynov.architecturemicroservice.garagevoiturecomposite.services.GarageVoitureService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/garagevoitures")
public class GarageVoitureController {
    Logger logger = LoggerFactory.getLogger(GarageClient.class);

    private final GarageVoitureService garagevoitureService;

    public GarageVoitureController(GarageVoitureService garagevoitureService) {
        this.garagevoitureService = garagevoitureService;
    }

    @GetMapping()
    public @ResponseBody ResponseEntity<List<GarageVoituresDTO>> getAllGarageVoitures() {
        return new ResponseEntity<>(garagevoitureService.getAllGaragesVoitures(), HttpStatus.OK);
    }

    @GetMapping("/voiturename/{nameVoiture}")
    public @ResponseBody ResponseEntity<?> getAllGaragesVoituresWithVoitureName(@PathVariable String nameVoiture) {
        logger.error(String.format("DEBUG %s",nameVoiture));
        return new ResponseEntity<>(garagevoitureService.getAllGaragesVoituresWithVoitureName(nameVoiture), HttpStatus.OK);
    }

    @GetMapping("/garageid/{garageId}")
    public @ResponseBody ResponseEntity<GarageVoituresDTO> getOneGarageVoitures(@PathVariable Integer garageId) {
        return new ResponseEntity<>(garagevoitureService.getOneGarageVoitures(garageId), HttpStatus.OK);
    }

    @GetMapping("/garageinformation/{voitureId}")
    public @ResponseBody ResponseEntity<?> getGarageInformations(@PathVariable Integer voitureId) {
        logger.error(String.format("DEBUG %s",voitureId));
        return new ResponseEntity<>(garagevoitureService.getGarageInformations(voitureId), HttpStatus.OK);
    }

    @GetMapping("/morethanfourvoiture")
    public @ResponseBody ResponseEntity<List<Garage>> getGarageMoreThanFoursVoiture() {
        return new ResponseEntity<>(garagevoitureService.getGarageMoreThanFoursVoiture(), HttpStatus.OK);
    }

}
