/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhachHang;

/**
 *
 * @author ACER
 */
public interface KhachHang_Interface {
    public boolean getAllKhachHangByDangNhap(String mail, String pass);
    
    public int addKhachHang(KhachHang kh);
    
    public int updateKhachHang(KhachHang kh);
}
