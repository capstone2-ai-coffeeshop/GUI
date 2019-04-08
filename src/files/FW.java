package files;

import java.io.*;

public class FW {
	
	public static void main(String[] args) {
		File newFile = new File("D:/4_Projects/FilesCreate/newFile" + 1 + ".txt");
		if (newFile.exists()) {
			System.out.println("The file already exists!");
		} else {
			try {
				newFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				FileWriter fileW = new FileWriter(newFile);
				BufferedWriter buffW = new BufferedWriter(fileW);
				buffW.write("---------------------------------------------------------\n");
				buffW.write("               AI COFFEE SHOP BILL RECEIPT               \n");
				buffW.write("---------------------------------------------------------\n");
				buffW.write("Bill ID:                                                 \n");
				buffW.write("Tên khách hàng:                                          \n");
				buffW.write("Thời gian:                                               \n");
				buffW.write("_________________________________________________________\n");
				buffW.write("|                                                       |\n");
				buffW.write("| Tên món          SL    Đơn giá        Thành tiền      |\n");
				buffW.write("|_______________________________________________________|\n");
				buffW.write("| Oreo Đá xay      1      42000            42000        |\n");
				buffW.write("| Oreo Đá xay      1      42000            42000        |\n");
				buffW.write("| Oreo Đá xay      1      42000            42000        |\n");
				buffW.write("|_______________________________________________________|\n");
				buffW.write("                                                         \n");
				buffW.write("Thành tiền:                                              \n");
				buffW.write("Giảm giá:                                                \n");
				buffW.write("Tổng cộng:                                               \n");
				buffW.write("Tiền khách đưa:                                          \n");
				buffW.write("Tiền trả lại:                                            \n");
				buffW.write("                                                         \n");
				buffW.write("_________________________________________________________\n");
				buffW.write("                                                         \n");
				buffW.write("           Cảm ơn quý khách và hẹn gặp lại !!!           \n");
				buffW.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
