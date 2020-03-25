package com.lyh.base;

/*
 * 定义了一个所有类的基类接口，所有的类都必须间接实现该接口
 * 该接口被抽象类BaseObject实现
 */

public interface Base {
	public abstract String getCurrentClassName();
}
