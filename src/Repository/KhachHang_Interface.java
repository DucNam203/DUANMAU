/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.KhachHang;
import ViewModel.KhachHang_DN;

/**
 *
 * @author ACER
 */
public interface KhachHang_Interface {
//    public KhachHang_DN getAllKhachHangByEmail(String mail);
//    
//    public KhachHang_DN getAllKhachHangByMatKhau(String pass);
    public int addKhachHang(KhachHang kh);
    
    public int updateKhachHang(KhachHang kh);
    
    public boolean dangNhap(String email, String pass);
}
