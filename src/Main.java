import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

//            FileReader fr = new FileReader("/Users/suriya-18343/Documents/JAVA/File_Reader/src/Tristar Invnetory_Bin Master.csv");
//            BufferedReader br = new BufferedReader(fr);
//
//            String line;
//
//
//            int numberOfRows = 0;
//            while((line = br.readLine() )!= null)
//            {
//                String[] li = line.split(",");
//                for(String l : li){
//                    System.out.print(l + "  ");
//                }
//                System.out.println();
////                System.out.println(line);
//                numberOfRows++;
//            }
//            br.close();
//            fr.close();
//
//        System.out.println("number of rows , " + numberOfRows);

        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
    }
}