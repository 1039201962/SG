package com.sg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sg.pojo.Item;

@Mapper
public interface ItemMapper extends BaseMapper<Item> {
	
	@Select("SELECT * FROM tb_item ORDER BY updated DESC LIMIT #{start},#{rows}")
	List<Item> findItems(@Param("start")int start,@Param("rows") int rows);

	
	
}
