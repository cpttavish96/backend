package licenta.item.dao;

import licenta.item.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ItemDto> getMenuItems(int menuId) {
        return jdbcTemplate.query("SELECT * FROM items WHERE menu_id = ?", new ItemRowMapper() {}, menuId );
    }

    public void addItem(int menuId) {

        int indexPos;

        if (getMaxIndexPos(menuId) != null) {
            indexPos = getMaxIndexPos(menuId) + 1;
        } else {
            indexPos = 1;
        }

        jdbcTemplate.update(
            "INSERT INTO " +
            "   items(type_id, menu_id, title, content, index_pos, text_size, text_font, font_weight, min_height, max_height, min_width, max_width, margin_top, margin_bottom, margin_left, margin_right)" +
            "VALUES " +
            "   (?, ?, ?, ?, ?, 15, 'Times New Roman', 1, 15, 20, 15, 20, 2, 2, 2, 2)",
                1, menuId, "New item ", "item content", indexPos
        );
    }

    public void editItem(int id, int menuId, String title, String content, int indexPos, int textSize, String textFont, int fontWeight, int minHeight, int maxHeight, int minWidth, int maxWidth, int marginTop, int marginBottom, int marginLeft, int marginRight) {
        jdbcTemplate.update(
            "UPDATE " +
            "   items " +
            "SET " +
            "   type_id = ?, " +
            "   title = ?, " +
            "   content = ?, " +
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
            "   id = ? AND menu_id = ? ",
                1, title, content, indexPos, textSize, textFont, fontWeight, minHeight, maxHeight, minWidth, maxWidth, marginTop, marginBottom, marginLeft, marginRight,
                id, menuId
        );
    }

    public void deleteItem(int id, int menuId) {
        jdbcTemplate.update("DELETE FROM items WHERE id = ? and menu_id = ?", id, menuId);
    }

    private Integer getMaxIndexPos(int menuId) {
        try {
            String sql = "SELECT max(index_pos) FROM items WHERE menu_id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[] { menuId }, Integer.class);
        }
        catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

}
