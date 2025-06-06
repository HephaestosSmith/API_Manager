package com.ruoyi.web.controller.tool;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * swagger 使用者測試方法
 * 
 * @author ruoyi
 */
@Api("使用者資訊管理")
@RestController
@RequestMapping("/test/user")
public class TestController extends BaseController
{
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<Integer, UserEntity>();
    {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ry", "admin123", "15666666666"));
    }

    @ApiOperation("獲取使用者列表")
    @GetMapping("/list")
    public R<List<UserEntity>> userList()
    {
        List<UserEntity> userList = new ArrayList<UserEntity>(users.values());
        return R.ok(userList);
    }

    @ApiOperation("獲取使用者詳細")
    @ApiImplicitParam(name = "userId", value = "使用者ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @GetMapping("/{userId}")
    public R<UserEntity> getUser(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            return R.ok(users.get(userId));
        }
        else
        {
            return R.fail("使用者不存在");
        }
    }

    @ApiOperation("新增使用者")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "使用者id", dataType = "Integer", dataTypeClass = Integer.class),
        @ApiImplicitParam(name = "username", value = "使用者名稱稱", dataType = "String", dataTypeClass = String.class),
        @ApiImplicitParam(name = "password", value = "使用者密碼", dataType = "String", dataTypeClass = String.class),
        @ApiImplicitParam(name = "mobile", value = "使用者手機", dataType = "String", dataTypeClass = String.class)
    })
    @PostMapping("/save")
    public R<String> save(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return R.fail("使用者ID不能為空");
        }
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @ApiOperation("更新使用者")
    @PutMapping("/update")
    public R<String> update(@RequestBody UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return R.fail("使用者ID不能為空");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId()))
        {
            return R.fail("使用者不存在");
        }
        users.remove(user.getUserId());
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @ApiOperation("刪除使用者資訊")
    @ApiImplicitParam(name = "userId", value = "使用者ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @DeleteMapping("/{userId}")
    public R<String> delete(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            users.remove(userId);
            return R.ok();
        }
        else
        {
            return R.fail("使用者不存在");
        }
    }
}

@ApiModel(value = "UserEntity", description = "使用者實體")
class UserEntity
{
    @ApiModelProperty("使用者ID")
    private Integer userId;

    @ApiModelProperty("使用者名稱稱")
    private String username;

    @ApiModelProperty("使用者密碼")
    private String password;

    @ApiModelProperty("使用者手機")
    private String mobile;

    public UserEntity()
    {

    }

    public UserEntity(Integer userId, String username, String password, String mobile)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
}
