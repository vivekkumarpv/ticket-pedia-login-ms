package com.ticketpedia.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticketpedia.usermanagement.model.Admin;
import com.ticketpedia.usermanagement.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Admin login(String username, String password) {
		Admin admin = adminRepository.findByUsername(username);
		if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
			return admin;
		}
		return null;
	}

	@Override
	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	@Override
	public Admin signup(Admin admin) {

		// Encode the password before saving it
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return adminRepository.save(admin);

	}
}
