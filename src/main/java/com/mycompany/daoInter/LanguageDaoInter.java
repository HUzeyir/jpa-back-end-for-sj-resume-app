package com.mycompany.daoInter;

import com.mycompany.entity.Language;
import java.util.List;

public interface LanguageDaoInter {

    List<Language> getAllLanguage();

    Language addLanguage(Language lang);

    Language findLanguage(Integer id);

    Language updateLanguage(Language lang);

    Language removeLanguage(Language lang);

}
