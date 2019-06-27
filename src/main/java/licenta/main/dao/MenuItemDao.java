package licenta.main.dao;

import licenta.common.RsHolder;
import licenta.common.RsHolderCallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MenuItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getUserMenus(int userId, RsHolder rs) {
        String sql = "SELECT * FROM menus WHERE user_id = ? ORDER BY index_pos ASC";
        jdbcTemplate.query(sql, new RsHolderCallbackHandler(rs), userId );
    }

    public void addMenu(int userId) {

        int indexPos;
        int userMenuCount = getUserMenuCount(userId) + 1;

        if (getMaxIndexPos(userId) != null) {
            indexPos = getMaxIndexPos(userId) + 1;
        } else {
            indexPos = 1;
        }

        String sql =
                "INSERT INTO " +
                "   menus(user_id, title, index_pos, text_size, text_font, font_weight, min_height, max_height, min_width, max_width, margin_top, margin_bottom, margin_left, margin_right)" +
                "VALUES " +
                "   (?, ?, ?, 15, 'Times New Roman', 1, 15, 20, 15, 20, 2, 2, 2, 2)";

        jdbcTemplate.update(sql, userId, "Menu " + userMenuCount, indexPos);
    }

    public void editMenu(int id, int userId, String title, int indexPos, int textSize, String textFont, int fontWeight, int minHeight, int maxHeight, int minWidth, int maxWidth, int marginTop, int marginBottom, int marginLeft, int marginRight) {

        String sql =
                "UPDATE " +
                "   menus " +
                "SET " +
                "   title = ?," +
                "   index_pos = ?, " +
                "   text_size = ?, " +
                "   text_font = ?, " +
                "   font_weight = ?, " +
                "   min_height = ?, " +
                "   max_height = ?, " +
                "   min_width = ?, " +
                "   max_width = ?, " +
                "   margin_top = ?, " +
                "   margin_bottom = ?, " +
                "   margin_left = ?, " +
                "   margin_right = ? " +
                "WHERE " +
                "   id = ? AND user_id = ? ";

        jdbcTemplate.update(
                sql,
                title, indexPos, textSize, textFont, fontWeight,
                minHeight, maxHeight, minWidth, maxWidth, marginTop, marginBottom, marginLeft, marginRight,
                id, userId
        );
    }

    public void deleteMenu(int id) {
        jdbcTemplate.update("DELETE FROM text_items WHERE menu_id = ?", id);
        jdbcTemplate.update("DELETE FROM menus WHERE id = ?", id);
    }

    private Integer getMaxIndexPos(int userId) {
        try {
            String sql = "SELECT max(index_pos) FROM menus WHERE user_id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[] { userId }, Integer.class);
        }
        catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    private Integer getUserMenuCount(int userId) {
        try {
            String sql = "SELECT count(*) FROM menus WHERE user_id = ? AND title LIKE 'Menu%' ";
            return jdbcTemplate.queryForObject(sql, new Object[] {userId}, Integer.class);
        }
        catch (EmptyResultDataAccessException e) {
            return 1;
        }
    }

    /*private List<Integer> getIndexes(int userId) {
        String sql = "SELECT index_pos FROM menus WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[] { userId }, new RowMapper<Integer>() {
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt(1);
            }
        });
    }*/
}