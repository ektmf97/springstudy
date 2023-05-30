package com.gdu.movie.util;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

  
  public String preventXSS(String str) {
    str = str.replace("<", "&lt;");
    str = str.replace(">", "&gt;"); 
    return str;  
  }
  
  
}