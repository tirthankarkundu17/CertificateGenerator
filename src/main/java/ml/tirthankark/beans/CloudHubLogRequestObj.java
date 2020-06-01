package ml.tirthankark.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "deploymentId", "instanceId", "text", "loggerName", "threadName", "startTime", "endTime",
		"priority", "limitMsgLen", "limit", "descending" })
public class CloudHubLogRequestObj {

	@JsonProperty("deploymentId")
	private String deploymentId;
	@JsonProperty("instanceId")
	private String instanceId;
	@JsonProperty("text")
	private String text;
	@JsonProperty("loggerName")
	private String loggerName;
	@JsonProperty("threadName")
	private String threadName;
	@JsonProperty("startTime")
	private Integer startTime;
	@JsonProperty("endTime")
	private Integer endTime;
	@JsonProperty("priority")
	private String priority;
	@JsonProperty("limitMsgLen")
	private Integer limitMsgLen;
	@JsonProperty("limit")
	private Integer limit;
	@JsonProperty("descending")
	private Boolean descending;

	@JsonProperty("deploymentId")
	public String getDeploymentId() {
		return deploymentId;
	}

	@JsonProperty("deploymentId")
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	@JsonProperty("instanceId")
	public String getInstanceId() {
		return instanceId;
	}

	@JsonProperty("instanceId")
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

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

	@JsonProperty("startTime")
	public Integer getStartTime() {
		return startTime;
	}

	@JsonProperty("startTime")
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	@JsonProperty("endTime")
	public Integer getEndTime() {
		return endTime;
	}

	@JsonProperty("endTime")
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@JsonProperty("priority")
	public String getPriority() {
		return priority;
	}

	@JsonProperty("priority")
	public void setPriority(String priority) {
		this.priority = priority;
	}

	@JsonProperty("limitMsgLen")
	public Integer getLimitMsgLen() {
		return limitMsgLen;
	}

	@JsonProperty("limitMsgLen")
	public void setLimitMsgLen(Integer limitMsgLen) {
		this.limitMsgLen = limitMsgLen;
	}

	@JsonProperty("limit")
	public Integer getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@JsonProperty("descending")
	public Boolean getDescending() {
		return descending;
	}

	@JsonProperty("descending")
	public void setDescending(Boolean descending) {
		this.descending = descending;
	}

	@Override
	public String toString() {
		return "CloudHubLogRequestObj [deploymentId=" + deploymentId + ", instanceId=" + instanceId + ", text=" + text
				+ ", loggerName=" + loggerName + ", threadName=" + threadName + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", priority=" + priority + ", limitMsgLen=" + limitMsgLen + ", limit="
				+ limit + ", descending=" + descending + "]";
	}

}