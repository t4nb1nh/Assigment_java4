package repository;

import entity.MauSac;
import entity.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class MauSacReposiroty {
    Session session= HibetnateUtil.getFACTORY().openSession();
    public ArrayList<MauSac> getAll(){
        Query query=session.createQuery("FROM MauSac ");
        ArrayList<MauSac> list= (ArrayList<MauSac>) query.getResultList();
        return list;
    }
    public boolean addMauSac(MauSac mauSac) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMauSac(MauSac mauSac ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public MauSac getOne(UUID id) {
        MauSac mauSac = new MauSac();
        try {
            mauSac = session.get(MauSac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    public boolean removeMauSac(MauSac mauSac) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
