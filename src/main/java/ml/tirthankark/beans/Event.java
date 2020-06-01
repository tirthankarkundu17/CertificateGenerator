package ml.tirthankark.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"loggerName",
"threadName",
"timestamp",
"message",
"priority"
})
public class Event {

@JsonProperty("loggerName")
private String loggerName;
@JsonProperty("threadName")
private String threadName;
@JsonProperty("timestamp")
private String timestamp;
@JsonProperty("message")
private String message;
@JsonProperty("priority")
private String priority;

@JsonProperty("loggerName")
public String getLoggerName() {
return loggerName;
}

@JsonProperty("loggerName")
public void setLoggerName(String loggerName) {
this.loggerName = loggerName;
}

@JsonProperty("threadName")
public String getThreadName() {
return threadName;
}

@JsonProperty("threadName")
public void setThreadName(String threadName) {
this.threadName = threadName;
}

@JsonProperty("timestamp")
public String getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

@JsonProperty("message")
public String getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(String message) {
this.message = message;
}

@JsonProperty("priority")
public String getPriority() {
return priority;
}

@JsonProperty("priority")
public void setPriority(String priority) {
this.priority = priority;
}

@Override
public String toString() {
	return "Event [loggerName=" + loggerName + ", threadName=" + threadName + ", timestamp=" + timestamp + ", message="
			+ message + ", priority=" + priority + "]";
}

}