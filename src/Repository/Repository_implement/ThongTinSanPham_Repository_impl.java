/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Repository.ThongTinSanPham_Interface;
import Unility.JDBC_Helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongTinSanPham_Repository_impl implements ThongTinSanPham_Interface{

    @Override
    public List<SanPham> getAllSanPham() {
        List<SanPham> listSP = new ArrayList<>();
        ResultSet rs;
        String sql = "select ma, ten from SanPham";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                SanPham sp = new SanPham(null, ma, ten);
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MauSac> getAllMauSac() {
        List<MauSac> listMS = new ArrayList<>();
        ResultSet rs;
        String sql = "select ma, ten from MauSac";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                MauSac ms = new MauSac(null, ma, ten);
                listMS.add(ms);
            }
            return listMS;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhaSanXuat> getAllNhaSanXuat() {
        List<NhaSanXuat> listNSX = new ArrayList<>();
        ResultSet rs;
        String sql = "select ma, ten from NSX";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                NhaSanXuat nsx = new NhaSanXuat(null, ma, ten);
                listNSX.add(nsx);
            }
            return listNSX;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DongSanPham> getAllDongSanPham() {
        List<DongSanPham> listDSP = new ArrayList<>();
        ResultSet rs;
        String sql = "select ma, ten from DongSP";
        rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                DongSanPham dsp = new DongSanPham(null, ma, ten);
                listDSP.add(dsp);
            }
            return listDSP;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public  int addSanPham(SanPham sp) {
        String sql = "insert into SanPham(ma, ten) values (?,?) ";
        return JDBC_Helper.updateTongQuat(sql, sp.getMa(), sp.getTen());
    }

    public  int addMauSac(MauSac ms) {
        String sql = "insert into MauSac(ma, ten) values (?,?) ";
        return JDBC_Helper.updateTongQuat(sql, ms.getMa(), ms.getTen());
    }

    public  int addDongSP(DongSanPham dsp) {
        String sql = "insert into DongSP(ma, ten) values (?,?) ";
        return JDBC_Helper.updateTongQuat(sql, dsp.getMa(), dsp.getTen());
    }

    public  int addNhaSanXuat(NhaSanXuat sx) {
        String sql = "insert into NSX(ma, ten) values (?,?) ";
        return JDBC_Helper.updateTongQuat(sql, sx.getMa(), sx.getTen());
    }

    
}
