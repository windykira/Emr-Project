package com.haoze;

import com.haoze.model.repository.entity.DataDictionaryEntity;
import com.haoze.model.repository.entity.DataElementEntity;
import com.haoze.model.repository.entity.DataElementValuesEntity;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;
import com.haoze.service.repository.DataElementService;
import com.haoze.service.repository.DataElementValuesService;
import com.haoze.service.repository.DataGroupService;
import com.haoze.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hp on 2018/7/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataGroupTest {

    @Autowired
    DataGroupService dataGroupService;
    @Autowired
    DataElementService dataElementService;
    @Autowired
    DataElementValuesService dataElementValuesService;

    @Test
    public void insertElementValues(){

        DataElementValuesEntity dataElementValuesEntity = new DataElementValuesEntity();
        dataElementValuesEntity.setPkOrg("e736c3b028cd4fb599a0175c00f6266c");
        dataElementValuesEntity.setDelFlag("0");
        dataElementValuesEntity.setCodeDeVal("01");
        dataElementValuesEntity.setNameDeVal("低热");
        dataElementValuesEntity.setDescribe("低热说明");
        dataElementValuesEntity.setPkDataElemt("972f4334be4942c9bab316bde8b3283f");
        dataElementValuesService.insert(dataElementValuesEntity);
    }

    @Test
    public void insertElement(){

        DataDictionaryVO dataDictionaryVO = new DataDictionaryVO();

        DataElementEntity dataElementEntity = new DataElementEntity();
        dataElementEntity.setCodeDe("FD");
        dataElementEntity.setNameDe("分度");
        dataElementEntity.setDefinition("desfs");
        dataElementEntity.setPkOrg("e736c3b028cd4fb599a0175c00f6266c");
        dataElementEntity.setDelFlag("0");

        DataDictionaryEntity dataDictionaryEntity = new DataDictionaryEntity();
        dataDictionaryEntity.setPkOrg("e736c3b028cd4fb599a0175c00f6266c");
        dataDictionaryEntity.setNameNode("分度");
        dataDictionaryEntity.setNodeType("2");
        dataDictionaryEntity.setOrdNode("1");
        dataDictionaryEntity.setPkFather("7fa685e9b25e42e28435066d615e4cfb");
        dataDictionaryEntity.setPkRoot("5794bf541c2c59af96278389f628df6a");
        dataDictionaryEntity.setRemark("remarkFD");

        dataDictionaryVO.setDataElement(dataElementEntity);
        dataDictionaryVO.setDataDictionary(dataDictionaryEntity);
        dataElementService.insert(dataDictionaryVO);
    }

    @Test
    public void insert(){

        DataDictionaryVO dataDictionaryVO = new DataDictionaryVO();
        DataDictionaryEntity dataDictionaryEntity = new DataDictionaryEntity();
        DataGroupEntity dataGroupEntity = new DataGroupEntity();
        dataGroupEntity.setCodeDg("DDD");
        dataGroupEntity.setNameDg("病案");
        dataGroupEntity.setDescribe("病案Describe");
        dataGroupEntity.setPkOrg("e736c3b028cd4fb599a0175c00f6266c");
        dataGroupEntity.setDgStdId("jiGGG");

        dataDictionaryEntity.setPkOrg("e736c3b028cd4fb599a0175c00f6266c");
        dataDictionaryEntity.setNameNode("病案");
        dataDictionaryEntity.setNodeType("1");
        dataDictionaryEntity.setOrdNode("1");
        dataDictionaryEntity.setPkFather("5794bf541c2c59af96278389f628df6a");
        dataDictionaryEntity.setPkRoot("5794bf541c2c59af96278389f628df6a");
        dataDictionaryEntity.setRemark("remark");

        dataDictionaryVO.setDataDictionary(dataDictionaryEntity);
        dataDictionaryVO.setDataGroup(dataGroupEntity);
        dataGroupService.insert(dataDictionaryVO);
    }
}
