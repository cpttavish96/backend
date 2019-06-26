package licenta.menus.controller;

import licenta.menus.dto.MenuDto;
import licenta.menus.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    public MenuService menuService;

    @GetMapping("/get")
    public List<MenuDto> getUserMenus(int userId) {
        return menuService.getUserMenus(userId);
    }

    @GetMapping("/add")
    public void addMenu(int userId) {
        menuService.addMenu(userId);
    }

    @PostMapping("/edit")
    public void editMenu(@RequestBody MenuDto menuDto) {
        menuService.editMenu(menuDto);
    }

    @GetMapping("/delete")
    public void deleteMenu(int id, int userId) {
        menuService.deleteMenu(id, userId);
    }
}
