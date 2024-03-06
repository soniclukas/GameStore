package pl.pabianczyklukasz.project;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class Store {
    private String name;
    private Address address;
    private List<Client> clients;

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public List<Client> readAllClients() {
        return clients;
    }

    public void updateClient(String oldName, String oldSurname, String newName, String newSurname) {
        Client clientByName = findClientByName(oldName);
        Client clientBySurname = findClientBySurname(oldSurname);
        if(clientByName != null && !clientByName.getName().equals(newName)
                && clientBySurname != null && !clientBySurname.getSurname().equals(newSurname)) {
            clientByName.setName(newName);
            clientBySurname.setSurname(newSurname);
        } else {
            throw new IllegalArgumentException("Osoba o takim imieniu i nazwisku już istnieje!");
        }
    }

    public Client findClientBySurname(String surname) {
        for(Client client : clients) {
            if (client.getSurname().equals(surname)) {
                return client;
            }
        }
        throw new IllegalArgumentException("Nie ma klienta o takim nazwisku " + surname);
    }

    public Client findClientByName(String name) {
        for (Client client : clients) {
            if(client.getName().equals(name)) {
                return client;
            }
        }
        throw new IllegalArgumentException("Nie ma klienta o takim imieniu " + name);
    }

    public boolean doesThisClientExist(Client client) {
        return clients.contains(client);
    }
}
