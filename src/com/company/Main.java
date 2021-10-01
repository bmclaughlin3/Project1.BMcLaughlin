package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;                             //Brendan McLaughlin
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        var ProductName = new ArrayList<String>();      //name=productName
        var Numberav= new ArrayList<Integer>();     //numbers= numberav
        var Productprice= new ArrayList<Float>();
        var fileName = "TestData.txt";
        var filePath = Paths.get(fileName);
        var allLines = Files.readAllLines(filePath);
        var userResponse = "";
        var reader = new Scanner(System.in);
        for (var line: allLines){
            var splitline= line.split(",");
                ProductName.add(splitline[0]);
                Numberav.add(Integer.parseInt(splitline[1]));
                Productprice.add(Float.parseFloat(splitline[2]));
        }
        for(int i = 0; i< ProductName.size(); i++){
            System.out.println("Student "+ ProductName.get(i)+ " has Jersey Number "+ Numberav.get(i));
        }
        while(!userResponse.equals("done")){
            System.out.print("Enter product name or 'done' to end:");
            userResponse = reader.nextLine();
            if (!userResponse.equals("done")){
                for (String A:ProductName){
                    if (A == userResponse){
                        var Pos =ProductName.indexOf(A);
                        var Num = Numberav.get(Pos);
                        var Price = Productprice.get(Pos);
                        System.out.println("Number available: " +Num + "Price: " +Price);

                    }else{
                        System.out.println("Product not found");
                    }
                }
            }
        }
    }
}
