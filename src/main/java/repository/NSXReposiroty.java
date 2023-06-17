package repository;

import entity.NSX;
import entity.NSX;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibetnateUtil;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.UUID;

public class NSXReposiroty {
    Session session= HibetnateUtil.getFACTORY().openSession();
    public ArrayList<NSX> getAll(){
        Query query=session.createQuery("FROM NSX ");
        ArrayList<NSX> list= (ArrayList<NSX>) query.getResultList();
        return list;
    }
    public boolean addNSX(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNSX(NSX nsx ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public NSX getOne(UUID id) {
        NSX nsx = new NSX();
        try {
            nsx = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public boolean removeNSX(NSX nsx) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
