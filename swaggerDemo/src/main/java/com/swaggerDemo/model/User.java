package com.swaggerDemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel("使用者實體類") //用於描述實體類
@Data                  //生成get、set方法
@NoArgsConstructor     //生成無參建構子
@AllArgsConstructor    //生成多參建構子
public class User {
    @ApiModelProperty(value = "姓名", required = true)   // @ApiModelProperty：用於描述字段訊息
    private String name;
    @ApiModelProperty(value = "年齡", required = true)
    private Integer age;
}
