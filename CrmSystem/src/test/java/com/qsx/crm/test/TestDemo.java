package com.qsx.crm.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.qsx.crm.model.UserModel;
import com.qsx.crm.module.user.repository.UserRepository;
import com.qsx.crm.module.user.service.UserService;

public class TestDemo {
	
	@Autowired
	private UserService userService;
/*	
	@Test
	public void test() {
		
		UserModel user = userService.findOne(1L);
		
		System.out.println(user.toString());
		
		

	}*/

	public static void main(String[] args) {
		int[]  array= new int[]{2,56,8,64,12,38,68};
		array = maopao(array);
		for (int i : array) {
			System.out.println(i );
		}
	}
	public static int[] maopao(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] <= array [i]);
			else {
				for (int j = i; j > 0; j--) {
					if (array[j] <= array[j-1]) {
						int temp = array[j-1];
						array[j-1] = array[j];
						array[j] = temp;
					}else {
						break;
					}
				}
			}
		}
		return array;
	}
}
