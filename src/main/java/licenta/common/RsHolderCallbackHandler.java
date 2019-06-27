package licenta.common;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Radu Dudas on 22.09.2016.
 */
public class RsHolderCallbackHandler implements RowCallbackHandler {
    private RsHolder rsHolder;

    public RsHolderCallbackHandler(RsHolder rsHolder) {
        this.rsHolder = rsHolder;
    }

    public void processRow(ResultSet rs) throws SQLException {
        rsHolder.set(rs);
    }
}