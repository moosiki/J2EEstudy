package online.shixun.common;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQL5InnoDBUTF8Dialect extends MySQL5Dialect{
	@Override
	public String getTableTypeString() {
		// TODO Auto-generated method stub
		return "ENGINE=InnoDB CHARSET=utf8";
	}
}
