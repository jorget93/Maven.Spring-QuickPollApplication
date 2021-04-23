package io.zipcoder.tc_spring_poll_application.services;

import io.zipcoder.tc_spring_poll_application.domain.Option;
import io.zipcoder.tc_spring_poll_application.domain.Poll;
import io.zipcoder.tc_spring_poll_application.repositories.OptionRepository;
import io.zipcoder.tc_spring_poll_application.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class PollService {

    @Autowired
    PollRepository pollRepository;

    @Autowired
    OptionRepository optionRepository;

    public void savePoll(Poll poll){
        //save to the OptionRepo?

        Poll tempPoll = new Poll();
        tempPoll.setQuestion(poll.getQuestion());
        Option option = new Option("question");
        Set<Option> newSet = new HashSet<>();
        option.setId(1L);
        newSet.add(option);
       // tempPoll.setOptions(newSet);
        pollRepository.save(tempPoll);
    }
}
