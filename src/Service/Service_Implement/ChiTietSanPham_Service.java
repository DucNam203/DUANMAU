/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Repository.Repository_implement.SanPhamChiTiet_Repository_impl;
import Service.ChiTietSanPham_Interface;
import ViewModel.SanPhamChiTiet_View;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ChiTietSanPham_Service implements ChiTietSanPham_Interface{
    SanPhamChiTiet_Repository_impl spct = new SanPhamChiTiet_Repository_impl();
    public List<SanPhamChiTiet_View> getAllChiTietSanPhamView(){
        return spct.getAllChiTietSanPhamView();
    }

    @Override
    public ChiTietSanPham getAllChiTietSPByTenSP(String ten) {
        return spct.getAllChiTietSPByTenSP(ten);
    }

    @Override
    public int laySoLuong() {
        return spct.laySoLuong();
    }

    @Override
    public int themSanPhamChiTiet(ChiTietSanPham sp) {
        return spct.themSanPhamChiTiet(sp);
    }

    @Override
    public String layIdChiTietSanPham() {
        return spct.layIdChiTietSanPham();
    }

    @Override
    public MauSac layIdMauSac(String ten) {
        return spct.layIdMauSac(ten);
    }

    @Override
    public NhaSanXuat layIdNhaSanXuat(String ten) {
        return spct.layIdNhaSanXuat(ten);
    }

    @Override
    public DongSanPham layIdDongSanPham(String ten) {
        return spct.layIdDongSanPham(ten);
    }

    @Override
    public SanPham layIdSanPham(String ten) {
        return spct.layIdSanPham(ten);
    }

    @Override
    public int xoaSanPhamChiTiet(String id) {
        return spct.xoaSanPhamChiTiet(id);
    }

    @Override
    public int suaSanPhamChiTiet(ChiTietSanPham ctsp, String id) {
        return spct.suaSanPhamChiTiet(ctsp, id);
    }

    @Override
    public String layIdSanPhamByTen(String ten) {
        return spct.layIdSanPhamByTen(ten);
    }

    @Override
    public List<ChiTietSanPham> getAllChiTietSPByTen(String ten) {
        return spct.getAllChiTietSPByTen(ten);
    }

    
}
