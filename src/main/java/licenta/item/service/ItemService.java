package licenta.item.service;

import licenta.item.dao.ItemDao;
import licenta.item.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<ItemDto> getMenuItems(int menuId) {
        return itemDao.getMenuItems(menuId);
    }

    public void addItem(int menuId) {
        itemDao.addItem(menuId);
    }

    public void editItem(ItemDto itemDto) {
        itemDao.editItem(
            itemDto.getId(), itemDto.getMenuId(), itemDto.getTitle(), itemDto.getContent(), itemDto.getIndexPos(), itemDto.getTextSize(),
            itemDto.getTextFont(), itemDto.getFontWeight(), itemDto.getMinHeight(), itemDto.getMaxHeight(), itemDto.getMinWidth(), itemDto.getMaxWidth(),
            itemDto.getMarginTop(), itemDto.getMarginBottom(), itemDto.getMarginLeft(), itemDto.getMarginRight()
        );
    }

    public void deleteItem(int id, int menuId) {
        itemDao.deleteItem(id, menuId);
    }

}
