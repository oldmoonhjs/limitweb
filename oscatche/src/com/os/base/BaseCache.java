package com.os.base;

import java.util.Date;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public class BaseCache extends GeneralCacheAdministrator {       
    
    private static final long serialVersionUID = -4397192926052141162L;  
    private String keyPrefix; //关键字前缀字符，区别属于哪个模块  
    private int refreshPeriod; //过期时间(单位为秒);           
  
    public BaseCache(String keyPrefix,int refreshPeriod){      
        super();      
        this.keyPrefix = keyPrefix;      
        this.refreshPeriod = refreshPeriod;      
  
    }      
  
    /** 
     *      
     * put(添加被缓存的对象) 
     * @param key 
     * @param value  
     * @return void 
     * @createDate 2013-1-31 下午04:16:46 
     * @since  1.0.0 
     */  
    public void put(String key,Object value){      
        this.putInCache(this.keyPrefix+"_"+key,value);      
    }      
  
    /** 
     * remove(删除被缓存的对象) 
     * @param key  
     * @return void 
     * @createDate 2013-1-31 下午04:17:06 
     * @since  1.0.0 
     */  
    public void remove(String key){      
        this.flushEntry(this.keyPrefix+"_"+key);      
    }      
  
    /** 
     * removeAll(删除指定日期所有被缓存的对象) 
     * @param date  
     * @return void 
     * @createDate 2013-1-31 下午04:17:29 
     * @since  1.0.0 
     */  
    public void removeAll(Date date){      
        this.flushAll(date);      
    }             
  
    /** 
     * removeAll(删除所有被缓存的对象)  
     * @return void 
     * @createDate 2013-1-31 下午04:18:01 
     * @since  1.0.0 
     */  
    public void removeAll(){      
        this.flushAll();      
    }      
  
    /** 
     * get(获取被缓存的对象) 
     * @param key 
     * @return 
     * @throws Exception  
     * @return Object 
     * @createDate 2013-1-31 下午04:18:45 
     * @since  1.0.0 
     */  
    public Object get(String key) throws Exception{      
        try{      
            return this.getFromCache(this.keyPrefix+"_"+key,this.refreshPeriod);      
        } catch (NeedsRefreshException e) {      
            this.cancelUpdate(this.keyPrefix+"_"+key);      
            e.printStackTrace();  
            throw e;  
        }        
    }              
}     