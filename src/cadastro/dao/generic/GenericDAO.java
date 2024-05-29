package cadastro.dao.generic;

import cadastro.domain.IPersistente;
import cadastro.domain.Produto;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author devMahaw
 */
public abstract class GenericDAO<T extends IPersistente> implements IGenericDAO<T> {

    private Map<Class, Map<Long, T>> map;

    public abstract Class<T> getTipoClasse();

    public GenericDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean register(T entity) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        return null;
    }

    @Override
    public Collection<T> searchAll() {
        return List.of();
    }

    @Override
    public T consult(String valor) {
        return null;
    }

    @Override
    public void change(T entity) {

    }

    @Override
    public void delete(String valor) {

    }
}
