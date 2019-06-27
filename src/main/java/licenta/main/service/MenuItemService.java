package licenta.main.service;

import licenta.main.dao.MenuItemDao;
import licenta.main.dto.MenuItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemDao menuItemDao;

    public List<MenuItemDto> getUserMenus(int userId) {

        List<MenuItemDto> result = new ArrayList<>();

        menuItemDao.getUserMenus(userId, rs ->
            result.add(new MenuItemDto(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getString("title"),
                rs.getInt("index_pos"),
                rs.getInt("text_size"),
                rs.getString("text_font"),
                rs.getInt("font_weight"),
                rs.getInt("min_height"),
                rs.getInt("max_height"),
                rs.getInt("min_width"),
                rs.getInt("max_width"),
                rs.getInt("margin_top"),
                rs.getInt("margin_bottom"),
                rs.getInt("margin_left"),
                rs.getInt("margin_right")
        )));

        return result;
    }

    public void addMenu(int userId) {
        menuItemDao.addMenu(userId);
    }

    public void editMenu(MenuItemDto menuDto) {
        menuItemDao.editMenu(
            menuDto.getId(), menuDto.getUserId(), menuDto.getTitle(), menuDto.getIndexPos(), menuDto.getTextSize(),
            menuDto.getTextFont(), menuDto.getFontWeight(), menuDto.getMinHeight(), menuDto.getMaxHeight(),
            menuDto.getMinWidth(), menuDto.getMaxWidth(), menuDto.getMarginTop(), menuDto.getMarginBottom(),
            menuDto.getMarginLeft(), menuDto.getMarginRight()
        );
    }

    public void deleteMenu(int id) {
        menuItemDao.deleteMenu(id);
    }
}