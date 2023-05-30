package com.gdu.app13.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummernoteImageDTO {
  private String filesystemName;
  private int blogNo; // 나는 무슨 블로그에 달린 이미지다. 
  // 써머노트에 첨부시킬 이미지 
  
}
