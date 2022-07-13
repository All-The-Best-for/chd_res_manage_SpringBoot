package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wbs
 * @create 2022-05-29 21:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManageLoginForm {
    private String name;
    private String pwd;
    private Integer manageClass;
}
