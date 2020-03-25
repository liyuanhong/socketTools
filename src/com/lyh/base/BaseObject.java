package com.lyh.base;

/*
 * 实现了基础Base接口的类，用来做统一操作
 * 所有类都必须继承BaseObject
 */

public abstract class BaseObject extends Object implements Base {
	
	/*
	 * (non-Javadoc)
	 * @see com.lyh.base.Base#getCurrentClassName()
	 * 获取当前类名
	 */
	public String getCurrentClassName(){
		return this.getClass().getName();
		
	}
	
}
