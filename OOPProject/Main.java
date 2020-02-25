
package javaapplication21;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        boolean addMore = true;
        boolean doMore = true;
        University uni = new University("Mahumman Ali Jinnah University","Karachi");
        Teacher teacher1 = new Teacher("Ammar",28,"03408650448","Gulberg","Ammar@jinnah.edu",10,40000);
        Teacher teacher2 = new Teacher("Ahmed",30,"03432958403","Dastagir","Ahmed@jinnah.edu",5,25000);
        Teacher teacher3 = new Teacher("Imran",25,"03343232124","Gulberg","Imran@jinnah.edu",12,50000);
        Teacher teacher4 = new Teacher("Owais",40,"03452349504","Shah Faisal","Owais@jinnah.edu",22,35000);
        ArrayList<Teacher> teacherList1 = new ArrayList<Teacher>();
        ArrayList<Teacher> teacherList2 = new ArrayList<Teacher>();
        ArrayList<Teacher> completeTeacherList = new ArrayList<Teacher>();
        ArrayList<Teacher> newDepartmentTeacher = new ArrayList<Teacher>();
        completeTeacherList.add(teacher1);
        completeTeacherList.add(teacher2);
        completeTeacherList.add(teacher3);
        completeTeacherList.add(teacher4);
        teacherList1.add(teacher1);
        teacherList1.add(teacher2);
        teacherList2.add(teacher3);
        teacherList2.add(teacher4);
        Student student1 = new Student("Hamza",22,"03435343433","Gulberg","Hamza@jinnah.edu.pk",1,2.0);
        Student student2 = new Student("Abdullah",21,"0302324244","Water Pump","Abdullah@jinnah.edu.pk",4,3.5);
        Student student3 = new Student("Mueez",23,"03412304344","Dastagir","Mueez@jinnah.edu.pk",45,4.0);
        Student student4 = new Student("Abid",25,"03451234555","Boat Basin","Abid@jinnah.edu.pk",30,2.7);
        Student student5 = new Student("Shaheer",20,"0341023024","Saddar","Shaheer@jinnah.edu.pk",11,3.1);
        Student student6 = new Student("Ali",23,"03445023204","Gulshan","Ali@jinnah.edu.pk",3,2.9);
        Student student7 = new Student("Taha",22,"03434053439","Defense","Taha@jinnah.edu.pk",4,2.5);
        Student student8 = new Student("Ghazanfar",21,"03454987695","Saddar","Ghazanfar@jinnah.edu.pk",5,1.5);
        Student student9 = new Student("Hammad",24,"03450392309","Gulshan","Hammad@jinnah.edu.pk",23,3.4);
        Student student10 = new Student("Haris",26,"03455968127","Defense","Haris@jinnah.edu.pk",11,3.6);
        ArrayList<Student> studentList1 = new ArrayList<Student>();
        ArrayList<Student> studentList2 = new ArrayList<Student>();
        ArrayList<Student> completeStudentList = new ArrayList<Student>();
        completeStudentList.add(student1);
        completeStudentList.add(student2);
        completeStudentList.add(student3);
        completeStudentList.add(student4);
        completeStudentList.add(student5);
        completeStudentList.add(student6);
        completeStudentList.add(student7);
        completeStudentList.add(student8);
        completeStudentList.add(student9);
        completeStudentList.add(student10);
        studentList1.add(student1);
        studentList1.add(student2);
        studentList1.add(student3);
        studentList1.add(student4);
        studentList1.add(student5);
        studentList2.add(student6);
        studentList2.add(student7);
        studentList2.add(student8);
        studentList2.add(student9);
        studentList2.add(student10);
        teacher1.setStudentList(studentList1);
        teacher2.setStudentList(studentList2);
        teacher3.setStudentList(studentList1);
        teacher4.setStudentList(studentList2);
        student1.setTeacher(teacherList1);
        student2.setTeacher(teacherList1);
        student3.setTeacher(teacherList1);
        student4.setTeacher(teacherList1);
        student5.setTeacher(teacherList1);
        student6.setTeacher(teacherList2);
        student7.setTeacher(teacherList2);
        student8.setTeacher(teacherList2);
        student9.setTeacher(teacherList2);
        student10.setTeacher(teacherList2);
        Departments department1 = new Departments("Software Engineering",10,teacherList1);
        Departments department2 = new Departments("Computer Science",24,teacherList2);
        uni.addDepartment(department1);
        uni.addDepartment(department2);
    while(doMore == true)
    {    
        System.out.println("Welcome to the University Portal.\nPlease enter the no of portal you want to acces.\n1.Admin\n2.Teacher\n3.Student");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        input.nextLine();
        if(choice == 1)
        {
            while(doMore == true)
            {
                addMore = true;
                System.out.println("What operation would you like to perform?\n1.Display Department List.\n2.Remove Department From List.\n3.Add a new Department\n4.Display The List of Teachers in the Department");
                choice = input.nextInt();
                input.nextLine();
                if(choice == 1)
                {
                    uni.displayDepartmentList();
                }
                else if(choice == 2)
                {
                    uni.removeDepartment();
                }
                else if(choice == 3)
                {
                    System.out.println("Please enter the name of the department:");
                    String depName = input.nextLine();
                    System.out.println("Please enter the code of the department:");
                    int depCode = input.nextInt();
                    input.nextLine();
                    while(addMore == true)
                    {
                        System.out.println("Would you like to add to the department:\n1.Existing Teacher\n2.New Teacher.");
                        choice = input.nextInt();
                        input.nextLine();
                        if(choice == 1)
                        {
                            while(addMore == true)
                            {
                                System.out.println("Please enter the index of the teacher to add from list.");
                                for(int i = 0 ; i<completeTeacherList.size() ; i++)
                                {
                                    System.out.println((i+1) + "." + completeTeacherList.get(i).name);
                                }
                                choice = input.nextInt();
                                newDepartmentTeacher.add(completeTeacherList.get(choice-1));
                                System.out.println("Would you like to add another teacher from list?\n1.Yes\n2.No");
                                choice = input.nextInt();
                                input.nextLine();
                                if(choice == 1)
                                {
                                   addMore = true;
                                }
                                else if(choice == 2)
                                {
                                    addMore = false;
                                }
                                else
                                {   
                                    System.out.println("Wrong input");
                                    addMore = false;
                                }
                            }
                 
                        }
                        else if(choice == 2)
                        {
                            while(addMore == true)
                            {
                                System.out.println("Please enter the following data for the Teacher.");
                                System.out.println("Teacher Name:");
                                String teacherName = input.nextLine();
                                System.out.println("Teacher Age:");
                                int teacherAge = input.nextInt();
                                input.nextLine();
                                System.out.println("Teacher Phone No:");
                                String teacherPhoneNo = input.nextLine();
                                System.out.println("Teacher Address:");
                                String teacherAddress = input.nextLine();
                                System.out.println("Teacher Email:");
                                String teacherEmail = input.nextLine();
                                System.out.println("Teacher Office No:");
                                int teacherOfficeNo = input.nextInt();
                                input.nextLine();
                                System.out.println("Teacher Salary:");
                                double teacherSalary = input.nextDouble();
                                Teacher newTeacher = new Teacher(teacherName,teacherAge,teacherPhoneNo,teacherAddress,teacherEmail,teacherOfficeNo,teacherSalary);
                                completeTeacherList.add(newTeacher);
                                newDepartmentTeacher.add(newTeacher);
                                System.out.println("Would you like to add another new teacher?\n1.Yes\n2.No");
                                choice = input.nextInt();
                                input.nextLine();
                                if(choice == 1)
                                {
                                   addMore = true;
                                }
                                else if(choice == 2)
                                {
                                    addMore = false;
                                }
                                else
                                {   
                                    System.out.println("Wrong input");
                                    addMore = false;
                                }
                            }    
                           
                        }
                        else
                        {
                            System.out.println("Wrong Input");
                        }
                    
                    System.out.println("Do you want to add more Teacher to the department?\n1.Yes\n2.No");
                    choice = input.nextInt();
                    input.nextLine();
                    if(choice == 1)
                    {
                        addMore = true;
                    }
                    else if(choice == 2)
                    {
                        addMore = false;
                    }
                    else
                    {
                        System.out.println("Wrong input");
                    }
                    }
                    Departments newDepartment = new Departments(depName,depCode,newDepartmentTeacher);
                    uni.addDepartment(newDepartment);
                }
                else if(choice == 4)
                {
                    System.out.println("Please enter the index of the department which teacher list you want to view.");
                    uni.displayDepartmentList();
                    choice = input.nextInt();
                    input.nextLine();
                    uni.getDepartment(choice-1).displayTeachersList();
                }
                System.out.println("Would you like to perform more actions as admin?\n1.Yes\n2.No");
                choice = input.nextInt();
                input.nextLine();
                if(choice == 1)
                {
                    doMore = true;
                }
                else if(choice == 2)
                {
                    doMore = false;
                }
                else
                {
                    System.out.println("Wrong Input");
                    doMore = false;
                }
            }
        }
        else if(choice == 2)
        {
            while(doMore == true)
            {
                System.out.println("Please select the index of the teacher which portal you want to access.");
                for(int i = 0 ; i<completeTeacherList.size();i++)
                {
                    System.out.println((i+1) + "." + completeTeacherList.get(i).name);
                }
                int teacherChoice = input.nextInt();
                input.nextLine();
                System.out.println("What action would you like to perform?\n1.Take Attendance\n2.See Student List");
                choice = input.nextInt();
                input.nextLine();
                if(choice == 1)
                {
                    completeTeacherList.get(teacherChoice-1).takeAttendance();
                }
                else if(choice == 2)
                {
                    completeTeacherList.get(teacherChoice-1).displayStudentList();
                }
                else
                {
                    System.out.println("Wrong input");
                }
                System.out.println("Would you like to perform any more action?\n1.Yes\n2.No");
                choice = input.nextInt();
                {
                    if(choice == 1)
                    {
                        doMore = true;
                    }
                    else if(choice == 2)
                    {
                        doMore = false;
                    }
                    else
                    {
                        System.out.println("Wrong input");
                    }
                }
            }
        }
        else if(choice == 3)
        {
            int studentChoice;
            System.out.println("Please enter the index of the student:");
            for(int i = 0; i< completeStudentList.size(); i++)
            {
                System.out.println((i+1) + "." + completeStudentList.get(i).name);
            }
            studentChoice = input.nextInt();
            input.nextLine();
            System.out.println(completeStudentList.get(studentChoice-1).toString());
          
        }
        else
        {
            System.out.println("Wrong input");
        }
        System.out.println("Would you like to rerun the program?\n1.Yes\n2.No");
        choice = input.nextInt();
        if(choice == 1)
        {
            doMore = true;
        }
        else
        {
            doMore = false;
        }   
            
    }
    }
}
