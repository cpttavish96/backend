package licenta.menus.service;

import licenta.menus.dao.MenuDao;
import licenta.menus.dto.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<MenuDto> getUserMenus(int userId) {
        return menuDao.getUserMenus(userId);
    }

    public void addMenu(int userId) {
        menuDao.addMenu(userId);
    }

    public void editMenu(MenuDto menuDto) {
        menuDao.editMenu(
            menuDto.getId(),
            menuDto.getUserId(),
            menuDto.getTitle(),
            menuDto.getIndexPos(),
            menuDto.getTextSize(),
            menuDto.getTextFont(),
            menuDto.getFontWeight(),
            menuDto.getMinHeight(),
            menuDto.getMaxHeight(),
            menuDto.getMinWidth(),
            menuDto.getMaxWidth(),
            menuDto.getMarginTop(),
            menuDto.getMarginBottom(),
            menuDto.getMarginLeft(),
            menuDto.getMarginRight()
        );
    }

    public void deleteMenu(int id, int userId) {
        menuDao.deleteMenu(id, userId);
    }
}