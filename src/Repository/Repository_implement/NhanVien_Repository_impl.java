/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Repository.NhanVien_Interface;
import Unility.JDBC_Helper;
import ViewModel.NhanVien_DN;
import ViewModel.NhanVien_View;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NhanVien_Repository_impl implements NhanVien_Interface {

    @Override
    public boolean DangNhapNhanVien(String email, String matKhau) {
        String sql = "select email, matKhau from NhanVien where email=? and matKhau=?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, email, matKhau);
        try {
            while (rs.next()) {
                String mal = rs.getString("email");
                String pass = rs.getString("matKhau");
                NhanVien_DN nv = new NhanVien_DN(mal, pass);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<NhanVien_View> getAllNhanVienView() {
        ArrayList<NhanVien_View> listNV = new ArrayList<>();
        String sql = "SELECT ma"
                + "      ,[Ten]\n"
                + "      ,[TenDem]\n"
                + "      ,[Ho]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String tenDem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                String GioiTinh = rs.getString("GioiTinh");
                String NgaySinh = rs.getString("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                int TrangThai = rs.getInt("TrangThai");
                NhanVien_View nvv = new NhanVien_View(ma, (ho + " " + tenDem + " " + ten), GioiTinh, DiaChi, NgaySinh, sdt, TrangThai);
                listNV.add(nvv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        String sql = "SELECT NhanVien.Id idnv ,NhanVien.[Ma] manv"
                + " ,NhanVien.[Ten] tennv ,[TenDem] ,[Ho] ,[GioiTinh]"
                + " ,[NgaySinh] ,NhanVien.[DiaChi] diaChinv ,[Sdt]"
                + " ,[MatKhau] ,[TrangThai] ,[email] ,CuaHang.[Id] idch"
                + " ,CuaHang.[Ma] mach ,CuaHang.[Ten] tench, ChucVu.[Id] idcv"
                + " ,ChucVu.[Ma] macv ,ChucVu.[Ten] tencv FROM [dbo].[NhanVien]"
                + " join ChucVu on NhanVien.idCV=ChucVu.id"
                + " join CuaHang on NhanVien.idCH=CuaHang.id";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while (rs.next()) {
                String idnv = rs.getString("idnv");
                String manv = rs.getString("manv");
                String tennv = rs.getString("tennv");
                String tenDem = rs.getString("tenDem");
                String ho = rs.getString("ho");
                String gioiTinh = rs.getString("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChinv = rs.getString("diaChinv");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                Integer trangThai = rs.getInt("trangThai");
                String email = rs.getString("email");
                String idch = rs.getString("idch");
                String mach = rs.getString("mach");
                String tench = rs.getString("tench");
                String idcv = rs.getString("idcv");
                String macv = rs.getString("macv");
                String tencv = rs.getString("tencv");
                ChucVu cv = new ChucVu(idcv, macv, tencv);
                CuaHang ch = new CuaHang(idch, mach, tench, null, null, null);
                NhanVien nv = new NhanVien(idnv, manv, tennv, tenDem, ho, gioiTinh, ngaySinh, diaChinv, sdt, matKhau, ch, cv, trangThai, email);
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addNhanVien(NhanVien nv) {
        String sql = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[TenDem]\n"
                + "           ,[Ho]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt]\n"
                + "           ,[MatKhau]\n"
                + "           ,[IdCH]\n"
                + "           ,[IdCV]\n"
                + "           ,[TrangThai]\n"
                + "           ,[email])\n"
                + "     VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return JDBC_Helper.updateTongQuat(sql, nv.getMa(), nv.getTen(), nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh(),
                nv.getDiaChi(), nv.getSoDienThoai(), nv.getMatKhau(), nv.getCuaHang().getId(), nv.getChucVu().getId(), nv.getTrangThai(), nv.getEmail());
    }

    @Override
    public int updateNhanVien(NhanVien nv) {
        String sql = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[TenDem] = ?\n"
                + "      ,[Ho] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[MatKhau] = ?\n"
                + "      ,[IdCH] = ?\n"
                + "      ,[IdCV] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[email] = ?\n"
                + " WHERE ma = ?";
        return JDBC_Helper.updateTongQuat(sql, nv.getTen(), nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh(), 
                nv.getDiaChi(), nv.getSoDienThoai(), nv.getMatKhau(), nv.getCuaHang().getId(), nv.getChucVu().getId(), nv.getTrangThai(), nv.getEmail(), nv.getMa());
    }

    @Override
    public int deleteNhanVien(String id) {
        String sql = "delete from NhanVien where ma = ?";
        return JDBC_Helper.updateTongQuat(sql, id);
    }

    @Override
    public String layChucVuByEmail(String email) {
        String sql = "select ChucVu.ten tencv from NhanVien join ChucVu on NhanVien.idCV=ChucVu.id where email = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, email);
        try {
            while (rs.next()) {
                String id = rs.getString("tencv");
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public NhanVien getAllNhanVienByMa(String maNV) {
        NhanVien nv = null;
        String sql = "SELECT NhanVien.Id idnv ,NhanVien.[Ma] manv"
                + " ,NhanVien.[Ten] tennv ,[TenDem] ,[Ho] ,[GioiTinh]"
                + " ,[NgaySinh] ,NhanVien.[DiaChi] diaChinv ,[Sdt]"
                + " ,[MatKhau] ,[TrangThai] ,[email] ,CuaHang.[Id] idch"
                + " ,CuaHang.[Ma] mach ,CuaHang.[Ten] tench, ChucVu.[Id] idcv"
                + " ,ChucVu.[Ma] macv ,ChucVu.[Ten] tencv FROM [dbo].[NhanVien]"
                + " join ChucVu on NhanVien.idCV=ChucVu.id"
                + " join CuaHang on NhanVien.idCH=CuaHang.id where NhanVien.ma=?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, maNV);
        try {
            while (rs.next()) {
                String idnv = rs.getString("idnv");
                String manv = rs.getString("manv");
                String tennv = rs.getString("tennv");
                String tenDem = rs.getString("tenDem");
                String ho = rs.getString("ho");
                String gioiTinh = rs.getString("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChinv = rs.getString("diaChinv");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                Integer trangThai = rs.getInt("trangThai");
                String email = rs.getString("email");
                String idch = rs.getString("idch");
                String mach = rs.getString("mach");
                String tench = rs.getString("tench");
                String idcv = rs.getString("idcv");
                String macv = rs.getString("macv");
                String tencv = rs.getString("tencv");
                ChucVu cv = new ChucVu(idcv, macv, tencv);
                CuaHang ch = new CuaHang(idch, mach, tench, null, null, null);
                nv = new NhanVien(idnv, manv, tennv, tenDem, ho, gioiTinh, ngaySinh, diaChinv, sdt, matKhau, ch, cv, trangThai, email);
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<NhanVien> getAllNhanVienByMaNV(String maNV) {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        String sql = "SELECT NhanVien.Id idnv ,NhanVien.[Ma] manv"
                + " ,NhanVien.[Ten] tennv ,[TenDem] ,[Ho] ,[GioiTinh]"
                + " ,[NgaySinh] ,NhanVien.[DiaChi] diaChinv ,[Sdt]"
                + " ,[MatKhau] ,[TrangThai] ,[email] ,CuaHang.[Id] idch"
                + " ,CuaHang.[Ma] mach ,CuaHang.[Ten] tench, ChucVu.[Id] idcv"
                + " ,ChucVu.[Ma] macv ,ChucVu.[Ten] tencv FROM [dbo].[NhanVien]"
                + " join ChucVu on NhanVien.idCV=ChucVu.id"
                + " join CuaHang on NhanVien.idCH=CuaHang.id where NhanVien.ma = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, maNV);
        try {
            while (rs.next()) {
                String idnv = rs.getString("idnv");
                String manv = rs.getString("manv");
                String tennv = rs.getString("tennv");
                String tenDem = rs.getString("tenDem");
                String ho = rs.getString("ho");
                String gioiTinh = rs.getString("gioiTinh");
                String ngaySinh = rs.getString("ngaySinh");
                String diaChinv = rs.getString("diaChinv");
                String sdt = rs.getString("sdt");
                String matKhau = rs.getString("matKhau");
                Integer trangThai = rs.getInt("trangThai");
                String email = rs.getString("email");
                String idch = rs.getString("idch");
                String mach = rs.getString("mach");
                String tench = rs.getString("tench");
                String idcv = rs.getString("idcv");
                String macv = rs.getString("macv");
                String tencv = rs.getString("tencv");
                ChucVu cv = new ChucVu(idcv, macv, tencv);
                CuaHang ch = new CuaHang(idch, mach, tench, null, null, null);
                NhanVien nv = new NhanVien(idnv, manv, tennv, tenDem, ho, gioiTinh, ngaySinh, diaChinv, sdt, matKhau, ch, cv, trangThai, email);
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
