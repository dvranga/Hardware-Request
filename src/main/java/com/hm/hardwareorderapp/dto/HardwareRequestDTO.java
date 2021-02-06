package com.hm.hardwareorderapp.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class HardwareRequestDTO {
	
	public int amiId;
	
	public int instanceId;
	
	public String userData;
	
	public String status;


}
