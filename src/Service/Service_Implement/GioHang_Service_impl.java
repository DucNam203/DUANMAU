/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import Repository.Repository_implement.GioHang_Repository_impl;
import Service.GioHang_Interface;
import ViewModel.HoaDonChiTiet_View;

/**
 *
 * @author ACER
 */
public class GioHang_Service_impl implements GioHang_Interface{
    GioHang_Repository_impl gh = new GioHang_Repository_impl();
    
    @Override
    public String layIdHoaDon(String maHD) {
        return gh.layIdHoaDon(maHD);
    }

    @Override
    public String layIdChiTietSP(String ten) {
        return gh.layIdChiTietSP(ten);
    }

    @Override
    public int luuHoaDonChiTiet(HoaDonChiTiet_View hd) {
        return gh.luuHoaDonChiTiet(hd);
    }
    
}
