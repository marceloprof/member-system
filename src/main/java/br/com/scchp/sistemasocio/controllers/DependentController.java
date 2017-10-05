package br.com.scchp.sistemasocio.controllers;

import br.com.scchp.sistemasocio.entities.Dependent;
import br.com.scchp.sistemasocio.repositories.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by milene on 30/09/17.
 */
@RestController
@RequestMapping("/dependents")
public class DependentController {

    @Autowired
    private DependentRepository dependentRepository;

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity getDependentAllByName(@RequestParam(value="name") String name){
        return new ResponseEntity(dependentRepository.findAllByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addDependent(@RequestBody Dependent dependent) {
        return new ResponseEntity(dependentRepository.save(dependent), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteDependent(@PathVariable Long id) {
        dependentRepository.delete(id);
        return new ResponseEntity("Dependent deleted successfully!", HttpStatus.CREATED);
    }

}
