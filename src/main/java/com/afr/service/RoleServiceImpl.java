package com.afr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.afr.dao.RoleDao;
import com.afr.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao dao;

	@Override
	public void saveRole(Role role) {
		dao.saveRole(role);
	}

	@Override
	public List<Role> findAllRoles() {
		return dao.findAllRoles();
	}

	@Override
	public void deleteRoleByID(int id) {
		dao.deleteRoleByID(id);
	}

	@Override
	public Role findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public void updateRole(Role role) {
		dao.updateRole(role);
	}

	@Override
	public Role findRoleByCode(String code) {
		return dao.findRoleByCode(code);
	}
	
	public List<Role> findRolesByOrg(String orgCode) {
		return dao.findRolesByOrg(orgCode);
	}
}
