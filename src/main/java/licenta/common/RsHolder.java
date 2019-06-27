package licenta.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radu Dudas on 21.09.2016.
 */
public interface RsHolder {
    void set(ResultSet rs) throws SQLException;
}
