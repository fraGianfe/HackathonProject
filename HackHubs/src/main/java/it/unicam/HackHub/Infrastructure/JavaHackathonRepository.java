package it.unicam.HackHub.Infrastructure;

import it.unicam.HackHub.Domain.Hackathon;
import it.unicam.HackHub.Domain.HackathonRepository;

import java.util.*;

public class JavaHackathonRepository implements HackathonRepository {
    private Set<Hackathon> hackathons = new HashSet<>();
@Override
    public <E extends Hackathon>  E save(E entity){
        hackathons.add(entity);
        return entity;
    }

    @Override
public  <E extends Hackathon> List<E> saveAll(Iterable<E> entities){
    List<E> saved = new ArrayList<>();

    for (E entity : entities) {
        hackathons.add(entity);
        saved.add(entity);
    }

    return saved;
}

@Override
public Optional<Hackathon> findById(Long Id ){
for (Hackathon entity : hackathons) {
    if(Id.equals(entity.getId())) return Optional.of(entity);

}
return Optional.empty();
}

@Override
public List<Hackathon> findAll( Iterable<Long> ids ){
    List<Hackathon> found = new ArrayList<>();
    for (Long id : ids) {
        findById(id).ifPresent(found::add);
    }
    return found;
}
}