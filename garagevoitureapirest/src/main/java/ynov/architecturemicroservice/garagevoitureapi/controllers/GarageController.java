package ynov.architecturemicroservice.garagevoitureapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;
import ynov.architecturemicroservice.garagevoitureapi.services.GarageService;

@RestController
@RequestMapping(path="/api")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/garages")
    public @ResponseBody ResponseEntity<Garage[]> getAllGarages() {
        return new ResponseEntity<>(garageService.getAllGarages(), HttpStatus.OK);
    }

    @GetMapping("/garages/{id}")
    public @ResponseBody
    ResponseEntity<?> getOneGarage(@PathVariable Integer id) {
        return new ResponseEntity<>(garageService.getOneGarage(id), HttpStatus.OK);
    }

    @DeleteMapping("/garages/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteGarageById(@PathVariable Integer id) {
        return new ResponseEntity<>(garageService.deleteGarageById(id), HttpStatus.OK);
    }

    @PutMapping("/garages/{id}")
    public @ResponseBody ResponseEntity<Garage> updateGarage(@PathVariable Integer id, @RequestBody Garage garage) {
        return new ResponseEntity<>(garageService.updateGarage(id, garage), HttpStatus.OK);
    }

    @PostMapping("/garages")
    public @ResponseBody
    ResponseEntity<Garage> addNewGarage(@RequestBody Garage newGarage) {
        return new ResponseEntity<>(garageService.addNewGarage(newGarage), HttpStatus.OK);
    }


}
