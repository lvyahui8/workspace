package com.tencent.vo;

/**
 * Author : samlv .
 * Date   : 2016/1/6 .
 */
public class LineNode extends BaseEntity {
    private Integer lineId;
    private String lineKey;
    private String nodeId;
    private Integer level;
    private String fromMethod;
    private Integer lineNumber;
    private String toMethod;
    private Integer costTime;

    /**
     * @return 关联的Line 表 ID
     */
    public Integer getLineId() {
        if(line != null && line.getId() != null){
            lineId = line.getId();
            return line.getId();
        }
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    /**
     *   lineKey,格式 类似于：84529/84516/85114/
     * @return
     */
    public String getLineKey() {
        return lineKey;
    }

    public void setLineKey(String lineKey) {
        this.lineKey = lineKey;
    }

    /**
     * EncodeMap之中的键，一个数字ID
     * @return 数字格式的ID
     */
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 处在调用链条中的层级
     * @return 层级
     */
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 主调方
     * @return 主调方函数全名
     */
    public String getFromMethod() {
        return fromMethod;
    }

    public void setFromMethod(String fromMethod) {
        this.fromMethod = fromMethod;
    }

    /**
     * 调用toMethod所在行号
     * @return 行号
     */
    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    private Line line;


    public Line line() {
        return line;
    }

    public void appendTo(Line line) {
        this.line = line;
    }

    /**
     * @return 被调函数全名
     */
    public String getToMethod() {
        return toMethod;
    }

    public void setToMethod(String toMethod) {
        this.toMethod = toMethod;
    }

    /**
     * 调用过程的耗时
     * @return 时间，一个毫秒数
     */
    public Integer getCostTime() {
        return costTime;
    }

    public void setCostTime(Integer costTime) {
        this.costTime = costTime;
    }
}
