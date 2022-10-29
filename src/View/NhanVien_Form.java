/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Service.Service_Implement.ChiTietSanPham_Service;
import Service.Service_Implement.GioHang_Service_impl;
import Service.Service_Implement.HoaDon_Service_impl;
import Service.Service_Implement.NhanVien_Service_impl;
import Service.Service_Implement.ThongTinSanPham_Service_impl;
import ViewModel.GioHang_View;
import ViewModel.HoaDonChiTiet_View;
import ViewModel.HoaDon_View;
import ViewModel.HoaDonn;
import ViewModel.SanPhamChiTiet_View;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class NhanVien_Form extends javax.swing.JFrame {
//---------------------------------------

    List<ChiTietSanPham> listCTSP;
    List<HoaDonn> hoaDonV;
    List<HoaDon_View> listHDV;
    List<SanPhamChiTiet_View> listCTSPV;
    List<SanPham> listSP;
    List<MauSac> listMS;
    List<NhaSanXuat> listNSX;
    List<DongSanPham> listDSP;
    ArrayList<GioHang_View> listGH = new ArrayList<>();
//---------------------------------------
    DefaultTableModel model;
    DefaultTableModel modelGioHang;
    //-----------------------------------
    ChiTietSanPham_Service SanPhamService = new ChiTietSanPham_Service();
    ThongTinSanPham_Service_impl thongTinSP = new ThongTinSanPham_Service_impl();
    HoaDon_Service_impl hoaDonService = new HoaDon_Service_impl();
    GioHang_Service_impl gioHangService = new GioHang_Service_impl();
    NhanVien_Service_impl nhanVienSV = new NhanVien_Service_impl();
    //-----------------------------------
    int soLuong = SanPhamService.laySoLuong();
    private String textfi;
    public NhanVien_Form(String text1) {
        initComponents();
        setLocationRelativeTo(null);
        rdoTatCa.setSelected(true);
        txtSoLuong.setText("1");
        this.textfi = text1;
        this.text.setText(text1);
        if(text.getText().equals("nhân viên")){
            btnQuanLyNhanVien.setVisible(false);
        }
        //add combobox
        fillCBBSanPham();
        fillCBBMauSac();
        fillCBBNhaSanXuat();
        fillCBBDongSP();
        //-----------------
        fillTableChiTietSanPham();
        fillTableHoaDon1();
    }
    

    private void fillTableChiTietSPByTen(String ten) {
        listCTSP = SanPhamService.getAllChiTietSPByTen(ten);
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ChiTietSanPham CTSP : listCTSP) {
            Object[] data = {
                CTSP.getSanPham().getTen(),
                CTSP.getNamBaoHanh(),
                CTSP.getMoTa(),
                CTSP.getSoLuongTon(),
                CTSP.getGiaNhap(),
                CTSP.getGiaXuat()
            };
            model.addRow(data);
        }

    }
    

    private void addGioHang(List<GioHang_View> listGH) {
        modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelGioHang.setRowCount(0);
        int d = 1;
        for (GioHang_View gd : listGH) {
            Object[] data = {
                d++,
                gd.getTen(),
                gd.getSoLuong(),
                gd.getDonGia(),
                gd.getSoLuong() * gd.getDonGia()
            };
            modelGioHang.addRow(data);
        }
    }

    private void fillTableChiTietSanPham() {
        listCTSPV = SanPhamService.getAllChiTietSanPhamView();
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPhamChiTiet_View ctsp : listCTSPV) {
            Object[] data = {
                ctsp.getTenSanPham(),
                ctsp.getNamBH(),
                ctsp.getMoTa(),
                ctsp.getSoLuongTon(),
                ctsp.getGiaNhap(),
                ctsp.getGiaBan()
            };
            model.addRow(data);
        }
    }

    private void fillTableHoaDon() {
        listHDV = hoaDonService.getAllHoaDon();
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int STT = 1;
        String tinhTrang = null;
        for (HoaDon_View HDV : listHDV) {
            if (HDV.getTinhTrang() == 1) {
                tinhTrang = "Đã thanh toán";
            } else if (HDV.getTinhTrang() == 2) {
                tinhTrang = "Chờ thanh toán";
            } else if (HDV.getTinhTrang() == 3) {
                tinhTrang = "Hủy";
            }
            Object[] data = {
                STT++,
                HDV.getMa(),
                HDV.getNgayTao(),
                tinhTrang
            };
            model.addRow(data);
        }
    }

    private void fillTableHoaDon1() {
        hoaDonV = hoaDonService.getAllHoaDonView();
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int STT = 1;
        String tinhTrang = null;
        for (HoaDonn HDV : hoaDonV) {
            if (HDV.getTinhTrang() == 1) {
                tinhTrang = "Đã thanh toán";
            } else if (HDV.getTinhTrang() == 2) {
                tinhTrang = "Chờ thanh toán";
            } else if (HDV.getTinhTrang() == 3) {
                tinhTrang = "Hủy";
            }
            Object[] data = {
                STT++,
                HDV.getMa(),
                HDV.getNgayTao(),
                tinhTrang
            };
            model.addRow(data);
        }
    }

    private void fillTableHoaDonByTinhTrang(int tinhTrang1) {
        hoaDonV = hoaDonService.getAllHoaDonByTrangThai(tinhTrang1);
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int STT = 1;
        String tinhTrang = null;
        for (HoaDonn HDV : hoaDonV) {
            if (HDV.getTinhTrang() == 1) {
                tinhTrang = "Đã thanh toán";
            } else if (HDV.getTinhTrang() == 2) {
                tinhTrang = "Chờ thanh toán";
            } else if (HDV.getTinhTrang() == 3) {
                tinhTrang = "Hủy";
            }
            Object[] data = {
                STT++,
                HDV.getMa(),
                HDV.getNgayTao(),
                tinhTrang
            };
            model.addRow(data);
        }
    }

    private void fillCBBSanPham() {
        cbbTenSanPham.removeAllItems();
        listSP = thongTinSP.getAllSanPham();
        for (SanPham sp : listSP) {
            cbbTenSanPham.addItem(sp.getTen());
        }
    }

    private void fillCBBMauSac() {
        cbbMauSac.removeAllItems();
        listMS = thongTinSP.getAllMauSac();
        for (MauSac ms : listMS) {
            cbbMauSac.addItem(ms.getTen());
        }
    }

    private void fillCBBNhaSanXuat() {
        cbbNhaSanXuat.removeAllItems();
        listNSX = thongTinSP.getAllNhaSanXuat();
        for (NhaSanXuat sx : listNSX) {
            cbbNhaSanXuat.addItem(sx.getTen());
        }
    }

    private void fillCBBDongSP() {
        cbbDongSanPham.removeAllItems();
        listDSP = thongTinSP.getAllDongSanPham();
        for (DongSanPham dsp : listDSP) {
            cbbDongSanPham.addItem(dsp.getTen());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnTrangSau = new javax.swing.JButton();
        lblDemTrang = new javax.swing.JLabel();
        btnTrangTiep = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnThemGioHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNamBaoHanh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        efd = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCong = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        cbbTenSanPham = new javax.swing.JComboBox<>();
        cbbNhaSanXuat = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbDongSanPham = new javax.swing.JComboBox<>();
        btnThemThongTinSanPham = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnQuanLyNhanVien = new javax.swing.JButton();
        text = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoHuy = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoTatCa = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Năm Bảo Hành", "Mô tả", "Số lượng tồn", "Giá Nhập", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnTrangSau.setText("trang sau");

        lblDemTrang.setText("1/5");

        btnTrangTiep.setText("trang tiếp");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnThemGioHang.setText("Thêm vào giỏ hàng");
        btnThemGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThemGioHang)
                        .addGap(31, 31, 31)
                        .addComponent(btnTrangSau)
                        .addGap(71, 71, 71)
                        .addComponent(lblDemTrang)
                        .addGap(65, 65, 65)
                        .addComponent(btnTrangTiep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrangSau)
                    .addComponent(lblDemTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrangTiep)
                    .addComponent(btnTimKiem)
                    .addComponent(btnThemGioHang))
                .addGap(26, 26, 26))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "sản phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Tên sản phẩm:");

        jLabel2.setText("Giá Nhập:");

        jLabel3.setText("Năm bảo hành:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Số Lượng:");

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        efd.setText("Giá bán:");

        jLabel6.setText("Mô tả:");

        jLabel5.setText("Nhà sản xuất:");

        jLabel7.setText("Màu sắc:");

        jLabel8.setText("Dòng sản phẩm:");

        btnCong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });

        btnTru.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });

        cbbTenSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTenSanPham.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTenSanPhamItemStateChanged(evt);
            }
        });

        cbbNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbDongSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThemThongTinSanPham.setText("Thêm thông tin sản phẩm");
        btnThemThongTinSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThongTinSanPhamActionPerformed(evt);
            }
        });

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane5.setViewportView(txtMoTa);

        btnQuanLyNhanVien.setText("Quản lý nhân viên");
        btnQuanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNhanVienActionPerformed(evt);
            }
        });

        text.setEnabled(false);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(text))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemThongTinSanPham)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(74, 74, 74))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGiaNhap))
                                        .addGap(53, 53, 53)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(efd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemThongTinSanPham)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(efd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnTru)
                                .addComponent(btnCong))
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel1);

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdoChoThanhToan);
        rdoChoThanhToan.setText("Chờ thanh toán");
        rdoChoThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChoThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHuy);
        rdoHuy.setText("Đã hủy");
        rdoHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHuyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán");
        rdoDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(rdoChoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoChoThanhToan)
                    .addComponent(rdoHuy)
                    .addComponent(rdoDaThanhToan)
                    .addComponent(rdoTatCa))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Mã hóa đơn");

        txtMaHoaDon.setEnabled(false);

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Ngày tạo:");

        txtNgayTao.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Tổng tiền:");

        txtTongTien.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tiền khách đưa:");

        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Tiền thừa:");

        txtTienThua.setEnabled(false);
        txtTienThua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienThuaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayTao)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa Đơn", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        int index = tblSanPham.getSelectedRow();
        model = (DefaultTableModel) tblSanPham.getModel();
        String ten = tblSanPham.getValueAt(index, 0).toString();
        ChiTietSanPham sp = SanPhamService.getAllChiTietSPByTenSP(ten);
        showChiTietSanPham(sp);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String text = JOptionPane.showInputDialog("");
        ChiTietSanPham ctsp = SanPhamService.getAllChiTietSPByTenSP(text);
        showChiTietSanPham(ctsp);
        fillTableChiTietSPByTen(text);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGioHangActionPerformed
        // TODO add your handling code here:
        GioHang_View cthd = new GioHang_View();
        if(cthd.equals(null)){
            return;
        }
        int row = tblSanPham.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Ban chua chon san pham muon mua");
            return;
        }
        cthd.setTen(tblSanPham.getValueAt(row, 0).toString());
        String text = JOptionPane.showInputDialog(this, "Nhap so luong muon mua");
        cthd.setSoLuong(Integer.parseInt(text));
        
//        if(){
//            JOptionPane.showMessageDialog(this, "Chua nhap so luong");
//            return;
//        }
        cthd.setDonGia(Double.parseDouble(tblSanPham.getValueAt(row, 5).toString()));
        listGH.add(cthd);
        addGioHang(listGH);
                for(int f=0; f<listGH.size(); f++){
                    if(cbbTenSanPham.getSelectedItem().equals(listGH.get(f).getTen())){
                        cthd.setSoLuong(Integer.parseInt(txtSoLuong.getText())+listGH.get(f).getSoLuong());
                        remove(f);
        //                listCTHD.remove(f);
                    }
                }
    }//GEN-LAST:event_btnThemGioHangActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Insert", "confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            ChiTietSanPham ctsp = getFormSanPham();
            SanPhamService.themSanPhamChiTiet(ctsp);
            fillTableChiTietSanPham();
            JOptionPane.showMessageDialog(this, "them thanh cong");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Update", "confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            String sp1 = SanPhamService.layIdSanPhamByTen(String.valueOf(cbbTenSanPham.getSelectedItem()));
            ChiTietSanPham ctsp = getFormSanPham();
            SanPhamService.suaSanPhamChiTiet(ctsp, sp1);
            fillTableChiTietSanPham();
            JOptionPane.showMessageDialog(this, "Sua thanh cong");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "delete", "confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            ChiTietSanPham ctsp = getFormSanPham();
            String idCTSP = SanPhamService.layIdChiTietSanPham();
            SanPhamService.xoaSanPhamChiTiet(idCTSP);
            System.out.println(ctsp.getId());
            fillTableChiTietSanPham();
            JOptionPane.showMessageDialog(this, "xoa thanh cong");
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        soLuong++;
        txtSoLuong.setText(String.valueOf(soLuong));
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        // TODO add your handling code here:
        if (checkSoLuong()) {
            soLuong--;
            txtSoLuong.setText(String.valueOf(soLuong));
        }
    }//GEN-LAST:event_btnTruActionPerformed

    public boolean checkSoLuong() {
        if (soLuong <= 1) {
            JOptionPane.showMessageDialog(this, "Số lượng quá thấp!!");
            return false;
        }
        return true;
    }


    private void cbbTenSanPhamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTenSanPhamItemStateChanged
        // TODO add your handling code here:
        //        if (cbbTenSanPham.getItemCount() > 0) {
        //
        //        }
    }//GEN-LAST:event_cbbTenSanPhamItemStateChanged

    private void btnThemThongTinSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThongTinSanPhamActionPerformed
        // TODO add your handling code here:
        ThongTinSanPham ttsp = new ThongTinSanPham();
        ttsp.setVisible(true);
    }//GEN-LAST:event_btnThemThongTinSanPhamActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:

        int index = tblHoaDon.getSelectedRow();

        model = (DefaultTableModel) tblHoaDon.getModel();
        String maHD = tblHoaDon.getValueAt(index, 1).toString();
        try {
            HoaDon_View hd = hoaDonService.getAllHoaDonByMa(maHD);
            showHoaDon(hd);
            txtTienKhachDua.setText("");
            txtTienThua.setText("");
        } catch (Exception e) {
            HoaDonn hd1 = hoaDonService.getAllHoaDonByMaHD(maHD);
            showHoaDon1(hd1);
            txtTongTien.setText("");
            txtTienKhachDua.setText("");
            txtTienThua.setText("");
        }

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        HoaDon_View hd = getFormHoaDon();
        hoaDonService.saveHoaDon(hd);
        fillTableHoaDon1();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void rdoChoThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChoThanhToanActionPerformed
        // TODO add your handling code here:
        int tt = 2;
        hoaDonV = hoaDonService.getAllHoaDonByTrangThai(tt);
        fillTableHoaDonByTinhTrang(tt);
    }//GEN-LAST:event_rdoChoThanhToanActionPerformed

    private void rdoHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHuyActionPerformed
        // TODO add your handling code here:
        hoaDonV = hoaDonService.getAllHoaDonByTrangThai(3);
        fillTableHoaDonByTinhTrang(3);

//        fillThanhCong(tt);
    }//GEN-LAST:event_rdoHuyActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed
        hoaDonV = hoaDonService.getAllHoaDonByTrangThai(1);
        fillTableHoaDonByTinhTrang(1);

//        fillThanhCong(tt);
    }//GEN-LAST:event_rdoDaThanhToanActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
        // TODO add your handling code here:
        fillTableHoaDon1();
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        ArrayList<HoaDonChiTiet_View> listHDCT = new ArrayList<>();
        for (GioHang_View hdct : listGH) {
            HoaDonChiTiet_View hd = new HoaDonChiTiet_View();
            hd.setIdHoaDon(gioHangService.layIdHoaDon(txtMaHoaDon.getText()));
            hd.setIdChiTietSP(gioHangService.layIdChiTietSP(hdct.getTen()));
            hd.setSoLuong(hdct.getSoLuong());
            hd.setDonGia(hdct.getDonGia());
            listHDCT.add(hd);
        }
        for (HoaDonChiTiet_View hoaDonChiTiet : listHDCT) {
            gioHangService.luuHoaDonChiTiet(hoaDonChiTiet);

        }
        HoaDonn hd = updateThanhCong();
        hoaDonService.updateThanhCong(hd);
        fillTableHoaDon1();
        JOptionPane.showMessageDialog(this, "Thanh toan thanh cong.");

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private HoaDonn updateThanhCong() {
        String ma = txtMaHoaDon.getText();
        Date ngayTao = new Date();
        int tinhTrang = 1;
        HoaDonn hd = new HoaDonn(ma, ngayTao, tinhTrang);
        return hd;
    }

    private HoaDonn updateHuy() {
        String ma = txtMaHoaDon.getText();
        Date ngayTao = new Date();
        int tinhTrang = 3;
        HoaDonn hd = new HoaDonn(ma, ngayTao, tinhTrang);
        return hd;
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Huy", "confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            HoaDonn hd = updateHuy();
            hoaDonService.updateHuy(hd);
            fillTableHoaDon1();
            JOptionPane.showMessageDialog(this, "da huy hoa don");
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtTienThuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienThuaCaretUpdate
    }//GEN-LAST:event_txtTienThuaCaretUpdate

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
        double TienDua = Double.parseDouble(txtTienKhachDua.getText().toString());
        double tongTien = Double.parseDouble(txtTongTien.getText().toString());
        txtTienThua.setText(String.valueOf(tongTien - TienDua));
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnQuanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienActionPerformed
        // TODO add your handling code here:
        new QLNhanVien().setVisible(true);
//        setVisible(false);
    }//GEN-LAST:event_btnQuanLyNhanVienActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
        fillCBBDongSP();
        fillCBBMauSac();
        fillCBBNhaSanXuat();
        fillCBBSanPham();
    }//GEN-LAST:event_btnResetActionPerformed

    private void reset(){
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtNamBaoHanh.setText("");
        txtMoTa.setText("");
        txtSoLuong.setText("");
        cbbTenSanPham.setSelectedItem(0);
        cbbMauSac.setSelectedItem(0);
        cbbDongSanPham.setSelectedItem(0);
        cbbNhaSanXuat.setSelectedItem(0);
    }
    
    
    private void showChiTietSanPham(ChiTietSanPham ctsp) {
        cbbTenSanPham.setSelectedItem(ctsp.getSanPham().getTen());
        cbbMauSac.setSelectedItem(ctsp.getMauSac().getTen());
        cbbNhaSanXuat.setSelectedItem(ctsp.getNhaSanXuat().getTen());
        cbbDongSanPham.setSelectedItem(ctsp.getDongSP().getTen());
        txtGiaNhap.setText(String.valueOf(ctsp.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(ctsp.getGiaXuat()));
        txtNamBaoHanh.setText(String.valueOf(ctsp.getNamBaoHanh()));
        txtSoLuong.setText(String.valueOf(ctsp.getSoLuongTon()));
        txtMoTa.setText(ctsp.getMoTa());
    }

    private void showHoaDon(HoaDon_View hdv) {
        txtMaHoaDon.setText(hdv.getMa());
        txtNgayTao.setText(hdv.getNgayTao().toString());
        txtTongTien.setText(String.valueOf(hdv.tongTien()));

    }

    private void showHoaDon1(HoaDonn hdv) {
        txtMaHoaDon.setText(hdv.getMa());
        txtNgayTao.setText(hdv.getNgayTao().toString());
//        txtTongTien.setText(String.valueOf(hdv.tongTien()));

    }

    private ChiTietSanPham getFormSanPham() {
        String id = String.valueOf(SanPhamService.layIdChiTietSanPham());
        String sp = String.valueOf(cbbTenSanPham.getSelectedItem());
        String ms = String.valueOf(cbbMauSac.getSelectedItem());
        String sx = String.valueOf(cbbNhaSanXuat.getSelectedItem());
        String dsp = String.valueOf(cbbDongSanPham.getSelectedItem());

        SanPham idsp = SanPhamService.layIdSanPham(sp);
        MauSac idMS = SanPhamService.layIdMauSac(ms);
        NhaSanXuat idNSX = SanPhamService.layIdNhaSanXuat(sx);
        DongSanPham idDongSP = SanPhamService.layIdDongSanPham(dsp);

        int nambh = Integer.parseInt(txtNamBaoHanh.getText());
        String moTa = txtMoTa.getText();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        double giaNhap = Double.parseDouble(txtGiaNhap.getText());
        double giaBan = Double.parseDouble(txtGiaBan.getText());
        ChiTietSanPham ctsp = new ChiTietSanPham(id, idsp, idNSX, idMS, idDongSP, nambh, moTa, soLuong, giaNhap, giaBan);
        return ctsp;
    }

    private HoaDon_View getFormHoaDon() {
        int row = hoaDonService.demMaHoaDon();
        String ma = "HD" + row++;
        Date ngayTao = new Date();
        int tinhTrang = 2;
        HoaDon_View hdv = new HoaDon_View(ma, ngayTao, tinhTrang, 0, 0);
        return hdv;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemGioHang;
    private javax.swing.JButton btnThemThongTinSanPham;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTrangSau;
    private javax.swing.JButton btnTrangTiep;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDongSanPham;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNhaSanXuat;
    private javax.swing.JComboBox<String> cbbTenSanPham;
    private javax.swing.JLabel efd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDemTrang;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoHuy;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField text;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNamBaoHanh;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
