/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import Repository.GioHang_Interface;
import Unility.JDBC_Helper;
import ViewModel.HoaDonChiTiet_View;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class GioHang_Repository_impl implements GioHang_Interface {

    @Override
    public String layIdHoaDon(String maHD) {
        String sql = "select id from HoaDon where ma = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, maHD);
        try {
            while (rs.next()) {
                String id = rs.getString("id");
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String layIdChiTietSP(String ten) {
        String sql = "select ChiTietSP.id idct from ChiTietSP join SanPham on SanPham.id=ChiTietSP.idSP where SanPham.ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        try {
            while(rs.next()){
                String tensp = rs.getString("idct");
                return tensp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int luuHoaDonChiTiet(HoaDonChiTiet_View hd) {
        String sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n" +
"           ([IdHoaDon]\n" +
"           ,[IdChiTietSP]\n" +
"           ,[SoLuong]\n" +
"           ,[DonGia])\n" +
"     VALUES (?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, hd.getIdHoaDon(), hd.getIdChiTietSP(), hd.getSoLuong(), hd.getDonGia());
    }
}
