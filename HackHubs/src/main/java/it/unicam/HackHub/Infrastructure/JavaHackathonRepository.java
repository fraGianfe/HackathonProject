package it.unicam.HackHub.Infrastructure;

import it.unicam.HackHub.Domain.Hackathon;
import it.unicam.HackHub.Domain.HackathonRepository;

import java.util.*;

public class JavaHackathonRepository extends HackathonRepository {
    private Set<Hackathon> hackathons = new HashSet();

    public <E extends Hackathon>  E save(E entity){
        hackathons.add(entity);
        return entity;
    }
public  <E extends Hackathon> List<E> saveAll(Iterable<E> entities){
    List<E> saved = new ArrayList<>();

    for (E entity : entities) {
        hackathons.add(entity);
        saved.add(entity);
    }

    return saved;
}
public Hackathon findById(Long Id ){
for (Hackathon entity : hackathons) {
    if(Id == entity.getId()) return entity;

}
return null;
}
public List<Hackathon> findAll( Iterable<Long> ids ){
        List<Hackathon> found = new ArrayList<>();
      for (Long id : ids) {
           Hackathon test = findById(id);
           if(test != null) found.add(test);
      }
      return found;
}
}