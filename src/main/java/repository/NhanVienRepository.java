package repository;

import entity.KhachHang;
import entity.NhanVien;
import entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class NhanVienRepository {
    Session session= HibetnateUtil.getFACTORY().openSession();
    public ArrayList<NhanVien> getAll(){
        Query query=session.createQuery("FROM NhanVien ");
        ArrayList<NhanVien> list= (ArrayList<NhanVien>) query.getResultList();
        return list;
    }
    public boolean addNhanVien(NhanVien nhanVien) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNhanVien(NhanVien nhanVien ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public NhanVien getOne(UUID id) {
        NhanVien nhanVien = new NhanVien();
        try {
            nhanVien = session.get(NhanVien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public boolean removeNhanVien(NhanVien nhanVien) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
