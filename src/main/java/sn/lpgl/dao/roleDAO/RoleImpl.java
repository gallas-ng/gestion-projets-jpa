package sn.lpgl.dao.roleDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.lpgl.config.HibernateUtil;
import sn.lpgl.entities.Role;

import java.util.List;

public class RoleImpl implements IRole{
    private Session session;
    private Transaction transaction;
    public RoleImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public int create(Role role) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Role> getAll() {
        return session.createCriteria(Role.class).list();
    }

    @Override
    public Role get(int id) {
        return session.get(Role.class, id);
    }

    @Override
    public int update(Role role) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.merge(role);
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.delete(get(id));
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }
}
