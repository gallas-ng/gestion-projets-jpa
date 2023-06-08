package sn.lpgl.dao.projetDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sn.lpgl.config.HibernateUtil;
import sn.lpgl.entities.Projet;

import java.util.List;

public class ProjetImpl implements IProjet{
    private Session session;
    private Transaction transaction;
    public ProjetImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public int create(Projet projet) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.save(projet);
            transaction.commit();
            ok = 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<Projet> getAll() {
        return session.createCriteria(Projet.class).list();
    }

    @Override
    public Projet get(int id) {
        return session.get(Projet.class, id);
    }

    @Override
    public int update(Projet projet) {
        int ok = 0;
        try {
            transaction = session.beginTransaction();
            session.merge(projet);
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
