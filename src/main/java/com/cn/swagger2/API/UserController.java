package com.cn.swagger2.API;

import com.cn.model.User;
import com.cn.util.AjaxResult;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 *
 * @author guowy
 * @create 2017-05-26 17:28
 **/
//@Auth
@Controller
public class UserController implements UserApi {


    private <T> Map<String, Object> findEasyUidata(Page<T> page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", page.getContent());
        map.put("total", page.getTotalElements());
        return map;
    }

    @Override
    public Map<String, Object> json(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "rows", defaultValue = "10") int rows,
            @NotNull @ApiParam(value = "用户ID", required = true) @RequestParam(name = "ID", defaultValue = "10", required = true) Long ID) {
        return null;
    }

    @Override
    public String list() {
        return null;
    }

    @Override
    public AjaxResult save(@RequestBody User user) {
        return null;
    }
}
