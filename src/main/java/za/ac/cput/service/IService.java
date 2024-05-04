package za.ac.cput.service;

import java.util.List;

public interface IService <T, ID>{
    public T create(T obj);
    public T read(ID id);
    public T update(T obj);
    public boolean delete(ID id);
    public List<T> getAll();
}
