import it.unicam.HackHub.Domain.InvitationRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class JavaInvitationRepository implements InvitationRepository {
    private Set<Invitation> invitations = new HashSet<>();

    @Override
    public Invitation findById(InvitationId id) {
        for(Invitation entity: invitations){
            if(id.equals(entity.getInvitationId()) return entity;
        }

        return null;
    }
    @Override
    public List<Invitation> findAll(Iterable<InvitationId> ids){
        List<Invitation> found = new ArrayList<>();
        for(InvitationId id: ids){
            Invitation test= findById(id);
            if(test!=null) found.add(test);

        }
        return found;
    }
@Override
    public  <E extends Invitation> E save(E entity){
        invitations.add(entity);
        return entity;
    }
    @Override
    public  <E extends Invitation> List<E> saveAll(Iterable<E> entities){
        List<E> saved = new ArrayList<>();
        for(E entity:entities){
            invitations.add(entity);
            saved.add(entity);

        }
        return saved;
    }

    }




