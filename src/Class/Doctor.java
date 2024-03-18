/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author ngoc
 */
public class Doctor implements Serializable {
    String name;
    int contactnumber;
    int ID;
    String speciality;
    Doctor()
    {}
    Doctor(String name, int contactnum, int ID, String skill)
    {
        this.name = name;
        this.contactnumber = contactnum;
        this.ID=ID;
        this.speciality = skill;
    }
    String Info()
    {
        return "Name: "+ name + " \nContact number: "+ contactnumber + "\n ID: "+ ID +"\n Speciality: "+ speciality;
    }
    public String toString()
    {
        return name;
    }
    void setName(String name)
    {
       this.name = name;
    }
    void setContactnum(int Contactnumber)
    {
       this.contactnumber = Contactnumber;
    }
    void setID(int ID)
    {
        this.ID=ID;
    }
   void setSpeciality(String skill)
    {
       this.speciality = skill;
    
    }
   String getName()
   {
       return name;
   }
   int getContact()
   {
       return contactnumber;
   }
   int getID()
   {
       return ID;
   }
   String getSpeciality()
   {
       return speciality;
   }
   ArrayList<Doctor> getList()
   {
        ArrayList<Doctor> listDoctor = new ArrayList<>();
       
        try {
            // TODO code application logic here
           /* Scanner sc = new Scanner(new File("doctor.txt"));
            while (sc.hasNext())
            {
                Doctor temp = new Doctor();
                temp.setName(sc.nextLine());
                temp.setContactnum(Integer.parseInt(sc.nextLine()));
                temp.setID(Integer.parseInt(sc.nextLine()));
                temp.setSpeciality(sc.nextLine());
                System.out.println(temp.Info());
                listDoctor.add(temp);
            */
            FileInputStream file = new FileInputStream("doctor.dat");
            //System.out.println("error here");
            
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            //System.out.println("error here");
            boolean endOfFile = false;
            
            while(!endOfFile){
                try {
                    
                    listDoctor.add((Doctor) inputFile.readObject());
                    
                }
                catch (EOFException e){
                   endOfFile = true;
                }
                catch (Exception f) {
                   JOptionPane.showMessageDialog(null,f.getMessage());
                }
                
            }
            
            inputFile.close();
            
        } 
        catch (Exception e) 
        {
            System.out.println("error here");
            System.out.println("got excepton");
        }
        /*for(Patient a : listTemp)
        {
            System.out.println(a.Info());
        }*/
       return  listDoctor;
   }
   void writeList(ArrayList<Doctor> doctorList)
   {
       try{
            /*FileWriter f = new FileWriter("doctor.txt");
            BufferedWriter p = new BufferedWriter(f);
            
            for(Doctor temp : doctorList)
            {
                String contactnum = String.valueOf(temp.getContact());
                String id = String.valueOf(temp.getID());
                p.write(temp.getName()+"\n");
                p.write(contactnum+"\n");
                p.write(id+"\n");
                p.write(temp.getSpeciality()+"\n");
                //f.close();
            }
            p.close();
            f.close();*/
            FileOutputStream file = new FileOutputStream("doctor.dat");
            
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for ( int i = 0; i < doctorList.size(); i++){
                outputFile.writeObject(doctorList.get(i));  
            }
            
            outputFile.close();
            JOptionPane.showMessageDialog(null,"Succefully saved!");
            //this.dispose();
        }
       catch(Exception e)
       {
            System.out.println("got exception");
        }
   }
   void deleteDoctor(ArrayList<Doctor> doctorList)
   {
       /*try{
           FileReader rf = new FileReader ("doctor.txt");
           BufferedReader bf = new BufferedReader (rf);
            FileWriter f = new FileWriter("doctor.txt",false);
            BufferedWriter p = new BufferedWriter(f);
            
            while (bf.readLine()!=null)
            {
                p.write("");   
            }
            Doctor temp = new Doctor();
            temp.writeList(doctorList);
        }catch(Exception e){
            System.out.println("got exception");
        }*/
       try {
            FileOutputStream file = new FileOutputStream("doctor.dat");
            
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for ( int i = 0; i < doctorList.size(); i++){
                outputFile.writeObject(doctorList.get(i));  
            }
            
            outputFile.close();
             JOptionPane.showMessageDialog(null,"Succefully deleted!");
            
             
             
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
   }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
