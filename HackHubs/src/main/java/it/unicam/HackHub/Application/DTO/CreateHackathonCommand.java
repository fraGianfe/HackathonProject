package it.unicam.HackHub.Application.DTO;

import it.unicam.HackHub.Domain.Period;

import java.time.LocalDate;
import java.util.List;

/**
 * Command to request the creation of a new Hackathon
 * @param name hackathon name
 * @param subscriptionDeadline subscription deadline
 * @param period hackathon period
 * @param maxTeamSize max team size
 * @param requirements hackathon requirements
 * @param prize winning prize
 * @param organizerEmail email of the creator(Organizer) of the hackathon
 * @param judgeEmail email of the judge of the hackathon
 * @param mentorsEmails emails of the mentors of the hackathon
 */

public record CreateHackathonCommand(
        String name,
        String location,
        LocalDate subscriptionDeadline,
        Period period,
        int maxTeamSize,
        String requirements,
        Double prize,
        String organizerEmail,
        String judgeEmail,
        List<String> mentorsEmails
) {
}
