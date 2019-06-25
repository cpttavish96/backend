package licenta.item.controller;

import licenta.item.dto.ItemDto;
import licenta.item.service.ItemService;
import licenta.menus.dto.MenuDto;
import licenta.menus.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {


    @Autowired
    public ItemService itemService;

    @GetMapping("/get")
    public List<ItemDto> getUserMenus(int menuId) {
        return itemService.getMenuItems(menuId);
    }

    @GetMapping("/add")
    public void addMenu(int menuId) {
        itemService.addItem(menuId);
    }

    @PostMapping("/edit")
    public void editMenu(int id, int menuId, String title, String content, int indexPos, int textSize, String textFont, int fontWeight, int minHeight, int maxHeight, int minWidth, int maxWidth, int marginTop, int marginBottom, int marginLeft, int marginRight) {
        itemService.editItem(id, menuId, content, title, indexPos, textSize, textFont, fontWeight, minHeight, maxHeight, minWidth, maxWidth, marginTop, marginBottom, marginLeft, marginRight);
    }

    @GetMapping("/delete")
    public void deleteMenu(int id, int menuId) {
        itemService.deleteItem(id, menuId);
    }

}
