package com.ty.mb.zm.stu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 钟鸣
 * @since 2020-05-27
 */
@Data
@TableName("student")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学号")
      @TableId(value = "sno", type = IdType.AUTO)
    private Integer sno;

    @ApiModelProperty(value = "姓名")
    private String sname;

    @ApiModelProperty(value = "年龄")
    private Integer sage;

    @ApiModelProperty(value = "性别")
    private String ssex;


}
