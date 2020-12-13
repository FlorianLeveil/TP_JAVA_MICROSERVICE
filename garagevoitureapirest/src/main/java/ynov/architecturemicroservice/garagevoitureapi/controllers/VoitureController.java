package ynov.architecturemicroservice.garagevoitureapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;
import ynov.architecturemicroservice.garagevoitureapi.services.VoitureService;

@RestController
@RequestMapping(path="/api")
public class VoitureController {
    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping("/voitures")
    public @ResponseBody
    ResponseEntity<Voiture[]> getAllVoitures() {
        return new ResponseEntity<>(voitureService.getAllVoitures(), HttpStatus.OK);
    }

    @GetMapping("/voitures/{id}")
    public @ResponseBody
    ResponseEntity<?> getOneVoiture(@PathVariable Integer id) {
        return new ResponseEntity<>(voitureService.getOneVoiture(id), HttpStatus.OK);
    }

    @DeleteMapping("/voitures/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteVoitureById(@PathVariable Integer id) {
        return new ResponseEntity<>(voitureService.deleteVoitureById(id), HttpStatus.OK);
    }

    @PutMapping("/voitures/{id}")
    public @ResponseBody ResponseEntity<Voiture> updateVoiture(@PathVariable Integer id, @RequestBody Voiture voiture) {
        return new ResponseEntity<>(voitureService.updateVoiture(id, voiture), HttpStatus.OK);
    }

    @PostMapping("/voitures")
    public @ResponseBody
    ResponseEntity<Voiture> addNewVoiture(@RequestBody Voiture newVoiture) {
        return new ResponseEntity<>(voitureService.addNewVoiture(newVoiture), HttpStatus.OK);
    }
}
