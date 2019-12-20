package com.in28minutes.restwebService.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import com.in28minutes.restwebService.users.*;

@Component
public class UserDaoService 
{
	private static List<Users> users=new ArrayList<>();
	private static Integer userCount=3;
	static
	{
		
		users.add(new Users(1, "Adam", new Date()));
		users.add(new Users(2, "Eve", new Date()));
		users.add(new Users(3, "Jack", new Date()));
	}
	
	public List<Users> findall()
	{
		return users;
	}
	
	public Users save(Users user)
	{
		if(user.getId()==null)
		{
			user.setId(++userCount);
		}
		users.add(user);
		
		return user;
	}
	
	public Users findOne(int id)
	{
		for(Users user:users)
		{
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	public Users deleteByUser(int id)
	{
		Iterator<Users> useritr = users.iterator();
		while(useritr.hasNext())
		{
			Users user = useritr.next();
			if(user.getId()==id)
			{
				useritr.remove();
				return user;
			}
		}
		return null;
	}

}
