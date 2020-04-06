package com.example.springapp.demo1;

public class UserDaoImpl implements UserDao{
    /** 保存用户 */
    @Override
    public void sava() {
        System.out.println("保存用户.....");
    }
    /** 修改用户 */
    @Override
    public void update() {
        System.out.println("修改用户");
    }
    /** 删除用户 */
    @Override
    public void delete() {
        System.out.println("删除用户");
    }
    /** 查询用户 */
    @Override
    public void find() {
        System.out.println("查询用户");
    }
}
