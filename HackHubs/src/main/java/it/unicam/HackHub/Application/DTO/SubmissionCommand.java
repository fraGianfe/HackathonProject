package it.unicam.HackHub.Application.DTO;

import java.io.File;

/** Command to send a submission to a specific Hackathon
 * @param userEmail email of the user sending it
 * @param hackathonId id of the hackathon the user send it to
 * @param **/

public record SubmissionCommand(
        String userEmail,
        Long hackathonId,
        String url) {

}
