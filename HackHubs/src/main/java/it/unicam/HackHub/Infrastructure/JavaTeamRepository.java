import it.unicam.HackHub.Domain.TeamRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class JavaTeamRepository implements TeamRepository {
    private Set<Team> teams = new HashSet<>();

    @Override
    public Optional<Team> findById(String id) {
        for(Team entity: teams){
            if(id.equals(entity.getName())) return Optional.of(entity);
        }

        return Optional.empty();
    }
    @Override
    public List<Team> findAll(Iterable<String> ids){
        List<Team> found = new ArrayList<>();

        for (String id : ids) {
            findById(id).ifPresent(found::add);
        }

        return found;
    }
    @Override
    public  <E extends Team> E save(E entity){
        teams.add(entity);
        return entity;
    }
    @Override
    public  <E extends Team> List<E> saveAll(Iterable<E> entities){
        List<E> saved = new ArrayList<>();
        for(E entity:entities){
            teams.add(entity);
            saved.add(entity);

        }
        return saved;
    }

}