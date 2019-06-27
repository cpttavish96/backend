package licenta.main.dao;

import licenta.common.RsHolder;
import licenta.common.RsHolderCallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TextItemDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getMenuItems(int menuId, RsHolder rs) {
        String sql = "SELECT * FROM text_items WHERE menu_id = ?";
        jdbcTemplate.query(sql, new RsHolderCallbackHandler(rs), menuId);
    }

    // 900 = bold, 100 = normal
    public void addTitle(int menuId) {
        addTextItem(1, menuId, "New title", 30, 900);
    }

    public void addSubtitle(int menuId) {
        addTextItem(2, menuId, "New subtitle", 20, 900);
    }

    public void addText(int menuId) {
        addTextItem(3, menuId, "New plain text item", 15, 100);
    }

    public void editItem(int id, int menuId, String title, int indexPos, int textSize, String textFont, int fontWeight, int minHeight, int maxHeight, int minWidth, int maxWidth, int marginTop, int marginBottom, int marginLeft, int marginRight) {

        String sql =
            "UPDATE " +
            "   text_items " +
            "SET " +
            "   title = ?, " +
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
            "   id = ? AND menu_id = ? ";

        jdbcTemplate.update(
                sql,
                title, indexPos, textSize, textFont, fontWeight,
                minHeight, maxHeight, minWidth, maxWidth, marginTop, marginBottom, marginLeft, marginRight,
                id, menuId
        );
    }

    public void deleteItem(int id) {
        String sql = "DELETE FROM text_items WHERE id = ? AND menu_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private void addTextItem(int typeId, int menuId, String text, int textSize, int fontWeight) {

        int indexPos;

        if (getMaxIndexPos(menuId) != null) {
            indexPos = getMaxIndexPos(menuId) + 1;
        } else {
            indexPos = 1;
        }

        String sql =
                "INSERT INTO " +
                "   text_items(type_id, menu_id, title, index_pos, text_size, text_font, font_weight, min_height, max_height, min_width, max_width, margin_top, margin_bottom, margin_left, margin_right)" +
                "VALUES " +
                "   (?, ?, ?, ?, ?, 'Times New Roman', ?, 15, 20, 15, 20, 2, 2, 2, 2)";

        jdbcTemplate.update(sql, typeId, menuId, text, indexPos, textSize, fontWeight);
    }

    private Integer getMaxIndexPos(int menuId) {
        try {
            String sql = "SELECT max(index_pos) FROM text_items WHERE menu_id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[] { menuId }, Integer.class);
        }
        catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

}
