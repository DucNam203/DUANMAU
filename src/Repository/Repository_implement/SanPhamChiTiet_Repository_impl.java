/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Repository.ChiTietSanPham_Interface;
import Unility.JDBC_Helper;
import ViewModel.SanPhamChiTiet_View;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class SanPhamChiTiet_Repository_impl implements ChiTietSanPham_Interface {

    @Override
    public List<SanPhamChiTiet_View> getAllChiTietSanPhamView() {
        List<SanPhamChiTiet_View> listCTSP = new ArrayList<>();
        String sql = "select SanPham.ten, namBh, mota, soLuongTon, giaNhap, giaBan from ChiTietSP join SanPham on ChiTietSP.idSP=SanPham.id";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ten = rs.getString("ten");
                int namBH = rs.getInt("namBH");
                String moTa = rs.getString("moTa");
                int soLuong = rs.getInt("soLuongTon");
                double giaNhap = rs.getDouble("giaNhap");
                double giaBan = rs.getDouble("giaBan");
                SanPhamChiTiet_View sp = new SanPhamChiTiet_View(ten, namBH, moTa, soLuong, giaNhap, giaBan);
                listCTSP.add(sp);
            }
            return listCTSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChiTietSanPham getAllChiTietSPByTenSP(String ten) {
        ResultSet rs;
        ChiTietSanPham ctsp = null;
        String sql = "select ChiTietSP.id idctsp, SanPham.Ten tensp, MauSac.Ten tenms,NSX.Ten tennsx, DongSP.Ten  tendsp"
                + " ,namBH, moTa, soLuongTon, giaNhap, giaBan from ChiTietSP "
                + "inner join SanPham on ChiTietSP.idSP=SanPham.id "
                + "inner join NSX on ChiTietSP.idNsx=NSX.id "
                + "inner join MauSac on ChiTietSP.idMauSac=MauSac.id "
                + "inner join DongSP on ChiTietSP.idDongSp=DongSP.id where SanPham.ten = ?";
        rs = JDBC_Helper.selectTongQuat(sql, ten);

        try {
            while (rs.next()) {
                String id = rs.getString("idctsp");
                String tensp = rs.getString("tensp");
                String tenMS = rs.getString("tenms");
                String tenNSX = rs.getString("tennsx");
                String tenDong = rs.getString("tendsp");
                int namBH = rs.getInt("nambh");
                String moTa = rs.getString("moTa");
                int soLuongTon = rs.getInt("soLuongTon");
                double giaNhap = rs.getDouble("giaNhap");
                double giaBan = rs.getDouble("giaBan");
                SanPham sap = new SanPham(null, null, tensp);
                MauSac ms = new MauSac(null, null, tenMS);
                NhaSanXuat nsx = new NhaSanXuat(null, null, tenNSX);
                DongSanPham dsp = new DongSanPham(null, null, tenDong);
                ctsp = new ChiTietSanPham(id, sap, nsx, ms, dsp, namBH, moTa, soLuongTon, giaNhap, giaBan);
            }
            return ctsp;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int laySoLuong() {
        String sql = "select soLuongTon from ChiTietSP";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                int soLuong = rs.getInt("soLuongTon");
                return soLuong;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public  String layIdChiTietSanPham() {
        String sql = "select id from ChiTietSP";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        SanPham sp = null;
        try {
            while (rs.next()) {
                String id = rs.getString(1);
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  MauSac layIdMauSac(String ten) {
        String sql = "select id from MauSac where ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        MauSac ms = null;
        try {
            while (rs.next()) {
                String id = rs.getString("id");
                ms = new MauSac(id, null, null);
            }
            return ms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public  NhaSanXuat layIdNhaSanXuat(String ten) {
        String sql = "select id from NSX where ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        NhaSanXuat sx = null;
        try {
            while (rs.next()) {
                String id = rs.getString("id");
                sx = new NhaSanXuat(id, null, null);
            }
            return sx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public  DongSanPham layIdDongSanPham(String ten) {
        String sql = "select id from DongSP where ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        DongSanPham dsp = null;
        try {
            while (rs.next()) {
                String id = rs.getString("id");
                dsp = new DongSanPham(id, null, null);
            }
            return dsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public  SanPham layIdSanPham(String ten) {
        String sql = "select id from SanPham where ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        SanPham sp = null;
        try {
            while (rs.next()) {
                String id = rs.getString("id");
                sp = new SanPham(id, null, null);
            }
            return sp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int themSanPhamChiTiet(ChiTietSanPham ctsp) {
        String sql = "insert into ChiTietSP(idSP, idNsx, idMauSac, idDongSP, namBH, moTa, soLuongTon, giaNhap, giaBan) values (?,?,?,?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, ctsp.getSanPham().getId(), ctsp.getNhaSanXuat().getId(), ctsp.getMauSac().getId(), ctsp.getDongSP().getId(), ctsp.getNamBaoHanh(),
                ctsp.getMoTa(), ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaXuat());
    }

    @Override
    public int xoaSanPhamChiTiet(String id) {
        String sql = "DELETE FROM [dbo].[ChiTietSP] WHERE id = ?";
        return JDBC_Helper.updateTongQuat(sql, id);
    }

    @Override
    public int suaSanPhamChiTiet(ChiTietSanPham ctsp, String id) {
        String sql = "declare @id uniqueidentifier set @id = (select id from SanPham where id=?) "
                + "update ChiTietSP set  idsp = ?, idNsx=?, idMauSac=?, idDongSP=?, namBH=?, moTa=?, soLuongTon=?, giaNhap=?, giaBan=? where @id=idSP";
        return JDBC_Helper.updateTongQuat(sql, id, ctsp.getSanPham().getId(), ctsp.getNhaSanXuat().getId(), ctsp.getMauSac().getId(), ctsp.getDongSP().getId(), ctsp.getNamBaoHanh(),
                ctsp.getMoTa(), ctsp.getSoLuongTon(), ctsp.getGiaNhap(), ctsp.getGiaXuat());
    }

    @Override
    public String layIdSanPhamByTen(String ten) {
        String sql = "select id from SanPham where ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        try {
            while(rs.next()){
                String id = rs.getString(1);
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> getAllChiTietSPByTen(String ten) {
        ArrayList<ChiTietSanPham> listCTSP = new ArrayList<>();
        ResultSet rs;
        ChiTietSanPham ctsp = null;
        String sql = "select ChiTietSP.id idctsp, SanPham.Ten tensp, MauSac.Ten tenms,NSX.Ten tennsx, DongSP.Ten  tendsp"
                + " ,namBH, moTa, soLuongTon, giaNhap, giaBan from ChiTietSP "
                + "inner join SanPham on ChiTietSP.idSP=SanPham.id "
                + "inner join NSX on ChiTietSP.idNsx=NSX.id "
                + "inner join MauSac on ChiTietSP.idMauSac=MauSac.id "
                + "inner join DongSP on ChiTietSP.idDongSp=DongSP.id where SanPham.ten = ?";
        rs = JDBC_Helper.selectTongQuat(sql, ten);

        try {
            while (rs.next()) {
                String id = rs.getString("idctsp");
                String tensp = rs.getString("tensp");
                String tenMS = rs.getString("tenms");
                String tenNSX = rs.getString("tennsx");
                String tenDong = rs.getString("tendsp");
                int namBH = rs.getInt("nambh");
                String moTa = rs.getString("moTa");
                int soLuongTon = rs.getInt("soLuongTon");
                double giaNhap = rs.getDouble("giaNhap");
                double giaBan = rs.getDouble("giaBan");
                SanPham sap = new SanPham(null, null, tensp);
                MauSac ms = new MauSac(null, null, tenMS);
                NhaSanXuat nsx = new NhaSanXuat(null, null, tenNSX);
                DongSanPham dsp = new DongSanPham(null, null, tenDong);
                ctsp = new ChiTietSanPham(id, sap, nsx, ms, dsp, namBH, moTa, soLuongTon, giaNhap, giaBan);
                listCTSP.add(ctsp);
            }
            return listCTSP;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
