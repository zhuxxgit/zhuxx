package com.zhuxx.demo.controller;
import com.zhuxx.demo.model.FtpFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by nishuai on 2017/12/26.
 */
@CrossOrigin
@Controller
public class FtpFileUploadController {

    //ftp处理文件上传
    @RequestMapping(value="/ftp", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("files") MultipartFile file,
                                          HttpServletRequest request) throws IOException {

        String fileName = file.getOriginalFilename();
        InputStream inputStream=file.getInputStream();
        String filePath=null;



        Boolean flag= FtpFileUtil.uploadFile(fileName,inputStream);
        if(flag==true){
            System.out.println("ftp上传成功！");
            filePath=fileName;
        }


        return  filePath;  //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
    }


}
