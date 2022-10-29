/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModel.HoaDon_View;
import ViewModel.HoaDonn;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface HoaDon_Interface {
    public List<HoaDon_View> getAllHoaDon();
    
    public HoaDon_View getAllHoaDonByMa(String maHD);
    
    public HoaDonn getAllHoaDonByMaHD(String maHD);
    
    public List<HoaDonn> getAllHoaDonByTrangThai(int trangThai);
    
    public int demMaHoaDon();
    
    public int saveHoaDon(HoaDon_View hdv);
    
    public List<HoaDonn> getAllHoaDonView();
    
    public int updateThanhCong(HoaDonn hd);
    
    public int updateHuy(HoaDonn hd);
    
}
