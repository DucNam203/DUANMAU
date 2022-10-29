/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import ViewModel.SanPhamChiTiet_View;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ChiTietSanPham_Interface {

    public List<SanPhamChiTiet_View> getAllChiTietSanPhamView();

    public ChiTietSanPham getAllChiTietSPByTenSP(String ten);
    
    public List<ChiTietSanPham> getAllChiTietSPByTen(String ten);

    public int laySoLuong();

    public int themSanPhamChiTiet(ChiTietSanPham sp);

    public String layIdChiTietSanPham();
    
    public String layIdSanPhamByTen(String ten);

    public MauSac layIdMauSac(String ten);

    public NhaSanXuat layIdNhaSanXuat(String ten);

    public DongSanPham layIdDongSanPham(String ten);
    
    public SanPham layIdSanPham(String ten);
    
    public int xoaSanPhamChiTiet(String id);
    
    public int suaSanPhamChiTiet(ChiTietSanPham ctsp, String id);
}
