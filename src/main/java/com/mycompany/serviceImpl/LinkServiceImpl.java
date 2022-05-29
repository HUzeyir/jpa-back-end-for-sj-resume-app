package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.LinkDaoImple;
import com.mycompany.daoInter.LinkDaoInter;
import com.mycompany.entity.Link;
import com.mycompany.service.LinkService;

public class LinkServiceImpl implements LinkService {

    private LinkDaoInter ldi = new LinkDaoImple();

    @Override
    public Link addLink(Link link) {
        return ldi.addLink(link);
    }

    @Override
    public Link findLink(Integer id) {
        return ldi.findLink(id);
    }

    @Override
    public Link updateLink(Link link) {
        return ldi.updateLink(link);
    }

    @Override
    public Link removeLink(Link link) {
        return ldi.removeLink(link);
    }

}
