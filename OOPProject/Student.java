package javaapplication21;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person implements Comparable<Student>
{
    int noOfPresents;
    int noOfAbsents;
    int id;
    double CGPA;
    public ArrayList<Teacher> teacher;
    BufferedReader fileRead;
    BufferedWriter fileWrite;
    String fileName;

    
    public Student(String name,int age,String phoneNo,String address,String email,int id,double CGPA)
    {
        super(name,age,phoneNo,address,email);
        this.id = id;
        this.CGPA = CGPA;
    }
    public void setTeacher(ArrayList<Teacher> teacher) throws IOException
    {
         Scanner input = new Scanner(System.in);
        this.fileName = "defaultName";
        this.teacher = teacher;
        boolean fileNameExists = true;
        while(fileNameExists == true)
        {
            try
            {
                System.out.println("Please enter the List Name of Teachers of the Student " + this.name + ":");
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
            for(Teacher teachers : this.teacher)
            {
                fileWrite.write(teachers.name);
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
    public void displayTeacherList()
    {
        try
        {
            FileReader fr = new FileReader(this.fileName + ".txt");
            fileRead = new BufferedReader(fr);
            System.out.println("Student:" + this.name);
            for(Teacher teachers1 : this.teacher)
            {
                System.out.println(fileRead.readLine());
            }
        }
        catch(IOException fileNotFound)
        {
            System.out.println("No List of Teachers was Made");
        }
    }
    
    @Override
    public int compareTo(Student p)
    {
        Scanner input = new Scanner(System.in);
        int sortMethod=0;
        while(sortMethod!=1 && sortMethod!=2 && sortMethod!=3)
        {
            System.out.println("How do you want to sort the list of Students?\n1.By Name\n2.By Age\n3.By CGPA");
            sortMethod = input.nextInt();
            input.nextLine();
        }
        if(sortMethod==1)
        {
            return this.name.compareTo(p.name);
        }
        else if(sortMethod==2)
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
            if(this.CGPA < p.CGPA)
            {
                return -1;
            }       
            else if(this.CGPA == p.CGPA) 
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
        return "Student Name:" + this.name + "\nId:" + this.id + "\nCGPA:" + this.CGPA + "\nPhone No:" + this.phoneNo + "\nEmail:" + this.email + "\nAge:" + this.age + "\nAddress:" + this.address + "\nNo Of Presents:" + this.noOfPresents + "\nNo Of Absents:" + this.noOfAbsents;
    }
}
