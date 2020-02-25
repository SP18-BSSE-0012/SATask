
package javaapplication21;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Collections;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Teacher extends Person implements Comparable<Teacher>
{
    int officeNo;
    double salary;
    BufferedReader fileRead;
    BufferedWriter fileWrite;
    ArrayList<Student> students;
    String fileName;
    
    
    public Teacher(String name,int age,String phoneNo,String address,String email,int officeNo,double salary)
    {
        super(name,age,phoneNo,address,email);
        this.officeNo = officeNo;
        this.salary = salary;
    }
    
    public void setStudentList(ArrayList<Student> students) throws IOException
    {
        Scanner input = new Scanner(System.in);
        this.fileName = "defaultName";
        this.students = students;
        boolean fileNameExists = true;
        while(fileNameExists == true)
        {
            try
            {
                System.out.println("Please enter the List Name of the Students of Teacher " + this.name + ":");
                this.fileName = input.nextLine();
                FileReader fr = new FileReader(this.fileName + ".txt");
                System.out.println("A List with the same name exists,please enter a different Name");
            }
            catch(IOException fileNotFound)
            {
                fileNameExists = false;
            }
        }   
        try
        {
            FileWriter fw = new FileWriter(this.fileName + ".txt");
            fileWrite = new BufferedWriter(fw);
            for(Student student : this.students)
            {
                fileWrite.write(student.name);
                fileWrite.newLine();
            }
        }
        catch(IOException wrongDirectory)
        {
            System.out.println("Failed to update file,Directory not found");
        }
        finally
        {
            fileWrite.close();
        }
        
    }
    public void displayStudentList()
    {
        try
        {
            FileReader fr = new FileReader(this.fileName + ".txt");
            fileRead = new BufferedReader(fr);
            System.out.println("Teacher:" + this.name);
            for(Student students1 : this.students)
            {
                System.out.println(fileRead.readLine());
            }
        }
        catch(IOException fileNotFound)
        {
            System.out.println("No List of Students was Made");
        }
        
    }
    public void takeAttendance()
    {
        Scanner input = new Scanner(System.in);
        boolean attendance = false;
        System.out.println("Please enter true for present and false for absent.");
        for(int i = 0; i < students.size(); i++)
        {
            boolean isValidInput = false;
            while(isValidInput == false)
            {
                try
                {
                    System.out.println(this.students.get(i).name);
                    attendance = input.nextBoolean();
                    isValidInput = true;
                }
                catch(InputMismatchException invalidInput)
                {
                    input.nextLine();
                    System.out.println("Please enter valid input");
                }
            }
            if(attendance == true)
            {
                students.get(i).noOfPresents++;
            }
            else
            {
                students.get(i).noOfAbsents++;
            }
        }
    }
    public void sortStudentList()
        {
            Collections.sort(students);
        }
    @Override
    public int compareTo(Teacher p)
    {
        Scanner input = new Scanner(System.in);
        int sortMethod=0;
        while(sortMethod!=1 && sortMethod!=2 && sortMethod!=3)
        {
            System.out.println("How do you want to sort the list of Teachers?\n1.By Name\n2.By Age\n3.By Salary");
            sortMethod = input.nextInt();
            input.nextLine();
        }
        if(sortMethod==1)
        {
            return this.name.compareTo(p.name);
        }
        else if(sortMethod == 2)
        {
            if(this.age < p.age)
            {
                return -1;
            }       
            else if(this.age == p.age) 
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            if(this.salary < p.salary)
            {
                return -1;
            }       
            else if(this.salary == p.salary) 
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
            
    }
    

    @Override
    public String toString()
    {
        return "Name:" + this.name + "\nAge:" + this.age + "\nAddress:" + this.address + 
                "\nPhone No:" + this.phoneNo + "\nEmail:" + this.email + "\nOffice No:" + this.officeNo +
                "Salary:" + this.salary;
                
    }
    
}
