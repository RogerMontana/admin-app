package com.loopme.task.adminapp;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.loopme.task.adminapp.dao.ApplicationDAO;
import com.loopme.task.adminapp.dao.UserDAO;
import com.loopme.task.adminapp.entity.app.App;
import com.loopme.task.adminapp.entity.app.AppType;
import com.loopme.task.adminapp.entity.user.UserRole;
import com.loopme.task.adminapp.services.application.AppCreateForm;
import com.loopme.task.adminapp.services.application.ApplicationService;
import com.loopme.task.adminapp.services.application.impl.ApplicatonServiceImpl;
import com.loopme.task.adminapp.services.user.UserCreateForm;
import com.loopme.task.adminapp.services.user.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ApplicationDAO applicationDAO;

	@Test
	public void saveAdminUserInfo() {
		UserServiceImpl service = new UserServiceImpl(userDAO);
		UserCreateForm form = new UserCreateForm();
		form.setRole(UserRole.ADMIN);
		form.setUsername("Name");
		form.setPassword("111111111");
		form.setEmail("fff@gmail.com");
		form.setEnabled(true);
		service.create(form);
		Assert.assertTrue(service.getByUsername("Name").get().getUsername().equals("Name"));
	}

	@Test
	public void saveApplications() {
		ApplicationService service = new ApplicatonServiceImpl(applicationDAO);
		AppCreateForm form = new AppCreateForm();
		form.setName("testApp");
		form.setType(AppType.IOS);
		service.create(form);
		App a = service.getAppByName("testApp").orElseThrow(NoSuchElementException::new);
		Assert.assertTrue(a.getName().equals("testApp"));
		Assert.assertTrue(a.getType().equals(AppType.IOS));
	}

}
