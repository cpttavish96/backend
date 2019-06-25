package licenta.item.dao;

import licenta.item.dto.ItemDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<ItemDto>
{
    public ItemDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(rs.getInt("id"));
        itemDto.setMenuId(rs.getInt("menu_id"));
        itemDto.setTypeId(rs.getInt("type_id"));
        itemDto.setTitle(rs.getString("title"));
        itemDto.setContent(rs.getString("content"));
        itemDto.setIndexPos(rs.getInt("index_pos"));
        itemDto.setTextSize(rs.getInt("text_size"));
        itemDto.setTextFont(rs.getString("text_font"));
        itemDto.setFontWeight(rs.getInt("font_weight"));
        itemDto.setMinHeight(rs.getInt("min_height"));
        itemDto.setMaxHeight(rs.getInt("max_height"));
        itemDto.setMinWidth(rs.getInt("min_width"));
        itemDto.setMaxWidth(rs.getInt("max_width"));
        itemDto.setMarginTop(rs.getInt("margin_top"));
        itemDto.setMarginBottom(rs.getInt("margin_bottom"));
        itemDto.setMarginLeft(rs.getInt("margin_left"));
        itemDto.setMarginRight(rs.getInt("margin_right"));

        return itemDto;
    }

}