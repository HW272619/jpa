package com.example.jdialectsdemo;

import com.example.jdialectsdemo.dao.ProduceClassDao;
import com.example.jdialectsdemo.entity.ProduceClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@SpringBootTest
class JdialectsdemoApplicationTests {
    @Autowired
    private ProduceClassDao produceClassDao;

    /**
     * 查询全部
     */
    @Test
    void contextLoads() {
        List<ProduceClass> list = produceClassDao.findAll();
        System.out.println(list);
    }

    /**
     * 分页查询
     */
    @Test
    void selectpage() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<ProduceClass> pageList = produceClassDao.getPageList(pageable);
        Page<ProduceClass> ProduceClassPage = produceClassDao.findAll(pageable);

        //总的数据条数
        long totalElements = ProduceClassPage.getTotalElements();
        System.out.println("totalElements:" + totalElements);
        //总的页数
        int totalPages = ProduceClassPage.getTotalPages();
        System.out.println("totalPages:" + totalPages);
        for (ProduceClass produceClass : pageList.getContent()) {
            System.out.println(produceClass);
        }
    }

    /**
     * 删除
     */
    @Test
    void delete() {
        produceClassDao.deleteByCode("ZFGX_YYCA_CC");
    }

    /**
     * 根据code查询
     */
    @Test
    void findbycode() {
        List<ProduceClass> classList = produceClassDao.findByCode("ZYYLCL_ZKJ_SZ");
        if (classList.size() == 0) {
            System.out.println("暂无此数据");
        } else {
            for (ProduceClass produceClass : classList) {
                System.out.println(produceClass);
            }
        }
    }

    /**
     * 计算总行数
     */
    @Test
    void getCount() {
        long count = produceClassDao.count();
        System.out.println(count);
    }

    /**
     * 新增
     */
    @Test
    void insert() {
        ProduceClass produceClass = new ProduceClass();
        produceClass.setID("B2B293C024E67E28E053020011ACBCCF");
        produceClass.setCODE("ZYYLCL_ZKJ_SZ");
        produceClass.setR_DATE(new Date());
        produceClass.setCLASS("1");
        produceClass.setR_TIME("08:28:20");
        produceClass.setDATAVALUE1(null);
        produceClass.setDATAVALUE2(4233.02148);
        produceClass.setDECIDE(null);
        produceClass.setTYPE(null);
        produceClass.setPROPERTY(null);
        produceClass.setREPORT_NAME(null);
        produceClass.setCREATE_BY(null);
        produceClass.setCREATE_TIME(new Date());
        produceClass.setMODIFY_BY(null);
        produceClass.setMODIFY_TIME(new Date());
        produceClassDao.save(produceClass);
    }
   @Test
    void update(){
       produceClassDao.updatebycode("1","ZFGX_YJCB_CC");
   }

}
