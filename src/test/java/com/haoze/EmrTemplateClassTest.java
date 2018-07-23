package com.haoze;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.service.emr.EmrCataLogService;
import com.haoze.service.template.EmrTemplateClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * Created by haoz-dev4 on 2018/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmrTemplateClassTest {

    @Autowired
    EmrTemplateClassService emrTemplateClassService;
    @Autowired
    EmrCataLogService emrCataLogService;

    @Test
    public void getRootNode() {

        String cataLogId = "d29ff8c978194dfd9efce20cb05321c2";
        String rootId = getRootId(cataLogId);
        assert cataLogId != null;
    }

    private String getRootId(String cataLogId) {
        EmrCataLogEntity emrCataLogEntity = emrCataLogService.get(cataLogId);
        if(StringUtils.isEmpty(emrCataLogEntity.getPkFather())){
            return emrCataLogEntity.getID();
        }
        return getRootId(emrCataLogEntity.getPkFather());
    }

    @Test
    public void list() {
        QueryParam queryParam = QueryParam.getDefaultQueryParam();
        queryParam.put("cataLogId", "3e21a79d81ce4f00824276280f30eb9c");
        Page<EmrTemplateClassEntity> list = emrTemplateClassService.list(queryParam);
        assert list != null;
    }
}
