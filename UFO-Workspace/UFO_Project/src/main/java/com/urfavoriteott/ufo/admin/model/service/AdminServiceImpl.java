package com.urfavoriteott.ufo.admin.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urfavoriteott.ufo.admin.model.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Autowired
    private AdminDao adminDao;
}