package io.zipcoder.tc_spring_poll_application.controller;

import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import io.zipcoder.tc_spring_poll_application.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PollController {

    private PollRepository pollRepository;

    @Autowired
    PollService pollService;

    @Autowired
    public PollController(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }

    @RequestMapping(value ="/polls", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls(){
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    @RequestMapping(value ="/polls", method = RequestMethod.POST)
    public ResponseEntity<?> createPoll(@RequestBody Poll poll){
        //poll = pollRepository.save(poll);
        pollService.savePoll(poll);
        //HttpHeaders responseHeaders = new HttpHeaders();
        //URI newPollUri = ServletUriComponentsBuilder
                //.fromCurrentRequest()
                //.path("/{id}")
                //.buildAndExpand(poll.getId())
                //.toUri();
        //responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, null, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/{pollsId}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable Long pollId){
        Poll p = pollRepository.findOne(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(value=".polls.{pollsId}", method= RequestMethod.GET)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId){
        //save the entity
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value= "/polls/{pollsId}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId){
        pollRepository.delete(pollId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
