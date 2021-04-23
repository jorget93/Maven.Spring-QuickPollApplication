package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "POLL_ID")
    private Long id;

    //@Column(name="QUESTION")
    private String question;

    @OneToMany
   // @JoinColumn(name = "POLL_ID")
    @OrderBy
    private Set<Option> options;

    public Poll() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set getOptions() {
        return options;
    }

    public void setOptions(Set options) {
        this.options = options;
    }
}
