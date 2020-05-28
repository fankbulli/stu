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
@TableName(value = "teacher")
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "tno", type = IdType.AUTO)
    @ApiModelProperty(value = "教师编号")
      private Integer tno;

    @ApiModelProperty(value = "教师名字")
    private String tname;


}
