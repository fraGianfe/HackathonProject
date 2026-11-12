package it.unicam.HackHub.Application;

import it.unicam.HackHub.Application.DTO.SubmissionCommand;
import it.unicam.HackHub.Domain.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubmissionService implements ISubmissionService {
    private final HackathonRepository hackathonRep;
    private final UserRepository userRep;

   @Override
    public String sendSubmission(SubmissionCommand sendCommand) {
        Hackathon hackathon= getHackathon(sendCommand.hackathonId());
        Team team = getUser(sendCommand.userEmail()).getTeam();
        hackathon.addSubmission(Team team, new Submission(sendCommand.url()));
        hackathonRep.save(hackathon);
        return "Submission sent";
    }

    private User getUser(String email ){
       return userRep.findById(email).orElseThrow(()->  throw new IllegalArgumentException("User not found"));

    }

    private Hackathon getHackathon(Long id){
        return hackathonRep.findById(id).orElseThrow(()->new  IllegalArgumentException("Hackathon Not Found"));
    }
}
