package cn.celadon.travel.canada.Util.exception;

/**
 * Created by empqqty on 6/13/2017.
 */
public class EntityNotFoundInDBException extends LogicalException {


    public EntityNotFoundInDBException(Object entityInDB) {
        super("Entity : " + entityInDB.toString() + "not found in DB");
    }

}
