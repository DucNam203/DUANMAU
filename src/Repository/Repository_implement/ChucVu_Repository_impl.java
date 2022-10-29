/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Repository_implement;

import DomainModels.ChucVu;
import Repository.ChucVu_Interface;
import Unility.JDBC_Helper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class ChucVu_Repository_impl implements ChucVu_Interface {

    @Override
    public List<ChucVu> getAllChucVu() {
        ArrayList<ChucVu> listCV = new ArrayList<>();
        String sql = "SELECT [Id]\n"
                + "      ,[Ma]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[ChucVu]";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql);
        try {
            while(rs.next()){
                String id = rs.getString("id");
                String ma = rs.getString("id");
                String ten = rs.getString("ten");
                ChucVu cv = new ChucVu(id, ma, ten);
                listCV.add(cv);
            }
            return listCV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ChucVu layIdChucVu(String ten) {
        String sql = "select id from ChucVu where ten = ?";
        ResultSet rs = JDBC_Helper.selectTongQuat(sql, ten);
        ChucVu cv = null;
        try {
            while(rs.next()){
                String id = rs.getString("id");
                cv = new ChucVu(id, null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cv;
    }

}
