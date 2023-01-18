package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Options {

    public static Client addClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del cliente");
        String name = scanner.nextLine();
        System.out.println("Ingresa la cédula del cliente");
        Integer id = Integer.parseInt(scanner.nextLine());
        Client client = new Client(name, id);
        return client;

    }

    public static void showClients(Client[] clients){
        if(clients[0] == null){
            System.out.println("No hay clientes para mostrar");
        }else {
            int j = 1;
            for (int i = 0; i < clients.length; i++){
                if(clients[i] != null){
                    System.out.println("Cliente número " + j++ + ": El cliente se llama " + clients[i].getName() +
                            " y su cédula es " + clients[i].getId());
                }
            }
        }


    }
}
