import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rental {

    public Rental() {

    }

    public Rental(Rental other) {

    }

    public void viewvehicles(){

        Scanner infileStream = null;

        try {
            infileStream = new Scanner(new File("Vehicle.txt"));
            while(infileStream.hasNext()){
            String vehicleDetails = infileStream.nextLine();
            System.out.println(vehicleDetails);

        }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        infileStream.close();
    }

    public String toString() {
        return "";
    }
}