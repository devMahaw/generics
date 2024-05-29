package cadastro;

import cadastro.dao.ClientDAO;
import cadastro.dao.IClientDAO;
import cadastro.domain.Client;

import javax.swing.*;

public class App {

    private static IClientDAO iClientDAO;

    public static void main(String[] args) {
        iClientDAO = new ClientDAO();

        String option;

        do {
            option = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta," +
                            " 3 para exclusão, 4 para alteração e 5 para sair",
                    "CRUD", JOptionPane.INFORMATION_MESSAGE);

            if (!isValidOption(option)) {
                JOptionPane.showMessageDialog(null,
                        "Opção inválida!",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            if (isExitOption(option)) {
                exit();
            } else if (isRegisterOption(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: " +
                                "Nome,CPF,Telefone,Endereço,Número,Cidade,Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                register(data);
            } else if (isConsultOption(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                consult(data);
            } else if (isDeleteOption(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Deleta cliente", JOptionPane.INFORMATION_MESSAGE);
                delete(data);
            } else {
                String data = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: " +
                                "Nome,CPF,Telefone,Endereço,Número,Cidade,Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                change(data);
            }
        } while (!isExitOption(option));
    }

    private static boolean isValidOption(String option) {
        if("1".equals(option) || "2".equals(option) || "3".equals(option)
                || "4".equals(option) || "5".equals(option)) {
            return true;
        };
        return false;
    }

    private static void exit() {
        String registeredClients = "";

        for (Client client : iClientDAO.searchAll()) {
            registeredClients += client.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, "Clientes cadastrados: "
                + registeredClients, "Até logo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isRegisterOption(String option) {
        if ("1".equals(option)) {
            return true;
        }

        return false;
    }

    private static boolean isConsultOption(String option) {
        if ("2".equals(option)) {
            return true;
        }

        return false;
    }

    private static boolean isDeleteOption(String option) {
        if ("3".equals(option)) {
            return true;
        }

        return false;
    }

    private static boolean isExitOption(String option) {
        if ("5".equals(option)) {
            return true;
        }

        return false;
    }

    private static void register(String data) {
        String[] separateData = data.split(",");
        Client client = new Client(separateData[0], separateData[1], separateData[2], separateData[3],
                separateData[4], separateData[5], separateData[6]);

        Boolean isRegistered = iClientDAO.register(client);

        if (isRegistered) {
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente já se encontra cadastrado",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void consult(String data) {
        Client client = iClientDAO.consult(data);

        if (client != null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente encontrado com sucesso: " + client.toString(),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente não encontrado",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void delete(String data) {
        Client client = iClientDAO.consult(data);

        if (client != null) {
            iClientDAO.delete(data);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "CPF não encontrado. Por favor, insira um CPF válido.",
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void change(String data) {
        String[] separateData = data.split(",");
        Client client = new Client(separateData[0], separateData[1], separateData[2], separateData[3],
                separateData[4], separateData[5], separateData[6]);

        iClientDAO.change(client);
    }
}
