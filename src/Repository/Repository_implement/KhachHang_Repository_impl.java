/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import DomainModels.KhachHang;
import Repository.KhachHang_Interface;
import Unility.JDBC_Helper;
import ViewModel.KhachHang_DN;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class KhachHang_Repository_impl implements KhachHang_Interface{

    @Override
    public boolean dangNhap(String email, String pass) {
        String sql = "select email, matKhau from KhachHang where email=? and matKhau = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, email, pass);
        try {
            while(rs.next()){
                String mal = rs.getString(1);
                String matkhau = rs.getString(2);
                KhachHang_DN kh = new KhachHang_DN(mal, matkhau);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    
    
    
//    @Override
//    public KhachHang_DN getAllKhachHangByEmail(String mail) {
//        KhachHang_DN kh = null;
//        String sql = "select email from KhachHang where email = ?";
//        ResultSet rs = JDBC_Helper.selectTongQuat(sql, mail);
//        try {
//            while(rs.next()){
//                String email = rs.getString("email");
//                kh = new KhachHang_DN(null, email);
//            }
//            return kh;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public KhachHang_DN getAllKhachHangByMatKhau(String pass) {
//        KhachHang_DN kh = null;
//        String sql = "select matKhau from KhachHang where matKhau = ?";
//        ResultSet rs = JDBC_Helper.selectTongQuat(sql, pass);
//        try {
//            while(rs.next()){
//                String matKhau = rs.getString("matKhau");
//                kh = new KhachHang_DN(null, matKhau);
//            }
//            return kh;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
    public static void main(String[] args) {
        KhachHang_Repository_impl kh = new KhachHang_Repository_impl();
        System.out.println(kh.dangNhap("namnam@gmail.com", "nam11ewf1"));
    }

    @Override
    public int addKhachHang(KhachHang kh) {
        String sql = "insert into KhachHang(ma, matKhau, email) values (?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, kh.getMa(), kh.getMatkhau(),kh.getEmail());
    }

    @Override
    public int updateKhachHang(KhachHang kh) {
        String sql = "update KhachHang set ten=?, tenDem=?, ho=?, ngaySinh=?, sdt=?, diaChi=?, thanhPho=?, quocGia=? where ma=?";
        return JDBC_Helper.updateTongQuat(sql, kh.getTen() ,kh.getTenDem(), kh.getHo(), kh.getNgaySinh(), kh.getSdt(), kh.getDiaChi(), kh.getThanhPho(), kh.getQuocGia(), kh.getMa());
    }
    
    
}
