package licenta.menus.dao;

import licenta.menus.dto.MenuDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuRowMapper implements RowMapper<MenuDto>
{
    public MenuDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuDto menuDto = new MenuDto();
        menuDto.setId(rs.getInt("id"));
        menuDto.setUserId(rs.getInt("user_id"));
        menuDto.setTitle(rs.getString("title"));
        menuDto.setIndexPos(rs.getInt("index_pos"));
        menuDto.setTextSize(rs.getInt("text_size"));
        menuDto.setTextFont(rs.getString("text_font"));
        menuDto.setFontWeight(rs.getInt("font_weight"));
        menuDto.setMinHeight(rs.getInt("min_height"));
        menuDto.setMaxHeight(rs.getInt("max_height"));
        menuDto.setMinWidth(rs.getInt("min_width"));
        menuDto.setMaxWidth(rs.getInt("max_width"));
        menuDto.setMarginTop(rs.getInt("margin_top"));
        menuDto.setMarginBottom(rs.getInt("margin_bottom"));
        menuDto.setMarginLeft(rs.getInt("margin_left"));
        menuDto.setMarginRight(rs.getInt("margin_right"));

        return menuDto;
    }

}