package cn.cooode.activityTools.controller.admin;

import cn.cooode.activityTools.constants.EntityConstants;
import cn.cooode.activityTools.constants.SessionConstants;
import cn.cooode.activityTools.dto.ResultDto;
import cn.cooode.activityTools.entity.Category;
import cn.cooode.activityTools.entity.User;
import cn.cooode.activityTools.service.CategoryService;
import cn.cooode.activityTools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.Date;

/**
 * Created by BaiYunfei on 2017/1/5.
 */
@RequestMapping("/admin/category")
@Controller
public class AdminCategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @RequestMapping("/update")
    public @ResponseBody
    ResultDto update(Long categoryId, String categoryName){
        if(categoryId <= 0){
            return new ResultDto(false,"id is null");
        }
        Category category = categoryService.get(categoryId);
        if(null == category){
            return new ResultDto(false,"category not exist");
        }
        category.setName(categoryName);
        categoryService.update(category);
        return new ResultDto(true);
    }

    @RequestMapping("/delete")
    public @ResponseBody ResultDto delete(Long categoryId){
        if(categoryId <= 0){
            return new ResultDto(false,"id is null");
        }
        categoryService.delete(categoryId);
        return new ResultDto(true);
    }

    @RequestMapping("/save")
    public @ResponseBody ResultDto save(String categoryName,HttpSession session){
        if(null == categoryName || "".equals(categoryName)){
            return new ResultDto(false,"name is null");
        }
        User user = userService.get((Long)session.getAttribute(SessionConstants.USER_ID));

        Category category = new Category();
        category.setName(categoryName);
        category.setAuthor(user);
        category.setPublishTime(new Date());
        category.setState(EntityConstants.CATEGORY_STATE_NORMAL);

        categoryService.save(category);
        return new ResultDto(true);
    }

}
