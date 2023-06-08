package sn.lpgl.dao.userDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.lpgl.config.HibernateUtil;
import sn.lpgl.entities.User;

import java.util.List;

public class UserImpl implements IUser{
    private Session session;
    private Transaction transaction;
    public UserImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public int create(User user) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> getAll() {
        return session.createCriteria(User.class).list();
    }

    @Override
    public User get(int id) {
        return session.get(User.class, id);
    }

    @Override
    public int update(User user) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.merge(user);
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
