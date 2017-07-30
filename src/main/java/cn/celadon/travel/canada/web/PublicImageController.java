package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.Util.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by empqqty on 7/22/2017.
 */
@RestController
@RequestMapping( value = "/images")
public class PublicImageController {

    @Value("${web.upload-path}")
    private String webUploadPath;

    @RequestMapping(value = "/batch/upload", method = RequestMethod.GET)
    public void updateImageGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        uploadImage(request, response);
    }

    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS, "Upload Image succeed");
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iter = multipartHttpServletRequest.getFileNames();
        String datdDirectory = "images" + File.separator + "upload" + File.separator;
        String uploadFileName = "";
        while (iter.hasNext()){
            MultipartFile file = multipartHttpServletRequest.getFile(iter.next());
            if (!file.isEmpty()) {
                if (file.getContentType().contains("image")) {
                    try {
                        webUploadPath = ResourceUtils.getURL(webUploadPath).getPath();


                        // 获取图片的文件名
                        String fileName = file.getOriginalFilename();
                        // 获取图片的扩展名
                        String extensionName = StringUtil.substringAfter(fileName, ".");
                        // 新的图片文件名 = 获取时间戳+"."图片扩展名
                        String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
                        uploadFileName = newFileName;
                        // 文件路径
                        String filePath = webUploadPath.concat(datdDirectory);

                        File dest = new File(filePath, newFileName);
                        if (!dest.getParentFile().exists()) {
                            dest.getParentFile().mkdirs();
                        }
                        file.transferTo(dest);
                        //String data = datdDirectory.replaceAll("\\\\", "/") + newFileName;
                        //Map<String, Object> resultMap = new java.util.HashMap<>();
                        // resultMap.put("file", data);


                    } catch (IOException e) {
                        e.printStackTrace();
                        resultMsg.setResultCode(ResultCode.ERROR);
                        resultMsg.setMessage(e.getMessage());
                    }
                }
            }
        }
        try {
            String imageOutput = datdDirectory.replaceAll("\\\\", "/") + uploadFileName;
            response.setContentType("text/html;charset=UTF-8");
            String callback = request.getParameter("CKEditorFuncNum");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageOutput + "',''" + ")");
            out.println("</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
