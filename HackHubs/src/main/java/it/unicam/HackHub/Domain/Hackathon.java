package it.unicam.HackHub.Domain;

import it.unicam.HackHub.Domain.Judge;
import it.unicam.HackHub.Domain.Mentor;
import it.unicam.HackHub.Domain.Organizer;
import it.unicam.HackHub.Domain.Submission;

import java.time.Period;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Hackathon {
    private String name;
    private Long id;
    private Organizer organizer;
    private Set<Mentor> mentors;
    private Judge judge;
    private int maxTeamSize;
    private String requirements;
    private Period period;
    private String location;
    private HackathonState state;
    private Set<Team> teams;
    private Date subscriptionDeadline;
    private Double prize;
    private Team winner;
    private Map<Team, Submission> submissions;


    public Hackathon(String name, Long id, Period period, Judge judge, Organizer organizer ) {

    }

    public boolean addTeam(Team team){
        if(teams.contains(team)||team==null){
            return false;
        } else {
            teams.add(team);
            return true;
        }
    }
    public void changeState(HackathonState state){
        this.state = state;
    }

    public boolean addSubmission(Team team, Submission submission){
        if (team == null || submission == null) {
            return false;
        }

        if (!teams.contains(team)) {
            return false;
        }

        if (submissions.containsKey(team)) {
            return false;
        }

        submissions.put(team, submission);
        return true;
    }

    public Long getId() { return id;}

    public String getName() {return name;}
}