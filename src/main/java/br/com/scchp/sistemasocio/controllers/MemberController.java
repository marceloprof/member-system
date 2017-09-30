package br.com.scchp.sistemasocio.controllers;

import br.com.scchp.sistemasocio.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by milene on 30/09/17.
 */
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllMembers(){
        return new ResponseEntity(memberRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getMemberById(@PathVariable Long id){
        return new ResponseEntity(memberRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public ResponseEntity getMemberByName(@PathVariable String name){
        return new ResponseEntity(memberRepository.findByName(name), HttpStatus.OK);
    }

}
