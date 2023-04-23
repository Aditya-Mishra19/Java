import java.io.*;
//Java code for serialization and deserialization
//of a Java object
public class Customer implements Serializable {
    private static final long serialversionUID =
    129348938L;
    transient int a;
    static int b;
    String name;
    String address;
    String phone_no;
    String product;
    double price;
// Default constructor
    public Customer(String name, String address, String phone_no, String product,double d)
    {
    this.name = name;
    this.address = address;
    this.phone_no = phone_no;
    this.product = product;
    this.price = d;
    }
}
