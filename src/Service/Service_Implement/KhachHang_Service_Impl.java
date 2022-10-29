/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import DomainModels.KhachHang;
import Repository.Repository_implement.KhachHang_Repository_impl;
import Service.KhachHang_Interface;
import ViewModel.KhachHang_DN;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhachHang_Service_Impl implements KhachHang_Interface {

    KhachHang_Repository_impl khachHangRP = new KhachHang_Repository_impl();

    @Override
    public boolean getAllKhachHangByDangNhap(String mail, String pass) {
        return khachHangRP.dangNhap(mail, pass);
    }

    public static void main(String[] args) {
        KhachHang_Service_Impl kh = new KhachHang_Service_Impl();
        System.out.println(kh.getAllKhachHangByDangNhap("namnam@gmail.com", "nam111"));
    }

    @Override
    public int addKhachHang(KhachHang kh) {
        return khachHangRP.addKhachHang(kh);
    }

    @Override
    public int updateKhachHang(KhachHang kh) {
        return khachHangRP.updateKhachHang(kh);
    }

}
