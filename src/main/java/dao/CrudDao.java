package dao;

import java.sql.Date;

/**
 * Created by isko on 9/25/17.
 */
public interface CrudDao<M, I> {

    void save(M model);

    M find(I id);

    void delete(I id);

    void update(M model);
}
//insert salt in cookies