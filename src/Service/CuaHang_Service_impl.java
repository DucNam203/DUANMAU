/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.CuaHang;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CuaHang_Service_impl {
    public List<CuaHang> getAllCuaHang();
    
    public CuaHang layIdCuaHang(String ten);
}
