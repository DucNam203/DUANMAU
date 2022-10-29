/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import Repository.HoaDon_Interface;
import Unility.JDBC_Helper;
import ViewModel.HoaDon_View;
import ViewModel.HoaDonn;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class HoaDon_Repository_impl implements HoaDon_Interface {

    @Override
    public List<HoaDon_View> getAllHoaDon() {
        ArrayList<HoaDon_View> listHDV = new ArrayList<>();
        String sql = "select ma, ngayTao, tinhTrang, soLuong, donGia from HoaDon join HoaDonChiTiet on HoaDon.id=HoaDonChiTiet.idHoaDon";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                Date ngayTao = rs.getDate("ngayTao");
                int tinhTrang = rs.getInt("tinhTrang");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                HoaDon_View hsv = new HoaDon_View(ma, ngayTao, tinhTrang, soLuong, donGia);
                listHDV.add(hsv);
            }
            return listHDV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public HoaDon_View getAllHoaDonByMa(String maHD) {
        HoaDon_View hdv = null;
        String sql = "select ma, ngayTao, tinhTrang, soLuong, donGia from HoaDon join HoaDonChiTiet on HoaDon.id=HoaDonChiTiet.idHoaDon where ma = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, maHD);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                Date ngayTao = rs.getDate("ngayTao");
                int tinhTrang = rs.getInt("tinhTrang");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                hdv = new HoaDon_View(ma, ngayTao, tinhTrang, soLuong, donGia);
            }
            return hdv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<HoaDonn> getAllHoaDonByTrangThai(int trangThai) {
        List<HoaDonn> listHDV = new ArrayList<>();
        String sql = "select ma, ngayTao, tinhTrang from HoaDon where tinhTrang = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, trangThai);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                Date ngayTao = rs.getDate("ngayTao");
                int tinhTrang = rs.getInt("tinhTrang");
                HoaDonn hdv = new HoaDonn(ma, ngayTao, tinhTrang);
                listHDV.add(hdv);
            }
            return listHDV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int demMaHoaDon() {
        String sql = "select count(*) from HoaDon";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        int row;
        try {
            while (rs.next()) {
                row = rs.getInt(1);
                return row;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public int saveHoaDon(HoaDon_View hdv) {
        String sql = "insert into HoaDon(ma, ngayTao, tinhTrang) values (?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, hdv.getMa(), hdv.getNgayTao(), hdv.getTinhTrang());
    }

    @Override
    public List<HoaDonn> getAllHoaDonView() {
        List<HoaDonn> listHD = new ArrayList<>();
        String sql = "select ma, ngayTao, tinhTrang from HoaDon";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                Date ngayTao = rs.getDate("ngayTao");
                int tinhTrang = rs.getInt("tinhTrang");
                HoaDonn hd = new HoaDonn(ma, ngayTao, tinhTrang);
                listHD.add(hd);
            }
            return listHD;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateThanhCong(HoaDonn hd) {
        String sql = "update HoaDon set tinhTrang = ? where ma=?";
        return JDBC_Helper.updateTongQuat(sql, hd.getTinhTrang(), hd.getMa());
    }

    @Override
    public int updateHuy(HoaDonn hd) {
        String sql = "update HoaDon set tinhTrang = ? where ma=?";
        return JDBC_Helper.updateTongQuat(sql, hd.getTinhTrang(), hd.getMa());
    }

    @Override
    public HoaDonn getAllHoaDonByMaHD(String maHD) {
        HoaDonn hdv = null;
        String sql = "select ma, ngayTao, tinhTrang from HoaDon where ma = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, maHD);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                Date ngayTao = rs.getDate("ngayTao");
                int tinhTrang = rs.getInt("tinhTrang");
                hdv = new HoaDonn(ma, ngayTao, tinhTrang);
            }
            return hdv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
