/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoInter;

import com.mycompany.entity.Link;

/**
 *
 * @author user
 */
public interface LinkDaoInter {

    Link addLink(Link link);

    Link findLink(Integer id);

    Link updateLink(Link link);

    Link removeLink(Link link);

}
