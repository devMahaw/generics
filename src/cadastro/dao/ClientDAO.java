package cadastro.dao;

import cadastro.dao.generic.GenericDAO;
import cadastro.domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientDAO extends GenericDAO<Client> implements IClientDAO {

    public ClientDAO() {
        super();
    }

    public Class<Client> getTipoClasse() {
        return Client.class;
    }

//    private Map<String, Client> map;
//
//    public ClientDAO() {
//        this.map = new HashMap<>();
//    }
//
//    @Override
//    public Boolean register(Client client) {
//        if (this.map.containsKey(client.getCpf())) {
//            return false;
//        }
//
//        this.map.put(client.getCpf(), client);
//        return true;
//    }
//
//    @Override
//    public void delete(String cpf) {
//        Client registeredClient = this.map.get(cpf);
//
//        if (registeredClient != null) {
//            this.map.remove(registeredClient.getCpf(), registeredClient);
//        }
//    }
//
//    @Override
//    public void change(Client client) {
//        Client registeredClient = this.map.get(client.getCpf());
//
//        if (registeredClient != null) {
//            registeredClient.setName(client.getName());
//            registeredClient.setTel(client.getTel());
//            registeredClient.setNumber(client.getNumber());
//            registeredClient.setAddress(client.getAddress());
//            registeredClient.setCity(client.getCity());
//            registeredClient.setState(client.getState());
//
//            this.map.put(registeredClient.getCpf(), registeredClient);
//        }
//    }
//
//    @Override
//    public Client consult(String cpf) {
//        return this.map.get(cpf);
//    }
//
//    @Override
//    public Collection<Client> searchAll() {
//        return this.map.values();
//    }
}
