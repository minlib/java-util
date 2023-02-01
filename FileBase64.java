package com.minzhan;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileBase64 {

    public static String fileEncode(String path) throws IOException {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    public static void fileDecode(String base64Code, String targetPath) throws IOException {
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        String output = fileEncode("E:\\work\\minzhan-ui.7z");
        Files.write(Paths.get("E:\\work\\minzhan-ui.txt"), output.getBytes());

        String base64 = new String(Files.readAllBytes(Paths.get("E:\\work\\minzhan-ui2.txt")));
        fileDecode(base64, "E:\\work\\minzhan-ui3.7z");
    }

}
