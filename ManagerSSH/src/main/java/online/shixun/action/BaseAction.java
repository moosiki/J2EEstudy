package online.shixun.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import online.shixun.service.Server;

/**
 * ͨ�õĿ���������
 * @param <T>
 */
public abstract class BaseAction<T> extends ActionSupport {

    /**
     * ģ�����
     */
    protected T object;

    /**
     * ģ����󼯺�
     */
    protected List<T> objects;

    /**
     * ģ�����
     */
    protected Server<T> server;
    
    /**
     * ����
     */
    protected Integer id;
    
    /**
     * ָ��ע���Ǹ�����
     * @param server
     */
    public abstract void setServer(Server<T> server);

    /**
     * �鿴����
     * @return
     */
    public abstract String list();
    
    /**
     * ȥ��ӽ���
     * @return
     */
    public String to_save(){
        return "to_save";
    }

    /**
     * ִ�����
     * @return
     */
    public  String do_save(){
        server.save(object);
        return "do_save";
    }

    /**
     * ���ݱ�Ų鿴һ��
     * @return
     */
    public abstract String to_edit();

    /**
     * ִ���޸�
     * @return
     */
    public  String do_edit(){
        server.edit(object);
        return "do_edit";
    }

    /**
     * ִ��ɾ��
     * @return
     */
    public  String do_delete(){
        server.delete(object);
        return "do_delete";
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
}
