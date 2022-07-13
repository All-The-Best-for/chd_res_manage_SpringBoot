package com.wbs.chd_res.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * @author wbs
 * @create 2022-06-05 9:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcUserList {
    private LinkedList<UserInfo> userList;
}
