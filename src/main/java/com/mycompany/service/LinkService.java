
package com.mycompany.service;

import com.mycompany.entity.Link;

public interface LinkService {

    Link addLink(Link link);

    Link findLink(Integer id);

    Link updateLink(Link link);

    Link removeLink(Link link);

}
