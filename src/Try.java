import java.util.Arrays;
import java.util.List;

public class Try {

    public static void main(String[] args) {
//        String[] list = {"Suriya","Narayanan","Suriyaaaa"};
//
//
//        List a1 = Arrays.asList(list);
//
//        a1.add("SIDNSAD");
//
//
//        System.out.println(a1);
//        for( : li)
//        {
//            System.out.println(i);
//        }



        String[] geeks = {"Rahul", "Utkarsh",
                "Shubham", "Neelam"};

        // Conversion of array to ArrayList
        // using Arrays.asList
        List al = Arrays.asList(geeks);
        System.out.println(al);

        // Adding some more values to the List.
        al.add("Shashank");
        al.add("Nishant");

        System.out.println(al);
    }
}
