package a5_GameTaiSuu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class taisuu {

	public static void main(String[] args) {
		double taiKhoanNguoiChoi = 5000000;
		Scanner sc = new Scanner(System.in);
		
		// NHẬN DIỆN QUỐC GIA ĐỂ DỊNH GIÁ TIỀN 
		Locale lc= new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getInstance(lc);
		
		int luaChon = 1;
		do {
			System.err.println("---Mời bạn lựa chọn---");
			System.out.println(" chọn 1 để tiếp tục chơi: ");
			System.out.println(" chọn phím 0 kì để thoát: ");
			luaChon = sc.nextInt();
			if(luaChon ==1) {
				System.out.println(" Bắt đầu chơi:");
				// đặt cược
				System.out.println("*** Tài khoản của bạn : ***" +taiKhoanNguoiChoi +" bạn muốn đặt cược bao nhiêu ");
				double datcuoc = 0;
				do {
					System.out.println("*** Đặt cược trong khoảng  0 <= số tiền cược <=" +taiKhoanNguoiChoi +":");
					datcuoc = sc.nextDouble();
				}
				while (datcuoc <=0 || datcuoc > taiKhoanNguoiChoi) ;
					
					// chọn tài sửu
					
					int luachonTaiSuu = 0;
					do {
						System.out.println("**** Chọn 1 -> tài || Chọn 2 -> xỉu:");
						luachonTaiSuu  = sc.nextInt();
					}while (luachonTaiSuu != 1 && luachonTaiSuu !=2);
					
					// hàm random tung xúc xắc
					Random xs1 = new Random();
					Random xs2 = new Random();
					Random xs3 = new Random();
					
					int giaTri1 = xs1.nextInt(5);
					int giaTri2 = xs2.nextInt(5);
					int giaTri3 = xs3.nextInt(5);
					int tong = giaTri1+ giaTri2+ giaTri3;
					
					// tính toán kết quả
					System.out.println("*** Kết quả: "+giaTri1+ " - " +giaTri2 + " - "+giaTri3);
					if(tong ==3 || tong == 18) {
						taiKhoanNguoiChoi -=datcuoc;
					
					System.out.println("*** Kết quả 3 cục xúc xắc là:  "+ tong+ " => nhà cái ăn hết , bạn đã thua cược: ");
					System.out.println("*** Tài khoản của bạn là: " +taiKhoanNguoiChoi);
					}
					else if( tong >= 4 && tong <= 10) {
						System.out.println("*** Tổng là: "+tong + "=> xỉu!");
						if(luachonTaiSuu ==2) {
							System.out.println("*** Bạn đã thắng cược: ");
							taiKhoanNguoiChoi += datcuoc;
							System.out.println("***Tài khoản của bạn là: "+numf.format(taiKhoanNguoiChoi));
						}
						else {
							System.out.println("*** Bạn đã thua cược! ");
							taiKhoanNguoiChoi -=datcuoc;
							System.out.println("*** Tài khoản của bạn là: "+numf.format(taiKhoanNguoiChoi));
						}}
					else {
						System.out.println("*** Tổng là :"+tong+"=> Tài! ");
						if(luachonTaiSuu ==1) {
							System.out.println("*** Bạn đã thắng cược: ");
							taiKhoanNguoiChoi += datcuoc;
							System.out.println("*** Tài khaorn của bạn là: "+numf.format(taiKhoanNguoiChoi));
						}
						else {
							System.out.println("*** Bạn đã thua cược! ");
							taiKhoanNguoiChoi -= datcuoc;
							System.out.println("*** Tài khaorn của bạn là: "+ numf.format(taiKhoanNguoiChoi));
						}
					}
			}
		}
			while(luaChon ==1);
		}
	}

							
		