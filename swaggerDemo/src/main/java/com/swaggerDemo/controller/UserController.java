package com.swaggerDemo.controller;

import com.swaggerDemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "使用者接口")
@RestController
@RequestMapping("/users")
public class UserController {

    @ApiOperation(value = "查詢使用者", notes = "查詢使用者。")
    @ApiResponses({
            @ApiResponse(responseCode="200", description="成功取得使用者"),
            @ApiResponse(responseCode="400", description="輸入格式錯誤"),
            @ApiResponse(responseCode="404", description="找不到使用者")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "使用者姓名", required = true),
            @ApiImplicitParam(name = "age", value = "使用者年齡", required = false),
    })
    @GetMapping(value = "/{name}")
    public ResponseEntity<User> findUser(@PathVariable(value = "name", required = true) String name,
                                         @RequestParam(value = "age", required = false) Integer age) {
        // 创建模拟数据，然后返回数据
        return ResponseEntity.ok(new User(name, age));
    }

}
