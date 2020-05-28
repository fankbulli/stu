package com.ty.mb.zm.stu.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName(value = "course")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Course对象", description="")
public class Course implements Serializable {

    private static final long serialVersionUID=1L;


    @TableId(value = "cno", type = IdType.AUTO)
    @ApiModelProperty(value = "课程编号")
      private Integer cno;

    @ApiModelProperty(value = "课程名字")
    private String cname;

    @ApiModelProperty(value = "教师编号")
    private Integer tno;


}
