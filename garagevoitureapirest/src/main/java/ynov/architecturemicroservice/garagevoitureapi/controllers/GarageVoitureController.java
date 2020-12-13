package ynov.architecturemicroservice.garagevoitureapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagevoitureapi.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.services.GarageVoitureService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/garagevoiture")
public class GarageVoitureController {
    private final GarageVoitureService garageVoitureService;

    public GarageVoitureController(GarageVoitureService garageVoitureService) {
        this.garageVoitureService = garageVoitureService;
    }

    @GetMapping()
    public @ResponseBody
    ResponseEntity<GarageVoituresDTO[]> getAllGaragesVoitures() {
        return new ResponseEntity<>(garageVoitureService.getAllGaragesVoitures(), HttpStatus.OK);
    }

    @GetMapping("/voiturename/{nameVoiture}")
    public @ResponseBody
    ResponseEntity<GarageVoituresDTO[]> getAllGaragesVoituresWithVoitureName(@PathVariable String nameVoiture) {
        return new ResponseEntity<>(garageVoitureService.getAllGaragesVoituresWithVoitureName(nameVoiture), HttpStatus.OK);
    }

    @GetMapping("/garageid/{garageId}")
    public @ResponseBody
    ResponseEntity<?> getOneGarageVoitures(@PathVariable Integer garageId) {
        return new ResponseEntity<>(garageVoitureService.getOneGarageVoitures(garageId), HttpStatus.OK);
    }

    @GetMapping("/garageinformation/{voitureId}")
    public @ResponseBody
    ResponseEntity<ArrayList<Object>> getGarageInformations(@PathVariable Integer voitureId) {
        return new ResponseEntity<>(garageVoitureService.getGarageInformations(voitureId), HttpStatus.OK);
    }

    @GetMapping("/morethanfourvoiture")
    public @ResponseBody
    ResponseEntity<List<Garage>> getGarageMoreThanFoursVoiture() {
        return new ResponseEntity<>(garageVoitureService.getGarageMoreThanFoursVoiture(), HttpStatus.OK);
    }


}
