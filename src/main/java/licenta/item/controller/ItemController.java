package licenta.item.controller;

import licenta.item.dto.ItemDto;
import licenta.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    public ItemService itemService;

    @GetMapping("/get")
    public List<ItemDto> getMenuItems(int menuId) {
        return itemService.getMenuItems(menuId);
    }

    @GetMapping("/add")
    public void addItem(int menuId) {
        itemService.addItem(menuId);
    }

    @PutMapping("/edit")
    public void editItem(@RequestBody ItemDto itemDto) {
        itemService.editItem(itemDto);
    }

    @DeleteMapping("/delete/{id}/{menuId}")
    public void deleteItem(@PathVariable int id, @PathVariable int menuId) {
        itemService.deleteItem(id, menuId);
    }
}
