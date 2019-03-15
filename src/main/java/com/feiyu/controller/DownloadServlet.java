package com.feiyu.controller;

import com.feiyu.util.Freemarker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zdy on 2019-03-15
 */
@WebServlet("/downloadFile")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("NAME", "韩满义");
        params.put("SEX", "男");

        String templatePath = Thread.currentThread().getContextClassLoader().getResource("/template").getPath();
        ByteArrayOutputStream outputStream = Freemarker.foutputStream(templatePath, "test.xml", params);

        // 设置响应头，控制浏览器下载该文件
        resp.setContentType("application/msword");
        resp.setHeader("content-disposition",
                "attachment;filename =" + URLEncoder.encode("ceshi.doc", "UTF-8"));
        OutputStream out = resp.getOutputStream();
        outputStream.writeTo(out);          //写到输出流
        outputStream.close();

        out.close();
    }

}
