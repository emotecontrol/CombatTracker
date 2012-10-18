import java.io.*;

public class FileTester {
    
    File file = new File("testdoc.txt");
    boolean tester ;
    
    FileTester(){
    
    System.out.println(file.exists());
    
    }
    
    public static void main(String[] arguments) {
        FileTester ft = new FileTester();
    }
}