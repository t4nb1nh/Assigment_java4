package repository;


import entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class SanPhamRepository {

    Session session = HibetnateUtil.getFACTORY().openSession();

    public ArrayList<SanPham> getAll() {
        Query query = session.createQuery("FROM SanPham ");
        ArrayList<SanPham> list = (ArrayList<SanPham>) query.getResultList();
        return list;
    }

    public boolean addSanPham(SanPham sanPham) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSanPham(SanPham sanPham ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SanPham getOne(UUID id) {
        SanPham sanPham = new SanPham();
        try {
            sanPham = session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public boolean removeSanPham(SanPham sanPham) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
