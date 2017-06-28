package org.publiccms.logic.service.cms;

import java.util.List;

import org.publiccms.entities.cms.CmsDictionaryData;
import org.publiccms.logic.dao.cms.CmsDictionaryDataDao;

// Generated 2016-11-20 14:50:55 by com.publiccms.common.source.SourceGenerator

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publiccms.common.base.BaseService;

/**
 *
 * CmsDictionaryDataService
 * 
 */
@Service
@Transactional
public class CmsDictionaryDataService extends BaseService<CmsDictionaryData> {

    /**
     * @param dictionaryId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public List<CmsDictionaryData> getList(long dictionaryId) {
        return dao.getList(dictionaryId);
    }

    @Autowired
    private CmsDictionaryDataDao dao;

}