package com.AdressBookSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    private List<PersonalDetails> items;
    public AddressBook(){
        this.items = new ArrayList<>();
    }
    public void addNewContact(PersonalDetails PDItems) {
        if (items.stream().anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(PDItems.getFirstName()))) {
            System.out.println("Duplicate found -> not added ");
        } else {
            items.add(PDItems);
        }
    }

    public void displayAddedContact(){
        if (items.isEmpty()){
            System.out.println("Address Book is Empty");
        }else{
            System.out.println("Hear is the Personal Details :");
            for ( int i =0; i < items.size();i++){
//                System.out.println("Contact Details are :" );
                System.out.println(items.get(i));
            }
        }
    }

    public void editFirstName(String input, String output){
        for ( PersonalDetails contact : items){
            if (contact.getFirstName().toLowerCase().equals(input.toLowerCase())){
                contact.setFirstName(output);
            }
        }
    }
    public void deleteContact(int index){
        items.remove(index);
    }

    public List<PersonalDetails> searchByCity(String city) {
        return items.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<PersonalDetails> searchByState(String state) {
        return items.stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Scanner sysInput= new Scanner(System.in);
        System.out.println("Welcome to AddressBook Program");
        PersonalDetails p = new PersonalDetails("Dev","Patel","Olpad","Olpad","Gujrat","123","00123456789","patelmayuraaa@gmail.com",1);
        PersonalDetails p1 = new PersonalDetails("Yash","Sharode","Udhana","Udhana","GJ","123","00123456789","yashSharode@gmail.com",2);
        PersonalDetails p2 = new PersonalDetails("Akshay","Sushir","Udhana","Udhana","Gujrat","123","00123456789","Akshaysushir@gmail.com",3);
        PersonalDetails p3 = new PersonalDetails("Vaibhav","Singh","Olpad","Olpad","GJ","123","00123456789","vaibhavsingh@gmail.com",4);
        PersonalDetails p4 = new PersonalDetails("Karitk","Gohil","Olpad","Olpad","Gujrat","123","00123456789","KartikGohil@gmail.com",5);
        PersonalDetails p5 = new PersonalDetails("Dev","Patel","Olpad","Olpad","Gujrat","123","00123456789","patelmayuraaa@gmail.com",1);
        AddressBook B =new AddressBook();
        B.addNewContact(p);
        B.addNewContact(p1);
        B.addNewContact(p2);
        B.addNewContact(p3);
        B.addNewContact(p4);
        B.addNewContact(p5);
        B.displayAddedContact();

        List<PersonalDetails> personsInUdhana = B.searchByCity("Udhana");
        System.out.println();
        System.out.println("Persons in Udhana:");
        personsInUdhana.forEach(System.out::println);

        List<PersonalDetails> personsInGujarat = B.searchByState("Gujrat");
        System.out.println();
        System.out.println("Persons in Gujarat:");
        personsInGujarat.forEach(System.out::println);


//        System.out.println("Enter First Name to edit : ");
//        String inputString = sysInput.next();
//        System.out.println("Enter Name :");
//        String editString = sysInput.next();
//
//        B.editFirstName(inputString,editString);
//        System.out.println(B);
//        B.displayAddedContact();

//        System.out.println("Enter index Number to delete");
//        int toDelete = sysInput.nextInt();
//
//        B.deleteContact(toDelete-1);
//        B.displayAddedContact();
    }

}