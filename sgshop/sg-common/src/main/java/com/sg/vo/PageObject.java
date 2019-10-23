package com.sg.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 后台系统商品管理系统传输数据使用
 * @author GouJian
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageObject implements Serializable{
	
	private int code = 0; //0为正确，1为错误
	private String msg = "";
	private int count = 0;
	private Object data =null;
	
	public PageObject(String msg) {
		super();
		this.msg = msg;
	}

	public PageObject(Object data) {
		super();
		this.data = data;
	}
}
