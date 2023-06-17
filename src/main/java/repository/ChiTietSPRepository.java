package repository;

import entity.ChiTietSP;
import entity.ChiTietSP;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class ChiTietSPRepository {
    Session session= HibetnateUtil.getFACTORY().openSession();
    public ArrayList<ChiTietSP> getAll(){
        Query query=session.createQuery("FROM ChiTietSP ");
        ArrayList<ChiTietSP> list= (ArrayList<ChiTietSP>) query.getResultList();
        return list;
    }
    public boolean addChiTietSP(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChiTietSP(ChiTietSP chiTietSP ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ChiTietSP getOne(UUID id) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try {
            chiTietSP = session.get(ChiTietSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public boolean removeChiTietSP(ChiTietSP chiTietSP) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
