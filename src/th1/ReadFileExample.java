package th1;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) throws IOException {
        File file;
        try {
            //Đọc file theo đường dẫn
            file = new File(filePath);
            //Kiểm tra file nếu không tồn tại thì ném ra ngoại lệ
            if (!file.exists())
                throw new FileNotFoundException();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        //Đọc từng dòng của file và tiến hành cộng tổng lại
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        int sum = 0;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(line);
            sum += Integer.parseInt(line);
        }
        br.close();

        //Hiển thị màn hình tổng các số nguyên trong file
        System.out.println("Tổng = " + sum);
    } catch (Exception e); {
        // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
        System.err.println("File không tồn tại or nội dung có lỗi!");
    }
}

    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);

    }
}
