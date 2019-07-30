package com.kimino_recipe.desktop.service;

import org.springframework.stereotype.Service;

import com.kimino_recipe.desktop.mapper.adminMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class adminServiceImpl implements adminService {
	
	adminMapper admin;
}
