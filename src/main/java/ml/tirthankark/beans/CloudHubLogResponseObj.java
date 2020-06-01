package ml.tirthankark.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "recordId", "deploymentId", "instanceId", "line", "event" })
public class CloudHubLogResponseObj {

	@JsonProperty("recordId")
	private String recordId;
	@JsonProperty("deploymentId")
	private String deploymentId;
	@JsonProperty("instanceId")
	private String instanceId;
	@JsonProperty("line")
	private Integer line;
	@JsonProperty("event")
	private Event event;
	
	@JsonProperty("recordId")
	public String getRecordId() {
		return recordId;
	}

	@JsonProperty("recordId")
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

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

	@JsonProperty("line")
	public Integer getLine() {
		return line;
	}

	@JsonProperty("line")
	public void setLine(Integer line) {
		this.line = line;
	}

	@JsonProperty("event")
	public Event getEvent() {
		return event;
	}

	@JsonProperty("event")
	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "recordId=" + recordId + ", deploymentId=" + deploymentId + ", instanceId="
				+ instanceId + ", line=" + line + ", event=" + event ;
	}
}
