import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SeriableExample {
public static void printdata(Customer object1)
	{

		System.out.println("name = " + object1.name);
		System.out.println("address = " + object1.address);
		System.out.println("phone_no = " + object1.phone_no);
		System.out.println("product = " + object1.product);
		System.out.println("price = " + object1.price);
		
	}

public static void main(String[] args)
	{
	
	Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
	System.out.print("Enter the details: ");
	System.out.println("Enter Customer name");	
	String cname= sc.nextLine(); 
	System.out.println("Address");
	String city=sc.nextLine();
	System.out.println("Enter Phone number");
	String phno=sc.nextLine();
	System.out.println("Enter the number of items:");
	int n=sc.nextInt();
	String products[]=new String[n];
	double product_price[]=new double[n];
	System.out.println("Enter Product details");
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter Product"+(i+1));
		String items=sc.next();
	    products[i]=items;
	}
	
    System.out.println("Enter Price");
    for(int i=0;i<n;i++)
	{
		System.out.println("Enter Price"+(i+1));
		product_price[i]=sc.nextDouble();
	}
    String product=products[0];
    for(int i=1;i<n;i++)
	{
		
    	product=product+","+products[i];
	}
    double total_price=0;
    for(int i=0;i<n;i++)
	{
		total_price=total_price+product_price[i];
	}
  
	Customer object = new Customer(cname, city, phno, product,total_price);
		String filename = "C:\\Users\\ANIGUN\\Desktop\\jav\\customer.txt";

		// Serialization
		try {

			// Saving of object in a file
			FileOutputStream file = new FileOutputStream
										(filename);
			ObjectOutputStream out = new ObjectOutputStream
										(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n"
							+ "Data before Deserialization.");
			printdata(object);

			// value of static variable changed
			object.b = 2000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		object = null;

		// Deserialization
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream
										(filename);
			ObjectInputStream in = new ObjectInputStream
										(file);

			// Method for deserialization of object
			object = (Customer)in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n"
								+ "Data after Deserialization.");
			printdata(object);

			// System.out.println("z = " + object1.z);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" +
								" is caught");
		}
	}
}

