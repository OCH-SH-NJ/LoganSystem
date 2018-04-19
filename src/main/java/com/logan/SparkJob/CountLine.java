package com.logan.SparkJob;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logan.pojo.Bucket;
import com.logan.pojo.DataPojo;
import com.logan.util.livy.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Created by dongjuli on 2018/4/18.
 */
@Repository
public class CountLine {

    private int session_status = Session.STARTING;
    private LivyInteractiveClient client = null;
    private final String AZUREHDINSIGHT_LIVY_URI = "";
    //	private String endpoint = "192.168.32.128:8998";
    private String endpoint="slc09wsl.us.oracle.com:8998";
    private List<DataPojo> dataPojos;
    private List<Bucket> buckets;
    private int logCount;
    
    
    
    public int getLogCount() {
		return logCount;
	}

	public void setLogCount(int logCount) {
		this.logCount = logCount;
	}

	public List<DataPojo> getDataPojos() {
		return dataPojos;
	}

	public void setDataPojos(List<DataPojo> dataPojos) {
		this.dataPojos = dataPojos;
	}

	public List<Bucket> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public CountLine() {
        String baseUri = "http://" + endpoint + AZUREHDINSIGHT_LIVY_URI;
        try {
            client = new LivyInteractiveClient(baseUri, "", "");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // Add escape sequence before a double quote character in the statement.
    private String checkStatement(String statement) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end;
        String buf = statement;

        while(buf.length() > 0) {
            end = buf.indexOf("\"");
            if(end < 0) {
                sb.append(buf);
                break;
            }
            sb.append(buf.substring(start, end));
            sb.append("\\");
            sb.append("\"");
            buf = buf.substring(end + 1);
            start = 0;
        }

        return sb.toString();
    }

    public String run(String x) {
    	return "success";
    }
    
    public String run(String SQL1,String SQL2,ArrayList<String> sqlList) throws IOException {
        String countline="";
        InteractiveJobParameters param = new InteractiveJobParameters(SessionKind.SPARK);

        // Set session listener
        try {
            client.createSession(param, 1000, new SessionEventListener() {
                @Override
                public boolean updateStatus(Session event) {
                    boolean ret = true;
                    switch(event.getState()) {
                        case Session.IDLE:
                            session_status = Session.IDLE;
                            ret = true;
                            break;
                        case Session.STARTING:
                            try {
                                System.out.println("Session is starting. Session ID: " + client.getSession().getId());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            session_status = Session.STARTING;
                            ret = true;
                            break;
                        case Session.DEAD:
                            session_status = Session.DEAD;
                            ret = false;
                            break;
                        case Session.ERROR:
                            session_status = Session.ERROR;
                            ret = true;
                            break;
                        default:
                            session_status = Session.ERROR;
                            ret = false;
                            break;
                    }
                    return ret;
                }
            });
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (LivyException e1) {
            e1.printStackTrace();
        }

        while(true) {
            if(session_status == Session.IDLE) break;
            try { Thread.sleep(500); } catch (InterruptedException e) {	e.printStackTrace(); }
        }
        String input = null;
        input = "sc.textFile(\"/scratch/dongjun/demo/logs/install2018-02-04_07-26-46PM.log\").count()";
        String statement = checkStatement(input);
        System.out.println("Your input is [" + statement + "]");
        try {
            client.submitStatement(statement, 1000, new StatementResultListener() {
                @Override
                public void update(StatementResult result) {
                    System.out.println("Update Received. " + result.getOutput());
                }
            });
        } catch (LivyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            String result=client.getStatementResult();
            StatementResults ret = JsonConverter.toObject(StatementResults.class, result);
            List<Statements> stt = ret.statements;
            for(Statements s:stt){
                if(s.output!=null){
                    if(s.output.status.equals("ok")){
                    countline=s.output.data.text;
                    return countline;
                  }
                }
            }
        }
    }

}

class StatementResults {
    public int total_statements;
    public List<Statements> statements;
}

class Statements {
    public int id;
    public String state;
    public String code;
    public Output output;
    public String progress;
}

class Output {
    public String status;
    public int execution_count;
    public String ename;
    public String evalue;
    public String[] traceback;
    public Data data;
}

class Data {
    @JsonProperty("text/plain")
    public String text;
}
