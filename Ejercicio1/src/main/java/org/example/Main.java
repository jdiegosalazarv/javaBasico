package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String option;
        Scanner scanner = new Scanner(System.in);
        Client [] clients = new Client[4];
        do {
//
            System.out.println("\nBienvenido, ingrese una de las siguientes opciones");
            System.out.println("a. Añadir un nuevo cliente");
            System.out.println("b. Borrar un cliente");
            System.out.println("c. Buscar un cliente");
            System.out.println("d. Mostrar los clientes");
            System.out.println("e. Salir");
            option = scanner.nextLine();

            switch (option) {
                case "a":
                    if(clients.length == 10){
                        System.out.println("Debe borrar un cliente antes de poder ingresar uno nuevo");
                        break;
                    }else{
                        if (clients[clients.length -1] == null){
                            for(int i = 0; i < clients.length; i++){
                                if(clients[i]==null){
                                    clients[i] = Options.addClient();
                                    break;
                                }
                            }
                            break;
                        }else{
                            Client [] clients2 = clients;
                            int size = clients2.length+1;
                            clients = new Client[size];
                            for (int i = 0; i < clients2.length; i++){
                                clients[i] = clients2[i];
                            }
                            clients[clients2.length] = Options.addClient();
                            break;
                        }
                    }
                case "b":
                    clients = Options.removeClient(clients);
                    break;
                case "c":
                    Options.findClient(clients);
                    break;
                case "d":
                    Options.showClients(clients);
                    break;
                case "e":
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opción incorrecta, ");
            }
        }while(!option.equals("e"));
    }
}