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

    public void editItem(int id, int menuId, String title, String content, int indexPos, int textSize, String textFont, int fontWeight, int minHeight, int maxHeight, int minWidth, int maxWidth, int marginTop, int marginBottom, int marginLeft, int marginRight) {
        itemDao.editItem(id, menuId, title, content, indexPos, textSize, textFont, fontWeight, minHeight, maxHeight, minWidth, maxWidth, marginTop, marginBottom, marginLeft, marginRight);
    }

    public void deleteItem(int id, int menuId) {
        itemDao.deleteItem(id, menuId);
    }

}
