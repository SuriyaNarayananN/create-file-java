import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class Main {

        static HashMap<String,String> BinMasterMap = new HashMap<>();

        public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Dealer Code - ");
        String dealerCode = bf.readLine();

        createPreparedBinMasterFile("Prepared BIN Master.csv",dealerCode);
        createPreparedMaterialInventory("Prepared Material Inventory.csv",dealerCode);
        createPreparedBatchFile("Prepared Batch.csv",dealerCode);
    }

        public static void createPreparedBinMasterFile(String fileName,String dealerCode) throws IOException {

        FileReader InventoryBinMasterFile = new FileReader("/Users/suriya-18343/Documents/JAVA/File_Reader/Source Files/Tristar Invnetory_Bin Master.csv");
        BufferedReader br = new BufferedReader(InventoryBinMasterFile);
        String filePath = "/Users/suriya-18343/Documents/JAVA/File_Reader/Generated-Files/" + fileName;
        File file = new File(filePath);
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);

        String line;

        int currentRowID = 1;




        while((line = br.readLine()) != null)
        {
            String[] eachLine = line.split(",");

            List<String> newArrayList = new ArrayList<>(Arrays.asList(eachLine));

            if(currentRowID > 1)
            {
                newArrayList.set(1,dealerCode +"-BIN_MASTER-" + (currentRowID-1));
                newArrayList.set(6,"99999");
                BinMasterMap.put(newArrayList.get(0),newArrayList.get(1));
            }
            Object[] obj = newArrayList.toArray();
            String[] stringArray = Arrays.copyOf(obj, obj.length, String[].class);
            currentRowID++;
            writer.writeNext(stringArray);
        }
        writer.close();
        System.out.println("file 1 generated");
    }

        public static void createPreparedMaterialInventory(String fileName,String dealerCode) throws IOException {
        FileReader InventoryFile = new FileReader("/Users/suriya-18343/Documents/JAVA/File_Reader/Source Files/Tristar Invnetory_Inventory.csv");
        BufferedReader br = new BufferedReader(InventoryFile);
        String filePath = "/Users/suriya-18343/Documents/JAVA/File_Reader/Generated-Files/" + fileName;
        File file = new File(filePath);
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile);

        String line;
        int currentRow = 1;
        while((line = br.readLine()) != null)
        {
//            if(currentRow > 3) break;

            String[] eachLine = line.split(",");
            List<String> newList = new ArrayList<>(Arrays.asList(eachLine));
//            System.out.println("Before");
//            System.out.println(newList);
            if(currentRow > 1)
            {
//                System.out.println("currentRow -> " + currentRow);
//                System.out.println("after interpret");
                newList.set(0,dealerCode+"-INVENTORY-" + (currentRow - 1));
                newList.set(1,"TM-INIT-" + newList.get(10));
//                System.out.println("before 12th index");
                if(BinMasterMap.get(newList.get(12)) != null)
                {
//                    System.out.println(newList);
//                    newList.set(13,BinMasterMap.get(newList.get(10)));
                    newList.add(BinMasterMap.get(newList.get(12)));
                }
            }
//            System.out.println(newList);
            Object[] obj = newList.toArray();
            String[] stringArray = Arrays.copyOf(obj, obj.length, String[].class);
            writer.writeNext(stringArray);
            currentRow++;
        }
        writer.close();

    }

        public static void createPreparedBatchFile(String fileName , String dealerCode) throws IOException {
            FileReader InventoryBinMasterFile = new FileReader("/Users/suriya-18343/Documents/JAVA/File_Reader/Generated-Files/Prepared Material Inventory.csv");
            BufferedReader br = new BufferedReader(InventoryBinMasterFile);
            String filePath = "/Users/suriya-18343/Documents/JAVA/File_Reader/Generated-Files/" + fileName;
            File file = new File(filePath);
//            CSVWriter writer = new CSVWriter(outputfile);
            CSVWriter writer = new CSVWriter(
                    new FileWriter(file),
                    CSVWriter.DEFAULT_SEPARATOR, // Default separator (comma)
                    CSVWriter.NO_QUOTE_CHARACTER, // No quoting
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER, // Default escape character
                    CSVWriter.DEFAULT_LINE_END // Default line ending
            );
            String line;
            int currentRow = 1;
            while ((line = br.readLine()) != null)
            {
//                if(currentRow > 2) break;

                String[] eachLine = line.split(",");
//
                List<String> newArrayList = new ArrayList<>(Arrays.asList(eachLine));
//                System.out.println(newArrayList);
//                System.out.println("printing 10th element , " + newArrayList.get(10));
//

                if(currentRow == 1)
                {
                    newArrayList.set(0,"Batch ID");
                    newArrayList.set(1,"Batch Name");
                    newArrayList.set(2,"Material Master ID");
                    newArrayList.set(3,"Material Inventory ID");
                    newArrayList.set(4,"Status");
                    newArrayList.set(5,"Material Price History");
                    newArrayList.set(6,"Total Quantity");
                    newArrayList.set(7,"Available Quantity");
                    newArrayList.set(8,"Reserved Quantity");
                    newArrayList.set(9,"Blocked Stock Quantity");
                    newArrayList.set(10,"Location");
                    newArrayList.set(11,"Division");
                    newArrayList.set(12,"Created Time");
                    newArrayList.set(13,"Material Code");
                }
                else
                {
                    String materialInventoryID = newArrayList.getFirst().replace("\"","");
//                    System.out.println("printing first element");
//                    System.out.println(materialInventoryID);
                    String name = "asd";
//                    System.out.println("Name -> " + name);
                    if(materialInventoryID == null)
                    {
                        materialInventoryID = "";
                    }
//                    System.out.println("priting arraylist before");
//                    System.out.println(newArrayList);
                    newArrayList.set(0,dealerCode+"-BATCH-" + (currentRow - 1));
                    newArrayList.set(1,"BATCH1-" + newArrayList.get(10).replace("\"",""));
                    newArrayList.set(2,newArrayList.get(2).replace("\"",""));
                    newArrayList.add(3,materialInventoryID.replace("\"",""));
                    newArrayList.add(4,"Active");
                    newArrayList.add(5,"");
                    newArrayList.set(6,newArrayList.get(6).replace("\"",""));
                    newArrayList.set(7,newArrayList.get(7).replace("\"",""));
                    newArrayList.set(8,newArrayList.get(8).replace("\"",""));
                    newArrayList.set(9,newArrayList.get(9).replace("\"",""));
                    newArrayList.set(10,newArrayList.get(10).replace("\"",""));
                    newArrayList.set(11,newArrayList.get(11).replace("\"",""));
                    newArrayList.set(12,newArrayList.get(12).replace("\"",""));
                    newArrayList.set(13,newArrayList.get(13).replace("\"",""));
//                    System.out.println("printing arraylist");
//                    System.out.println(newArrayList);
                    newArrayList.removeLast();
                    newArrayList.removeLast();
                    newArrayList.removeLast();
//                    System.out.println("printing after removing last 3");
//                    System.out.println(newArrayList);
                }
                Object[] obj = newArrayList.toArray();
                String[] stringArray = Arrays.copyOf(obj, obj.length, String[].class);
                currentRow++;
                writer.writeNext(stringArray);
            }
            writer.close();

        }


        public static void createPreparedLotFile(String fileName , String dealerCode) throws IOException, FileNotFoundException{

        }
    }