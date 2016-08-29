package com.tencent.service;

import com.tencent.dao.BaseDao;
import com.tencent.impl.DownloadListener;
import com.tencent.impl.Downloadable;
import com.tencent.utils.IOUtils;
import com.tencent.utils.LogUtils;
import com.tencent.utils.NetUtils;
import com.tencent.utils.StringUtils;
import com.tencent.vo.Zz_upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author : samlv .
 * Date   : 2016/1/7 9:54.
 */
public class DownloadService {
    private List<Object> downloads;
    private String savePath;

    private List<DownloadListener> listeners = new ArrayList<DownloadListener>();

    public void loadUploadEntitys(Class clazz){
        BaseDao<Zz_upload> baseDao = new BaseDao<Zz_upload>(Zz_upload.class);
        try {
            Map<Object,Object> conditions = new HashMap<Object,Object>();
            conditions.put("p_id",8);
            this.downloads = baseDao.findByNameQuery(clazz.newInstance(),conditions,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public void addDownloadListener(DownloadListener  listener){
        this.listeners.add(listener);
    }

    public void startDownload() throws IOException {
        for (Object object : downloads){
            Downloadable downItem = (Downloadable) object;
            LogUtils.outLine("下载项目:"+downItem);
            if(savePath == null || "".equals(savePath)){
                savePath = IOUtils.getBasePath()+IOUtils.FILE_SP+"tmp";
                File tmpDir = new File(savePath);
                if(!tmpDir.exists()){
                    if(!tmpDir.mkdir()){
                        throw new IOException("无法创建tmp目录"+savePath);
                    }
                }
            }
            String fullFName = savePath + IOUtils.FILE_SP + downItem.getFileName();
            if(NetUtils.download(downItem.getUrl(),fullFName)){
                notifyListener("finish",fullFName);
            }
        }
    }

    public void notifyListener(String type,String saveFile){
        if("finish".equals(type)){
            for (DownloadListener listener : listeners){
                listener.downloadFinishd(saveFile);
            }
        }
    }
}
