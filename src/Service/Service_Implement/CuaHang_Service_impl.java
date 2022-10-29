/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import DomainModels.CuaHang;
import Repository.Repository_implement.CuaHang_Repository_impl;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CuaHang_Service_impl implements Service.CuaHang_Service_impl{
    CuaHang_Repository_impl cuahangRP = new CuaHang_Repository_impl();
    
    @Override
    public List<CuaHang> getAllCuaHang() {
        return cuahangRP.getAllCuaHang();
    }

    @Override
    public CuaHang layIdCuaHang(String ten) {
        return cuahangRP.layIdCuaHang(ten);
    }
}
