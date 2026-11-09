package it.unicam.HackHub.Domain;

import java.util.List;

public interface Save<T>{

    /** save entity E
     * @param E the entity to save that extends T
     * @return the entity saved
     */

    <E extends T> E save(E entity);

    /** save all the entities inside an Iterable<E>
     * @param  entities entities inside the iterable
     * @return a list of the entities saved
     */

    <E extends T> List<E> saveAll(Iterable<E> entities);
}