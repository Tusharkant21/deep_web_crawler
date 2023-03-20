

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        encodeImage("src\\inputImages\\pkaymetal_careers.png", "src\\outputImages\\pkaymetal.txt");
        decodeImage("src\\outputImages\\pkaymetal.txt","src\\outputImages\\newpkaymetal.png");

    }

    private static  String encodeImage(String imgPath, String savePath) throws Exception{
        FileInputStream imageStream =  new FileInputStream(imgPath);
        byte[] data = imageStream.readAllBytes();
        String imageString = Base64.getEncoder().encodeToString(data);
        FileWriter fileWriter = new FileWriter(savePath);
        fileWriter.write(imageString);
        fileWriter.close();
        imageStream.close();
        return imageString;

    }

    private static void decodeImage(String textPath, String savePath) throws Exception{
        FileInputStream inputStream = new FileInputStream(textPath);
        inputStream.readAllBytes();
       byte[] data= Base64.getDecoder().decode(new String(inputStream.readAllBytes()));
        FileOutputStream fileOutputStream = new FileOutputStream(savePath);
        fileOutputStream.write(data);
        fileOutputStream.close();
        inputStream.close();
    }
}