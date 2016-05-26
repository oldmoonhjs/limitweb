package com.os.base;

import java.util.Date;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public class BaseCache extends GeneralCacheAdministrator {       
    
    private static final long serialVersionUID = -4397192926052141162L;  
    private String keyPrefix; //�ؼ���ǰ׺�ַ������������ĸ�ģ��  
    private int refreshPeriod; //����ʱ��(��λΪ��);           
  
    public BaseCache(String keyPrefix,int refreshPeriod){      
        super();      
        this.keyPrefix = keyPrefix;      
        this.refreshPeriod = refreshPeriod;      
  
    }      
  
    /** 
     *      
     * put(��ӱ�����Ķ���) 
     * @param key 
     * @param value  
     * @return void 
     * @createDate 2013-1-31 ����04:16:46 
     * @since  1.0.0 
     */  
    public void put(String key,Object value){      
        this.putInCache(this.keyPrefix+"_"+key,value);      
    }      
  
    /** 
     * remove(ɾ��������Ķ���) 
     * @param key  
     * @return void 
     * @createDate 2013-1-31 ����04:17:06 
     * @since  1.0.0 
     */  
    public void remove(String key){      
        this.flushEntry(this.keyPrefix+"_"+key);      
    }      
  
    /** 
     * removeAll(ɾ��ָ���������б�����Ķ���) 
     * @param date  
     * @return void 
     * @createDate 2013-1-31 ����04:17:29 
     * @since  1.0.0 
     */  
    public void removeAll(Date date){      
        this.flushAll(date);      
    }             
  
    /** 
     * removeAll(ɾ�����б�����Ķ���)  
     * @return void 
     * @createDate 2013-1-31 ����04:18:01 
     * @since  1.0.0 
     */  
    public void removeAll(){      
        this.flushAll();      
    }      
  
    /** 
     * get(��ȡ������Ķ���) 
     * @param key 
     * @return 
     * @throws Exception  
     * @return Object 
     * @createDate 2013-1-31 ����04:18:45 
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