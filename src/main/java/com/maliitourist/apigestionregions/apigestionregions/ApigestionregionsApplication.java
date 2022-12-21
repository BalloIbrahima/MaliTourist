package com.maliitourist.apigestionregions.apigestionregions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.maliitourist.apigestionregions.apigestionregions.models.Admin;
import com.maliitourist.apigestionregions.apigestionregions.models.ERole;
import com.maliitourist.apigestionregions.apigestionregions.models.Role;
import com.maliitourist.apigestionregions.apigestionregions.repository.AdminRepository;
import com.maliitourist.apigestionregions.apigestionregions.repository.RoleRepository;
import com.maliitourist.apigestionregions.apigestionregions.services.AdminService;
@SpringBootApplication
public class ApigestionregionsApplication {
	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(ApigestionregionsApplication.class, args);
		RoleRepository roleRepos = ctx.getBean(RoleRepository.class);
		AdminRepository adminRepos = ctx.getBean(AdminRepository.class);

		AdminService adminService = ctx.getBean(AdminService.class);
		
		PasswordEncoder encoder=ctx.getBean(PasswordEncoder.class);



		//Creation du role admin
		try {
			roleRepos.findByName(ERole.ROLE_ADMIN).get();
		} catch (Exception e) {
			// TODO: handle exception
			Role adminRole = new Role();
			// adminRole.setId(2L);
			adminRole.setName(ERole.ROLE_ADMIN);
			roleRepos.save(adminRole);

		}
		//creation du super admin
		try {
			adminRepos.findByUsername("Ballo").get();
		} catch (Exception e) {
			// TODO: handle exception
			Admin admin=new Admin();

			admin.setNom("Ballo");
			admin.setPrenom("Ibrahima");
			admin.setUsername("Ballo");
			admin.setPassword(encoder.encode("bababallo") );
			admin.getRoles().add(roleRepos.findByName(ERole.ROLE_ADMIN).get());
		
			adminService.saveAdmin(admin);

		}
	}

}
