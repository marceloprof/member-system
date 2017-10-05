package br.com.scchp.sistemasocio.controllers;

import br.com.scchp.sistemasocio.entities.Member;
import br.com.scchp.sistemasocio.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity getMemberAllByName(@RequestParam(value="name") String name){
        return new ResponseEntity(memberRepository.findAllByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addMember(@RequestBody Member member) {
        return new ResponseEntity(memberRepository.save(member), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id){
        memberRepository.delete(id);
        return new ResponseEntity("Member deleted successfully.", HttpStatus.OK);
    }

}
