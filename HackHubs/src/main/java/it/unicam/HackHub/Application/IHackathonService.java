package it.unicam.HackHub.Application;

import it.unicam.HackHub.Application.DTO.CreateHackathonCommand;

public interface IHackathonService {
    /** Creates a new hackathon based on the provided requested data.
     * <p>
     * The method validates the information in the requested (e.g., ensures required fields are present,
     * dates are coherent, and referenced staff exist), then constructs and persists
     * a {@code Hackathon} entity. The returned entity includes its generated
     * identifier and any default state applied during creation.
     * </p>
     *
     * @param requested a data transfer object containing all necessary information
     *                for the hackathon
     * @return the fully initialized and persisted {@code Hackathon} entity,
     *         complete with its generated ID and current status
     * @throws IllegalArgumentException if the request is invalid or violates
     *                                  any business rule (e.g., past deadline,
     *                                  non‑existent staff, invalid team size) **/
    String createHackathon(CreateHackathonCommand requested);
}
