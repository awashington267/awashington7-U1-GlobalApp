package us.aw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FileInput {
    private BufferedReader in = null;
    private String fileName;
    HashSet<String> lines = new HashSet<>();
    String line = "";
    String cvsSplitBy = ",";
    String[] country = line.split(cvsSplitBy);





    public FileInput(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
            while ((line = in.readLine()) != null) {
                if (lines.add(line)) {
                    //System.out.println("Country [code= " + country[0] + " , name=" + country[1] + "]");
                    System.out.println(line);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void fileRead() {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
        }
    }

    public String fileReadLine() {
        try {
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
            return null;
        }
    }

    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
