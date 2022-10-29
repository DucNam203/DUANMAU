/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Service_Implement;

import DomainModels.ChucVu;
import Repository.Repository_implement.ChucVu_Repository_impl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ChucVu_Service_impl implements Service.ChucVu_Service_impl{
    ChucVu_Repository_impl chucVuRP = new ChucVu_Repository_impl();
    
    @Override
    public List<ChucVu> getAllChucVu() {
        return chucVuRP.getAllChucVu();
    }

    @Override
    public ChucVu layIdChucVu(String ten) {
        return chucVuRP.layIdChucVu(ten);
    }
    
}
