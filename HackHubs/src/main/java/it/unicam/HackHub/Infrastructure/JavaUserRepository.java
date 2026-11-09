import it.unicam.HackHub.Domain.InvitationRepository;
import it.unicam.HackHub.Domain.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class JavaUserRepository implements UserRepository {
    private Set<User> users = new HashSet<>();

    @Override
    public User findById(String id) {
        for(User entity: users){
            if(id==entity.getEmail()) return entity;
        }

        return null;
    }
    @Override
    public List<User> findAll(Iterable<String> ids){
        List<User> found = new ArrayList<>();
        for(String id: ids){
            User test= findById(id);
            if(test!=null) found.add(test);

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