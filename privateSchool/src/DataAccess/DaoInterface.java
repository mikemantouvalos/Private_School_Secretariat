
package DataAccess;

import java.util.List;


public interface DaoInterface<E> {
    
    boolean create(E e);

    List<E> findAll();

    E findById(int id);

}
    
