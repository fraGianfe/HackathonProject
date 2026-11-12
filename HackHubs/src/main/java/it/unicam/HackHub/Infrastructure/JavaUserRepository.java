import it.unicam.HackHub.Domain.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class JavaUserRepository implements UserRepository {
    private Set<User> users = new HashSet<>();

    @Override
    public Optional<User> findById(String id) {
        for(User entity: users){
            if(id.equals(entity.getEmail())) return Optional.of(entity);
        }

        return Optional.empty();
    }
    @Override
    public List<User> findAll(Iterable<String> ids){
        List<User> found = new ArrayList<>();
        for (String id : ids) {
            findById(id).ifPresent(found::add);
        }

        return found;
    }
    @Override
    public  <E extends User> E save(E entity){
        users.add(entity);
        return entity;
    }
    @Override
    public  <E extends User> List<E> saveAll(Iterable<E> entities){
        List<E> saved = new ArrayList<>();
        for(E entity:entities){
            users.add(entity);
            saved.add(entity);

        }
        return saved;
    }

}