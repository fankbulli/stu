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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Sc对象", description="")
@TableName(value = "sc")
public class Sc implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "sno", type = IdType.AUTO)
    @ApiModelProperty(value = "学号")
    private Integer sno;

    @ApiModelProperty(value = "课程编号")
    private Integer cno;

    @ApiModelProperty(value = "成绩")
    private Integer score;


}
