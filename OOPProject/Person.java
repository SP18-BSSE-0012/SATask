
package javaapplication21;

public abstract class Person 
{
    String name;
    int age;
    String address;
    String phoneNo;
    String email;
        
        public Person(String name,int age,String phoneNo,String address,String email)
        {
            this.name = name;
            this.age = age;
            this.address = address;
            this.phoneNo = phoneNo;
            this.email = email;
        }
        
        public abstract String toString();

        
    
}
