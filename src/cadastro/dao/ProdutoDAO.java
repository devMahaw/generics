package cadastro.dao;

import cadastro.dao.generic.GenericDAO;
import cadastro.domain.Produto;

import java.util.Collection;
import java.util.List;

/**
 * @author devMahaw
 */
public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    public ProdutoDAO() {
        super();
    }

    @Override
    public Boolean register(Produto produto) {
        return null;
    }

    @Override
    public void delete(String cpf) {

    }

    @Override
    public void change(Produto produto) {

    }

    @Override
    public Produto consult(String cpf) {
        return null;
    }

    @Override
    public Collection<Produto> searchAll() {
        return List.of();
    }
}
