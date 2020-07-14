package com.cc1021.dao;

import com.cc1021.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门dao
 * 模拟数据库中的数据
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();   //  创建一个部门表
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "销售部"));
    }

    /**
     * 获取所有部门信息
     * @return
     */
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    /**
     * 通过id获取部门
     * @param id
     * @return
     */
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }


}
