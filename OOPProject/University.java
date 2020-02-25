
package javaapplication21;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class University
{
    private String name;
    private String address;
    String fileName = "defaultName";
    public BufferedWriter fileWrite;
    public BufferedReader fileRead;
    private final ArrayList<Departments> departments;
    
        public University(String name,String address) throws IOException
        {
            this.name = name;
            this.address = address;
            this.departments = new ArrayList<Departments>();
            Scanner input = new Scanner(System.in);
            boolean fileNameExists = true;
            while(fileNameExists == true)
            {   
                try
                {
                    System.out.println("Please enter the List Name for Departments of the University:");
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
        
        public void setName(String name)
        {
            this.name = name;
        }
        public void setAddress(String address)
        {
            this.address = address;
        }
        public String getName()
        {
            return this.name;
        }
        public String getAddress()
        {
            return this.address;
        }
        public Departments getDepartment(int choice)
        {
            return this.departments.get(choice);
        }
        public void addDepartment(Departments department) throws IOException
        {
            departments.add(department);
            updateDepartmentList();
        }
        public void removeDepartment() throws IOException
        {
            displayDepartmentList();
            Scanner input = new Scanner(System.in);
            boolean isValidInput = false;
            int index=0;
            while(!isValidInput)
            {
                try
                {
                    System.out.println("Please enter the index of the Department in list to remove.");
                    index = input.nextInt();
                    isValidInput = true;
                }
                catch(InputMismatchException invalidInput)
                {
                    input.nextLine();
                    System.out.println("Please enter valid input");
                }
            }
            try
            {
               departments.remove(index-1);
               updateDepartmentList();
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Wrong index value was inputted");
            }
          
        }
        public void displayDepartmentList()
        {
            for(int i = 0;i < departments.size() ; i++)
            {
                System.out.println((i+1)+"." + departments.get(i).toString());
            }
        }
        public void sortDepartmentList()
        {
            Collections.sort(departments);
        }
        public void updateDepartmentList() throws IOException
        {
            try
            {
                FileWriter fw = new FileWriter(this.fileName + ".txt");
                fileWrite = new BufferedWriter(fw);
                for(Departments departments1 : this.departments)
                {
                    fileWrite.write(departments1.getName());
                    fileWrite.newLine();
                }
            }
            catch(IOException updateFailed)
            {
                System.out.println("The update to department list failed");
            }
            finally
            {
                fileWrite.close();
            }
        }
}
