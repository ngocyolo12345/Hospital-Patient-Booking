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
public class Patient implements Serializable {
    private String name;
    String Contactnumber;
    int ID;
    String issue;
   String recommend;
   Patient()
   {}
   Patient(String name, String Contactnumber, int ID, String issue)
   {
       this.name=name;
       this.Contactnumber= Contactnumber;
       this.ID=ID;
       this.issue = issue;
   }
   String Info()
   {
       return "Name: " +name + " \nContact number: "+Contactnumber +" \nId: " + ID + " \nIssue: "+ issue;
   }
   void setName(String name)
   {
       this.name = name;
   }
   void setContactnum(String Contactnumber)
   {
       this.Contactnumber = Contactnumber;
   }
   void setID(int ID)
   {
       this.ID=ID;
   }
   void setIssue(String issue)
   {
       this.issue = issue;
   }
   String getName()
   {
       return name;
   }
   String getContact()
   {
       return Contactnumber;
   }
   int getID()
   {
       return ID;
   }
   String getIssue()
   {
       return issue;
   }
   ArrayList<Patient> getList()
   {
        ArrayList<Patient> listPatient = new ArrayList<>();
       
        try {
            // TODO code application logic here
            /*Scanner sc = new Scanner(new File("text.txt"));
            //sc.useDelimiter(",");
            while (sc.hasNext())
            {
                Patient temp = new Patient();
                temp.setName(sc.nextLine());
                temp.setContactnum(Integer.parseInt(sc.nextLine()));
                temp.setID(Integer.parseInt(sc.nextLine()));
                temp.setIssue(sc.nextLine());
                //System.out.println(temp.Info());
                listPatient.add(temp);
            }*/
            FileInputStream file = new FileInputStream("patient.dat");
            //System.out.println("error here");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            //System.out.println("error here");
            boolean endOfFile = false;
            
            while(!endOfFile){
                try {
                    
                    listPatient.add((Patient) inputFile.readObject());
                    
                }
                catch (EOFException e){
                   endOfFile = true;
                }
                catch (Exception f) {
                   JOptionPane.showMessageDialog(null,f.getMessage());
                }
                
            }
            
            inputFile.close();
            
            
        } catch (Exception e) {
            System.out.println("exception docfile");
            System.out.println("got excepton");
        }
        /*for(Patient a : listTemp)
        {
            System.out.println(a.Info());
        }*/
       return  listPatient;
   }
   void writeList(ArrayList<Patient> patientList)
   {
       try{
            /*FileWriter f = new FileWriter("text.txt");
            BufferedWriter p = new BufferedWriter(f);
            
            for(Patient temp : patientList)
            {
                String contactnum = String.valueOf(temp.getContact());
                String id = String.valueOf(temp.getID());
                p.write(temp.getName()+"\n");
                p.write(contactnum+"\n");
                p.write(id+"\n");
                p.write(temp.getIssue()+"\n");
                //f.close();
            }
            p.close();
            f.close();
*/
            FileOutputStream file = new FileOutputStream("patient.dat");
            
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for ( int i = 0; i < patientList.size(); i++){
                outputFile.writeObject(patientList.get(i));  
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
   void deletePatient(ArrayList<Patient> patientList)
   {
       /*try{
           FileReader rf = new FileReader ("text.text");
           BufferedReader bf = new BufferedReader (rf);
            FileWriter f = new FileWriter("text.text",false);
            BufferedWriter p = new BufferedWriter(f);
            
            while (bf.readLine()!=null)
            {
                p.write("");   
            }
            Patient temp = new Patient();
            temp.writeList(patientList);
        }
        catch(Exception e)
        {
            System.out.println("got exception");
        }*/
       try {
            FileOutputStream file = new FileOutputStream("patient.dat");
            
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for ( int i = 0; i < patientList.size(); i++){
                outputFile.writeObject(patientList.get(i));  
            }
            
            outputFile.close();
             JOptionPane.showMessageDialog(null,"Succefully deleted!");
             //this.dispose();
             
             
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
   
   @Override
   public String toString()
   {
       return name;
   }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
