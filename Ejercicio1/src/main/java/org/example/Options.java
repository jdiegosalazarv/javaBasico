package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Options {

    public static Client addClient(){
        Scanner scanner = new Scanner(System.in);
        boolean isString = false;
        boolean isNumber = false;
        Client client;
        System.out.println("Ingresa el nombre del cliente");
        String name = scanner.nextLine();
        if(name.matches("[a-z]+")){
            isString = true;
        }
        Integer id = 0;
        try{
            System.out.println("Ingresa la cédula del cliente");
            id = Integer.parseInt(scanner.nextLine());
            isNumber = true;
        }catch (Exception e){
            System.out.println("No has ingresado un número");
        }
        if(isString && isNumber){
            client = new Client(name, id);
            return client;
        }
        return null;
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

    public static Client[] removeClient(Client[] clients){
        Scanner scanner = new Scanner(System.in);
        Client[] clients2 = clients;
        System.out.println("Indica la posición que deseas borrar");
        try{
            int position = Integer.parseInt(scanner.nextLine())-1;
            if(position >= 0 && position < clients.length - 1){
                if(clients.length>4){
                    clients2 = modifyArray(clients, clients.length-1,position);
                }else{
                    clients2 = modifyArray(clients,4,position);
                }

            }else{
                System.out.println("Posición equivocada");
            }
        }catch (Exception e){
            System.out.println("Error, debes ingresar un número válido");
        }

        return clients2;
    }

    public static Client[] modifyArray(Client[] clients, int size, int position){
        Client[] clients2 = new Client[size];
        int newPosition = 0;
        for (int i = 0; i < clients.length; i++){
            if (i == position){
                continue;
            }
            clients2[newPosition++] = clients[i];
        }
        return clients2;
    }

    public static void findClient(Client[] clients){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el número de cédula del cliente");
        try{
            int id = Integer.parseInt(scanner.nextLine());
            int position = 0;
            boolean isClient = false;
            for (int i = 0; i < clients.length; i++) {
                position++;
                if (clients[i] != null && clients[i].getId() == id){
                    isClient = true;
                    System.out.println("El cliente que se busca está en la posición " + position + ", El cliente se llama " +
                            clients[i].getName() + " y su cédula es " + clients[i].getId());
                }
            }
            if (!isClient){
                System.out.println("No hay ningún cliente con ese número de cédula");
            }
        }catch (Exception e){
            System.out.println("Error, debes ingresar un número");
        }
    }
}
