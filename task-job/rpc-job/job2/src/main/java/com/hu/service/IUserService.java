package com.hu.service;

import com.hu.domain.User;

import java.util.Collection;
import java.util.List;

/**
 * Simple to Introduction
 * className: IUserService
 *
 * @author EricYang
 * @version 2018/11/10 11:18
 */
public interface IUserService {
    public User getById(String id);
    public User deleteById(String id);
    public User save(User user);
    public Collection<User> getAllUsers();
}
