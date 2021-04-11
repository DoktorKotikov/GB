package lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOMain {
    public static void main(String[] args) throws IOException {
        File file = new File("1/1.txt");
//        byte[] bytes = {65, 66, 67, 68};
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write(bytes);
//
//        }
        PipedInputStream in = null;
        PipedOutputStream out = null;
        try {
            in = new PipedInputStream();
            out = new PipedOutputStream();

            out.connect(in);
            for (int i = 0; i < 100; i++){
                out.write(i);
            }

            int x;
            while((x = in.read()) != -1){
                System.out.println(x + " ");
            }
        } finally {
            in.close();
            out.close();
        }
//            try (BufferedReader br = new BufferedReader(new FileReader(file))){
//                String line;
//                while ((line = br.readLine()) != null) {
//                    System.out.println(line);
//                }
//            }
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)){
//            int x;
//            while ((x = isr.read()) != -1) {
//                System.out.println((char) x);
//            }
//        }
        //byte[] buf = new byte[512];
//        int x;
//        try (BufferedInputStream bis = new BufferedInputStream (new FileInputStream(file))){
//            while((x = bis.read()) != 0) {
//                System.out.println(x);
//            }
//        }
        //file.mkdir();
//        System.out.println(file.exists());
//        file.createNewFile();
//        System.out.println(file.exists());
        //System.out.println(file.isAbsolute());//проверка на абсолютный путь
    }
}
