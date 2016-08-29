package analyseData;

/**
 * Created by henryjhuang on 2015/11/19.
 */
public class LowDataBean implements Comparable<LowDataBean>
{
    private String nodeId;
    private String fromMethod;
    private String toMethod;
    private Integer level ;
    private Integer delay;
    private Long reportTime;
//    private long threadId;  //now ,just handle main thread. so , no need the thread id
    private String lineNumber;

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

//    public long getThreadId() {
//        return threadId;
//    }
//
//    public void setThreadId(long threadId) {
//        this.threadId = threadId;
//    }

    public String getNodeId() {
        return nodeId;
    }



    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int compareTo(LowDataBean arg0) {
        return this.getReportTime().compareTo(arg0.getReportTime());
    }

    public String getFromMethod() {
        return fromMethod;
    }

    public Long getReportTime() {
        return reportTime;
    }

    public void setReportTime(Long reportTime) {
        this.reportTime = reportTime;
    }

    public void setFromMethod(String fromMethod) {
        this.fromMethod = fromMethod;
    }

    public String getToMethod() {
        return toMethod;
    }

    public void setToMethod(String toMethod) {
        this.toMethod = toMethod;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}
