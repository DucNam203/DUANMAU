/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ChucVu;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ChucVu_Service_impl {
    public List<ChucVu> getAllChucVu();
    
    public ChucVu layIdChucVu(String ten);
}
