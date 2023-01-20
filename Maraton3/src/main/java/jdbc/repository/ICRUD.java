package jdbc.repository;

import java.util.List;

public interface ICRUD <T>{
    void getAll();
    void save(T t);
    void update(T t);
    void saveAll(List<T> t);
    void delete(int t);
    void getById(int t);
}
