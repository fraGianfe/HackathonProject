import main.java.it.unicam.HackHub.Domain.Judge;
import main.java.it.unicam.HackHub.Domain.Mentor;
import main.java.it.unicam.HackHub.Domain.Organizer;
import main.java.it.unicam.HackHub.Domain.Submission;

import java.util.Date;
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


    public Hackathon(String name, Long id, Period period, Judge judge, Organizer organizer ) {

    }

    public boolean registerTeam(Team team){
    return  false;
    }
    public void changeState(HackathonState state){
        this.state = state;
    }
    public void addSubmission(Team team, Submission submission){

    }

}