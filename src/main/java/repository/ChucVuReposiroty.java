package repository;

import entity.ChucVu;
import entity.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuReposiroty {
    Session session= HibetnateUtil.getFACTORY().openSession();

    public ArrayList<ChucVu> getAll(){
        Query query=session.createQuery("from ChucVu ");
        ArrayList<ChucVu> list= (ArrayList<ChucVu>) query.getResultList();
        return list;
    }
    public boolean addChucVu(ChucVu chucVu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChucVu(ChucVu chucVu ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ChucVu getOne(UUID id) {
        ChucVu chucVu = new ChucVu();
        try {
            chucVu = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }

    public boolean removeChucVu(ChucVu chucVu) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
