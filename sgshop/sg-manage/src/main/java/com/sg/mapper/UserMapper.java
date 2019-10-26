package com.sg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sg.pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
	@Select("SELECT * FROM tb_user ORDER BY updated DESC LIMIT #{start},#{rows}")
	List<User> findUser(@Param("start")Integer start,@Param("rows")Integer rows);
	
	@Select("SELECT * FROM tb_user WHERE username LIKE '%${key}%'" )
	List<User> findlike(@Param("key")String key);

}
