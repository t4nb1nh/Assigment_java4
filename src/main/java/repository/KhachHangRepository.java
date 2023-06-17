package repository;

import entity.KhachHang;
import entity.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class KhachHangRepository {

    Session session= HibetnateUtil.getFACTORY().openSession();
    public ArrayList<KhachHang> getAll(){
        Query query=session.createQuery("FROM KhachHang ");
        ArrayList<KhachHang> list= (ArrayList<KhachHang>) query.getResultList();
        return list;
    }
    public boolean addKhachHang(KhachHang khachHang) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateKhachHang(KhachHang khachHang ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public KhachHang getOne(UUID id) {
        KhachHang khachHang = new KhachHang();
        try {
            khachHang = session.get(KhachHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public boolean removeKhachHang(KhachHang khachHang) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
