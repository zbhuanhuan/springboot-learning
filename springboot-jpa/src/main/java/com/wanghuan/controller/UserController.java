package com.wanghuan.controller;

import com.wanghuan.entity.UserEntity;
import com.wanghuan.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 54416 on 2017/8/1.
 */
@RestController
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<UserEntity> list9(){
        return userJPA.findAll();
    }

    @RequestMapping(value = "/add")
    public String add(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("测试");
        userEntity.setAddress("测试地址");
        userEntity.setAge(21);
        userJPA.save(userEntity);
        return "用户信息添加成功";
    }

    @RequestMapping(value = "/delete")
    public String delete(Long userId){
        userJPA.delete(userId);
        return "用户信息删除成功";
    }
    @RequestMapping(value = "/{age}")
    public List<UserEntity> age(@PathVariable int age){
        return userJPA.nativeQuery(age);
    }
    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere(){
        userJPA.deleteQuery("admin","12345");
        return "自定义SQL删除数据成功";
    }
    @RequestMapping(value = "/cutpage")
    public List<UserEntity> cutPage(int page){
        UserEntity userEntity = new UserEntity();
        userEntity.setSize(2);
        userEntity.setSord("desc");
        userEntity.setPage(page);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(userEntity.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction, userEntity.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(userEntity.getPage() - 1,userEntity.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }
}
