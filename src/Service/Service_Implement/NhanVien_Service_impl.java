/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import DomainModels.NhanVien;
import Repository.Repository_implement.NhanVien_Repository_impl;
import Service.NhanVien_Interface;
import ViewModel.NhanVien_View;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NhanVien_Service_impl implements NhanVien_Interface{
    NhanVien_Repository_impl nhanVienRP = new NhanVien_Repository_impl();
    @Override
    public boolean DangNhapNhanVien(String email, String matKhau) {
        return nhanVienRP.DangNhapNhanVien(email, matKhau);
    }

    @Override
    public List<NhanVien_View> getAllNhanVienView() {
        return nhanVienRP.getAllNhanVienView();
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRP.getAllNhanVien();
    }

    @Override
    public String layChucVuByEmail(String email) {
        return nhanVienRP.layChucVuByEmail(email);
    }

    @Override
    public int addNhanVien(NhanVien nv) {
        return nhanVienRP.addNhanVien(nv);
    }

    @Override
    public int updateNhanVien(NhanVien nv) {
        return nhanVienRP.updateNhanVien(nv);
    }

    @Override
    public int deleteNhanVien(String id) {
        return nhanVienRP.deleteNhanVien(id);
    }

    @Override
    public NhanVien getAllNhanVienByMa(String maNV) {
        return nhanVienRP.getAllNhanVienByMa(maNV);
    }

    @Override
    public List<NhanVien> getAllNhanVienByMaNV(String maNV) {
        return nhanVienRP.getAllNhanVienByMaNV(maNV);
    }
    
    
}
