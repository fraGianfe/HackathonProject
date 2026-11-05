import it.unicam.HackHub.Domain.StaffMemberRepository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JavaStaffMemberRepository implements StaffMemberRepository {
    private Set<StaffMember> staffs = new HashSet<>();

    @Override
    public StaffMember findById(String id) {
        for(StaffMember entity: staffs){
            if(id==entity.getEmail()) return entity;
        }

        return null;
    }
    @Override
    public List<StaffMember> findAll(Iterable<String> ids){
        List<StaffMember> found = new ArrayList<>();
        for(String id: ids){
            StaffMember test= findById(id);
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
    public  <E extends StaffMember> List<E> saveAll(Iterable<E> entities){
        List<E> saved = new ArrayList<>();
        for(E entity:entities){
            staffs.add(entity);
            saved.add(entity);

        }
        return saved;
    }

}