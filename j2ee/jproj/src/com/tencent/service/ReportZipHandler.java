package com.tencent.service;

import analyseData.GenLine;
import analyseData.LineSumInfo;
import analyseData.LowDataBean;
import com.tencent.dao.BaseDao;
import com.tencent.utils.IOUtils;
import com.tencent.utils.LogUtils;
import com.tencent.utils.ZipUtil;
import com.tencent.vo.Line;
import com.tencent.vo.LineNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author : samlv .
 * Date   : 2016/1/7 10:52.
 */
public class ReportZipHandler {
    private String lowDataFile;
    private String baseInfoFile;
    private String zipFile;
    private String filePath;

    public ReportZipHandler(String zipFile) throws IOException {
        this.zipFile = zipFile;
        File zip = new File(zipFile);
        filePath = zip.getParent() + IOUtils.FILE_SP + (zip.getName().substring(0,zip.getName().lastIndexOf(".")));
        new File(filePath).mkdir();
        lowDataFile = filePath + IOUtils.FILE_SP + "lowData";
        baseInfoFile = filePath + IOUtils.FILE_SP + "baseInfo";
        LogUtils.outLine(zipFile);
        LogUtils.outLine(filePath);
        ZipUtil.unZipFiles(zipFile, filePath);
    }


    public void handle() {

        GenLine genLine = new GenLine();
        genLine.loadReportData(lowDataFile);
        genLine.generateLine();
        Map<String, LineSumInfo> lineSumInfoMap = genLine.getLineList();
        List<Line> lines = new ArrayList<Line>();
        List<LineNode> lineNodes = new ArrayList<LineNode>();
        for (Iterator<Map.Entry<String,LineSumInfo>> it = lineSumInfoMap.entrySet().iterator();it.hasNext();){
            Map.Entry<String,LineSumInfo> lineItem = it.next();
            System.out.println(lineItem.getKey());
            LineSumInfo lineSumInfo = lineItem.getValue();
            Line line = new Line();
            line.setLineKey(lineSumInfo.getLineIdNd());
            line.setLineContent(lineItem.getKey());
            line.setUin("1250565056");
            lines.add(line);

            for(LowDataBean lowDataBean : lineSumInfo.getLowDataBeans()){
                LineNode lineNode = new LineNode();
                lineNode.appendTo(line);
                // 冗余列，提高效能
                lineNode.setLineId(line.getId());
                lineNode.setLineKey(line.getLineKey());
                lineNode.setNodeId(lowDataBean.getNodeId());
                lineNode.setLevel(lowDataBean.getLevel());
                lineNode.setFromMethod(lowDataBean.getFromMethod());
                lineNode.setLineNumber(Integer.valueOf(lowDataBean.getLineNumber()));
                lineNode.setToMethod(lowDataBean.getToMethod());
                lineNode.setCostTime(lowDataBean.getDelay());
                lineNodes.add(lineNode);
            }
        }

        BaseDao<Line> lineDao = new BaseDao<Line>(Line.class);
        lineDao.addAll(lines);
        System.out.println(lines);
        BaseDao<LineNode> lineNodeDao = new BaseDao<LineNode>(LineNode.class);
        lineNodeDao.addAll(lineNodes);
    }

}
