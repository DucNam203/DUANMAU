/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Repository.Repository_implement.ThongTinSanPham_Repository_impl;
import Service.ThongTinSanPham_Interface;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ThongTinSanPham_Service_impl implements ThongTinSanPham_Interface{
    ThongTinSanPham_Repository_impl thongTinSanPham = new ThongTinSanPham_Repository_impl();
        
    @Override
    public List<SanPham> getAllSanPham() {
        return thongTinSanPham.getAllSanPham();
    }

    @Override
    public List<MauSac> getAllMauSac() {
        return thongTinSanPham.getAllMauSac();
    }

    @Override
    public List<NhaSanXuat> getAllNhaSanXuat() {
        return thongTinSanPham.getAllNhaSanXuat();
    }

    @Override
    public List<DongSanPham> getAllDongSanPham() {
        return thongTinSanPham.getAllDongSanPham();
    }

    @Override
    public int addSanPham(SanPham sp) {
        return thongTinSanPham.addSanPham(sp);
    }

    @Override
    public int addMauSac(MauSac ms) {
        return thongTinSanPham.addMauSac(ms);
    }

    @Override
    public int addNhaSanXuat(NhaSanXuat sx) {
        return thongTinSanPham.addNhaSanXuat(sx);
    }

    @Override
    public int addDongSP(DongSanPham dsp) {
        return thongTinSanPham.addDongSP(dsp);
    }
    
}
