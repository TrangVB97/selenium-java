package example;

import java.util.Random;
import java.util.UUID;

public class HocSinh {
    private String id;
    private String ten;
    private int tuoi;
    private double diemTrungBinh;

    public HocSinh(String ten, int tuoi, double diemTrungBinh) {
       this.id = "TVN-AK48-" + UUID.randomUUID().toString() ;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diemTrungBinh = diemTrungBinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void hienThiThongTin() {
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
    }

    public String xepLoai() {
        if (diemTrungBinh>=9) {
            return "Xuất sắc";
        } else if (diemTrungBinh >= 8) {
            return "Giỏi";
        } else if (diemTrungBinh >= 6.5) {
            return "Khá";
        } else if (diemTrungBinh >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

}
