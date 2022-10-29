/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.HoaDonChiTiet_View;

/**
 *
 * @author ACER
 */
public interface GioHang_Interface {
    public String layIdHoaDon(String maHD);
    
    public String layIdChiTietSP(String ten);
    
    public int luuHoaDonChiTiet(HoaDonChiTiet_View hd);
}
