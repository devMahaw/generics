package cadastro.dao;

import cadastro.dao.generic.IGenericDAO;
import cadastro.domain.Produto;

import java.util.Collection;

/**
 * @author devMahaw
 */
public interface IProdutoDAO extends IGenericDAO<Produto> {

    public Boolean register(Produto produto);
    public void delete(String cpf);
    public void change(Produto produto);
    public Produto consult(String cpf);
    public Collection<Produto> searchAll();
}
