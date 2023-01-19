package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String option;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();
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
                    Client client = Options.addClient();
                    if(client != null){
                        if(clients.size() == 0){
                            clients.add(client);
                        }else{
                            for (int i = 0; i < clients.size(); i++) {
                                if(clients.get(i).getId() == client.getId()){
                                    System.out.println("Cliente con esa cèdula ya existe");
                                }else{
                                    clients.add(client);
                                    System.out.println("Cliente agregado");
                                }
                            }
                        }
                    }
                    break;
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