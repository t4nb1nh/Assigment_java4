package repository;

import entity.DongSp;
import entity.DongSp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class DongSpReposiroty {
    Session session= HibetnateUtil.getFACTORY().openSession();

    public ArrayList<DongSp> getAll(){
        Query query=session.createQuery("from DongSp ");
        ArrayList<DongSp> list= (ArrayList<DongSp>) query.getResultList();
        return list;
    }
    public boolean addDongSp(DongSp dongsp) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dongsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDongSp(DongSp dongsp ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(dongsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public DongSp getOne(UUID id) {
        DongSp dongsp = new DongSp();
        try {
            dongsp = session.get(DongSp.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongsp;
    }

    public boolean removeDongSp(DongSp dongsp) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(dongsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
