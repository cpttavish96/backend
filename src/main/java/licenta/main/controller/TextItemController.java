package licenta.main.controller;

import licenta.main.dto.TextItemDto;
import licenta.main.service.TextItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class TextItemController {

    @Autowired
    public TextItemService textItemService;

    @PostMapping("/get-items")
    public List<TextItemDto> getMenuItems(@RequestBody int menuId) {
        return textItemService.getMenuItems(menuId);
    }

    @PostMapping("/add-text")
    public void addItem(@RequestBody int menuId) {
        textItemService.addText(menuId);
    }

    @PostMapping("/add-subtitle")
    public void addSubtitle(@RequestBody int menuId) {
        textItemService.addSubtitle(menuId);
    }

    @PostMapping("/add-title")
    public void addTitle(@RequestBody int menuId) {
        textItemService.addTitle(menuId);
    }

    @PostMapping("/edit-item")
    public void editItem(@RequestBody TextItemDto textItemDto) {
        textItemService.editItem(textItemDto);
    }

    @PostMapping("/delete-item")
    public void deleteItem(@RequestBody int id) {
        textItemService.deleteItem(id);
    }
}
