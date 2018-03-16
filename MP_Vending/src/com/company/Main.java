package com.company;

import com.company.object.CashBox;
import com.company.object.Item;
import com.company.object.RegularVendingMachine;
import com.company.object.Supply;
import com.company.object.Transaction;
import com.company.object.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        VendingMachine vm = null;
        //select menu 1 - create vending machine, 2 - test vending machine, 3 - exit
        System.out.println("Venidng Machine");
        int endFlag = 0;

        OUTER:
        while(endFlag <1){
            System.out.println("Please type the #:");
            System.out.println("1 - Create a new Vending Machine (Regular only)");
            System.out.println("2 - Test Vending Machine (Regular only)");
            System.out.print("3 - Exit program\n#");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();


            if(choice != "3"){
                switch(choice){
                    case "1": System.out.println("Create vending machine...");
                        break;
                    case "2": System.out.println("Test Vending Machine...");
                        break;
                    default : System.out.println("# entered is out of the current option. Exiting progam...");
                        choice = "3";
                        break;
                }
            }else{
                exit();
            }
            //should have the option to add supply(adding item) or add cashBox (with adding cash)
            //there should be option whether to create another object / cash box / go back to main menu
            if(choice.equals("1")){
                System.out.print("Enter Vending Machine Name: ");
                String vendingMachineName = scanner.nextLine();
                if(vendingMachineName != ""){
                    vm = createVendingMachine(vendingMachineName);
                    continue OUTER;
                }else {
                    vm = createVendingMachine("defaultvendingName");
                    continue OUTER;
                }

            }
            
            
            //testing menu should be added (if no vending machine was created, plese use the testVendingMachine
            //1-Add cash
            //2-Select item
            //
            if(choice.equals("2")){
                if(vm == null){
                    testVendingMachine(null);
                    continue OUTER;
                }else {
                    testVendingMachine(vm);
                }
            } else{
                System.out.println("Exit program...");
                endFlag = 1;
                exit();
            }
        }





    }

    public static VendingMachine createVendingMachine(String name){
        VendingMachine vm = new RegularVendingMachine(name);
        System.out.println("Vending machine (" + vm.getVendingName() + ") was created.");
        System.out.println(vm.toString());

        return vm;
    }

    public static void testVendingMachine(VendingMachine vm){

        //generate items
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("Coke",100,new Double(35),10));
        itemList.add(new Item("Royal",100,new Double(35), 10));
        itemList.add(new Item("Sarsi",100,new Double(40), 10));
        itemList.add(new Item("Pepsi",100,new Double(30), 10));
        itemList.add(new Item("Mountain Dew",100,new Double(40), 10));
        itemList.add(new Item("Nestea Red Iced Tea",100,new Double(25), 10));
        itemList.add(new Item("Nestea Lemon Iced Tea",100,new Double(25), 10));
        itemList.add(new Item("Kopiko Iced Coffee",100,new Double(25), 10));

        //generateSupply
        Supply supply = new Supply(itemList);

        //generate cashbox
        CashBox cashBox = new CashBox();
        cashBox.setPHP_200(100);
        cashBox.setPHP_100(100);
        cashBox.setPHP_50(100);
        cashBox.setPHP_20(100);
        cashBox.setPHP_10(200);
        cashBox.setPHP_5(200);
        cashBox.setPHP_1(200);


        //create new VendingMachine if not vending machine was created
        if(vm == null){
            vm = new RegularVendingMachine("TestVending", cashBox, supply );
            System.out.println(vm.toString());
        }else {
            vm.setSupply(supply);
            vm.setCashBox(cashBox);
            System.out.println(vm.toString());
        }



        //test display of items
        vm.displayItems();



        //test transaction
        Transaction tr = new Transaction();
        Item itemSelected = new Item("Coke",100,new Double(35));
        List<Item> selectedItems = new ArrayList<Item>();
        selectedItems.add(itemSelected);
        try {
            vm.createNewTransaction(50,selectedItems);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //get total sales amount
        System.out.println("Total Sales: " + vm.getTotalSales());

        //get cash amount from the cash box
        System.out.println("Total Cash Amount in Cash Box: " + vm.getTotalCashAmount().intValue());

    }



    public static void exit(){
        System.exit(0);
    }
}