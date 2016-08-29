package com.tencent.app;

import com.tencent.dao.DBConnectionManager;
import com.tencent.impl.DownloadListener;
import com.tencent.service.DownloadService;
import com.tencent.service.ReportZipHandler;
import com.tencent.vo.Zz_upload;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length > 0){
            if("-c".equals(args[0])){
                DBConnectionManager.configFile = args[1];
            }
        }
        /*
        BaseDao baseDao = new BaseDao();

        try {

//            List<Object> users =  baseDao.findAll(new User());
//            for(Object object : users){
//                User user = (User) object;
//                System.out.println(user);
//            }

//            List<Object> uploads = baseDao.findAll(new Zz_upload());

            Map<Object,Object> conditions = new HashMap<Object,Object>();
            conditions.put("p_id",8);
            List<Object> uploads = baseDao.findByNameQuery(new Zz_upload(),conditions,false);
            for (Object object : uploads){
                Zz_upload zz_upload = (Zz_upload) object;
                System.out.println(zz_upload);

                String savePath = IOUtils.getBasePath() + "/tmp/";
                File savePathFile = new File(savePath);
                if(!savePathFile.exists()){
                    savePathFile.mkdir();
                }
                String fileId = StringUtils.uuid();
                String fileName = savePath + fileId + ".zip";
                boolean success = NetUtils.download(zz_upload.getF_url(),fileName);

                if (success){
                    LogUtils.outLine("下载成功,开始解压");
                    try{
                        ZipUtil.unZipFiles(fileName, savePath + fileId + "/", true);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }else{
                    LogUtils.outLine("下载失败");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        */
//        System.out.println(StringUtils.lcfirst("User"));

        DownloadService downloadService = new DownloadService();
        downloadService.loadUploadEntitys(Zz_upload.class);

        try {
            downloadService.addDownloadListener(new DownloadListener() {
                @Override
                public void downloadFinishd(String saveFile) {
                    try {
                        ReportZipHandler zipHandler = new ReportZipHandler(saveFile);
                        zipHandler.handle();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            downloadService.startDownload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


