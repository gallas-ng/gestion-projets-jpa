package sn.lpgl;

import sn.lpgl.config.HibernateUtil;
import sn.lpgl.dao.roleDAO.IRole;
import sn.lpgl.dao.roleDAO.RoleImpl;
import sn.lpgl.entities.Role;

public class App {
    public static void main(String[] args) {

        // -0  -- Effecuter les migrations dans la bd --
        //HibernateUtil.getSessionFactory();


        IRole roleDAO = new RoleImpl();
        //Creation
        Role role = new Role();
        role.setNomR("admin");
        int ok = roleDAO.create(role);
        if(ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");
        //Liste
        /*classeDao.getAll().forEach(
                cl -> {
                    System.out.println("ID : " + cl.getId());
                    System.out.println("NOM : " + cl.getLibelle());
                    System.out.println("EFFECTIF : " + cl.getEffectif());
                }
        );*/
        //Selection et Modification
        /*Classe classe = classeDao.get(3);
        classe.setLibelle("L3RI");
        classe.setEffectif(5);
        int ok = classeDao.update(classe);
        if(ok == 1)
            System.out.println("OK");
        else
            System.out.println("KO");*/
        //Suppression
//        int ok = classeDao.delete(3);
//        if(ok == 1)
//            System.out.println("OK");
//        else
//            System.out.println("KO");
    }
}