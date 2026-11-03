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
}