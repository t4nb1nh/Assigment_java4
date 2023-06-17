package repository;

import entity.CuaHang;
import entity.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibetnateUtil;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangReposiroty {
    Session session= HibetnateUtil.getFACTORY().openSession();

    public ArrayList<CuaHang> getAll(){
        Query query=session.createQuery("FROM CuaHang ");
        ArrayList<CuaHang> list= (ArrayList<CuaHang>) query.getResultList();
        return list;
    }
    public boolean addCuaHang(CuaHang cuaHang) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCuaHang(CuaHang cuaHang ) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CuaHang getOne(UUID id) {
        CuaHang cuaHang = new CuaHang();
        try {
            cuaHang = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }

    public boolean removeCuaHang(CuaHang cuaHang) {

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
