package com.ruoyi.web.controller.tool;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.utils.StringUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * swagger 使用者測試方法
 *
 * @author ruoyi
 */
@Tag(name = "使用者資訊管理")
@RestController
@RequestMapping("/test/user")
public class TestController extends BaseController {

    private final static Map<Integer, UserEntity> users = new LinkedHashMap<>();
    static {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ry", "admin123", "15666666666"));
    }

    @Operation(summary = "獲取使用者列表")
    @GetMapping("/list")
    public R<List<UserEntity>> userList() {
        List<UserEntity> userList = new ArrayList<>(users.values());
        return R.ok(userList);
    }

    @Operation(summary = "獲取使用者詳細")
    @GetMapping("/{userId}")
    public R<UserEntity> getUser(
            @Parameter(description = "使用者ID", required = true)
            @PathVariable Integer userId) {
        if (!users.isEmpty() && users.containsKey(userId)) {
            return R.ok(users.get(userId));
        } else {
            return R.fail("使用者不存在");
        }
    }

    @Operation(summary = "新增使用者")
    @PostMapping("/save")
    public R<String> save(@RequestBody UserEntity user) {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId())) {
            return R.fail("使用者ID不能為空");
        }
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @Operation(summary = "更新使用者")
    @PutMapping("/update")
    public R<String> update(@RequestBody UserEntity user) {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId())) {
            return R.fail("使用者ID不能為空");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId())) {
            return R.fail("使用者不存在");
        }
        users.put(user.getUserId(), user);
        return R.ok();
    }

    @Operation(summary = "刪除使用者資訊")
    @DeleteMapping("/{userId}")
    public R<String> delete(
            @Parameter(description = "使用者ID", required = true)
            @PathVariable Integer userId) {
        if (!users.isEmpty() && users.containsKey(userId)) {
            users.remove(userId);
            return R.ok();
        } else {
            return R.fail("使用者不存在");
        }
    }
}

@Schema(name = "UserEntity", description = "使用者實體")
class UserEntity {

    @Schema(description = "使用者ID", example = "1")
    private Integer userId;

    @Schema(description = "使用者名稱", example = "admin")
    private String username;

    @Schema(description = "使用者密碼", example = "admin123")
    private String password;

    @Schema(description = "手機號碼", example = "0912345678")
    private String mobile;

    public UserEntity() {}

    public UserEntity(Integer userId, String username, String password, String mobile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    // Getter / Setter
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
