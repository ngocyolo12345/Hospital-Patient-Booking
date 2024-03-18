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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ngoc
 */
public class Case implements Serializable{
    int IDcase;
    Patient patientInCase;
    Doctor doctorInCase;
    Case()
    {}
    Case(int ID, Patient a, Doctor b)
    {  
        this.IDcase=ID;
        patientInCase = a;
        doctorInCase =b;
    }
    int getID()
    {
        return IDcase;
    }
    Patient getPatient()
    {
        return patientInCase;
    }
    Doctor getDoctor()
    {
        return doctorInCase;
    }
    void Info()
    {
        System.out.println("1");
    }
    ArrayList<Case> getList()
   {
        ArrayList<Case> listCase = new ArrayList<>();
       
        try {
            // TODO code application logic here
            /*Scanner sc = new Scanner(new File("case.txt"));
            while (sc.hasNext())
            {
                int id = Integer.parseInt(sc.nextLine());
                
                Patient tempPatient = new Patient();
                tempPatient.setName(sc.nextLine());
                
                tempPatient.setContactnum(Integer.parseInt(sc.nextLine()));
                
                tempPatient.setID(Integer.parseInt(sc.nextLine()));
                
                tempPatient.setIssue(sc.nextLine());
                
                Doctor tempDoctor = new Doctor();
                tempDoctor.setName(sc.nextLine());
                tempDoctor.setContactnum(Integer.parseInt(sc.nextLine()));
                tempDoctor.setID(Integer.parseInt(sc.nextLine()));
                tempDoctor.setSpeciality(sc.nextLine());
                
                Case tempCase = new Case(id,tempPatient,tempDoctor);
                listCase.add(tempCase);
            }
        } catch (Exception e) {
            System.out.println("got excepton case1");
        }*/
            FileInputStream file = new FileInputStream("case.dat");
            //System.out.println("error here");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            //System.out.println("error here");
            boolean endOfFile = false;
            
            while(!endOfFile){
                try {
                    
                    listCase.add((Case) inputFile.readObject());
                    
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
     
        return listCase;
   }
     void writeList(ArrayList<Case> caseList)
   {
       try{
            /*FileWriter f = new FileWriter("case.txt");
            PrintWriter p = new PrintWriter(f);
            for(Case temp : caseList)
            {
                Patient a = temp.getPatient();
                Doctor b= temp.getDoctor();
                String id = String.valueOf(temp.getID());
                p.write(id+"\n");
                
                String contactnumP = String.valueOf(a.getContact());
                String IDpatient = String.valueOf(a.getID());
                p.write(a.getName()+"\n");
                p.write(contactnumP+"\n");
                p.write(IDpatient+"\n");
                p.write(a.getIssue()+"\n");
                
                
                String contactnumD = String.valueOf(b.getContact());
                String IDdoctor = String.valueOf(b.getID());
                p.write(b.getName()+"\n");
                p.write(contactnumD+"\n");
                p.write(IDdoctor+"\n");
                p.write(b.getSpeciality()+"\n");
                //f.close();
            }
            p.close();
            f.close();
        }
        catch(Exception e)
        {
            System.out.println("got exception case");
        }*/
            FileOutputStream file = new FileOutputStream("case.dat");
            
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for ( int i = 0; i < caseList.size(); i++){
                outputFile.writeObject(caseList.get(i));  
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
   void deleteCase(ArrayList<Case> caseList, int selectCase)
   {
       Case deleteEntry = null;
       for(Case a : caseList)
        {
            if(a.getID()==selectCase)
            {
                deleteEntry = a;
            }
        }
       if (deleteEntry != null){
           caseList.remove(deleteEntry);
       }
       try{
           /*FileReader rf = new FileReader ("case.txt");
           BufferedReader bf = new BufferedReader (rf);
            FileWriter f = new FileWriter("case.txt",false);
            BufferedWriter p = new BufferedWriter(f);
            
            while (bf.readLine()!=null)
            {
                p.write("");   
            }
            Case temp = new Case();
            temp.writeList(caseList);
        }
        catch(Exception e)
        {
            System.out.println("got exception");
        }*/
           FileOutputStream file = new FileOutputStream("case.dat");
            
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for ( int i = 0; i < caseList.size(); i++){
                outputFile.writeObject(caseList.get(i));  
            }
            
            outputFile.close();
             JOptionPane.showMessageDialog(null,"Succefully deleted!");
             //this.dispose();
             
             
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
   }
}
