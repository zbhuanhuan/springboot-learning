package com.wanghuan.jpa;

import com.wanghuan.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 54416 on 2017/8/1.
 */
public interface UserJPA extends JpaRepository<UserEntity,Long> {
    @Query(value = "select * from t_user where t_age > 1",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    //根据用户名、密码删除一条数据
    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}
