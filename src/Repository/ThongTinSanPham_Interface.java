/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ThongTinSanPham_Interface {

    public List<SanPham> getAllSanPham();

    public List<MauSac> getAllMauSac();

    public List<NhaSanXuat> getAllNhaSanXuat();

    public List<DongSanPham> getAllDongSanPham();
    
    public int addSanPham(SanPham sp);
    
    public int addMauSac(MauSac ms);
    
    public int addNhaSanXuat(NhaSanXuat sx);
    
    public int addDongSP(DongSanPham dsp);
}
