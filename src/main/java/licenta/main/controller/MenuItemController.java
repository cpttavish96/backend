package licenta.main.controller;

import licenta.main.dto.MenuItemDto;
import licenta.main.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/menus")
public class MenuItemController {

    @Autowired
    public MenuItemService menuService;

    @PostMapping("/get-menus")
    public List<MenuItemDto> getUserMenus(@RequestBody int userId) {
        return menuService.getUserMenus(userId);
    }

    @PostMapping("/add-menu")
    public void addMenu(@RequestBody int userId) {
        menuService.addMenu(userId);
    }

    @PostMapping("/edit-menu")
    public void editMenu(@RequestBody MenuItemDto menuDto) {
        menuService.editMenu(menuDto);
    }

    @PostMapping("/delete-menu")
    public void deleteMenu(@RequestBody int id) {
        menuService.deleteMenu(id);
    }
}
