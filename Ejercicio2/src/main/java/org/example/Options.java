package org.example;

import java.util.ArrayList;
import java.util.List;
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

    public static void showClients(ArrayList<Client> clients){
        if(clients.isEmpty()){
            System.out.println("No hay clientes para mostrar");
        }else {
            int j = 1;
            for (int i = 0; i < clients.size(); i++){
                System.out.println("Cliente número " + j++ + ": El cliente se llama " + clients.get(i).getName() +
                        " y su cédula es " + clients.get(i).getId());
            }
        }
    }

    public static ArrayList<Client> removeClient(ArrayList<Client> clients){
        Scanner scanner = new Scanner(System.in);
        boolean clientRemoved = false;
        System.out.println("Indica la cédula del cliente a borrar");
        try{
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId() == id){
                    clients.remove(i);
                    clientRemoved = true;
                }
            }
        }catch (Exception e){
            System.out.println("Error, debes ingresar un número válido");
        }
        if (clientRemoved){
            System.out.println("Cliente eliminado");
        }else{
            System.out.println("Cédula no existe");
        }

        return clients;
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

    public static void findClient(ArrayList<Client> clients){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el número de cédula del cliente");
        try{
            int id = Integer.parseInt(scanner.nextLine());
            int position = 0;
            boolean isClient = false;
            for (int i = 0; i < clients.size(); i++) {
                position++;
                if (clients.get(i).getId() == id){
                    isClient = true;
                    System.out.println("El cliente que se busca está en la posición " + position + ", El cliente se llama " +
                            clients.get(i).getName() + " y su cédula es " + clients.get(i).getId());
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
