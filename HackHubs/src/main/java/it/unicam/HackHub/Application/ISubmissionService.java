package it.unicam.HackHub.Application;

import it.unicam.HackHub.Application.DTO.SubmissionCommand;


public interface ISubmissionService {

    /**
 * Send and add a submission for a specific team in a given hackathon.
 * @param sendCommand command to execute
 * @return a status string for failure or succes of the operation
 */
    String sendSubmission(SubmissionCommand sendCommand);
}
