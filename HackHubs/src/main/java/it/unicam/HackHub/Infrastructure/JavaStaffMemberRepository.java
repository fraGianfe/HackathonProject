import it.unicam.HackHub.Domain.StaffMember;
import it.unicam.HackHub.Domain.StaffMemberRepository;


import java.util.*;

public class JavaStaffMemberRepository implements StaffMemberRepository {
    private Set<StaffMember> staffs = new HashSet<>();

    @Override
    public Optional<StaffMember> findById(String id) {
        for(StaffMember entity: staffs){
            if(id.equals(entity.getEmail())) return Optional.of(entity);
        }

        return Optional.empty();
    }
    @Override
    public List<StaffMember> findAll(Iterable<String> ids){
        List<StaffMember> found = new ArrayList<>();
        for (String id : ids) {
            findById(id).ifPresent(found::add);
        }

        return found;
    }

    @Override
    public  <E extends StaffMember> E save(E entity){
        staffs.add(entity);
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