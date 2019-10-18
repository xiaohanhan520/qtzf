package com.xh.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileUpDo {


    /**
     * 文件上传
     * @param request
     * @param file
     */
    public void upload(HttpServletRequest request, MultipartFile file){
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件路径
        String path = request.getSession().getServletContext().getRealPath("路径");
        //获取文件夹
        File f = new File(path);
        //判断文件夹是否存在
        if(!f.exists()){
            f.mkdir();
        }
        try {
            //获取uuid防止名字重复
            String uuid = UUID.randomUUID().toString();
            file.transferTo(new File(path, uuid + originalFilename));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * 文件下载
     *
     */

    public void download(HttpServletResponse response, HttpServletRequest request){
        //获取文件路径
        String path = request.getSession().getServletContext().getRealPath("路径");

        try {
            //获取文件流
            byte[] fileToByteArray = FileUtils.readFileToByteArray(new File(path, "文件名"));
            //名字设置utf-8格式
            String n = URLEncoder.encode("文件名");
            //设置utf-8格式
            response.setCharacterEncoding("UTF-8");
            //以附件形式下载
            response.setContentType("application/octet-stream; charset=utf-8");
            //写入下载文件名
            response.setHeader("Content-Disposition","attachment; filename=" + n);

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(fileToByteArray);
            //关闭资源
            fileToByteArray.clone();
            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * 在线读取文件
     * @param response
     * @param request
     */
    public void download2(HttpServletResponse response, HttpServletRequest request){
        try{
            //获取文件路径
            String path = request.getSession().getServletContext().getRealPath("路径");
            //获取文件
            File file = new File(path + "文件名");
            //读取文件
            byte[] fileToByteArray = FileUtils.readFileToByteArray(file);
            //输出文件
            response.getOutputStream().write(fileToByteArray);
            //关闭资源
            fileToByteArray.clone();
            response.getOutputStream().close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
