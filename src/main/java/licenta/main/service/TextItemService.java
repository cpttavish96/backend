package licenta.main.service;

import licenta.main.dao.TextItemDao;
import licenta.main.dto.TextItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextItemService {

    @Autowired
    private TextItemDao itemDao;

    public List<TextItemDto> getMenuItems(int menuId) {

        List<TextItemDto> result = new ArrayList<>();

        itemDao.getMenuItems(menuId, rs ->
            result.add(new TextItemDto(
                rs.getInt("id"),
                rs.getInt("type_id"),
                rs.getInt("menu_id"),
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

    public void addTitle(int menuId) {
        itemDao.addTitle(menuId);
    }

    public void addSubtitle(int menuId) {
        itemDao.addSubtitle(menuId);
    }

    public void addText(int menuId) {
        itemDao.addText(menuId);
    }

    public void editItem(TextItemDto itemDto) {
        itemDao.editItem(
            itemDto.getId(), itemDto.getMenuId(), itemDto.getTitle(), itemDto.getIndexPos(), itemDto.getTextSize(),
            itemDto.getTextFont(), itemDto.getFontWeight(), itemDto.getMinHeight(), itemDto.getMaxHeight(),
            itemDto.getMinWidth(), itemDto.getMaxWidth(), itemDto.getMarginTop(), itemDto.getMarginBottom(),
            itemDto.getMarginLeft(), itemDto.getMarginRight()
        );
    }

    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }
}
