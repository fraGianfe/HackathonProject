package it.unicam.HackHub.Application;

import it.unicam.HackHub.Application.DTO.CreateHackathonCommand;
import it.unicam.HackHub.Domain.Hackathon;
import it.unicam.HackHub.Domain.HackathonRepository;
import it.unicam.HackHub.Domain.StaffMember;
import it.unicam.HackHub.Domain.StaffMemberRepository;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;


@RequiredArgsConstructor
public class HackathonService implements IHackathonService{
    private final HackathonRepository hackathonRep;
    private final StaffMemberRepository staffRep;




    @Override
    public  String createHackathon(CreateHackathonCommand requested) {
checkDateOrder(requested);
checkStaff(requested);
StaffMember organizer= staffRep.findById(requested.organizerEmail()).orElseThrow(()->new IllegalStateException("No organizer found for email"));
StaffMember judge= staffRep.findById(requested.judgeEmail()).orElseThrow(()->new IllegalStateException("No Judge found for email"));
List<StaffMember> mentors = staffRep.findAll(requested.mentorsEmails());
        if (mentors.size() != requested.mentorsEmails().size()) {
            throw new IllegalStateException(
                    "One or more mentors not found");
  }
        Hackathon hackathon = new Hackathon(
                requested.name(),
                requested.location(),
                requested.subscriptionDeadline(),
                requested.period(),
                requested.maxTeamSize(),
                requested.requirements(),
                requested.prize(), organizer,
                judge,
                new HashSet<>(mentors));
        hackathonRep.save(hackathon);
        return "Hackathon" + hackathon.getName()+"created";
    }

    public void checkStaff(CreateHackathonCommand requested) {
        if(requested.organizerEmail().equals(requested.judgeEmail())) {
            throw new IllegalStateException("Organizer cannot be a judge too");
        }
        if(requested.mentorsEmails().stream().anyMatch(e -> e.equals(requested.organizerEmail()))) {
            throw new IllegalStateException("Organizer cannot be a mentor too");
        }
        if(requested.mentorsEmails().stream().anyMatch(e -> e.equals(requested.judgeEmail()))) {
            throw new IllegalStateException("judge cannot be a mentor too");
        }
    }
  public void checkDateOrder(CreateHackathonCommand requested)
  {
      if(requested.period().endDate().isBefore(requested.period().startDate())) {
          throw new IllegalArgumentException("Period end date must be before start date");
      }
      if(requested.subscriptionDeadline().isAfter(requested.period().startDate())||requested.subscriptionDeadline().isEqual(requested.period().startDate())) {
          throw new IllegalArgumentException("Subscription deadline must be before start date");
      }

  }
}
