import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileScanner {
    String txtFile = null;
    Scanner scnr;
    File newFile = new File("src/savefile.txt");

    public String getFileText() {
        try {
            scnr = new Scanner(newFile);
            while (scnr.hasNextLine()) {
                txtFile = txtFile + scnr.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }
        return txtFile;
    }

    //Scanner Object


}
