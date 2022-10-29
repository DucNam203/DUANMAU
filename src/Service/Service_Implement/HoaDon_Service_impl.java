/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import Repository.Repository_implement.HoaDon_Repository_impl;
import Service.HoaDon_Interface;
import ViewModel.HoaDon_View;
import ViewModel.HoaDonn;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HoaDon_Service_impl implements HoaDon_Interface{
    HoaDon_Repository_impl HDRP = new HoaDon_Repository_impl();
    
    @Override
    public List<HoaDon_View> getAllHoaDon() {
        return HDRP.getAllHoaDon();
    }

    @Override
    public HoaDon_View getAllHoaDonByMa(String maHD) {
        return HDRP.getAllHoaDonByMa(maHD);
    }

    @Override
    public List<HoaDonn> getAllHoaDonByTrangThai(int trangThai) {
        return HDRP.getAllHoaDonByTrangThai(trangThai);
    }

    @Override
    public int saveHoaDon(HoaDon_View hdv) {
        return HDRP.saveHoaDon(hdv);
    }

    @Override
    public int demMaHoaDon() {
        return HDRP.demMaHoaDon();
    }

    @Override
    public List<HoaDonn> getAllHoaDonView() {
        return HDRP.getAllHoaDonView();
    }

    @Override
    public int updateThanhCong(HoaDonn hd) {
        return HDRP.updateThanhCong(hd);
    }

    @Override
    public int updateHuy(HoaDonn hd) {
        return HDRP.updateHuy(hd);
    }

    @Override
    public HoaDonn getAllHoaDonByMaHD(String maHD) {
        return HDRP.getAllHoaDonByMaHD(maHD);
    }
    
}
