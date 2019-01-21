package com.zhuxx.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhuxx.demo.dao.UserMapper;
import com.zhuxx.demo.model.FileUtil;
import com.zhuxx.demo.model.FtpFileUtil;
import com.zhuxx.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public String getUser(){

     User user = userMapper.findByUserName("刘丽");
     if(user != null){
         return user.toString();
     } return "error";
    }
    @GetMapping("/test2")
    public String deleteUser(){

        User user = userMapper.deleteByUserName("刘丽");
        if(user == null){
            return "数据已删除";
        } return "error2";
    }
    @GetMapping("/test3")
    public String updateUser(){

        User user = userMapper.updateByUserName("李丽");
        if(user != null){
            return "数据已更新";
        } return "error3";
    }
    @GetMapping("/test4")
    public String getAllUser(){

        User user = userMapper.findUserByUserName("*");
        if(user != null){
            return user.toString();
        } return "error4";
    }
    @GetMapping("/test5")
    public void Insert() throws ParseException {
        User user = new User();
        user.setId(5);
        user.setUsername("王五");
        user.setPassword("5555");
        user.setGender("男");
        SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(date.parse("1992-05-14"));
        userMapper.insertUser(user);

    }
    /**
     * 创建日期:2018年4月6日<br/>
     * 代码创建:黄聪<br/>
     * 功能描述:通过request的方式来获取到json数据<br/>
     *
     * @param jsonParam fastjson对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/json/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByJSON(@RequestBody JSONObject jsonParam) {
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        String username = jsonParam.getString("username");
        result.put("data", username);

        return result.toJSONString();
    }

    /**
     * 创建日期:2018年4月6日<br/>
     * 代码创建:黄聪<br/>
     * 功能描述:通过HttpServletRequest 的方式来获取到json的数据<br/>
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/request/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByRequest(HttpServletRequest request) {

        //获取到JSONObject
        JSONObject jsonParam = this.getJSONParam(request);

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "request");
        result.put("data", "name");

        return result.toJSONString();
    }

    /**
     * 创建日期:2018年4月6日<br/>
     * 代码创建:黄聪<br/>
     * 功能描述:通过request来获取到json数据<br/>
     * @param request
     * @return
     */
    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
            // 直接将json信息打印出来
            System.out.println(jsonParam.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }
    @ResponseBody
    @RequestMapping(value = "/inster/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String insterByRequest(HttpServletRequest request) throws ParseException {

        //获取到JSONObject
        JSONObject jsonParam = this.getJSONParam(request);

        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        User user = new User();
        int id = jsonParam.getInteger("id");
        user.setId(id);
        String username = jsonParam.getString("username");
        user.setUsername(username);
        String password = jsonParam.getString("password");
        user.setPassword(password);
        String gender = jsonParam.getString("gender");
        user.setGender(gender);
        String birthday = jsonParam.getString("birthday");
        SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(date.parse(birthday));
        userMapper.insertUser(user);
        result.put("data", jsonParam);
        return result.toJSONString();
    }

    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }

}
