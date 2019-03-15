package com.feiyu.util

import org.junit.Test


/**
 * Created by zdy on 2019-03-15
 */
class FreemarkerTest {
    /**
     * 测试根据模版xml导出word
     */
    @Test
    void testFprint() {

        Map<String, Object> params = ["NAME": "韩满义", "SEX": "男"]

        String templatePath = Class.class.getResource("/template").getPath()
        println templatePath
        String docFilePath = templatePath + "/ceshi.doc"
        templatePath = java.net.URLDecoder.decode(templatePath, "utf-8")
        Freemarker.fprint(templatePath, "test.xml", params, docFilePath)

    }
}
