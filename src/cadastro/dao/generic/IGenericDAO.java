package cadastro.dao.generic;

import cadastro.domain.IPersistente;
import cadastro.domain.Produto;

import java.util.Collection;

/**
 * @author devMahaw
 */
public interface IGenericDAO <T extends IPersistente> {

    public Boolean register(T entity);
    public void delete(String valor);
    public void change(T entity);
    public T consult(String valor);
    public Collection<T> searchAll();
}
