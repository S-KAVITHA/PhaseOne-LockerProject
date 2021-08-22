import java.io.File;  
import java.io.PrintWriter;  
public class PrintWriterExample {  
    public static void main(String[] args) throws Exception {  
             //Data to write on Console using PrintWriter  
      PrintWriter writer = new PrintWriter(System.out);    
      writer.write("Javatpoint provides tutorials of all technology.");        
 writer.flush();  
      writer.close();  
//Data to write in File using PrintWriter       
      PrintWriter writer1 =null;    
      String path = System.getProperty("user.dir");
         writer1 = new PrintWriter(new File(path));  
         writer1.write("Like Java, Spring, Hibernate, Android, PHP etc.");                                                   
                         writer1.flush();  
         writer1.close();  
    }  
}  