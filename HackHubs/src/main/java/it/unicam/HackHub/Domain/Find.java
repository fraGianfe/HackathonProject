package it.unicam.HackHub.Domain;

import java.util.List;
import java.util.Optional;

public interface Find<T,K> {
    /**
     * find an entity by his ID
     * @param id of the entity K
     * @return the entity if is found, else null
     **/
Optional<T> findById(K id);

/** Find iterable of entities by their ID
 * @param ids ids of the entities
 * @return a List of all the entities found
 * */
List<T> findAll(Iterable<K> ids);

}