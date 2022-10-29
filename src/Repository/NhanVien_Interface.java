/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.NhanVien;
import View.QLNhanVien;
import ViewModel.NhanVien_View;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface NhanVien_Interface {
    public boolean DangNhapNhanVien(String email, String matKhau);
    
    public List<NhanVien_View> getAllNhanVienView();
    
    public List<NhanVien> getAllNhanVien();
    
    public int addNhanVien(NhanVien nv);
    
    public int updateNhanVien(NhanVien nv);
    
    public int deleteNhanVien(String id);
    
    public String layChucVuByEmail(String email);
    
    public NhanVien getAllNhanVienByMa(String maNV);
    
    public List<NhanVien> getAllNhanVienByMaNV(String maNV);
    
}
