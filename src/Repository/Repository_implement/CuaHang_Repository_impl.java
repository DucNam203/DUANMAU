/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import DomainModels.CuaHang;
import Repository.CuaHang_Interface;
import Unility.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class CuaHang_Repository_impl implements CuaHang_Interface {

    @Override
    public List<CuaHang> getAllCuaHang() {
        ArrayList<CuaHang> listCH = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "      ,[DiaChi]\n"
                + "      ,[ThanhPho]\n"
                + "      ,[QuocGia]\n"
                + "  FROM [dbo].[CuaHang]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while(rs.next()){
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String diaChi = rs.getString("diaChi");
                String thanhPho = rs.getString("thanhPho");
                String quocgia = rs.getString("quocGia");
                CuaHang ch = new CuaHang(id, ma, ten, diaChi, thanhPho, quocgia);
                listCH.add(ch);
            }
            return listCH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CuaHang layIdCuaHang(String ten) {
        String sql = "select id from CuaHang where ten = ?";
        CuaHang ch = null;
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        try {
            while(rs.next()){
                String id = rs.getString("id");
                ch = new CuaHang(id, null, null, null, null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ch;
    }
    
    

}
