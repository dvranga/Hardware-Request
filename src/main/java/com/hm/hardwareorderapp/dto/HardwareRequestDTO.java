package com.hm.hardwareorderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareRequestDTO {
	
	public int amiId;
	
	public int instanceId;
	
	public String userData;
	
	public String status;


}
