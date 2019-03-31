package com.scut.leaflet.utils;
import com.scut.leaflet.controller.key;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@CrossOrigin
public class picUtil {
    @Autowired
    //private AreaService areaService;
    private static String UPLOAD_FOLDER = "D:/images/pc/";
  private Logger logger = LoggerFactory.getLogger(picUtil.class);
    //private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static String singleFileUpload(MultipartFile pc1 ,String LeafletId) throws IOException {
         String word = key.unique();





       // logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(pc1) || pc1.isEmpty()) {
           // logger.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = pc1.getBytes();
            Path path = Paths.get( UPLOAD_FOLDER +LeafletId+"/");
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(path);
            }
            //文件写入指定路径
            //Files.write(path, bytes);
            String extension = getFileExtension(pc1);

            String relativeAddr =  word + extension;
            Thumbnails.of(pc1.getInputStream()).size(200, 200)
                    .outputQuality(0.8f).toFile(path+"/"+relativeAddr);
            //logger.debug("文件写入成功...");
            System.out.println("文件写入成功：地址："+path);

            String a = path+"\\"+relativeAddr;
            System.out.println("文件写入成功：地址："+a);
/*            Area area =new Area();
            area.setAreaId(4);
            area.setPriority(1);
            area.setAreaName(a);
            areaService.addArea(area);*/

           //"文件上传成功" + Paths.get(path + "/" + relativeAddr);


            return Paths.get(path + "/" + relativeAddr).toString();







        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }

    }


  //  @PostMapping("/deleteFile")
    public static String deFile(String  path){
        String   resultInfo = null;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        //Area area = areaService.getAreaById(path);
        //area.getAreaName();


        // String sb =area.getAreaName();;
        // sb.replace("/","\\");
        //String sb1 = "F:\\photos\\蛇皮玩意儿\\123\\瞎把.jpg";
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                resultInfo =  "1-删除成功";
            } else {
                resultInfo =  "0-删除失败";
            }
        } else {
            resultInfo = "文件不存在！";
        }

        return resultInfo;

    }



    //wqeweqweqwrqwqrqwrqerqe
    //@PostMapping("/delete")
    public  static String deFileA1(String path) throws IOException {
        path = "33";



        // 获取区域信息
        //Area area = areaService.getAreaById(path);
        //area.getAreaName();
        System.out.println(" 在运行");

        // String sb =area.getAreaName();;
        // sb.replace("/","\\");
        //String sb1 = "F:\\photos\\蛇皮玩意儿\\123\\瞎把.jpg";
        String sb = "\\root\\pic\\5";
        deleteDirectory(sb);
        Path sb1 = Paths.get( sb);
        if (!Files.isWritable(sb1)) {
            Files.createDirectories(sb1);
        }
        System.out.println( " 运行完毕");

        return "888";

    }


    @PostMapping("/deleteFileA")
    public static  String  deFileA(int path){
        String   resultInfo = null;
        path = 8;
        boolean flag = false;

        // 获取区域信息

        File file = new File("\\root\\pic\\");
        // if (!file.endsWith(File.separator)) {
        // dirPath = dirPath + File.separator;
        //}
        // File dirFile = new File(file);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!file.exists() || !file.isDirectory()) {
            String a1 = "对应的文件不存在，或者不是一个目录，则退出";
            return a1;
        }
        flag = true;
        File[] files = file.listFiles();// 获得传入路径下的所有文件
        for (int i = 0; i < files.length; i++) {// 循环遍历删除文件夹下的所有文件(包括子目录)
            if (files[i].isFile()) {// 删除子文件
                deFile(files[i].getAbsolutePath());
                System.out.println(files[i].getAbsolutePath() + " 删除成功");
                if (!flag)
                    break;// 如果删除失败，则跳出
            } else {// 运用递归，删除子目录
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;// 如果删除失败，则跳出
            }
        }
        if (!flag)
            return "";
        if (file.delete()) {// 删除当前目录
            return "";
        } else {
            return "失败";
        }
    }






    public static boolean deleteDirectory(String dirPath) {// 删除目录（文件夹）以及目录下的文件
        // 如果sPath不以文件分隔符结尾，自动添加文件分隔符
        boolean flag=false;
        String a = null;
        if (!dirPath.endsWith(File.separator)) {
            dirPath = dirPath + File.separator;
            System.out.println("没有后缀符号'/'");

        }
        File dirFile = new File(dirPath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            System.out.println("不是目录");
            return false;
        }
        flag = true;
        File[] files = dirFile.listFiles();// 获得传入路径下的所有文件
        for (int i = 0; i < files.length; i++) {// 循环遍历删除文件夹下的所有文件(包括子目录)
            if (files[i].isFile()) {// 删除子文件
                a= deFile(files[i].getAbsolutePath());
                System.out.println(files[i].getAbsolutePath() + " 目录文件删除成功");
                if (!flag)
                    break;// 如果删除失败，则跳出
            } else {// 运用递归，删除子目录
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;// 如果删除失败，则跳出
            }
        }
        if (!flag)
            return false;
        if (dirFile.delete()) {// 删除当前目录
            return true;
        } else {
            return false;
        }
    }

    private static String getFileExtension(MultipartFile File) {
        String originalFileName = File.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));

    }
}

