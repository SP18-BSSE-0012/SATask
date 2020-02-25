
package javaapplication21;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Departments implements Comparable<Departments>
{
    private String name;
    private int code;
    private ArrayList<Teacher> teachers;
    public String fileName = "defaultName";
    public BufferedReader fileRead;
    public BufferedWriter fileWrite;
    
        public Departments(String name,int code,ArrayList<Teacher> teachers) throws IOException
        {
            this.name = name;
            this.code = code;
            this.teachers = teachers;
            Scanner input = new Scanner(System.in);
            boolean fileNameExists = true;
            while(fileNameExists == true)
            {   
                try
                {
                    System.out.println("Please enter the List Name for Teachers of the " + this.name +" Department:");
                    this.fileName = input.nextLine();
                    FileReader fr = new FileReader(this.fileName + ".txt");
                    System.out.println("A List with the same name exists,please enter a different Name");
                }
                catch(IOException fileNotFound)
                {
                    fileNameExists = false;
                }
            }   
            updateTeacherList();
        }
        
        public void setName(String name)
        {
            this.name = name;
        }
        public void setCode(int code)
        {
            this.code = code;
        }
        public String getName()
        {
            return this.name;
        }
        public int getCode()
        {
            return this.code;
        }
        public void sortTeacherList()
        {
            Collections.sort(teachers);
        }
        public void displayTeachersList()
        {
             try
            {
                FileReader fr = new FileReader(this.fileName + ".txt");
                fileRead = new BufferedReader(fr);
                System.out.println("Department:" + this.getName());
                for(Teacher teachers1 : this.teachers)
                {
                    System.out.println(fileRead.readLine());
                }
            }
            catch(IOException fileNotFound)
            {
                System.out.println("No List of Teachers was Made");
            }
        }
        public void addTeacher(Teacher teacher) throws IOException
        {
            this.teachers.add(teacher);
            updateTeacherList();
        }
        public void updateTeacherList() throws IOException
        {
            try
            {
                FileWriter fw = new FileWriter(this.fileName + ".txt");
                fileWrite = new BufferedWriter(fw);
                for(Teacher teachers1 : this.teachers)
                {
                    fileWrite.write(teachers1.name);
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
       @Override 
        public int compareTo(Departments p)
        {
            Scanner input = new Scanner(System.in);
            int sortMethod=0;
            while(sortMethod!=1 && sortMethod!=2)
            {
                System.out.println("How do you want to sort the list of departments?\n1.By Name\n2.By Code");
                sortMethod = input.nextInt();
                input.nextLine();
            }
            if(sortMethod==1)
            {
                return this.getName().compareTo(p.getName());
            }
            else
            {
                if(this.getCode() < p.getCode())
                {
                    return -1;
                }          
                else if(this.getCode() == p.getCode()) 
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
            return "Department: " + this.name + " " + this.code;
        }
        
}
